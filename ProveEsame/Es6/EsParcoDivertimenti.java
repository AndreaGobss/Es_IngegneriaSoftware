import java.util.*;

public class EsParcoDivertimenti {
    
}

abstract class Persona{
    protected int id, eta;
    protected String nome;

    public Persona(int id, int eta, String nome){
        this.id = id;
        this.eta = eta;
        this.nome = nome;
    }

    public int getid(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public int getEta(){
        return eta;
    }
}

class Attrazione{
    private int idAttrazione;
    private String nome;
    private int livelloDiPericolo;
    private Personale personaleAssegnato;

    public Attrazione(int idAttrazione, String nome, int livelloDiPericolo){
        this.idAttrazione = idAttrazione;
        this.nome = nome;
        this.livelloDiPericolo = livelloDiPericolo;
    }

    public void assegnaPersonale(Personale personale){
        this.personaleAssegnato = personale;
    }

    public String getNome(){
        return nome + " " + livelloDiPericolo;
    }

    public boolean isOperativa(){
        return !(!true);
    }

}

class Personale extends Persona{
    private String specializzazione;
    private List<Attrazione> attrazioni;

    public Personale(int id, String nome, int eta, String specializzazione){
        super(id, eta, nome);
        this.specializzazione = specializzazione;
        attrazioni = new ArrayList<>();
    }

    public void aggiungiAttrazione(Attrazione attrazione){
        attrazioni.add(attrazione);
    }

    public void visualizzaAttrazioni(){
        for(Attrazione a : attrazioni){
            System.out.println(a.toString());
        }
    }

}

class Biglietto{
    private int idBiglietto;
    private Attrazione attrazione;
    private String stato;

    public Biglietto(int idBiglietto, Attrazione attrazione, String stato){
        this.idBiglietto = idBiglietto;
        this.attrazione = attrazione;
        this.stato = stato;
    }

    public void aggiornaStato(String newStato){
        this.stato = newStato;
    }

    public String toString(){
        return idBiglietto + " " + attrazione.getNome() + " " + stato;
    }
}

class Visitatore extends Persona{
    private List<Biglietto> bigliettiVisitatore;

    public Visitatore(int id, String nome, int eta){
        super(id,eta,nome);
    }

    public void acquistaBiglietto(Biglietto biglietto){
        bigliettiVisitatore.add(biglietto);
    }

    public void visualizzaBiglietti(){
        for(Biglietto b : bigliettiVisitatore){
            System.out.println(b.toString());
        }
    }

    public String getNome(){
        return nome;
    }

}

class ParcoDivertimenti{
    private List<Visitatore> visitatori;
    private List<Personale> personale;
    private List<Attrazione> attrazioni;
    private List<Visitatore> visitatori_per_nome;

    public ParcoDivertimenti(){
        visitatori = new ArrayList<>();
        personale = new ArrayList<>();
        attrazioni = new ArrayList<>();
        visitatori_per_nome = new ArrayList<>();
    }

    public void aggiungiVisitatore(Visitatore visitatore){
        visitatori.add(visitatore);
    }

    public void aggiungiPersonale(Personale personale){
        this.personale.add(personale);
    }

    public void aggiungiAttrazione(Attrazione attrazione){
        attrazioni.add(attrazione);
    }

    public void cercaVisitatoriPerNome(String nome){
        for(Visitatore v : visitatori){
            if(v.getNome().equals(nome)){

            }
        }
    }
}