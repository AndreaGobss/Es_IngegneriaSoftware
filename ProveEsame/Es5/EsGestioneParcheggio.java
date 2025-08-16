import java.util.*;

public class EsGestioneParcheggio {
    public static void main(String[] args) {
        Parcheggio parcheggio = new Parcheggio();

        Veicolo v1 = new Veicolo("di0m3rd4", "Macchina", "due");
        Veicolo v2 = new Veicolo("f4ncul01fr0c1", "Camper", "troie");

        Cliente c1 = new Cliente("1", "Merdessandro", v1);
        Cliente c2 = new Cliente("2", "Zambromerda", v2);

        GestoreParcheggio gestore = new GestoreParcheggio("Coglione", 1);

        gestore.aggiungiCliente(c1, parcheggio);
        gestore.aggiungiCliente(c2, parcheggio);

        PostoAuto p1 = new PostoAuto(0, 0, "Macchina");
        PostoAuto p2 = new PostoAuto(1, 0, "Camper");

        parcheggio.aggiungiPosto(p1);
        parcheggio.aggiungiPosto(p2);

        parcheggio.visualizzaPostiDisponibili();
        System.out.println("");
        parcheggio.parcheggiaVeicolo(c1, v1);
        parcheggio.visualizzaPostiDisponibili();
        System.out.println("");
        parcheggio.libera(0);
        parcheggio.visualizzaPostiDisponibili();
    }
}

class Veicolo{
    private String targa;
    private String tipo;
    private String colore;

    public Veicolo(String targa, String tipo, String colore){
        this.targa = targa;
        this.tipo = tipo;
        this.colore = colore;
    }

    @Override
    public String toString(){
        return this.targa + " " + this.tipo + " " + this.colore;
    }

    public String getTipo(){
        return this.tipo;
    }
}

class Cliente{
    private String idcliente, nome;
    private Veicolo veicolo;

    public Cliente(String idcliente, String nome, Veicolo veicolo){
        this.idcliente = idcliente;
        this.nome = nome;
        this.veicolo = veicolo;
    }

    public String toString(){
        return this.idcliente + " " + this.nome + this.veicolo.toString();
    }
}

class PostoAuto{
    private int numeroPosto;
    private int piano;
    private boolean occupato = false;
    private String tipoVeicoloConsentito;

    public PostoAuto(int n, int p, String t){
        this.numeroPosto = n;
        this.piano = p;
        this.tipoVeicoloConsentito = t;
    }

    public void liberaPosto(){
        this.occupato = false;
    }

    public void setOccupato(){
        this.occupato = true;
    }

    public String getVeicoloConsentito(){
        return tipoVeicoloConsentito;
    }

    public boolean isDisponibile(){
        return !occupato;
    }

    public int getNumeroPosto(){
        return numeroPosto;
    }

    public String toString(){
        return "" + numeroPosto + " " + piano + " " + !occupato + " " +  tipoVeicoloConsentito;
    }
}

class GestoreParcheggio{
    private String nome;
    private int idGestore;

    public GestoreParcheggio(String n, int i){
        this.nome = n;
        this.idGestore = i;
    }

    public void aggiungiCliente(Cliente c, Parcheggio p){
        p.aggiungiCliente(c);
    }

    public void rimuoviCliente(Cliente c, Parcheggio p){
        p.rimuoviCliente(c);
    }
}

class Parcheggio{
    private List<PostoAuto> posti;
    private List<Cliente> clienti;

    public Parcheggio(){
        posti = new ArrayList<>();
        clienti = new ArrayList<>();
    }

    public void aggiungiPosto(PostoAuto p){
        posti.add(p);
    }

    public void rimuoviPosto(PostoAuto p){
        posti.remove(p);
    }

    public void aggiungiCliente(Cliente c){
        clienti.add(c);
    }

    public void rimuoviCliente(Cliente c){
        clienti.remove(c);
    }

    public void parcheggiaVeicolo(Cliente cliente, Veicolo veicolo){
        for(PostoAuto p : posti){
            String tipo = veicolo.getTipo();
            if(p.getVeicoloConsentito().equals(tipo) && p.isDisponibile()){
                p.setOccupato();
                System.out.println("Parcheggio parcheggiato parcheggio");
                break;
            }    
        }
    }

    public void libera(int numeroPosto){
        for(PostoAuto p : posti){
            if(p.getNumeroPosto() == (numeroPosto)){
                p.liberaPosto();
                System.out.println("Posto liberato, dio cane");
            }
        }
    }

    public void visualizzaPostiDisponibili(){
        for(PostoAuto p : posti){
            if(p.isDisponibile()){
                System.out.println(p.toString());
            }
        }
    }
}


