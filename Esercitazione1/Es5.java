import java.util.ArrayList;
import java.util.List;

interface Prenotabile {
    void prenota() throws Exception;
}

abstract class Viaggio implements Prenotabile {
    private String destinazione;
    private double prezzo;
    private boolean prenotato;

    public Viaggio(String destinazione, double prezzo) {
        this.destinazione = destinazione;
        this.prezzo = prezzo;
        this.prenotato = false;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public boolean isPrenotato() {
        return prenotato;
    }

    public void setPrenotato(boolean prenotato) {
        this.prenotato = prenotato;
    }

    public abstract String descrizione();

    @Override
    public void prenota() throws Exception {
        if (prenotato) {
            throw new Exception("Viaggio già prenotato!");
        }
        prenotato = true;
    }
}

class ViaggioAereo extends Viaggio {
    private String compagniaAerea;
    private String numeroPosto;

    public ViaggioAereo(String destinazione, double prezzo, String compagniaAerea, String numeroPosto) {
        super(destinazione, prezzo);
        this.compagniaAerea = compagniaAerea;
        this.numeroPosto = numeroPosto;
    }

    public String getCompagniaAerea() {
        return compagniaAerea;
    }

    public String getNumeroPosto() {
        return numeroPosto;
    }

    @Override
    public String descrizione() {
        return "Viaggio Aereo a " + getDestinazione() + " con " + compagniaAerea + ", posto " + numeroPosto + ". Prezzo: " + getPrezzo();
    }
}

class ViaggioTreno extends Viaggio {
    private String numeroCarrozza;
    private String numeroPosto;

    public ViaggioTreno(String destinazione, double prezzo, String numeroCarrozza, String numeroPosto) {
        super(destinazione, prezzo);
        this.numeroCarrozza = numeroCarrozza;
        this.numeroPosto = numeroPosto;
    }

    public String getNumeroCarrozza() {
        return numeroCarrozza;
    }

    public String getNumeroPosto() {
        return numeroPosto;
    }

    @Override
    public String descrizione() {
        return "Viaggio in Treno a " + getDestinazione() + ", carrozza " + numeroCarrozza + ", posto " + numeroPosto + ". Prezzo: " + getPrezzo();
    }
}

class SistemaPrenotazioni {
    private List<Viaggio> viaggi;

    public SistemaPrenotazioni() {
        this.viaggi = new ArrayList<>();
    }

    public void aggiungiViaggio(Viaggio viaggio) {
        viaggi.add(viaggio);
    }

    public void prenotaViaggio(Viaggio viaggio) {
        try {
            viaggio.prenota();
            System.out.println("Prenotazione effettuata: " + viaggio.descrizione());
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public void visualizzaViaggi() {
        for (Viaggio viaggio : viaggi) {
            System.out.println(viaggio.descrizione());
        }
    }
}

public class Es5{
    public static void main(String[] args) {
        SistemaPrenotazioni sistema = new SistemaPrenotazioni();

        ViaggioAereo viaggioAereo = new ViaggioAereo("Cento", 30000, "Cento Airlines", "12A");
        ViaggioTreno viaggioTreno = new ViaggioTreno("Budrio", 100, "3", "45B");

        sistema.aggiungiViaggio(viaggioAereo);
        sistema.aggiungiViaggio(viaggioTreno);

        sistema.visualizzaViaggi();

        sistema.prenotaViaggio(viaggioAereo);
        sistema.prenotaViaggio(viaggioAereo); 
    }
}