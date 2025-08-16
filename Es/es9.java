public class es9 {
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setNome("Giulia");
        p.setEta(22);
        System.out.println(p.getNome() + " " + p.getEta());
        p.setNome("Marco");
        p.setEta(30);
        System.out.println(p.getNome() + " " + p.getEta());
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
