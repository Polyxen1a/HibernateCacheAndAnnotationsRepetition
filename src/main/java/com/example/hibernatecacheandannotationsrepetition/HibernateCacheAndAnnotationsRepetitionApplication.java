package com.example.hibernatecacheandannotationsrepetition;

import java.sql.*;

public class HibernateCacheAndAnnotationsRepetitionApplication {
    public static void main(String[] args) throws SQLException {
        UserDAO personDAO = new UserDAOImpl();
    }
}
