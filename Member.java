import java.io.Serializable;

// Wajib memenuhi syarat agar bisa disave (implements Serializable)
public class Member implements Serializable {
    // Atribut: String id, String nama
    private String id;
    private String nama;

    // Constructor untuk menset id dan nama
    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // Getter untuk memanggil atribut saat proses cetak/load
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}