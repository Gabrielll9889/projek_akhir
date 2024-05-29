package model;

public class Contact {
    // Atribut untuk menyimpan data kontak
    private int id;          // ID unik untuk setiap kontak
    private String name;     // Nama kontak
    private String phone;    // Nomor telepon kontak
    private String email;    // Alamat email kontak

    // Konstruktor default
    public Contact() {}

    // Konstruktor untuk membuat kontak baru tanpa ID (biasanya untuk kontak baru yang belum disimpan di database)
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Konstruktor untuk membuat kontak dengan ID (biasanya untuk kontak yang sudah ada di database)
    public Contact(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter untuk mendapatkan ID kontak
    public int getId() {
        return id;
    }

    // Setter untuk mengatur ID kontak
    public void setId(int id) {
        this.id = id;
    }

    // Getter untuk mendapatkan nama kontak
    public String getName() {
        return name;
    }

    // Setter untuk mengatur nama kontak
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk mendapatkan nomor telepon kontak
    public String getPhone() {
        return phone;
    }

    // Setter untuk mengatur nomor telepon kontak
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter untuk mendapatkan alamat email kontak
    public String getEmail() {
        return email;
    }

    // Setter untuk mengatur alamat email kontak
    public void setEmail(String email) {
        this.email = email;
    }
}
