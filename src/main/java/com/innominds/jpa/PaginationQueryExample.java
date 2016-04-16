package com.innominds.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.innominds.model.EmployeeEntity;

public class PaginationQueryExample {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();

        final int pageSize = 20;
        int initial = 0;

        do {

            final List<EmployeeEntity> list = em.createQuery("SELECT e FROM Employee e", EmployeeEntity.class).setFirstResult(initial).setMaxResults(pageSize)
                    .getResultList();
            initial += pageSize;
            list.stream().forEach(System.out::println);
            System.out.println("------------------------");

        } while (initial < 120);

        em.close();
        emf.close();
    }

}
