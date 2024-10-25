package fr.rana.baedaar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/esiea_social_network";
    private static final String USER = "Baedaar";
    private static final String PASSWORD = "n@3J2wXle@Qe4).Y";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
