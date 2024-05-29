package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    // Metode untuk menambahkan kontak ke database
    public void addContact(Contact contact) throws SQLException {
        // Query SQL untuk menambahkan data kontak
        String query = "INSERT INTO contacts (name, phone, email) VALUES (?, ?, ?)";
        // Menggunakan try-with-resources untuk memastikan koneksi dan statement ditutup setelah digunakan
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            // Mengatur parameter query dengan data dari objek Contact
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            // Menjalankan query
            stmt.executeUpdate();
        }
    }

    // Metode untuk menghapus kontak dari database berdasarkan ID
    public void deleteContact(int id) throws SQLException {
        // Query SQL untuk menghapus data kontak berdasarkan ID
        String query = "DELETE FROM contacts WHERE id=?";
        // Menggunakan try-with-resources untuk memastikan koneksi dan statement ditutup setelah digunakan
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            // Mengatur parameter query dengan ID kontak
            stmt.setInt(1, id);
            // Menjalankan query
            stmt.executeUpdate();
        }
    }

    // Metode untuk memperbarui data kontak di database
    public void updateContact(Contact contact) throws SQLException {
        // Query SQL untuk memperbarui data kontak berdasarkan ID
        String query = "UPDATE contacts SET name=?, phone=?, email=? WHERE id=?";
        // Menggunakan try-with-resources untuk memastikan koneksi dan statement ditutup setelah digunakan
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            // Mengatur parameter query dengan data dari objek Contact
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getPhone());
            stmt.setString(3, contact.getEmail());
            stmt.setInt(4, contact.getId());
            // Menjalankan query
            stmt.executeUpdate();
        }
    }

    // Metode untuk mendapatkan semua kontak dari database
    public List<Contact> getAllContacts() throws SQLException {
        // List untuk menyimpan data kontak yang diambil dari database
        List<Contact> contacts = new ArrayList<>();
        // Query SQL untuk mendapatkan semua data kontak
        String query = "SELECT * FROM contacts";
        // Menggunakan try-with-resources untuk memastikan koneksi, statement, dan result set ditutup setelah digunakan
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            // Mengambil data kontak dari ResultSet dan menambahkannya ke list
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setPhone(rs.getString("phone"));
                contact.setEmail(rs.getString("email"));
                contacts.add(contact);
            }
        }
        // Mengembalikan list kontak
        return contacts;
    }
}
