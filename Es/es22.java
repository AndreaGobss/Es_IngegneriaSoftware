import java.util.ArrayList;

public class es22 {
    public static void main(String[] args) {
        ArrayList<Spedibile> ordini = new ArrayList<>();
        ordini.add(new OrdineOnline());
        ordini.add(new OrdineNegozio());
        ordini.add(new OrdineOnline());

        for (Spedibile o : ordini) {
            System.out.println(o.spedizione());
        }
    }
}

interface Spedibile {
    String spedizione();
}

class OrdineOnline implements Spedibile {
    public String spedizione() {
        return "Spedizione tramite corriere";
    }
}

class OrdineNegozio implements Spedibile {
    public String spedizione() {
        return "Ritiro in negozio";
    }
}