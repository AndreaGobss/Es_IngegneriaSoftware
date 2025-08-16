import java.util.ArrayList;
import java.util.function.Predicate;

public class es24 {
    public static void main(String[] args) {
        Catalogo<Prodotto> catalogo = new Catalogo<>();
        catalogo.aggiungi(new Prodotto("Pane", 1.2, true));
        catalogo.aggiungi(new Prodotto("Latte", 0.9, false));
        catalogo.aggiungi(new Prodotto("Uova", 2.5, true));

        ArrayList<Prodotto> perPrezzo = catalogo.filtra(p -> p.getPrezzo() < 2);
        ArrayList<Prodotto> perNome = catalogo.filtra(p -> p.getNome().startsWith("P"));
        ArrayList<Prodotto> disponibili = catalogo.filtra(p -> p.isDisponibile());

        for (Prodotto p : perPrezzo) {
            System.out.println("Prezzo < 2: " + p.getNome());
        }
        for (Prodotto p : perNome) {
            System.out.println("Nome P: " + p.getNome());
        }
        for (Prodotto p : disponibili) {
            System.out.println("Disponibile: " + p.getNome());
        }
    }
}

class Catalogo<T> {
    private ArrayList<T> elementi = new ArrayList<>();

    public void aggiungi(T elem) {
        elementi.add(elem);
    }

    public ArrayList<T> filtra(Predicate<T> pred) {
        ArrayList<T> risultato = new ArrayList<>();
        for (T e : elementi) {
            if (pred.test(e)) {
                risultato.add(e);
            }
        }
        return risultato;
    }
}

class Prodotto {
    private String nome;
    private double prezzo;
    private boolean disponibile;

    public Prodotto(String nome, double prezzo, boolean disponibile) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.disponibile = disponibile;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }
}