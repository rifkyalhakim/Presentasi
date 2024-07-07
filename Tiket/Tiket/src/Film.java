public class Film {
    private String judul;
    private int hargaTiket;

    public Film(String judul, int hargaTiket) {
        this.judul = judul;
        this.hargaTiket = hargaTiket;
    }

    public String getJudul() {
        return judul;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }
}