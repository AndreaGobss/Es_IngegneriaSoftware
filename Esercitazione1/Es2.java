import java.util.ArrayList;
import java.util.List;

abstract class MaterialeBibliotecario {
    private String titolo;
    private int annoPubblicazione;

    public MaterialeBibliotecario(String titolo, int annoPubblicazione) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public String toString() {
        return "Titolo: " + titolo + ", Anno di Pubblicazione: " + annoPubblicazione;
    }
}

class Libro extends MaterialeBibliotecario {
    private String autore;

    public Libro(String titolo, int annoPubblicazione, String autore) {
        super(titolo, annoPubblicazione);
        this.autore = autore;
    }

    public String getAutore() {
        return autore;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autore: " + autore;
    }
}

class Rivista extends MaterialeBibliotecario {
    private int numeroEdizione;

    public Rivista(String titolo, int annoPubblicazione, int numeroEdizione) {
        super(titolo, annoPubblicazione);
        this.numeroEdizione = numeroEdizione;
    }

    public int getNumeroEdizione() {
        return numeroEdizione;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numero Edizione: " + numeroEdizione;
    }
}

class Biblioteca {
    private List<MaterialeBibliotecario> materiali;

    public Biblioteca() {
        this.materiali = new ArrayList<>();
    }

    public void aggiungiMateriale(MaterialeBibliotecario materiale) {
        materiali.add(materiale);
    }

    public void rimuoviMateriale(MaterialeBibliotecario materiale) {
        materiali.remove(materiale);
    }

    public void visualizzaMateriali() {
        for (MaterialeBibliotecario materiale : materiali) {
            System.out.println(materiale);
        }
    }
}

public class Es2 {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro("Il Signore Panini", 1954, "J.R.R. Tolkien");
        Rivista rivista1 = new Rivista("Panini super gustosi", 2025, 5);

        biblioteca.aggiungiMateriale(libro1);
        biblioteca.aggiungiMateriale(rivista1);

        biblioteca.visualizzaMateriali();
    }
}