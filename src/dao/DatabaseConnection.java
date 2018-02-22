package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private Connection connection = null;

    private DatabaseConnection() {
        getConnectionToDatabase();
    }

    private void getConnectionToDatabase() {
        try{
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection("jdbc:sqlite:resources/library");
        } catch (SQLException | NullPointerException e ){
            System.out.println("DB connection problem.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return this.connection;
    }

}

