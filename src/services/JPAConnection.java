package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAConnection {
    private EntityManager entityManager = buildEntityManager();

    private EntityManager buildEntityManager() {
//        Map addProperties = new HashMap();
//        addProperties.put( "hibernate.show_sql", false );
//        addProperties.put( "hibernate.connection.url","jdbc:postgresql://192.168.100.10:5432/portal" );
//        addProperties.put("hibernate.connection.username","postgres");
//        addProperties.put("hibernate.connection.password", "Bn160783" );
//        addProperties.put( "hibernate.connection.driver_class","org.postgresql.Driver" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_UNIT"/*, addProperties */);
        return emf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
