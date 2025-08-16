import java.util.*;


class Persona{
    protected String nome;

    public Persona(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

}

class Cliente extends Persona{
    private int codiceCliente;

    public Cliente(String nome, int codiceCliente){
        super(nome);
        this.codiceCliente = codiceCliente;
    }

    public int getCodice(){
        return codiceCliente;
    }
}

class Staff extends Persona{
    private int codiceStaff;

    public Staff(String nome, int codiceStaff){
        super(nome);
        this.codiceStaff = codiceStaff;
    }

    public int getCodice(){
        return codiceStaff;
    }
}

class Film{
    private String titolo;
    private boolean disponibile = true;

    public Film(String titolo){
        this.titolo = titolo;
    }

    public String getTitolo(){
        return titolo;
    }

    public boolean isDisponibile(){
        return disponibile;
    }

    public void setDisponibile(boolean disponibile){
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
        return titolo + (disponibile ? " [Disponibile]" : " [Noleggiato]");
    }
}

class Noleggio{
    private Cliente cliente;
    private Film film;
    private boolean restituito = false;

    public Noleggio(Cliente cliente, Film film){
        this.cliente = cliente;
        this.film = film;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Film getFilm(){
        return film;
    }

    public boolean isRestituito(){
        return restituito;
    }

    public void restituisci(){
        restituito = true;
    }
}

class SistemaScrotale{
    List<Film> listaFilm;
    List<Noleggio> listaNoleggi;
    List<Cliente> listaClienti;

    public SistemaScrotale(){
        listaFilm = new ArrayList<>();
        listaNoleggi = new ArrayList<>();
        listaClienti = new ArrayList<>();
    }

    public void aggiungiFilm(Film film, Staff staff){
        listaFilm.add(film);
    }

    public void rimuoviFilm(Film film, Staff staff){
        for(Noleggio n : listaNoleggi){
            if(n.getFilm().equals(film) && !n.isRestituito()){
                listaFilm.remove(film);
                break;
            }
        }
    }

    public void registraCliente(Cliente cliente){
        listaClienti.add(cliente);
    }

    public void noleggiaFilm(Cliente cliente, Film film){
        boolean giaNoleggiato = false;
        for(Noleggio n : listaNoleggi){
            if(n.getFilm().equals(film) && !n.isRestituito()){
                giaNoleggiato = true;
            }
        }

        if(film.isDisponibile() && !giaNoleggiato){
            listaNoleggi.add(new Noleggio(cliente, film));
            film.setDisponibile(false);
        }
    }

    public void restituisciFilm(Cliente cliente, Film film){
        for(Noleggio n : listaNoleggi){
            if(n.getCliente().equals(cliente) && n.getFilm().equals(film)){
                n.restituisci();
                break;
            }
        }
    }

    public void stampaFilmNoleggiatiDa(Cliente cliente) {
        for (Noleggio n : listaNoleggi) {
            if (n.getCliente().equals(cliente) && !n.isRestituito()) {
                System.out.println(n.getFilm());
            }
        }
    }
}

public class GestioneNoleggi {
    public static void main(String[] args) {
        SistemaScrotale s = new SistemaScrotale();

        Staff staff1 = new Staff("Gianni Banana", 1);
        Cliente cliente1 = new Cliente("Pietro Scialbone", 0);

        Film film1 = new Film("La notte della notte");
        Film film2 = new Film("La notte della notte 2: la notte");

        s.aggiungiFilm(film1, staff1);
        s.aggiungiFilm(film2, staff1);
        s.registraCliente(cliente1);
            
        s.noleggiaFilm(cliente1, film1);

        System.out.println("Film noleggiati da Pietro: ");
        s.stampaFilmNoleggiatiDa(cliente1);

        s.restituisciFilm(cliente1, film1);

        System.out.println("Dopo la restituzione; ");
        s.stampaFilmNoleggiatiDa(cliente1);

    }
    
}
