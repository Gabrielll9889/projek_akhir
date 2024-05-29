package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // URL untuk menghubungkan ke database MySQL yang berada di localhost pada port 3306, dan menggunakan database bernama contact_db
    private static final String URL = "jdbc:mysql://localhost:3306/contact_db";
    // Username untuk mengakses database
    private static final String USER = "root";
    // Password untuk mengakses database (disarankan untuk tidak menggunakan password kosong pada aplikasi produksi)
    private static final String PASSWORD = "";

    // Metode untuk mendapatkan koneksi ke database
    public static Connection getConnection() throws SQLException {
        // Menggunakan DriverManager untuk mendapatkan koneksi ke database dengan URL, username, dan password yang telah ditentukan
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
