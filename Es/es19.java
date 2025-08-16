
public class es19 {
    public static void main(String[] args) {
        Pagabile f = new Fattura(100, 22);
        Pagabile a = new Abbonamento(10, 12);
        System.out.println(f.calcolaTotale());
        System.out.println(a.calcolaTotale());
    }
}

interface Pagabile {
    double calcolaTotale();
}

class Fattura implements Pagabile {
    private double importo;
    private double iva;

    public Fattura(double importo, double iva) {
        this.importo = importo;
        this.iva = iva;
    }

    public double calcolaTotale() {
        return importo + importo * iva / 100;
    }
}

class Abbonamento implements Pagabile {
    private double quotaMensile;
    private int mesi;

    public Abbonamento(double quotaMensile, int mesi) {
        this.quotaMensile = quotaMensile;
        this.mesi = mesi;
    }

    public double calcolaTotale() {
        return quotaMensile * mesi;
    }
}
