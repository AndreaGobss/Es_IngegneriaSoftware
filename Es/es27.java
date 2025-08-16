public class es27 {
    public static void main(String[] args) {
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
