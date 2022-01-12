package com.progress.exercise;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.progress.db.ServiceBaseImpl;

import org.hibernate.jpa.QueryHints;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class ExerciseServiceImpl extends ServiceBaseImpl<Exercise, Long> implements ExerciseService {

    @Override
    public List<Exercise> getByExerciseGroup(Long exercisegroupid) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM Exercise e WHERE e.exerciseGroupId = " + exercisegroupid;
        TypedQuery<Exercise> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        var entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }

    @Override
    public Boolean initExercise(Long exerciseid) {
        return true;
    }

    public ExerciseServiceImpl() {
        super();
        this.persistenceClass = Exercise.class;
    }

}
