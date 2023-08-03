package com.example.hibernatecacheandannotationsrepetition;


import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public User getuserByID(int id) {
        return HibernateSessionFactorySessionUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return null;
    }

    @Override
    public List<User> getUsersByRole() {
        List<User> users = (List<User>) HibernateSessionFactorySessionUtil.getSessionFactory()
                .openSession().createQuery("SELECT id FROM User WHERE roles = :role").list();
        return users;
    }

    @Override
    public List<User> getEveryone() {
        List<User> users = (List<User>) HibernateSessionFactorySessionUtil.getSessionFactory()
                .openSession().createQuery("FROM User").list();

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

    @Override
    public void addUser(User newUser) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User userToUpdate) {

    }
}
