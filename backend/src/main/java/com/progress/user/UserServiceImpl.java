package com.progress.user;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import com.progress.db.ServiceBaseImpl;

import org.hibernate.jpa.QueryHints;
import org.mindrot.jbcrypt.BCrypt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class UserServiceImpl extends ServiceBaseImpl<User, Long> implements UserService {

    public UserServiceImpl() {
        super();
        this.persistenceClass = User.class;
    }

    public User getByUsername(String username) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM User u WHERE u.userName = '" + username + "'";
        TypedQuery<User> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        try {
            var entity = query.getSingleResult();
            em.getTransaction().commit();
            em.close();
            return entity;
        } catch (NoResultException e) {
            em.getTransaction().commit();
            em.close();
            return null;
        }
    }

    public User authenticate(String username, String password) {
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
        String hql = "FROM User u WHERE u.userName = '" + username + "'";
        TypedQuery<User> query = em.createQuery(hql, persistenceClass).setHint(QueryHints.HINT_READONLY, true);
        List<User> results = query.getResultList();
        em.getTransaction().commit();
        em.close();
        for (User result : results) {
            if (BCrypt.checkpw(password, result.getPasswordHash()))
                return result;
        }
        return null;
    }

    public User signUp(String username, String password, String gender) {
        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(password, salt);
        User entity = new User(username, passwordHash, Gender.valueOf(gender));
        return create(entity);
    }
}