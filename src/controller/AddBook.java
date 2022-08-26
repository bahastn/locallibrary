package controller;

import entities.Authors;
import entities.Books;
import entities.Language;
import entities.Subjects;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.controlsfx.control.textfield.TextFields;
import services.ListFields;
import services.ValidationService;

import javax.persistence.*;
import javax.security.auth.Subject;
import java.net.URL;
import java.util.ResourceBundle;


public class AddBook implements Initializable {
    public TextField bookTitleField;
    public TextField authorField;
    public TextField authorField2;
    public TextField issueYearField;
    public TextField subjectField;
    public TextField locationField;
    public TextField languageField;


    public void addBook(ActionEvent actionEvent) throws Exception {
        if (isFilled()) {
            Books book = new Books();
            Authors author = new Authors();
            Authors author2 = new Authors();
            Subjects subject = new Subjects();
            Language language = new Language();
            ValidationService validaTionService = new ValidationService();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();


            book.setBookTitle(bookTitleField.getText().trim().toLowerCase());
            book.setYearOfPublish(validYear(issueYearField.getText().trim().toLowerCase()));
            book.setLocation(locationField.getText().trim().toLowerCase());

            if (isExistAuthor(authorField.getText().trim().toLowerCase())) {
                author = validaTionService.getAuthor(authorField.getText().trim().toLowerCase());
                book.setAuthor(author);
            } else {
                author.setAuthorName(authorField.getText().trim().toLowerCase());
                em.persist(author);
                book.setAuthor(author);
            }
            if (isExistAuthor(authorField2.getText().trim().toLowerCase())) {
                author2 = validaTionService.getAuthor(authorField2.getText().trim().toLowerCase());
                book.setAuthor2(author2);
            } else {
                author2.setAuthorName(authorField2.getText().trim().toLowerCase());
                em.persist(author2);
                book.setAuthor2(author2);
            }
            if (isExistSubject(subjectField.getText().trim().toLowerCase())) {
                subject = validaTionService.getSubject(subjectField.getText().trim().toLowerCase());
                book.setBookSubject(subject);
            } else {
                subject.setSubject(subjectField.getText().trim().toLowerCase());
                em.persist(subject);
                book.setBookSubject(subject);
            }

            if (isExistLanguage(languageField.getText().trim().toLowerCase())) {
                language = validaTionService.getLanguage(languageField.getText().trim().toLowerCase());
                book.setLanguage(language);

            } else {
                language.setLanguage(languageField.getText().trim().toLowerCase());
                em.persist(language);
                book.setLanguage(language);
            }

            em.persist(book);
            em.getTransaction().commit();
            em.close();
            emf.close();
            clearAllFields();
        }
        else {
            AlertBox.massage("Field missing", "ناونیشانی کتێب یان نووسەر باتاڵە!!");
        }

    }

    private boolean isFilled() {
        if (!bookTitleField.getText().isEmpty() && !authorField.getText().isEmpty()) {
            return true;
        }
        return false;

    }

    private Integer validYear(String number) {
        try {
            Integer no = Integer.valueOf(number);
            return no;
        } catch (Exception e) {
            return 0;
        }
    }

    private boolean isExistLanguage(String language) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("findByLanguage");
            query.setParameter(1, language.trim());
           Language lang = (Language) query.getSingleResult();
            if (lang != null) {
                em.close();
                emf.close();
                return true;
            }
        } catch (NoResultException e) {
            e.getStackTrace();
            em.close();
            emf.close();
        }
        return false;
    }

    private boolean isExistSubject(String subject) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("findBySubject");
            query.setParameter(1, subject.trim());
            Subjects sub = (Subjects) query.getSingleResult();
            if (sub != null) {
                em.close();
                emf.close();
                return true;
            }
        } catch (NoResultException e) {
            e.getStackTrace();
            em.close();
            emf.close();
        }
        return false;
    }

    private boolean isExistAuthor(String authorName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("findByAuthor");
            query.setParameter(1, authorName.trim());
            Authors author = (Authors) query.getSingleResult();
            if (author != null) {
                em.close();
                emf.close();
                return true;
            }
        } catch (NoResultException e) {
            e.getStackTrace();
            em.close();
            emf.close();
        }
        return false;

    }
    void clearAllFields(){
      bookTitleField.clear();
      authorField.clear();
        authorField2.clear();
       issueYearField.clear();
        subjectField.clear();
        locationField.clear();
         languageField.clear();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListFields listFields = new ListFields();
        TextFields.bindAutoCompletion(subjectField, listFields.listOfSubjects());
        TextFields.bindAutoCompletion(languageField, listFields.listOfLanguages());
    }
}
