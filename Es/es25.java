import java.util.ArrayList;

public class es25 {
    public static void main(String[] args) {
        ArrayList<ContoBancario> conti = new ArrayList<>();
        conti.add(new ContoCorrente(1000));
        conti.add(new ContoRisparmio(2000));

        for (ContoBancario c : conti) {
            System.out.println(c.calcolaInteresse());
        }
    }
}

abstract class ContoBancario {
    protected double saldo;

    public ContoBancario(double saldo) {
        this.saldo = saldo;
    }

    abstract double calcolaInteresse();
}

class ContoCorrente extends ContoBancario {
    public ContoCorrente(double saldo) {
        super(saldo);
    }

    double calcolaInteresse() {
        return saldo * 0.01;
    }
}

class ContoRisparmio extends ContoBancario {
    public ContoRisparmio(double saldo) {
        super(saldo);
    }

    double calcolaInteresse() {
        return saldo * 0.03;
    }
}