package com.example.hibernatecacheandannotationsrepetition;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDAOImpl implements UserDAO {
    @Override
    public void create(User user) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public User getUserByID(int id) {
        return HibernateSessionFactorySessionUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        List<User> users = (List<User>) HibernateSessionFactorySessionUtil.getSessionFactory()
                .openSession().createQuery("SELECT id FROM User WHERE roles = :role");
        return users;
    }

    @Override
    public List<User> getEveryone() {
        List<User> users = (List<User>) HibernateSessionFactorySessionUtil.getSessionFactory()
                .openSession().createQuery("FROM User").list();
        List<User> users1 = HibernateSessionFactorySessionUtil.getSessionFactory()
                .openSession().createQuery("FROM User", User.class).list();
        return users;
    }

    @Override
    public void updatePersonById(User user) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            user.setTimeOfModification(new Date());
            session.update(user);
            transaction.commit();
        }
    }

    @Override
    public void deleteUser(User user) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }
}
