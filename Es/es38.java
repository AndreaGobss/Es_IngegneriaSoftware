public class es38 {
    public static void main(String[] args) {
        Previsione[] giorni = new Previsione[10];
        java.util.Random rand = new java.util.Random();
        String[] stati = {"Sole", "Pioggia", "Nuvoloso", "Temporale"};
        java.time.LocalDate oggi = java.time.LocalDate.now();

        for (int i = 0; i < 10; i++) {
            int temp = rand.nextInt(21) + 10; // 10-30 gradi
            String stato = stati[rand.nextInt(stati.length)];
            giorni[i] = new Previsione(temp, oggi.plusDays(i), stato);
        }

        Previsione caldo = giorni[0], freddo = giorni[0];
        for (Previsione p : giorni) {
            if (p.getTemperatura() > caldo.getTemperatura()) caldo = p;
            if (p.getTemperatura() < freddo.getTemperatura()) freddo = p;
        }

        System.out.println("Più caldo: " + caldo.getData() + " " + caldo.getTemperatura() + " " + caldo.getStato());
        System.out.println("Più freddo: " + freddo.getData() + " " + freddo.getTemperatura() + " " + freddo.getStato());
    }
}

class Previsione {
    private int temperatura;
    private java.time.LocalDate data;
    private String stato;

    public Previsione(int temperatura, java.time.LocalDate data, String stato) {
        this.temperatura = temperatura;
        this.data = data;
        this.stato = stato;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public java.time.LocalDate getData() {
        return data;
    }

    public String getStato() {
        return stato;
    }
}
