import java.time.LocalDate;
import java.util.ArrayList;

public class es20 {
    public static void main(String[] args) {
        ArrayList<VoceDiario> voci = new ArrayList<>();
        voci.add(new VoceDiario("Studio Java", LocalDate.now().minusDays(2)));
        voci.add(new VoceDiario("Sport", LocalDate.now().minusDays(10)));
        voci.add(new VoceDiario("Cinema", LocalDate.now().minusDays(5)));

        LocalDate oggi = LocalDate.now();
        for (VoceDiario v : voci) {
            if (!v.getData().isBefore(oggi.minusDays(7))) {
                System.out.println(v.getTesto() + " " + v.getData());
            }
        }
    }
}

class VoceDiario {
    private String testo;
    private LocalDate data;

    public VoceDiario(String testo, LocalDate data) {
        this.testo = testo;
        this.data = data;
    }

    public String getTesto() {
        return testo;
    }

    public LocalDate getData() {
        return data;
    }
}

