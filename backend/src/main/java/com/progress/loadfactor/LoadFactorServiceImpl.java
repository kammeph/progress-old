package com.progress.loadfactor;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.progress.db.ServiceBaseImpl;

import org.hibernate.jpa.QueryHints;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class LoadFactorServiceImpl extends ServiceBaseImpl<LoadFactor, Long> implements LoadFactorService {

    @Override
    public List<LoadFactor> getByExercise(Long exerciseid) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM LoadFactor l WHERE l.exerciseId = " + exerciseid;
        TypedQuery<LoadFactor> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        var entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }
    
    public LoadFactorServiceImpl() {
        super();
        this.persistenceClass = LoadFactor.class;
    }
}
