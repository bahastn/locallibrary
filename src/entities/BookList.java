package entities;

public class BookList {

    private String bookTitle;
    private String author;
    private String author2;
    private Integer yearOfPublish;
    private String location;
    private String bookSubject;
    private String language;


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public Integer getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(Integer yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBookSubject() {
        return bookSubject;
    }

    public void setBookSubject(String bookSubject) {
        this.bookSubject = bookSubject;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
