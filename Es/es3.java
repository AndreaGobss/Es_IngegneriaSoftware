public class es3 {
    public static void main(String[] args) {
        Forma[] forme = new Forma[2];
        forme[0] = new Cerchio(5);
        forme[1] = new Rettangolo(4, 6);

        for (Forma f : forme) {
            System.out.println(f.area());
        }
    }
}

abstract class Forma {
    abstract double area();
}

class Cerchio extends Forma {
    private double raggio;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    double area() {
        return Math.PI * raggio * raggio;
    }
}

class Rettangolo extends Forma {
    private double base, altezza;

    public Rettangolo(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    double area() {
        return base * altezza;
    }
}
