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
        return HibernateSessionFactorySessionUtil.getSessionFactory().openSession().get(Role.class, id);
    }


    @Override
    public Role getRoleByName(String name) {
        return HibernateSessionFactorySessionUtil.getSessionFactory().openSession().get(Role.class, name);
    }


    @Override
    public void deleteRole(Role role) {
        try (Session session = HibernateSessionFactorySessionUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(role);
            transaction.commit();
        }
        @Override
        public void addRole(Role newRole) {

        }
        @Override
        public List<Role> getAllRoles() {

    }
        @Override
        public void updateRole(Role roleToUpdate) {
            
        }
}
