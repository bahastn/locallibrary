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
    public ObservableList<BookList> getListItems() {
        ObservableList<BookList> list = FXCollections.observableArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT b from Books b ");

        List<Books> booksList = query.getResultList();

        for (Books b: booksList ){
           BookList bookList = new BookList();
           bookList.setBookTitle(b.getBookTitle());

           list.add(bookList);
        }


        return list;
    }
}
