package com.example.hibernatecacheandannotationsrepetition;

import java.sql.*;
import java.util.List;

public class HibernateCacheAndAnnotationsRepetitionApplication {

        UserDAO userDAO = new UserDAOImpl() {
            @Override
            public User getUserByID(int id) {
                return null;
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
    }
}
