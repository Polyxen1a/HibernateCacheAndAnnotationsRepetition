package com.example.hibernatecacheandannotationsrepetition;

import java.sql.SQLException;

public class HibernateCacheAndAnnotationsRepetitionApplication {
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAOImpl();
        RoleDAO roleDAO = new RoleDAOImpl();
    }
}
