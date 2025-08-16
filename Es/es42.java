public class es42 {
    public static void main(String[] args) {
        Libro l = new Libro("il salamone");
        Rivista r = new Rivista("boh");

        l.presta();
        r.presta();

        l.restituisci();
        r.restituisci();
    }
}

abstract class MaterialeBibliotecario {
    protected String titolo;

    public MaterialeBibliotecario(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }
}

interface Prestabile {
    void presta();
    void restituisci();
}

class Libro extends MaterialeBibliotecario implements Prestabile {
    private boolean prestato = false;

    public Libro(String titolo) {
        super(titolo);
    }

    public void presta() {
        if (!prestato) {
            prestato = true;
            System.out.println("Libro '" + titolo + "' prestato");
        }
    }

    public void restituisci() {
        if (prestato) {
            prestato = false;
            System.out.println("Libro '" + titolo + "' restituito");
        }
    }
}

class Rivista extends MaterialeBibliotecario implements Prestabile {
    private boolean prestato = false;

    public Rivista(String titolo) {
        super(titolo);
    }

    public void presta() {
        if (!prestato) {
            prestato = true;
            System.out.println("Rivista '" + titolo + "' prestata");
        }
    }

    public void restituisci() {
        if (prestato) {
            prestato = false;
            System.out.println("Rivista '" + titolo + "' restituita");
        }
    }
}
