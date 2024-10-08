package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.util.JDBCUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<User> getAll_query() {
        return entityManager.createQuery("select u from users u", User.class).getResultList();
    }

    @Transactional
    public List<User> getAll_criteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    public Collection<User> getAll_jdbc() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection connection = JDBCUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            connection.setAutoCommit(false);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    byte[] idBytes = rs.getBytes("id");
                    ByteBuffer byteBuffer = ByteBuffer.wrap(idBytes);
                    UUID id = new UUID(byteBuffer.getLong(), byteBuffer.getLong());
                    users.add(new User(id, rs.getString("username"), rs.getInt("age")));
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}
