package com.innominds.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.innominds.model.EmployeeEntity;

public class NamedParameterQueryExample {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();

        final TypedQuery<EmployeeEntity> namedParameterQuery = em.createQuery("SELECT e FROM Employee e WHERE e.id>=:id", EmployeeEntity.class);
        namedParameterQuery.setParameter("id", 50l);
        final List<EmployeeEntity> npl = namedParameterQuery.getResultList();
        npl.stream().forEach(System.err::println);

        em.close();
        emf.close();
    }
}
