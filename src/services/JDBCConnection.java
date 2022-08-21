package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private Connection connection = buildConnection();

    private Connection buildConnection() {
        try {
//           Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.20.107:5432/portal", "portal", "Per@2020#jul");
         Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/portal", "portal", "Per@2020#jul");
            Class.forName("org.postgresql.Driver");
            con.setAutoCommit(false);

            return con;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("JDBC Connection failure");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }

}



