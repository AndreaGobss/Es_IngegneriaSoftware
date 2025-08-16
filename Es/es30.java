public class es30 {
    public static void main(String[] args) {
        Contatto[] rubrica = {
            new Contatto("Mario maio", "123456789", "mario@esempio.com"),
            new Contatto("Luigi gianni", "987654321", "vsds@asd.com"),
            new Contatto("Anna pepper", "555555555", "anasdana@asdad.com")
        };

        String nomeParziale = "Luigi";
        String dominio = "esempio.com";

        for (Contatto c : rubrica) {
            if (c.getNome().contains(nomeParziale)) {
                System.out.println("Trovato per nome: " + c.getNome());
            }
        }

        for (Contatto c : rubrica) {
            if (c.getEmail().endsWith(dominio)) {
                System.out.println("Trovato per dominio: " + c.getNome());
            }
        }
    }
}

class Contatto {
    private String nome;
    private String numero;
    private String email;

    public Contatto(String nome, String numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }
}
