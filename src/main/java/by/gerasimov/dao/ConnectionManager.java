package by.gerasimov.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static String url = "jdbc:mysql://localhost:3306/userBankList?useTimezone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "1111";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}