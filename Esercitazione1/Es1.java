interface Veicolo {
    public int avvia();
    public int ferma();
    public String getTipo();
}

abstract class MezzoDiTrasporto implements Veicolo {
    private String targa;

    public MezzoDiTrasporto(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }
}

class Auto extends MezzoDiTrasporto {
    private String tipo = "auto";

    public Auto(String targa) {
        super(targa);
    }

    public int avvia() {
        return 1;
    }

    public int ferma() {
        return 0;
    }

    public String getTipo() {
        return tipo;
    }
}

class Moto extends MezzoDiTrasporto {
    private String tipo = "moto";

    public Moto(String targa) {
        super(targa);
    }

    public int avvia() {
        return 1;
    }

    public int ferma() {
        return 0;
    }

    public String getTipo() {
        return tipo;
    }
}

public class Es1 {
    public static void main(String[] args) {
        Veicolo[] veicoli = new Veicolo[2];
        veicoli[0] = new Auto("AB123CD");
        veicoli[1] = new Moto("EF456GH");

        for (Veicolo v : veicoli) {
            System.out.println("Tipo: " + v.getTipo() + ", Targa: " + ((MezzoDiTrasporto) v).getTarga());
            System.out.println("Avvio: " + v.avvia());
            System.out.println("Fermo: " + v.ferma());
        }
    }
}
