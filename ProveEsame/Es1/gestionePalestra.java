import java.util.ArrayList;
import java.util.List;

class Persona{
    protected String nome;
    protected String email;

    public Persona(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
}

class Istruttore extends Persona{
    private String licenza;

    public Istruttore(String nome, String email, String licenza){
        super(nome, email);
        this.licenza = licenza; 
    }
}

class Iscritto extends Persona{
    private int idIscritto;

    public Iscritto(String nome, String email, int idIscritto){
        super(nome, email);
        this.idIscritto = idIscritto;
    }

    public boolean prenotaCorso(Corso corso){
        if(corso.aggiungiIscritto(this)) {
            return true;
        }
        return false;
    }

    public boolean annullaPrenotazione(Corso corso){
        if(corso.rimuoviIscritto(this)){
            return true;
        }
        return false;
    }

}

class Corso{
    private String nome;
    private String durata;
    private Istruttore istruttore;
    public List<Iscritto> iscritti; 

    public Corso(String nome, String durata, Istruttore istruttore){
        this.nome = nome;
        this.durata = durata;
        this.istruttore = istruttore;
        this.iscritti = new ArrayList<>();
    }

    public boolean aggiungiIscritto(Iscritto iscritto){
        if(!iscritti.contains(iscritto)){
            iscritti.add(iscritto);
            return true;
        }
        return false;
    }

    public boolean rimuoviIscritto(Iscritto iscritto){
        if(iscritti.contains(iscritto)){
            iscritti.remove(iscritto);
            return true;
        }
        return false;
    }
}

class Palestra{
    private List<Corso> corsi;

    public Palestra(){
        corsi = new ArrayList<>();
    }

    public void aggiungiCorsi(Corso corso){
        corsi.add(corso);
    }

    public void rimuoviCorsi(Corso corso){
        if(corsi.contains(corso)){
            corsi.remove(corso);
        }
    }
}

public class gestionePalestra {
    public static void main(String[] args) {
        Istruttore bastardo = new Istruttore("Bastardo Cane", "emailgay", "Stupratore");
        Corso karate = new Corso("Karate", "200 anni", bastardo);
        Iscritto pallino = new Iscritto("Pallino pallone", "nasoidfjun", 0);

        Palestra palestra = new Palestra();

        palestra.aggiungiCorsi(karate); 

        pallino.prenotaCorso(karate);

        

    }
    
}
