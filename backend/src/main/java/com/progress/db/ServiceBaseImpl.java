package com.progress.db;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.hibernate.jpa.QueryHints;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class ServiceBaseImpl<T, ID extends Serializable> implements ServiceBase<T, ID> {

    protected EntityManagerFactory emf;
    protected Class<T> persistenceClass;

    Map<String, Object> configOverrides = new HashMap<String, Object>();

    @Inject
    @ConfigProperty(name = "DB_URL")
    protected String dburl;

    @PostConstruct
    public void init() {
        Map<String, Object> configOverrides = new HashMap<String, Object>();
        configOverrides.put("javax.persistence.jdbc.url", "jdbc:mysql:" + dburl + "/progress?createDatabaseIfNotExist=true");
        this.emf = Persistence.createEntityManagerFactory("progressapi", configOverrides);
    }

    public ServiceBaseImpl() {
    }

    @PreDestroy
    public void deinit() {
        emf.close();
    }

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    @Override
    public List<T> getAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(persistenceClass);
        criteria.from(persistenceClass);
        List<T> entities = em.createQuery(criteria).setHint(QueryHints.HINT_READONLY, true).getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }

    @Override
    public T get(ID id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Map<String, Object> hints = new HashMap<>();
        hints.put(QueryHints.HINT_READONLY, true);
        T entity = em.find(persistenceClass, id, hints);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public T create(T entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        T merged = em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return merged;
    }

    @Override
    public Boolean update(ID id, T object) throws IllegalArgumentException, IllegalAccessException {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            T entity = em.find(persistenceClass, id);
            em.merge(entity);
            Field[] fields = persistenceClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(object);
                field.set(entity, value);
            }
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean delete(ID id) {
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            T entity = em.find(persistenceClass, id);
            em.remove(entity);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
