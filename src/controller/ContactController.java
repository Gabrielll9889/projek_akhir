package controller;

import model.Contact;
import model.ContactDAO;
import view.ContactView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ContactController {
    private ContactDAO contactDAO; // DAO untuk mengakses data kontak dari database
    private ContactView contactView; // View untuk menampilkan dan mengelola antarmuka pengguna

    // Konstruktor untuk menginisialisasi ContactController dengan objek DAO dan View
    public ContactController(ContactDAO contactDAO, ContactView contactView) {
        this.contactDAO = contactDAO;
        this.contactView = contactView;

        // Menambahkan ActionListener untuk tombol Save di form kontak
        contactView.getContactForm().getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveContact(); // Memanggil metode untuk menyimpan kontak
            }
        });

        // Menambahkan ActionListener untuk tombol Delete di form kontak
        contactView.getContactForm().getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact(); // Memanggil metode untuk menghapus kontak
            }
        });

        // Menambahkan ActionListener untuk tombol Edit di form kontak
        contactView.getContactForm().getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editContact(); // Memanggil metode untuk mengedit kontak
            }
        });

        // Memuat data kontak pada saat controller diinisialisasi
        loadContacts();
    }

    // Metode untuk menyimpan kontak
    private void saveContact() {
        // Mendapatkan data dari form kontak
        String name = contactView.getContactForm().getNameField().getText();
        String phone = contactView.getContactForm().getPhoneField().getText();
        String email = contactView.getContactForm().getEmailField().getText();

        // Membuat objek Contact baru
        Contact contact = new Contact(name, phone, email);

        try {
            // Menambahkan kontak ke database melalui DAO
            contactDAO.addContact(contact);
            loadContacts(); // Memuat ulang data kontak setelah penambahan
            JOptionPane.showMessageDialog(contactView, "Contact saved successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(contactView, "Error saving contact: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode untuk menghapus kontak
    private void deleteContact() {
        int selectedRow = contactView.getContactTable().getSelectedRow(); // Mendapatkan baris yang dipilih dari tabel kontak
        if (selectedRow != -1) {
            // Mendapatkan ID kontak dari tabel berdasarkan baris yang dipilih
            int id = (int) contactView.getTableModel().getValueAt(selectedRow, 0);
            try {
                // Menghapus kontak dari database melalui DAO
                contactDAO.deleteContact(id);
                loadContacts(); // Memuat ulang data kontak setelah penghapusan
                JOptionPane.showMessageDialog(contactView, "Contact deleted successfully!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(contactView, "Error deleting contact: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(contactView, "Please select a contact to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode untuk mengedit kontak
    private void editContact() {
        int selectedRow = contactView.getContactTable().getSelectedRow(); // Mendapatkan baris yang dipilih dari tabel kontak
        if (selectedRow != -1) {
            // Mendapatkan ID kontak dari tabel berdasarkan baris yang dipilih
            int id = (int) contactView.getTableModel().getValueAt(selectedRow, 0);
            // Mendapatkan data baru dari form kontak
            String name = contactView.getContactForm().getNameField().getText();
            String phone = contactView.getContactForm().getPhoneField().getText();
            String email = contactView.getContactForm().getEmailField().getText();
            // Membuat objek Contact dengan data yang diperbarui
            Contact contact = new Contact(id, name, phone, email);
            try {
                // Memperbarui kontak di database melalui DAO
                contactDAO.updateContact(contact);
                loadContacts(); // Memuat ulang data kontak setelah pembaruan
                JOptionPane.showMessageDialog(contactView, "Contact updated successfully!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(contactView, "Error updating contact: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(contactView, "Please select a contact to edit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Metode untuk memuat data kontak dari database dan menampilkannya di tabel
    private void loadContacts() {
        try {
            // Mendapatkan daftar kontak dari database melalui DAO
            List<Contact> contacts = contactDAO.getAllContacts();
            DefaultTableModel model = contactView.getTableModel();
            model.setRowCount(0); // Menghapus data lama dari tabel

            // Menambahkan setiap kontak ke dalam tabel
            for (Contact contact : contacts) {
                model.addRow(new Object[]{contact.getId(), contact.getName(), contact.getPhone(), contact.getEmail()});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(contactView, "Error loading contacts: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
