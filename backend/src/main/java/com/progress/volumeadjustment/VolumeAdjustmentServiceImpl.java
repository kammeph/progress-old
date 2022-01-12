package com.progress.volumeadjustment;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.progress.db.ServiceBaseImpl;

import org.hibernate.jpa.QueryHints;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class VolumeAdjustmentServiceImpl extends ServiceBaseImpl<VolumeAdjustment, Long> implements VolumeAdjustmentService {
    
    public VolumeAdjustmentServiceImpl() {
        super();
        this.persistenceClass = VolumeAdjustment.class;
    }

    public List<VolumeAdjustment> getByProperty(Integer property) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM VolumeAdjustment v WHERE v.volumeProperty = " + property;
        TypedQuery<VolumeAdjustment> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        var entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }

    public List<VolumeAdjustment> getByGender(Integer gender) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM VolumeAdjustment v WHERE v.gender = " + gender;
        TypedQuery<VolumeAdjustment> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        var entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }

    public List<VolumeAdjustment> getByGenderAndProperty(Integer gender, Integer property) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM VolumeAdjustment v WHERE v.gender = " + gender + " AND v.volumeProperty = " + property;
        TypedQuery<VolumeAdjustment> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        var entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }

    public List<VolumeAdjustment> getByUser(Long userid) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM volumeAdjustments va INNER JOIN volumeAdjustment_user vu ON va.id = vu.volumeAdjustmentId AND vu.userId = " + userid;
        Query query = em.createNativeQuery(sql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        var entities = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return entities;
    }

    public VolumeAdjustment getByUserAndProperty(Long userid, Integer property) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String sql = "SELECT * FROM volumeAdjustments va INNER JOIN volumeAdjustment_user vu ON va.id = vu.volumeAdjustmentId AND vu.userId = " + userid + " AND va.volumeProperty = " + property;
        Query query = em.createNativeQuery(sql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        VolumeAdjustment entity = null;
        try {
            entity = (VolumeAdjustment)query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println(e.getMessage());
        }
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    public void addUser(Long id, Long userid) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String sql = "INSERT INTO volumeAdjustment_user (volumeAdjustmentId, userId) Values (" + id + "," + userid + ");";
        Query query = em.createNativeQuery(sql);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    public void removeUser(Long id, Long userid) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String sql = "DELETE FROM volumeAdjustment_user WHERE volumeAdjustmentId = " + id + " AND userId = " + userid + ";";
        Query query = em.createNativeQuery(sql);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
