package com.example.hibernatecacheandannotationsrepetition;

import java.sql.*;
import java.util.List;

public class HibernateCacheAndAnnotationsRepetitionApplication {
    public static void main(String[] args) throws SQLException {

        UserDAO userDAO = new UserDAO() {
            @Override
            public void create(User user) {

            }

            @Override
            public User getUserByID(int id) {
                return null;
            }

            @Override
            public List<User> getUsersByRole(Role role) {
                return null;
            }

            @Override
            public List<User> getEveryone() {
                return null;
            }

            @Override
            public void updatePersonById(User user) {

            }

            @Override
            public void deleteUser(User user) {

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
        };

        User newUser = new User("John", "Doe");
        userDAO.addUser(newUser);

        List<User> users = userDAO.getAllUsers();
        System.out.println("Список пользователей:");
        for (User user : users) {
            System.out.println(user);
        }

        User userToUpdate = users.get(0);
        userToUpdate.setLastName("Smith");
        userDAO.updateUser(userToUpdate);

        User userToDelete = users.get(1);
        userDAO.deleteUser(userToDelete);

        RoleDAO roleDAO = new RoleDAO() {
            @Override
            public void createNewRole(Role role) {

            }

            @Override
            public Role getRoleByID(int id) {
                return null;
            }

            @Override
            public Role getRoleByName(String name) {
                return null;
            }

            @Override
            public void deleteRole(Role role) {

            }

            @Override
            public void addRole(Role newRole) {

            }

            @Override
            public List<Role> getAllRoles() {
                return null;
            }

            @Override
            public void updateRole(Role roleToUpdate) {

            }
        };

        Role newRole = new Role("Admin");
        roleDAO.addRole(newRole);

        List<Role> roles = roleDAO.getAllRoles();
        System.out.println("Список ролей:");
        for (Role role : roles) {
            System.out.println(role);
        }

        Role roleToUpdate = roles.get(0);
        roleToUpdate.setName("user");
        roleDAO.updateRole(roleToUpdate);

        Role roleToDelete = roles.get(1);
        roleDAO.deleteRole(roleToDelete);
    }
}
