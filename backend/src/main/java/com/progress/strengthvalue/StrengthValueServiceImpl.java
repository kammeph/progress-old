package com.progress.strengthvalue;

import java.util.List;

import com.progress.db.ServiceBaseImpl;

import org.hibernate.jpa.QueryHints;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class StrengthValueServiceImpl extends ServiceBaseImpl<StrengthValue, Long> implements StrengthValueService {

    public StrengthValueServiceImpl() {
        super();
        this.persistenceClass = StrengthValue.class;
    }

    @Override
    public List<StrengthValue> getByUser(Long userid) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM StrengthValue s WHERE s.userId = " + userid;
        TypedQuery<StrengthValue> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        var entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }
}