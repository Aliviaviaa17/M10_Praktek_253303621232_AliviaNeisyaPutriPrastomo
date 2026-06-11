import java.io.*;
import java.util.ArrayList;

public class GuildSystem {
    public static void main(String[] args) {
        
        // ==========================================
        // 3. PROSES SAVE (SKENARIO PERTAMA)
        // ==========================================
        
        // Buat sebuah ArrayList<Member>
        ArrayList<Member> guildMembers = new ArrayList<>();
        
        // Isi ArrayList tersebut dengan 3 objek Member secara manual
        guildMembers.add(new Member("G004", "Jaehyun"));
        guildMembers.add(new Member("G007", "Alivia"));
        guildMembers.add(new Member("G009", "Akies"));
        
        System.out.println("Memulai proses Serialization...");
        
        // Tulis logika Serialization (Try-With-Resources) ke file "guild_data.dat"
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("guild_data.dat"))) {
            oos.writeObject(guildMembers);
            System.out.println("Data Guild BERHASIL disimpan ke 'guild_data.dat'!\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
        }

        
        // ==========================================
        // 4. PROSES LOAD (SKENARIO KEDUA)
        // ==========================================
        
        System.out.println("Memulai proses Deserialization...");
        
        // Tulis logika Deserialization untuk membaca file "guild_data.dat"
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("guild_data.dat"))) {
            
            // SYARAT MUTLAK: Beri komentar berawalan // pada bagian Downcasting ArrayList
            // Melakukan downcasting object hasil readObject() secara eksplisit menjadi tipe ArrayList<Member>
            @SuppressWarnings("unchecked")
            ArrayList<Member> loadedMembers = (ArrayList<Member>) ois.readObject();
            
            System.out.println("Data Guild BERHASIL dimuat dari file!\n");
            System.out.println("=== DAFTAR MEMBER GUILD ===");
            
            // Gunakan Foreach loop untuk mencetak semua ID dan Nama Member ke layar terminal
            for (Member m : loadedMembers) {
                System.out.println("ID: " + m.getId() + " | Nama: " + m.getNama());
            }
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat memuat data: " + e.getMessage());
        }
    }
}