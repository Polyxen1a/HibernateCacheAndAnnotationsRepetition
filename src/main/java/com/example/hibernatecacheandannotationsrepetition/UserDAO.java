package com.example.hibernatecacheandannotationsrepetition;

import java.util.List;

public interface UserDAO {

    void create(User user);

    User getUserByID(int id);

    List<User> getUsersByRole(Role role);

    List<User> getUsersByRole();

    List<User> getEveryone();

    void updatePersonById(User user);

    void deleteUser(User user);

    void addUser(User newUser);

    List<User> getAllUsers();

    void updateUser(User userToUpdate);

    void addRole(Role newRole);

    List<Role> getAllRoles();

    void updateRole(Role roleToUpdate);
}
