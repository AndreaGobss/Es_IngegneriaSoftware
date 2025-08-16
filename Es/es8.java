import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class es8 {
    public static void main(String[] args) {
        ArrayList<Squadra> squadre = new ArrayList<>();
        squadre.add(new Squadra("A", 10));
        squadre.add(new Squadra("B", 15));
        squadre.add(new Squadra("C", 8));

        Collections.sort(squadre, new Comparator<Squadra>() {
            public int compare(Squadra s1, Squadra s2) {
                return s2.getPunti() - s1.getPunti();
            }
        });

        for (Squadra s : squadre) {
            System.out.println(s.getNome() + " " + s.getPunti());
        }
    }
}

class Squadra {
    private String nome;
    private int punti;

    public Squadra(String nome, int punti) {
        this.nome = nome;
        this.punti = punti;
    }

    public String getNome() {
        return nome;
    }

    public int getPunti() {
        return punti;
    }
}
