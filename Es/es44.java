public class es44 {
    public static void main(String[] args) {
        if (args.length < 3) return;
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        String op = args[2];
        Operazione operazione = null;
        if (op.equals("+")) operazione = new Somma();
        else if (op.equals("-")) operazione = new Sottrazione();
        else if (op.equals("*")) operazione = new Moltiplicazione();
        else if (op.equals("/")) operazione = new Divisione();
        if (operazione != null) {
            System.out.println(operazione.calcola(a, b));
        }
    }
}

abstract class Operazione {
    abstract double calcola(double a, double b);
}

class Somma extends Operazione {
    double calcola(double a, double b) {
        return a + b;
    }
}

class Sottrazione extends Operazione {
    double calcola(double a, double b) {
        return a - b;
    }
}

class Moltiplicazione extends Operazione {
    double calcola(double a, double b) {
        return a * b;
    }
}

class Divisione extends Operazione {
    double calcola(double a, double b) {
        return b != 0 ? a / b : 0;
    }
}
