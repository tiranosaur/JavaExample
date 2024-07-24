package org.example.repository;

import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    private static final String URL = "jdbc:mysql://mysql-8.2:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER_CLASS);
            System.out.println("MySQL Driver successfully loaded.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User get(UUID id) {
        User user = null;
        String query = "SELECT id, name, age FROM users WHERE id = ?";

        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, id.toString());
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    user = new User(rs.getObject("id"), rs.getString("name"), rs.getInt("age"));
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return user;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (
                Connection connection = this.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            connection.setAutoCommit(false);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    users.add(new User(rs.getObject("id"), rs.getString("name"), rs.getInt("age")));
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return users;
    }

    public void save(User user) {
        try {
            String query = "INSERT INTO users (id, name, age) VALUES (?, ?, ?)";

            Connection connection = getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                connection.setAutoCommit(false); // Start transaction
                preparedStatement.setString(1, user.getId().toString());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setInt(3, user.getAge());
                preparedStatement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction on error
                System.err.println(e.getMessage());
            } finally {
                connection.setAutoCommit(true); // Restore default auto-commit behavior
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean delete(UUID id) {
        try {
            String query = "DELETE FROM users WHERE id = ?";
            boolean rowDeleted;
            Connection connection = getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                connection.setAutoCommit(false); // Start transaction
                preparedStatement.setString(1, id.toString());
                rowDeleted = preparedStatement.executeUpdate() > 0;
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction on error
                throw e;
            } finally {
                connection.setAutoCommit(true); // Restore default auto-commit behavior
            }
            return rowDeleted;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
