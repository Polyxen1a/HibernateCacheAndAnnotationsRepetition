package com.example.hibernatecacheandannotationsrepetition;

import java.util.List;

public interface UserDAO {

    void create(User user);

    User getUserByID(int id);

    List<User> getUsersByRole(Role role);

    List<User> getEveryone();

    void updatePersonById(User user);

    void deleteUser(User user);
}
