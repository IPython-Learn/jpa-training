package com.innominds.jpa;

import java.util.Properties;

import javax.persistence.Cache;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.innominds.model.EmployeeEntity;

/**
 *
 * Second level cache can be controller using property "javax.persistence.sharedCache.". Following values are allowed
 * <ul>
 * <li>ALL: All entity data is stored in the 2nd level cache</li>
 * <li>NONE: No data is cached</li>
 * <li>ENABLE_SELECTIVE: Entities marked with @Cachable are cached</li>
 * <li>DISABLE_SELECTIVE: All entities except @Cachable(false) are cached</li>
 * <li>UNSPECIFIED: Caching behavior is not specified, Persistence provider's default caching behavior is used.</li>
 *
 *
 */
public class SecondLevelCaching {

    public static void main(String[] args) {

        final Properties additionalConfig = new Properties();
        additionalConfig.put("javax.persistence.sharedCache.mode", "ALL");
        additionalConfig.put("javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE);
        additionalConfig.put("javax.persistence.cache.storeMode", CacheStoreMode.USE);

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DERBYPU", additionalConfig);
        final Cache cache = emf.getCache();
        System.out.println("Is entity available in second level cache?  :  " + cache.contains(EmployeeEntity.class, 1l));

        final EntityManager em1 = emf.createEntityManager();
        System.out.println(em1.find(EmployeeEntity.class, 1l));

        System.out.println("Is entity available in second level cache?  :  " + cache.contains(EmployeeEntity.class, 1l));
        final EntityManager em2 = emf.createEntityManager();
        System.out.println(em2.find(EmployeeEntity.class, 1l));

        Query query = em2.createQuery("SELECT  e FROM  Employee e WHERE e.id=:id");
        query.setParameter("id", 1l);
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);

        System.out.println(query.getSingleResult());

        query = em2.createQuery("SELECT  e FROM  Employee e WHERE e.id=:id");
        query.setParameter("id", 1l);
        // query.setHint("javax.persistence.cache.retrieveMode", CacheStoreMode.USE);
        query.setHint("org.hibernate.cacheable", Boolean.TRUE);
        System.out.println(query.getSingleResult());

    }
}
