public class es34 {
    public static void main(String[] args) {
        SquadraNazionale[] squadre = {
            new SquadraNazionale("Italia", 10),
            new SquadraNazionale("Francia", 15),
            new SquadraNazionale("Germania", 12)
        };
        java.util.Arrays.sort(squadre);
        for (SquadraNazionale s : squadre) {
            System.out.println(s.getNome() + " " + s.getPunti());
        }
    }
}

class SquadraNazionale implements Comparable<SquadraNazionale> {
    private String nome;
    private int punti;

    public SquadraNazionale(String nome, int punti) {
        this.nome = nome;
        this.punti = punti;
    }

    public String getNome() {
        return nome;
    }

    public int getPunti() {
        return punti;
    }

    public int compareTo(SquadraNazionale o) {
        return o.punti - this.punti;
    }
}
