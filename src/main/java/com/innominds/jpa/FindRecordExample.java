package com.innominds.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.innominds.model.EmployeeEntity;

public class FindRecordExample {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();
        final EmployeeEntity entity = em.find(EmployeeEntity.class, 1l);
        System.out.println(entity);

        em.close();
        emf.close();

    }
}
