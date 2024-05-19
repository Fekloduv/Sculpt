package com.example.sculpte;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sculpt";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";

    public DatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables or perform any necessary setup
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade database version if needed
    }

    public int getUserId(String nameSent, String passwordSent) {
        int user_id = -1;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sculpt", USERNAME, PASSWORD);
            String schema = "public";
            String table = "users";
            String query = "SELECT * FROM " + schema + "." + table + " WHERE name = '" + nameSent + "' AND password = '" + passwordSent + "'";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    user_id = resultSet.getInt("id_user");
                }
            } catch (SQLException e) {
                System.err.println("Error executing query: " + e.getMessage());
                return -1;
            }
            return user_id;

        } catch (Exception e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return -1;
        }
    }
}

