import java.util.ArrayList;

public class es4 {
    public static void main(String[] args) {
        ArrayList<Studente> studenti = new ArrayList<>();

        studenti.add(new Studente("Anna", "A001", new int[]{28, 30, 27}));
        studenti.add(new Studente("Luca", "A002", new int[]{25, 26, 24}));

        for (Studente s : studenti) {
            System.out.println(s.getNome() + " media: " + s.mediaVoti());
        }
    }
}

class Studente {
    private String nome;
    private String matricola;
    private int[] voti;

    public Studente(String nome, String matricola, int[] voti) {
        this.nome = nome;
        this.matricola = matricola;
        this.voti = voti;
    }

    public String getNome() {
        return nome;
    }

    public double mediaVoti() {
        int somma = 0;
        for (int v : voti) {
            somma += v;
        }
        return voti.length > 0 ? (double) somma / voti.length : 0;
    }
}
