package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ContactView extends JFrame {
    // Membuat instance dari ContactForm untuk bagian input data
    private ContactForm contactForm = new ContactForm();
    // Membuat tabel untuk menampilkan data kontak dengan model tabel default
    private JTable contactTable = new JTable(new DefaultTableModel(new Object[]{"ID", "Name", "Phone", "Email"}, 0));
    // Membungkus tabel dengan JScrollPane untuk memungkinkan scrolling
    private JScrollPane tableScrollPane = new JScrollPane(contactTable);

    // Konstruktor untuk mengatur tampilan jendela
    public ContactView() {
        // Mengatur judul jendela
        setTitle("Contact Management");
        // Mengatur operasi default saat jendela ditutup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Mengatur ukuran jendela
        setSize(600, 400);
        // Mengatur layout jendela menjadi BorderLayout
        setLayout(new BorderLayout());

        // Menambahkan ContactForm ke bagian atas jendela
        add(contactForm, BorderLayout.NORTH);
        // Menambahkan JScrollPane yang membungkus tabel ke bagian tengah jendela
        add(tableScrollPane, BorderLayout.CENTER);
    }

    // Getter untuk mendapatkan instance ContactForm
    public ContactForm getContactForm() {
        return contactForm;
    }

    // Getter untuk mendapatkan instance JTable
    public JTable getContactTable() {
        return contactTable;
    }

    // Getter untuk mendapatkan model tabel dari JTable
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) contactTable.getModel();
    }
}
