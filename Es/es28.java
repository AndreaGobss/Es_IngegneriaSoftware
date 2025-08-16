public class es28 {
    public static void main(String[] args) {
        Prodotto[] prodotti = {
            new Alimentare("Pane"),
            new Elettronico("Telefono"),
            new Alimentare("Latte"),
            new Elettronico("PC")
        };

        for (Prodotto p : prodotti) {
            if (p instanceof Alimentare) {
                System.out.println(p.getNome());
            }
        }
    }
}

class Prodotto {
    private String nome;

    public Prodotto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Alimentare extends Prodotto {
    public Alimentare(String nome) {
        super(nome);
    }
}

class Elettronico extends Prodotto {
    public Elettronico(String nome) {
        super(nome);
    }
}
