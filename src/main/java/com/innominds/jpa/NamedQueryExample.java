package com.innominds.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NamedQueryExample {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();

        final Query namedQuery = em.createNamedQuery("employeeById");
        namedQuery.setHint("javax.persistence.query.timeout", 1);
        namedQuery.setParameter("id", 80l);
        System.out.println(namedQuery.getSingleResult());

        System.out.println(em.createNamedQuery("getRecentEmployee").getSingleResult());

        em.close();
        emf.close();
    }
}
