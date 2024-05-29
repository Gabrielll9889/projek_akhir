import controller.ContactController;
import model.ContactDAO;
import view.ContactView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Menjalankan kode di Event Dispatch Thread (EDT) untuk memastikan bahwa GUI berjalan di thread yang aman
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Membuat instance ContactDAO untuk berinteraksi dengan database
                ContactDAO contactDAO = new ContactDAO();
                // Membuat instance ContactView untuk menampilkan antarmuka pengguna
                ContactView contactView = new ContactView();
                // Membuat instance ContactController untuk menghubungkan model (ContactDAO) dan view (ContactView)
                new ContactController(contactDAO, contactView);
                // Mengatur jendela ContactView agar terlihat
                contactView.setVisible(true);
            }
        });
    }
}
