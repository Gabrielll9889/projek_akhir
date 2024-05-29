package view;

import javax.swing.*;
import java.awt.*;

public class ContactForm extends JPanel {
    // Deklarasi field input dan tombol
    private JTextField nameField = new JTextField(20); // Field input untuk nama kontak
    private JTextField phoneField = new JTextField(20); // Field input untuk nomor telepon kontak
    private JTextField emailField = new JTextField(20); // Field input untuk email kontak
    private JButton saveButton = new JButton("Save"); // Tombol untuk menyimpan kontak
    private JButton deleteButton = new JButton("Delete"); // Tombol untuk menghapus kontak
    private JButton editButton = new JButton("Edit"); // Tombol untuk mengedit kontak

    // Konstruktor untuk mengatur layout dan menambahkan komponen ke panel
    public ContactForm() {
        // Menggunakan GridBagLayout untuk tata letak yang fleksibel
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Memberi margin antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL; // Mengatur agar komponen mengisi ruang horizontal yang tersedia

        // Menambahkan label dan field input untuk nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);

        // Menambahkan label dan field input untuk nomor telepon
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(phoneField, gbc);

        // Menambahkan label dan field input untuk email
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(emailField, gbc);

        // Menambahkan tombol save
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(saveButton, gbc);

        // Menambahkan tombol delete
        gbc.gridx = 2;
        gbc.gridy = 3;
        add(deleteButton, gbc);

        // Menambahkan tombol edit
        gbc.gridx = 3;
        gbc.gridy = 3;
        add(editButton, gbc);
    }

    // Getter untuk field input nama
    public JTextField getNameField() {
        return nameField;
    }

    // Getter untuk field input nomor telepon
    public JTextField getPhoneField() {
        return phoneField;
    }

    // Getter untuk field input email
    public JTextField getEmailField() {
        return emailField;
    }

    // Getter untuk tombol save
    public JButton getSaveButton() {
        return saveButton;
    }

    // Getter untuk tombol delete
    public JButton getDeleteButton() {
        return deleteButton;
    }

    // Getter untuk tombol edit
    public JButton getEditButton() {
        return editButton;
    }
}
