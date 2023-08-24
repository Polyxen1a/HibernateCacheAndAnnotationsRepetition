package com.example.hibernatecacheandannotationsrepetition;


import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;


public class UserDAOImpl implements UserDAO {
    @Override
    public void create(User user) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    @Override
    public User getUserByID(int id) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            List<User> users = session.createQuery("SELECT u FROM User u WHERE :role MEMBER OF u.roles", User.class)
                    .setParameter("role", role)
                    .list();
            return users;
        }
    }

    @Override
    public List<User> getUsersByRole() {
        return null;
    }

    @Override
    public List<User> getEveryone() {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            List<User> users = session.createQuery("FROM User", User.class)
                    .list();
            return users;
        }
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


    @Override
    public void addRole(Role newRole) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(newRole);
            transaction.commit();
        }
    }

    @Override
    public List<Role> getAllRoles() {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            List<Role> roles = session.createQuery("FROM Role", Role.class)
                    .list();
            return roles;
        }
    }

    @Override
    public void updateRole(Role roleToUpdate) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(roleToUpdate);
            transaction.commit();
        }
    }
}

