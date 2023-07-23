package com.example.hibernatecacheandannotationsrepetition;

public interface RoleDAO {
    void createNewRole(Role role);
    Role getRoleByID(int id);

    Role getRoleByName(String name);

    void deleteRole(Role role);
}
