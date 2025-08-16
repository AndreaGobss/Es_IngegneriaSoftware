public class es29 {
    public static void main(String[] args) {
        Canzone[] playlist = {
            new Canzone("Song1", "Artista1", 210),
            new Canzone("Song2", "Artista2", 180),
            new Canzone("Song3", "Artista3", 240)
        };
        System.out.println(Canzone.durataTotale(playlist));
    }
}

class Canzone {
    private String titolo;
    private String artista;
    private int durata; // in secondi

    public Canzone(String titolo, String artista, int durata) {
        this.titolo = titolo;
        this.artista = artista;
        this.durata = durata;
    }

    public static int durataTotale(Canzone[] playlist) {
        int tot = 0;
        for (Canzone c : playlist) {
            tot += c.durata;
        }
        return tot;
    }
}
