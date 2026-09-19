package org.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public static boolean registerUser(
            String name,
            String email,
            String phone,
            String password
    ) throws SQLException {

        String sql = """
                INSERT INTO users (name, email, phone, password)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, phone);
            statement.setString(4, password);

            statement.executeUpdate();

            return true;
        }
    }
}