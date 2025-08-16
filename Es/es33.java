public class es33 {
    public static void main(String[] args) {
        Parcheggio parcheggio = new Parcheggio(3);
        Auto a1 = new Auto("AA111AA");
        Auto a2 = new Auto("BB222BB");
        Auto a3 = new Auto("CC333CC");

        parcheggio.entra(a1);
        parcheggio.entra(a2);
        parcheggio.stato();

        parcheggio.esci("AA111AA");
        parcheggio.entra(a3);
        parcheggio.stato();
    }
}

class Auto {
    private String targa;

    public Auto(String targa) {
        this.targa = targa;
    }

    public String getTarga() {
        return targa;
    }
}

class PostoAuto {
    private Auto auto;

    public boolean isLibero() {
        return auto == null;
    }

    public void occupa(Auto a) {
        auto = a;
    }

    public void libera() {
        auto = null;
    }

    public Auto getAuto() {
        return auto;
    }
}

class Parcheggio {
    private PostoAuto[] posti;

    public Parcheggio(int n) {
        posti = new PostoAuto[n];
        for (int i = 0; i < n; i++) {
            posti[i] = new PostoAuto();
        }
    }

    public void entra(Auto a) {
        for (PostoAuto p : posti) {
            if (p.isLibero()) {
                p.occupa(a);
                return;
            }
        }
    }

    public void esci(String targa) {
        for (PostoAuto p : posti) {
            if (!p.isLibero() && p.getAuto().getTarga().equals(targa)) {
                p.libera();
                return;
            }
        }
    }

    public void stato() {
        for (int i = 0; i < posti.length; i++) {
            if (posti[i].isLibero()) {
                System.out.println("Posto " + i + ": libero");
            } else {
                System.out.println("Posto " + i + ": " + posti[i].getAuto().getTarga());
            }
        }
    }
}
