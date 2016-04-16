package com.innominds.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.innominds.model.EmployeeEntity;

public class QueryExample {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();
        final List<EmployeeEntity> list = em.createQuery("SELECT e FROM Employee e", EmployeeEntity.class).getResultList();
        list.stream().forEach(System.out::println);

        em.close();
        emf.close();
    }

}
