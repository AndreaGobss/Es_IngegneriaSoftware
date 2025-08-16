public class es41 {
    public static void main(String[] args) {
        Prodotto p1 = new Prodotto("Pane", 1.2);
        Prodotto p2 = new Prodotto("Latte", 0.9);
        Prodotto p3 = new Prodotto("Uova", 2.5);

        Cliente c1 = new Cliente("Gianni");
        Cliente c2 = new Cliente("Luca");

        Ordine o1 = new Ordine();
        o1.aggiungiProdotto(p1);
        o1.aggiungiProdotto(p2);

        Ordine o2 = new Ordine();
        o2.aggiungiProdotto(p3);

        c1.aggiungiOrdine(o1);
        c2.aggiungiOrdine(o2);

        System.out.println("Totale ordine Gianni: " + o1.totale());
        System.out.println("Totale ordine Luca: " + o2.totale());
    }
}

class Prodotto {
    private String nome;
    private double prezzo;

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }
}

class Cliente {
    private String nome;
    private java.util.ArrayList<Ordine> ordini = new java.util.ArrayList<>();

    public Cliente(String nome) {
        this.nome = nome;
    }

    public void aggiungiOrdine(Ordine o) {
        ordini.add(o);
    }

    public java.util.ArrayList<Ordine> getOrdini() {
        return ordini;
    }
}

class Ordine {
    private java.util.ArrayList<Prodotto> prodotti = new java.util.ArrayList<>();

    public void aggiungiProdotto(Prodotto p) {
        prodotti.add(p);
    }

    public double totale() {
        double tot = 0;
        for (Prodotto p : prodotti) {
            tot += p.getPrezzo();
        }
        return tot;
    }
}
