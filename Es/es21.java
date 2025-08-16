import java.util.ArrayList;

public class es21 {
    public static void main(String[] args) {
        Sala sala1 = new Sala("Sala A", 50);
        Film film1 = new Film("Boh");
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();

        int postiRichiesti = 5;
        if (sala1.getPostiDisponibili() >= postiRichiesti) {
            prenotazioni.add(new Prenotazione(film1, sala1, postiRichiesti));
            sala1.prenotaPosti(postiRichiesti);
            System.out.println("Prenotazione effettuata");
        } else {
            System.out.println("Posti non disponibili");
        }

        postiRichiesti = 48;
        if (sala1.getPostiDisponibili() >= postiRichiesti) {
            prenotazioni.add(new Prenotazione(film1, sala1, postiRichiesti));
            sala1.prenotaPosti(postiRichiesti);
            System.out.println("Prenotazione effettuata");
        } else {
            System.out.println("Posti non disponibili");
        }
    }
}

class Sala {
    private String nome;
    private int postiTotali;
    private int postiPrenotati = 0;

    public Sala(String nome, int postiTotali) {
        this.nome = nome;
        this.postiTotali = postiTotali;
    }

    public int getPostiDisponibili() {
        return postiTotali - postiPrenotati;
    }

    public void prenotaPosti(int n) {
        postiPrenotati += n;
    }

    public String getNome() {
        return nome;
    }
}

class Film {
    private String titolo;

    public Film(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }
}

class Prenotazione {
    private Film film;
    private Sala sala;
    private int posti;

    public Prenotazione(Film film, Sala sala, int posti) {
        this.film = film;
        this.sala = sala;
        this.posti = posti;
    }

    public Film getFilm() {
        return film;
    }

    public Sala getSala() {
        return sala;
    }

    public int getPosti() {
        return posti;
    }
}