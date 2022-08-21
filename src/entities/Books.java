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

    private Integer volume;
    private Integer bookEdition;
    private Integer yearOfPublish;
    private String cityOfPublish;
    private Integer numberOfPages;
    private Integer publisherSequence;
    private Types type;
    private String bookClassificationNumber;
    private String authorClassificationNumber;

    private String location;
    private String locationZone;
    private boolean containMap;
    private boolean containPicture;
    private boolean containChart;
    private boolean containDocumentHandWrite;
    private Subjects bookSubject;

    private String bookAbstract;
    private Language language;

    private String categories;
    private LocalDateTime addedDate;
    private String note;
    private Double price;
    private Integer unites;
    private File coverImage;
    private String coverImagePath;
    private File eBook;
    private String eBookPath;

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


    @Column(name = "BOOK_EDITION")
    public Integer getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(Integer bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Integer getCoverEdition() {
        return volume;
    }

    public void setCoverEdition(Integer volume) {
        this.volume = volume;
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

    @Column(name = "BOOK_ABSTRACT", length = 800)
    public String getBookAbstract() {
        return bookAbstract;
    }

    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }


    public String getBookClassificationNumber() {
        return bookClassificationNumber;
    }

    public void setBookClassificationNumber(String bookClassificationNumber) {
        this.bookClassificationNumber = bookClassificationNumber;
    }

    public String getAuthorClassificationNumber() {
        return authorClassificationNumber;
    }

    public void setAuthorClassificationNumber(String authorClassificationNumber) {
        this.authorClassificationNumber = authorClassificationNumber;
    }

    public String getLocationZone() {
        return locationZone;
    }

    public void setLocationZone(String locationZone) {
        this.locationZone = locationZone;
    }

    public boolean isContainMap() {
        return containMap;
    }

    public void setContainMap(boolean containMap) {
        this.containMap = containMap;
    }

    public boolean isContainPicture() {
        return containPicture;
    }

    public void setContainPicture(boolean containPicture) {
        this.containPicture = containPicture;
    }

    public boolean isContainChart() {
        return containChart;
    }

    public void setContainChart(boolean containChart) {
        this.containChart = containChart;
    }

    public boolean isContainDocumentHandWrite() {
        return containDocumentHandWrite;
    }

    public void setContainDocumentHandWrite(boolean containDocumentHandWrite) {
        this.containDocumentHandWrite = containDocumentHandWrite;
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

    public Integer getPublisherSequence() {
        return publisherSequence;
    }

    public void setPublisherSequence(Integer publisherSequence) {
        this.publisherSequence = publisherSequence;
    }

    public String getCityOfPublish() {
        return cityOfPublish;
    }

    public void setCityOfPublish(String cityOfPublish) {
        this.cityOfPublish = cityOfPublish;
    }

    public Integer getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(Integer yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getUnites() {
        return unites;
    }

    public void setUnites(Integer unites) {
        this.unites = unites;
    }

    public File getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(File coverImage) {
        this.coverImage = coverImage;
    }

    public File geteBook() {
        return eBook;
    }

    public void seteBook(File eBook) {
        this.eBook = eBook;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getCoverImagePath() {
        return coverImagePath;
    }

    public void setCoverImagePath(String coverImagePath) {
        this.coverImagePath = coverImagePath;
    }

    public String geteBookPath() {
        return eBookPath;
    }

    public void seteBookPath(String eBookPath) {
        this.eBookPath = eBookPath;
    }


}
