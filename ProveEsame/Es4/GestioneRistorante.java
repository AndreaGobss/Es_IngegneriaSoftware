import java.util.*;

class Persona{
    protected String nome;
    protected String telefono;

    public Persona(String nome, String telefono){
        this.nome = nome;
        this.telefono = telefono;
    }

    public String getNome(){
        return nome;
    }
}

class Cliente extends Persona{
    public Cliente(String nome, String telefono){
        super(nome, telefono);
    } 
}

class Staff extends Persona{
    private int numeroStaff;

    public Staff(String nome, String telefono, int numeroStaff){
        super(nome, telefono);
        this.numeroStaff = numeroStaff;
    }

    public void aggiungiTavolo(List<Tavolo> listaTavoli, Tavolo tavolo){
        listaTavoli.add(tavolo);
    }

    public void rimuoviTavolo(List<Tavolo> listaTavoli, Tavolo tavolo){
        if(listaTavoli.contains(tavolo)){
            listaTavoli.remove(tavolo);
        }
    }

}

class Tavolo{
    private int numeroTavolo;

    public Tavolo(int numeroTavolo){
        this.numeroTavolo = numeroTavolo;
    }

    public int getTavolo(){
        return numeroTavolo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Tavolo)) return false;
        Tavolo other = (Tavolo) obj;
        return this.numeroTavolo == other.numeroTavolo;
    }
}

class Prenotazione{
    private Cliente prenotante;
    private Tavolo numeroTavolo;
    private String oraPrenotazione;

    public Prenotazione(Cliente prenotante, Tavolo numeroTavolo, String oraPrenotazione){
        this.prenotante = prenotante;
        this.numeroTavolo = numeroTavolo;
        this.oraPrenotazione = oraPrenotazione;
    }

    public Cliente getPrenotante(){
        return prenotante;
    }

    public Tavolo getTavolo(){
        return numeroTavolo;
    }

    public String getOraPrenotazione(){
        return oraPrenotazione;
    }
}

class Ristorante{
    List<Cliente> clienti;
    List<Tavolo> tavoli;
    List<Prenotazione> prenotazioni;

    public Ristorante(){
        clienti = new ArrayList<>();
        tavoli = new ArrayList<>();
        prenotazioni = new ArrayList<>();
    }

    public boolean aggiungiPrenotazione(Cliente cliente, Tavolo tavolo, String oraPrenotazione){
        for(Prenotazione p : prenotazioni){
            if(p.getTavolo().equals(tavolo) && p.getOraPrenotazione().equals(oraPrenotazione)){
                System.out.println("Il tavolo è già prenotato a quest'ora");
                return false;
            }
        }
        prenotazioni.add(new Prenotazione(cliente, tavolo, oraPrenotazione));
        return true;
    }

    public boolean annullaPrenotazione(Cliente cliente, Tavolo tavolo, String oraPrenotazione){
        for(Prenotazione p : prenotazioni){
            if(p.getTavolo().equals(tavolo) && p.getOraPrenotazione().equals(oraPrenotazione)){
                prenotazioni.remove(p);
                return true;
            }
        }
        return false;
    }

}


public class GestioneRistorante {
    public static void main(String[] args) {
        
    }
    
}
