import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bioskop bioskop = new Bioskop("Cinema XXI");
        Database database = new Database();

        // Inisialisasi daftar film
        Film film1 = new Film("Avengers: Endgame", 75000);
        Film film2 = new Film("Spider-Man: No Way Home", 80000);

        // Menambahkan film ke bioskop
        bioskop.tambahFilm(film1);
        bioskop.tambahFilm(film2);

        boolean beliLagi;

        do {
            System.out.println("Selamat datang di " + bioskop.getNama());
            System.out.println("Daftar Film:");

            List<Film> daftarFilm = bioskop.getDaftarFilm();
            for (int i = 0; i < daftarFilm.size(); i++) {
                Film film = daftarFilm.get(i);
                System.out.println((i + 1) + ". " + film.getJudul() + " - Rp " + film.getHargaTiket());
            }

            System.out.print("Pilih nomor film yang ingin ditonton: ");
            int pilihanFilm = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            System.out.print("Masukkan jumlah penonton: ");
            int jumlahPenonton = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            List<Penonton> daftarPenonton = new ArrayList<>();
            double totalHarga = 0;

            for (int i = 0; i < jumlahPenonton; i++) {
                System.out.print("Masukkan nama penonton ke-" + (i + 1) + ": ");
                String namaPenonton = scanner.nextLine();

                System.out.print("Masukkan nomor kursi yang diinginkan: ");
                int nomorKursi = scanner.nextInt();
                scanner.nextLine(); // membersihkan newline

                Film filmDipilih = daftarFilm.get(pilihanFilm - 1);
                Tiket tiket = new Tiket(filmDipilih, nomorKursi);
                Penonton penonton = new Penonton(namaPenonton, tiket);

                bioskop.tambahPenonton(penonton);
                daftarPenonton.add(penonton);

                totalHarga += filmDipilih.getHargaTiket(); // Menambahkan harga tiket ke total harga
            }

            // Proses pembayaran (contoh sederhana)
            Pembayaran pembayaran = new Pembayaran();
            boolean sukses = pembayaran.prosesPembayaran(totalHarga);

            if (sukses) {
                System.out.println("Pembelian tiket berhasil!");
                System.out.println("Total harga semua tiket: Rp " + totalHarga);
            } else {
                System.out.println("Pembayaran gagal, silahkan coba lagi.");
            }

            // Tambahkan semua penonton ke database
            for (Penonton p : daftarPenonton) {
                database.tambahPenonton(p);
            }

            // Tampilkan daftar penonton (contoh sederhana)
            List<Penonton> daftarSemuaPenonton = database.getDaftarPenonton();
            System.out.println("\nDaftar Penonton:");
            for (Penonton p : daftarSemuaPenonton) {
                System.out.println(p.getNama() + " - " + p.getTiket().getFilm().getJudul() +
                        " - Nomor Kursi: " + p.getTiket().getNomorKursi());
            }

            // Tanya apakah ingin melakukan pembelian lagi
            System.out.print("\nApakah ada penambahan pembelian lagi? (ya/tidak): ");
            String jawaban = scanner.nextLine();

            if (jawaban.equalsIgnoreCase("ya")) {
                beliLagi = true;
            } else {
                beliLagi = false;
                System.out.println("Terima kasih telah menggunakan layanan kami.");
            }

        } while (beliLagi);

        scanner.close();
    }
}