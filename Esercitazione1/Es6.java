import java.util.ArrayList;
import java.util.List;

interface Pagabile {
    void effettuaPagamento(double importo) throws SaldoInsufficienteException;
}

abstract class MetodoPagamento implements Pagabile {
    private double saldoDisponibile;

    public MetodoPagamento(double saldoDisponibile) {
        this.saldoDisponibile = saldoDisponibile;
    }

    public double getSaldoDisponibile() {
        return saldoDisponibile;
    }

    public void setSaldoDisponibile(double saldoDisponibile) {
        this.saldoDisponibile = saldoDisponibile;
    }

    protected void decrementaSaldo(double importo) {
        this.saldoDisponibile = saldoDisponibile - importo;
    }
}

class CartaDiCredito extends MetodoPagamento {
    private String numeroCarta;

    public CartaDiCredito(double saldoDisponibile, String numeroCarta) {
        super(saldoDisponibile);
        this.numeroCarta = numeroCarta;
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    @Override
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException {
        if (importo > getSaldoDisponibile()) {
            throw new SaldoInsufficienteException("Saldo insufficiente sulla carta di credito.");
        }
        decrementaSaldo(importo);
        System.out.println("Pagamento di " + importo + " effettuato con Carta di Credito " + numeroCarta);
    }
}

class PayPal extends MetodoPagamento {
    private String email;

    public PayPal(double saldoDisponibile, String email) {
        super(saldoDisponibile);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void effettuaPagamento(double importo) throws SaldoInsufficienteException {
        if (importo > getSaldoDisponibile()) {
            throw new SaldoInsufficienteException("Saldo insufficiente su PayPal.");
        }
        decrementaSaldo(importo);
        System.out.println("Pagamento di " + importo + " effettuato con PayPal " + email);
    }
}

class SaldoInsufficienteException extends Exception {
    public SaldoInsufficienteException(String message) {
        super(message);
    }
}

class SistemaPagamenti {
    private List<MetodoPagamento> metodiPagamento;

    public SistemaPagamenti() {
        this.metodiPagamento = new ArrayList<>();
    }

    public void aggiungiMetodoPagamento(MetodoPagamento metodo) {
        metodiPagamento.add(metodo);
    }

    public void effettuaPagamento(MetodoPagamento metodo, double importo) {
        try {
            metodo.effettuaPagamento(importo);
        } catch (SaldoInsufficienteException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

public class Es6{
    public static void main(String[] args) {
        SistemaPagamenti sistema = new SistemaPagamenti();

        CartaDiCredito carta = new CartaDiCredito(500, "1234-5678-9012-3456");
        PayPal paypal = new PayPal(300, "pagapal@gmail.com");

        sistema.aggiungiMetodoPagamento(carta);
        sistema.aggiungiMetodoPagamento(paypal);

        sistema.effettuaPagamento(carta, 200);
        sistema.effettuaPagamento(paypal, 350); 
    }
}