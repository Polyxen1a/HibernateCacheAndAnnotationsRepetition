package com.example.hibernatecacheandannotationsrepetition;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public void createNewRole(Role role) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        }
    }

    @Override
    public Role getRoleByID(int id) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            return session.get(Role.class, id);
        }
    }

    @Override
    public Role getRoleByName(String name) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Role WHERE name = :name", Role.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    @Override
    public void deleteRole(Role role) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        }
    }

    @Override
    public List<Role> getAllRoles() {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Role", Role.class).list();
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

