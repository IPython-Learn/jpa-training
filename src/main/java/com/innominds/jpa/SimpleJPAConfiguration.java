package com.innominds.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.innominds.model.EmployeeEntity;

public class SimpleJPAConfiguration {

    @PersistenceContext(type = PersistenceContextType.EXTENDED, unitName = "MysqlPU")
    EntityManager entityManager;

    public static void main(String[] args) {

        // DERBY
        new SimpleJPAConfiguration().derbyPersistence();
        // MYSQL
        // mysqlPersistence();

    }

    void mysqlPersistence() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MysqlPU");
        final EntityManager em = emf.createEntityManager();
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName("ThirupathiReddy");
        em.getTransaction().begin();
        entity = em.merge(entity);
        entity = em.find(EmployeeEntity.class, entity.getId());
        em.flush();
        em.getTransaction().commit();
    }

    void derbyPersistence() {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();
        final EmployeeEntity entity = new EmployeeEntity();
        entity.setId(10100l);
        entity.setName("ThirupathiReddy");

        em.getTransaction().begin();
        // persistence context starts

        em.persist(entity);

        entity.setName("PersistenceContextChanged My Name");

        // persistence context ends
        em.getTransaction().commit();

        System.err.println(em.find(EmployeeEntity.class, 10100l));

        em.close();

    }
}
