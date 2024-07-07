import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Film> daftarFilm;
    private List<Penonton> daftarPenonton;

    public Database() {
        daftarFilm = new ArrayList<>();
        daftarPenonton = new ArrayList<>();
    }

    public void tambahFilm(Film film) {
        daftarFilm.add(film);
    }

    public void tambahPenonton(Penonton penonton) {
        daftarPenonton.add(penonton);
    }

    public List<Film> getDaftarFilm() {
        return daftarFilm;
    }

    public List<Penonton> getDaftarPenonton() {
        return daftarPenonton;
    }
}