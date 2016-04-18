package com.innominds.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdvancedQuery {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();

        System.err.println(em.createNamedQuery("getEmployeeDTO").getResultList());

        em.close();
        emf.close();
    }
}
