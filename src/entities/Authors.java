package entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Bahast Saber
 * @Project parliament-library
 * @Package krd.parliament.library.entities
 * @date ١٧/٠٦/٢٠٢١
 * @Time ٠٧:٥٩ م
 */
@Entity
@Table(name = "AUTUORS")
public class Authors {
    private Long authorId;
    private String authorNumber;
    private String authorName;
    private LocalDateTime addedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getAuthorId() {
        return authorId;
    }


    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Column(name = "AUTHOR_NUMBER")
    public String getAuthorNumber() {
        return authorNumber;
    }

    public void setAuthorNumber(String authorNumber) {
        this.authorNumber = authorNumber;
    }
    @Column(name = "AUTHOR_NAME" )
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @CreationTimestamp
    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return authorName.equals(authors.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName);
    }
}
