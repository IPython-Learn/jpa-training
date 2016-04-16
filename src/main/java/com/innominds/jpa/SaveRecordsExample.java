package com.innominds.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.innominds.model.EmployeeEntity;

public class SaveRecordsExample {

    public static void main(String[] args) {

        saveRecords();
    }

    static void saveRecords() {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        for (int i = 1; i < 100; i++) {
            final EmployeeEntity entity = new EmployeeEntity();
            entity.setId(new Long(i));
            entity.setSalary(108.890 * i);
            entity.setJoinDate(new Date());
            entity.setName("ThirupathiReddy");
            em.persist(entity);
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}
