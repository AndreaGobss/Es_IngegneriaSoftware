public class es40 {
    public static void main(String[] args) {
        Persona p = new Persona("Anna", 25);
        java.util.HashMap<String, Object> mappa = toMap(p);
        System.out.println(mappa);

        Persona p2 = fromMap(mappa);
        System.out.println(p2.getNome() + " " + p2.getEta());
    }

    public static java.util.HashMap<String, Object> toMap(Persona p) {
        java.util.HashMap<String, Object> map = new java.util.HashMap<>();
        map.put("nome", p.getNome());
        map.put("eta", p.getEta());
        return map;
    }

    public static Persona fromMap(java.util.HashMap<String, Object> map) {
        String nome = (String) map.get("nome");
        int eta = (int) map.get("eta");
        return new Persona(nome, eta);
    }
}

class Persona {
    private String nome;
    private int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }
}
