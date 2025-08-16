import java.util.ArrayList;

public class es15 {
    public static void main(String[] args) {
        ArrayList<Libro> libri = new ArrayList<>();
        libri.add(new Libro("Il nome della rosa", "Eco", 1980));
        libri.add(new Libro("1984", "Orwell", 1949));
        libri.add(new Libro("I promessi sposi", "Manzoni", 1827));

        for (Libro l : libri) {
            System.out.println(l.getTitolo() + " " + l.getAutore() + " " + l.getAnno());
        }
    }
}

class Libro {
    private String titolo;
    private String autore;
    private int anno;

    public Libro(String titolo, String autore, int anno) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public int getAnno() {
        return anno;
    }
}

