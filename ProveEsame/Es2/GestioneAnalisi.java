import java.util.ArrayList;
import java.util.List;

class Paziente{
    private String nome;
    private int eta;
    private int codice;

    public Paziente(String nome, int eta, int codice){
        this.nome = nome;
        this.eta = eta;
        this.codice = codice;
    }

    public String getNome(){
        return nome;
    }

    public int getCodice(){
        return codice;
    }

    public int getEta(){
        return eta;
    }
}

class Analisi {
    private String nome;
    private String descrizione;

    public Analisi(String nome, String descrizione){
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getNome(){
        return nome;
    }

    public String getDescrizione(){
        return descrizione;
    }
}

class Referto{
    private int valore;
    private Paziente paziente;
    private Analisi analisi;

    public Referto(int valore, Paziente paziente, Analisi analisi){
        this.valore = valore;
        this.paziente = paziente;
        this.analisi = analisi;
    }

    public int getValore(){
        return valore;
    }

    public Paziente getPaziente(){
        return paziente;
    }

    public Analisi getAnalisi(){
        return analisi;
    }
}

class Laboratorio{
    private List<Analisi> listaAnalisi;
    private List<Referto> listaReferti;

    public Laboratorio(){
        listaAnalisi = new ArrayList<>();
        listaReferti = new ArrayList<>();
    }

    public void addAnalisi(Analisi nuovaAnalisi){
        if(!listaAnalisi.contains(nuovaAnalisi)){
            listaAnalisi.add(nuovaAnalisi);
        }
    }

    public void registraReferto(Referto nuovoReferto){
        listaReferti.add(nuovoReferto);
    }

    public List<Referto> getRefertiPaziente(Paziente paziente){
        List<Referto> refertiPaziente = new ArrayList<>();

        for(Referto r : listaReferti){
            if(r.getPaziente().equals(paziente)){
                refertiPaziente.add(r);
            }
        }

        return refertiPaziente;
    }

    public List<Referto> getRefertiAnalisi(Analisi analisi){
        List<Referto> refertiAnalisi = new ArrayList<>();

        for(Referto r : listaReferti){
            if(r.getAnalisi().equals(analisi)){
                refertiAnalisi.add(r);
            }
        }

        return refertiAnalisi;
    }
}

public class GestioneAnalisi{
    public static void main(String args[]){
        Laboratorio lab = new Laboratorio();

        Analisi cacca = new Analisi("cacca", "misura percentuale cacca nel sangue");
        Analisi piscia = new Analisi("piscia", "misura percentuale piscia nel sangue");

        lab.addAnalisi(cacca);
        lab.addAnalisi(piscia);

        Paziente stronzo = new Paziente("Stronzo Stronzini", 3, 0);
        Paziente infame = new Paziente("Infame Infamini", 98, 1);

        Referto r1 = new Referto(30, stronzo, cacca);
        Referto r2 = new Referto(40, stronzo, piscia);
        Referto r3 = new Referto(50, infame, cacca);
        Referto r4 = new Referto(60, infame, piscia);

        lab.registraReferto(r1);
        lab.registraReferto(r2);
        lab.registraReferto(r3);
        lab.registraReferto(r4);

        System.out.println("Referti di Stronzo: ");
        for(Referto r : lab.getRefertiPaziente(stronzo)){
            System.out.println("" + r.getValore() + "" + r.getAnalisi() + "" + r.getPaziente());
        }

        System.out.println("Referti relativi alla cacca: ");
        for(Referto r : lab.getRefertiAnalisi(cacca)){
            System.out.println(r.getValore() + " " + r.getAnalisi() + " " + r.getPaziente());
        }
    }
}