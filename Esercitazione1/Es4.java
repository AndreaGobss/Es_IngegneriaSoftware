import java.util.ArrayList;
import java.util.List;

abstract class Dipendente {
    private String nome;
    private double stipendio;

    public Dipendente(String nome, double stipendio) {
        this.nome = nome;
        this.stipendio = stipendio;
    }

    public String getNome() {
        return nome;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public abstract double calcolaStipendio();
}

class Impiegato extends Dipendente {
    public Impiegato(String nome, double stipendio) {
        super(nome, stipendio);
    }

    @Override
    public double calcolaStipendio() {
        return getStipendio();
    }
}

class Manager extends Dipendente {
    private double bonus;

    public Manager(String nome, double stipendio, double bonus) {
        super(nome, stipendio);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calcolaStipendio() {
        return getStipendio() + bonus;
    }
}

class Azienda {
    private List<Dipendente> dipendenti;

    public Azienda() {
        this.dipendenti = new ArrayList<>();
    }

    public void aggiungiDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
    }

    public void stampaStipendiTotali() {
        double totale = 0;
        for (Dipendente dipendente : dipendenti) {
            totale += dipendente.calcolaStipendio();
        }
        System.out.println("Stipendi totali: " + totale);
    }
}

public class Es4{
    public static void main(String[] args) {
        Azienda azienda = new Azienda();

        Impiegato impiegato1 = new Impiegato("Piero Pieroni", 2000);
        Manager manager1 = new Manager("Franco IlGattoDiPrima", 3000, 1000);

        azienda.aggiungiDipendente(impiegato1);
        azienda.aggiungiDipendente(manager1);

        azienda.stampaStipendiTotali();
    }
}