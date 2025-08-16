public class es43 {
    public static void main(String[] args) {
        java.util.ArrayList<Contatto> rubrica = new java.util.ArrayList<>();
        rubrica.add(new Contatto("Gianni", "123456789", "mario@email.com"));
        rubrica.add(new Contatto("blob", "987654321", "s@asd.com"));

        // aggiunta
        rubrica.add(new Contatto("zoz", "555555555", "asdad@asd.com"));

        // rimozione per nome
        String nomeDaRimuovere = "blob";
        rubrica.removeIf(c -> c.getNome().equals(nomeDaRimuovere));

        // ricerca per nome
        String nomeDaCercare = "zoz";
        for (Contatto c : rubrica) {
            if (c.getNome().equals(nomeDaCercare)) {
                System.out.println(c.getNome() + " " + c.getNumero() + " " + c.getEmail());
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
