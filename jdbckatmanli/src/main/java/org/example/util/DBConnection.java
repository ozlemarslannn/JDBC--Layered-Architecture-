package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public  Connection openConnection() {
        String url = "jdbc:postgresql://IP_ADRESS:PORT_NUMBER/DATABASE_NAME";
        String userName = "postgres";
        String password = "postgres";

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadı: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL bağlantı hatası: " + e.getMessage());
        }
        return connection;
    }

    public  void  closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Bağlantı kapatma sırasında hata alındı: " + e.getMessage());
        }
    }
}