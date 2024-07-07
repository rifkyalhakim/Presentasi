public class Penonton {
    private String nama;
    private Tiket tiket;

    public Penonton(String nama, Tiket tiket) {
        this.nama = nama;
        this.tiket = tiket;
    }

    public String getNama() {
        return nama;
    }

    public Tiket getTiket() {
        return tiket;
    }
}