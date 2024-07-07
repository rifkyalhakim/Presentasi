import java.util.ArrayList;
import java.util.List;

public class Bioskop {
    private String nama;
    private List<Film> daftarFilm;
    private List<Penonton> daftarPenonton;

    public Bioskop(String nama) {
        this.nama = nama;
        this.daftarFilm = new ArrayList<>();
        this.daftarPenonton = new ArrayList<>();
    }

    public void tambahFilm(Film film) {
        daftarFilm.add(film);
    }

    public List<Film> getDaftarFilm() {
        return daftarFilm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void tambahPenonton(Penonton penonton) {
        daftarPenonton.add(penonton);
    }

    public List<Penonton> getDaftarPenonton() {
        return daftarPenonton;
    }
}