package services;

import entities.Authors;
import entities.Language;
import entities.Subjects;

import javax.persistence.*;


public class ValidationService {
    public Authors getAuthor(String authorName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("findByAuthor");
            query.setParameter(1, authorName.trim());
            Authors author = (Authors) query.getSingleResult();
            if (author != null) {
                em.close();
                emf.close();
                return author;
            }
        } catch (NoResultException e) {
            e.getStackTrace();
            em.close();
            emf.close();
        }
            return null;
    }

    public Subjects getSubject(String subject) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("findBySubject");
            query.setParameter(1, subject.trim());
            Subjects sub = (Subjects) query.getSingleResult();
            if (sub != null) {
                em.close();
                emf.close();
                return sub;
            }
        } catch (NoResultException e) {
            e.getStackTrace();
            em.close();
            emf.close();
        }
        return null;
    }

    public Language getLanguage(String language) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("findByLanguage");
            query.setParameter(1, language.trim());
            Language lang = (Language) query.getSingleResult();
            if (lang != null) {
                em.close();
                emf.close();
                return lang;
            }
        } catch (NoResultException e) {
            e.getStackTrace();
            em.close();
            emf.close();
        }
        return null;
    }
}
