import java.util.ArrayList;

public class es11 {
    public static void main(String[] args) {
        ArrayList<Prodotto> prodotti = new ArrayList<>();
        prodotti.add(new Prodotto("Pane", "P01", 1.2));
        prodotti.add(new Prodotto("Latte", "L02", 0.9));
        prodotti.add(new Prodotto("Uova", "U03", 2.5));

        String codiceCercato = "L02";
        Prodotto trovato = null;
        for (Prodotto p : prodotti) {
            if (p.getCodice().equals(codiceCercato)) {
                trovato = p;
                break;
            }
        }
        if (trovato != null) {
            System.out.println(trovato.getNome() + " " + trovato.getPrezzo());
        } else {
            System.out.println("Prodotto non trovato");
        }
    }
}

class Prodotto {
    private String nome;
    private String codice;
    private double prezzo;

    public Prodotto(String nome, String codice, double prezzo) {
        this.nome = nome;
        this.codice = codice;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodice() {
        return codice;
    }

    public double getPrezzo() {
        return prezzo;
    }
}
