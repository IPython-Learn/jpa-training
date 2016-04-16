package com.innominds.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.innominds.model.EmployeeEntity;

public class PositionalParameterQueryExample {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU");
        final EntityManager em = emf.createEntityManager();

        final TypedQuery<EmployeeEntity> positionalParamQuery = em.createQuery("SELECT e FROM Employee e WHERE e.id>?1", EmployeeEntity.class);
        positionalParamQuery.setParameter(1, 10l);
        final List<EmployeeEntity> ppl = positionalParamQuery.getResultList();
        ppl.stream().forEach(System.err::println);

        em.close();
        emf.close();
    }
}
