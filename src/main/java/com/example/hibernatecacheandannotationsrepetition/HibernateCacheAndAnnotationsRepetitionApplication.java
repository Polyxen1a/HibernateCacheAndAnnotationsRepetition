package com.example.hibernatecacheandannotationsrepetition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HibernateCacheAndAnnotationsRepetitionApplication {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        final Connection finalConnection = connection;
        UserDAO userDAO = new UserDAOImpl() {
            @Override
            public User getUserByID(int id) {
                return null;
            }

            @Override
            public void addUser(User newUser) {
                String query = "INSERT INTO users (name, email) VALUES (?, ?)";
                try (PreparedStatement statement = finalConnection.prepareStatement(query)) {
                    statement.setString(1, newUser.getName());
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void updateUser(User userToUpdate) {

            }
        };
    }
}
