package entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

/**
 * @author Bahast Saber
 * @Project parliament-library
 * @Package krd.parliament.library.entities
 * @date ١٧/٠٦/٢٠٢١
 * @Time ٠٧:٥٩ م
 */
@Entity
@Table(name = "BOOK")
public class Books {
    private Long bookId;
    private String ISBN_10;
    private String ISBN_13;
    private String bookTitle;
    private String branchBookTitle;
    private Authors author;
    private Authors author2;
    private Integer yearOfPublish;
    private Types type;
    private String location;
    private Subjects bookSubject;
    private Language language;
    private String categories;
    private LocalDateTime addedDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getISBN_10() {
        return ISBN_10;
    }

    public void setISBN_10(String ISBN_10) {
        this.ISBN_10 = ISBN_10;
    }

    public String getISBN_13() {
        return ISBN_13;
    }

    public void setISBN_13(String ISBN_13) {
        this.ISBN_13 = ISBN_13;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    public Subjects getBookSubject() {
        return bookSubject;
    }

    public void setBookSubject(Subjects bookSubject) {
        this.bookSubject = bookSubject;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBranchBookTitle() {
        return branchBookTitle;
    }

    public void setBranchBookTitle(String branchBookTitle) {
        this.branchBookTitle = branchBookTitle;
    }

    @ManyToOne
    @JoinColumn(name = "LANGUAGE_ID")
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public Integer getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(Integer yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @ManyToOne
    @JoinColumn(name = "AUTHOR_1")
    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "AUTHOR_2")
    public Authors getAuthor2() {
        return author2;
    }
    public void setAuthor2(Authors author2) {
        this.author2 = author2;
    }

    @CreationTimestamp
    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }


}
