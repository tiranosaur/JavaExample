package org.example.demors.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.example.demors.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@ApplicationScoped
public class UserDAO {
    private final SessionFactory factory;

    public UserDAO() {
        factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
    }

    public void getError() {
        if (true) {
            throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
        }
    }

    public List<User> getUsers(int offset, int limit) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("select u from User u", User.class)
                .setFirstResult(offset * limit)
                .setMaxResults(limit)
                .getResultList();
        session.getTransaction().commit();
        return users;
    }

    public User getUser(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        User user = session
                .createQuery("select u from User u where u.id = :userId", User.class)
                .setParameter("userId", id)
                .uniqueResult();
        session.getTransaction().commit();
        return user;
    }
}