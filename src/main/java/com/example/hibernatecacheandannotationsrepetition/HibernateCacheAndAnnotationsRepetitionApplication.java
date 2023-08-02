package com.example.hibernatecacheandannotationsrepetition;

import java.sql.*;
import java.util.List;

public class HibernateCacheAndAnnotationsRepetitionApplication {
    public static void main(String[] args) throws SQLException {

        final String user = "postgres";
        final String password = "0451";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password)) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            CityDAO cityDAO = new CityDAOImpl(connection);

            City newCity = new City("Luga");
            cityDAO.insertCityIntoTable(newCity);

            Employee newEmployee = new Employee("Andrey", "Martynov", "MALE", 37, newCity.getCity_id());
            employeeDAO.insertEmployeeIntoTable(newEmployee);
            employeeDAO.selectEmployeeById(4);
            employeeDAO.getAllEmployees();
            employeeDAO.updateEmployee(newEmployee);

            newCity.setCity_name("Velikiye Luki");
            cityDAO.updateCity(newCity);

            employeeDAO.dropEmployee(newEmployee);
            cityDAO.dropCity(newCity);
        }
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
