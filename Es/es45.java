public class es45 {
    public static void main(String[] args) {
        Persona[] persone = new Persona[4];
        persone[0] = new Studente("Gianni", "A001");
        persone[1] = new Studente("Luca", "A002");
        persone[2] = new Insegnante("Prof. borz", "Matematica");
        persone[3] = new Insegnante("Prof. daflok", "Storia");

        for (Persona p : persone) {
            System.out.println(p.info());
        }
    }
}

class Persona {
    protected String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public String info() {
        return nome;
    }
}

class Studente extends Persona {
    private String matricola;

    public Studente(String nome, String matricola) {
        super(nome);
        this.matricola = matricola;
    }

    public String info() {
        return nome + " (Studente) - Matricola: " + matricola;
    }
}

class Insegnante extends Persona {
    private String materia;

    public Insegnante(String nome, String materia) {
        super(nome);
        this.materia = materia;
    }

    public String info() {
        return nome + " (Insegnante) - Materia: " + materia;
    }
}
