package org.example.demojst.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.demojst.model.*;
import org.example.demojst.util.DBUtil;

public class UserDAO {
    public void insertUser(User user) throws SQLException {
        String query = "INSERT INTO users (name, email, country) VALUES (?, ?, ?)";

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false); // Start transaction
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback(); // Rollback transaction on error
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore default auto-commit behavior
        }
    }

    public User selectUser(int id) throws SQLException {
        User user = null;
        String query = "SELECT id, name, email, country FROM users WHERE id = ?";

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false); // Start transaction
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("country"));
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback(); // Rollback transaction on error
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore default auto-commit behavior
        }
        return user;
    }

    public List<User> selectAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false); // Start transaction
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("country")));
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback(); // Rollback transaction on error
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore default auto-commit behavior
        }
        return users;
    }

    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";
        boolean rowUpdated;

        Connection connection = DBUtil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false); // Start transaction
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            connection.rollback(); // Rollback transaction on error
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
        return rowUpdated;
    }

    public boolean deleteUser(int id) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        boolean rowDeleted;
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false); // Start transaction
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
            connection.commit();
        } catch (SQLException e) {
            connection.rollback(); // Rollback transaction on error
            throw e;
        } finally {
            connection.setAutoCommit(true); // Restore default auto-commit behavior
        }
        return rowDeleted;
    }
}
