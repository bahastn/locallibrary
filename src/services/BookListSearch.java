package services;

import entities.BookList;
import entities.Books;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class BookListSearch {
    public ObservableList<BookList> getListItems(String keyWord, String subject, Integer year, String author, String language) {
        ObservableList<BookList> list = FXCollections.observableArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
//        System.out.println(queryBuilder(keyWord, subject, year,author, language));
        Query query = em.createQuery(queryBuilder(keyWord, subject, year,author, language));
        List<Books> booksList = query.getResultList();
        for (Books b : booksList) {
            BookList bookList = new BookList();
            if (b.getBookTitle() != null) {
                bookList.setBookTitle(b.getBookTitle());
            }
            if(b.getBookSubject() != null) {
                bookList.setBookSubject(b.getBookSubject().getSubject());
            }
            if(b.getAuthor() != null) {
                bookList.setAuthor(b.getAuthor().getAuthorName());
            }
            bookList.setAuthor2(b.getAuthor2().getAuthorName());
            bookList.setLanguage(b.getLanguage().getLanguage());
            bookList.setLocation(b.getLocation());
            bookList.setYearOfPublish(b.getYearOfPublish());
            list.add(bookList);
        }


        return list;
    }
    String queryBuilder(String keyWord, String subject, Integer year, String author, String language){
        String keyWordQ="";
        String subjectQ = "";
        String yearQ = "";
        String authorQ = "";
        String languageQ ="";
        if(!keyWord.isEmpty()){
            if(!subject.isEmpty()  || year != null || !author.isEmpty() || !language.isEmpty()) {
                keyWordQ = "b.bookTitle LIKE  '%" + keyWord + "%' AND";
            }
            else {
                keyWordQ = "b.bookTitle LIKE '%" + keyWord + "%'";
            }
        }
        if(!subject.isEmpty()){
            if( year != null || !author.isEmpty() || !language.isEmpty()) {
                subjectQ = " b.bookSubject.subject = '" + subject + "' AND";
            }
            else {
                subjectQ = " b.bookSubject.subject = '" + subject + "'";
            }
        }
        if(year != null) {
            if( !author.isEmpty() || !language.isEmpty()) {
                yearQ = " b.yearOfPublish = " + year + " AND";
            }
            else {
                yearQ = " b.yearOfPublish = " + year ;
            }
        }
        if(!author.isEmpty()){
            if(!language.isEmpty()) {
                authorQ = " b.author.authorName LIKE  '%" + author + "%' AND";
            }
            else {
                authorQ = " b.author.authorName LIKE  '%" + author + "%'";
            }
        }
        if(!language.isEmpty()){
            languageQ = " b.language.language = '" +language + "'";
        }

        String query = " Select b From Books b where " + keyWordQ +subjectQ + yearQ + authorQ +languageQ;

        return query;
    }
}
