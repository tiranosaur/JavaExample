package org.example.demojst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/docker";
    private static final String USER = "root";
    private static final String PASSWORD = "tiger";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    private DBUtil() {
    }

    static {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
