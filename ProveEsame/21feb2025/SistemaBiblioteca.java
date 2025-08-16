import java.util.ArrayList;
import java.util.List;

class Persona{
    protected String nome;
    protected String email;

    public Persona(String nome, String email){
        this.email = email;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail(){
        return email;
    }
}

class Utente extends Persona{
    private int idUtente;

    public Utente(String nome, String email, int idUtente){
        super(nome, email);
        this.idUtente = idUtente;
    }
}

class StaffBiblioteca extends Persona{
    private int idStaff;

    public StaffBiblioteca(String nome, String email, int idStaff){
        super(nome, email);
        this.idStaff = idStaff;
    }

    public void aggiungiLibro(Libro libro, Biblioteca biblioteca){
        biblioteca.aggiungiLibro(libro);
    }

    public void rimuoviLibro(Libro libro, Biblioteca biblioteca){
        biblioteca.rimuoviLibro(libro);
    }
}

class Libro{
    private String titolo;
    private String autore;
    private boolean disponibile = true;

    public Libro(String titolo, String autore){
        this.titolo = titolo;
        this.autore = autore;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile){
        this.disponibile = disponibile;
    }

    public String getTitolo(){
        return titolo;
    }
}

class Prenotazione{
    private Utente utente;
    private Libro libro;

    public Prenotazione(Utente utente, Libro libro){
        this.utente = utente;
        this.libro = libro;
    }
}

class Biblioteca{
    private List<Libro> elencoLibri = new ArrayList<>();
    private List<Prenotazione> elencoPrenotazioni = new ArrayList<>();

    public void aggiungiLibro(Libro libro){
        elencoLibri.add(libro);
    }

    public void rimuoviLibro(Libro libro){
        elencoLibri.remove(libro);
    }

    public boolean aggiungiPrenotazione(Utente utente, Libro libro){
        if (libro.isDisponibile()){
            libro.setDisponibile(false);
            elencoPrenotazioni.add(new Prenotazione(utente, libro));
            return true;
        }
        return false;
    }

    public boolean rimuoviPrenotazione(Utente utente, Libro libro){
        for(Prenotazione p : elencoPrenotazioni){
            if(p.equals(new Prenotazione(utente, libro))){
                elencoPrenotazioni.remove(p);
                libro.setDisponibile(true);
                return true;
            }
        }
        return false;
    }

}

public class SistemaBiblioteca{
    public static void main(String[] args){

        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("La merda e il piscio", "Franco Culo");
        Libro libro2 = new Libro("100 ricette con la merda", "Mario Zambrini");

        Utente utente1 = new Utente("Gianni", "Palle", 0);
        StaffBiblioteca staff1 = new StaffBiblioteca("Scroto 2", "sesso", 0);

        staff1.aggiungiLibro(libro1, biblioteca);

        if (biblioteca.aggiungiPrenotazione(utente1, libro1)) {
            System.out.println(utente1.getNome() + " ha prenotato " + libro1.getTitolo());
        } else {
            System.out.println("Prenotazione non riuscita.");
        }

    }
}