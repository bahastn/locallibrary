package services;
import entities.Language;
import entities.Subjects;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListFields {
    public Set<String> listOfSubjects() {
        Set<String> set = new HashSet<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select s from Subjects s");
        List<Subjects> subjectsList = query.getResultList();
        for (Subjects s: subjectsList) {
            String subject = new String(s.getSubject());
            set.add(subject);
        }
        em.close();
        emf.close();

        return set;
    }

    public Set<String> listOfLanguages() {
        Set<String> set = new HashSet<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select l from Language l");
        List<Language> languageList= query.getResultList();
        for (Language l: languageList) {
            String language = new String(l.getLanguage());
            set.add(language);
        }
        em.close();
        emf.close();

        return set;
    }
}
