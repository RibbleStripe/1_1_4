package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static Connection getConnection() {
        Connection connection;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb";
            String USERNAME = "root";
            String PASSWORD = "root";
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

