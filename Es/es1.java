import java.util.ArrayList;

public class es1 {
    public static void main(String[] args) {
        ArrayList<Contatto> rubrica = new ArrayList<>();
        Contatto c1 = new Contatto();
        c1.setNome("Mario");
        c1.setNumeroTelefono("123456789");
        rubrica.add(c1);

        Contatto c2 = new Contatto();
        c2.setNome("Luigi");
        c2.setNumeroTelefono("987654321");
        rubrica.add(c2);

        for (Contatto c : rubrica) {
            System.out.println(c.getNome() + ": " + c.getNumeroTelefono());
        }

        if (args.length > 0) {
            String json = args[0];
            json = json.replace("{", "").replace("}", "").replace("\"", "");
            String[] coppie = json.split(",");
            Persona p = new Persona();
            for (String coppia : coppie) {
                String[] kv = coppia.split(":");
                if (kv[0].trim().equals("nome")) p.setNome(kv[1].trim());
                if (kv[0].trim().equals("eta")) p.setEta(Integer.parseInt(kv[1].trim()));
            }
            System.out.println(p.getNome() + " " + p.getEta());
        }
    }
}

class Contatto {
    private String nome;
    private String numeroTelefono;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}

class Persona {
    private String nome;
    private int eta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
}
