package entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Bahast Saber
 * @Project parliament-library
 * @Package krd.parliament.library.entities
 * @date ١٨/٠٦/٢٠٢١
 * @Time ٠٣:١٨ م
 */
@Entity
@Table(name = "SUBJECTS")
@NamedQuery(name = "findBySubject", query = "select s from Subjects s where s.subject =?1")
public class Subjects {
    private Long subjectId;
    private String subject;
    private LocalDateTime addedDate;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
        Subjects subjects = (Subjects) o;
        return subject.equals(subjects.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject);
    }
}
