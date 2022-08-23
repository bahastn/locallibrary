package entities;

public class BookList {

    private String bookTitle;
    private Authors author;
    private Authors author2;
    private Integer yearOfPublish;
    private String location;
    private Subjects bookSubject;
    private Language language;


    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public Authors getAuthor2() {
        return author2;
    }

    public void setAuthor2(Authors author2) {
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

    public Subjects getBookSubject() {
        return bookSubject;
    }

    public void setBookSubject(Subjects bookSubject) {
        this.bookSubject = bookSubject;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
