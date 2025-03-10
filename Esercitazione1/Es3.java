interface Animale {
    void emettiVerso();
    void muoviti();
}

abstract class AnimaleBase implements Animale {
    private String nome;

    public AnimaleBase(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Animale: " + nome;
    }
}

class Cane extends AnimaleBase {
    public Cane(String nome) {
        super(nome);
    }

    @Override
    public void emettiVerso() {
        System.out.println(getNome() + " dice: cane!");
    }

    @Override
    public void muoviti() {
        System.out.println(getNome() + " fa cose da cane.");
    }
}

class Gatto extends AnimaleBase {
    public Gatto(String nome) {
        super(nome);
    }

    @Override
    public void emettiVerso() {
        System.out.println(getNome() + " dice: la vita è una lunga serie di delusioni che portano ad una singola gioia");
    }

    @Override
    public void muoviti() {
        System.out.println(getNome() + " gatomao.");
    }
}

public class Es3 {
    public static void main(String[] args) {
        Animale[] animali = new Animale[2];
        animali[0] = new Cane("Patata");
        animali[1] = new Gatto("Franco");

        for (Animale animale : animali) {
            animale.emettiVerso();
            animale.muoviti();
        }
    }
}