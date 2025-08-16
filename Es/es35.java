public class es35 {
    public static void main(String[] args) {
        Giocatore g1 = new Giocatore("Mario");
        Giocatore g2 = new Giocatore("Gianni");
        java.util.Random rand = new java.util.Random();

        for (int turno = 0; turno < 5; turno++) {
            g1.addPunteggio(lanciaDadi(rand));
            g2.addPunteggio(lanciaDadi(rand));
        }

        System.out.println(g1.getNome() + ": " + g1.getPunteggio());
        System.out.println(g2.getNome() + ": " + g2.getPunteggio());
        if (g1.getPunteggio() > g2.getPunteggio()) {
            System.out.println("Vince " + g1.getNome());
        } else if (g2.getPunteggio() > g1.getPunteggio()) {
            System.out.println("Vince " + g2.getNome());
        } else {
            System.out.println("Pareggio");
        }
    }

    static int lanciaDadi(java.util.Random rand) {
        int somma = 0;
        for (int i = 0; i < 3; i++) {
            somma += rand.nextInt(6) + 1;
        }
        return somma;
    }
}

class Giocatore {
    private String nome;
    private int punteggio = 0;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void addPunteggio(int punti) {
        punteggio += punti;
    }
}
