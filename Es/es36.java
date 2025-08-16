public class es36 {
    public static void main(String[] args) {
        Libro[] libri = {
            new Libro("Il nome della rosa", "Eco", "Giallo", 1980),
            new Libro("1984", "Orwell", "Fantascienza", 1949),
            new Libro("I promessi sposi", "Manzoni", "Storico", 1827),
            new Libro("Il pendolo di Foucault", "Eco", "Giallo", 1988)
        };

        String autoreCercato = "Eco";
        String genereCercato = "Giallo";

        for (Libro l : libri) {
            if (l.getAutore().equals(autoreCercato) && l.getGenere().equals(genereCercato)) {
                System.out.println(l.getTitolo());
            }
        }
    }
}

class Libro {
    private String titolo;
    private String autore;
    private String genere;
    private int anno;

    public Libro(String titolo, String autore, String genere, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.anno = anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public int getAnno() {
        return anno;
    }
}
