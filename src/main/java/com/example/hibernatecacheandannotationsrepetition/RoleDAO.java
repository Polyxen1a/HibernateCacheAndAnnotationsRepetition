package com.example.hibernatecacheandannotationsrepetition;

import java.util.List;

public interface RoleDAO {
    void createNewRole(Role role);
    Role getRoleByID(int id);

    Role getRoleByName(String name);

    void deleteRole(Role role);

    void addRole(Role newRole);

    List<Role> getAllRoles();

    void updateRole(Role roleToUpdate);
}
