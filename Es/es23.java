import java.util.ArrayList;

public class es23 {
    public static void main(String[] args) {
        Paziente p1 = new Paziente("carmni", "P01");
        Paziente p2 = new Paziente("cacsd", "P02");
        Medico m1 = new Medico("Dr. mao");
        Medico m2 = new Medico("Dr. bau");

        ArrayList<Visita> visite = new ArrayList<>();
        visite.add(new Visita(p1, m1, "2025-07-01"));
        visite.add(new Visita(p2, m2, "2024-09-12"));
        visite.add(new Visita(p1, m2, "2023-01-07"));

        String codiceCercato = "P01";
        for (Visita v : visite) {
            if (v.getPaziente().getCodice().equals(codiceCercato)) {
                System.out.println(v.getPaziente().getNome() + " " + v.getMedico().getNome() + " " + v.getData());
            }
        }
    }
}

class Paziente {
    private String nome;
    private String codice;

    public Paziente(String nome, String codice) {
        this.nome = nome;
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCodice() {
        return codice;
    }
}

class Medico {
    private String nome;

    public Medico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Visita {
    private Paziente paziente;
    private Medico medico;
    private String data;

    public Visita(Paziente paziente, Medico medico, String data) {
        this.paziente = paziente;
        this.medico = medico;
        this.data = data;
    }

    public Paziente getPaziente() {
        return paziente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getData() {
        return data;
    }
}