public class es39 {
    public static void main(String[] args) {
        Task[] tasks = {
            new Task("Compiti", 2, java.time.LocalDate.of(2024, 6, 10)),
            new Task("Spesa", 1, java.time.LocalDate.of(2024, 6, 8)),
            new Task("Allenamento", 3, java.time.LocalDate.of(2024, 6, 9))
        };
        java.util.Arrays.sort(tasks, (a, b) -> {
            if (a.getPriorita() != b.getPriorita())
                return a.getPriorita() - b.getPriorita();
            return a.getScadenza().compareTo(b.getScadenza());
        });
        for (Task t : tasks) {
            System.out.println(t.getDescrizione() + " " + t.getPriorita() + " " + t.getScadenza());
        }
    }
}

class Task {
    private String descrizione;
    private int priorita;
    private java.time.LocalDate scadenza;

    public Task(String descrizione, int priorita, java.time.LocalDate scadenza) {
        this.descrizione = descrizione;
        this.priorita = priorita;
        this.scadenza = scadenza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getPriorita() {
        return priorita;
    }

    public java.time.LocalDate getScadenza() {
        return scadenza;
    }
}
