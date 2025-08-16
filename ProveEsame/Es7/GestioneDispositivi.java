import java.util.*;

public class GestioneDispositivi {
    
}

interface Connesso{
    public void connetti();
    public void disconnetti();
    public boolean statoConnessione();
}

abstract class Dispositivo{
    protected String id;

    public Dispositivo(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public abstract void accendi();
    public abstract void spegni(); 
    public abstract void connetti();
    public abstract void disconnetti();
}

class Computer extends Dispositivo implements Connesso{
    private String OS;
    private boolean connection;

    public Computer(String id, String OS){
        super(id);
        this.OS = OS;
        connection = false;
    }

    public void connetti(){
        System.out.println("Computer" + this.getId() + "connesso");
        connection = true; 
    }

    public void disconnetti(){
        System.out.println("Computer" + this.getId() + "connesso");
        connection = false;
    }

    public void accendi(){
        System.out.println("Computer" + this.getId() + "connesso");
    }

    public void spegni(){
        System.out.println("Computer" + this.getId() + "connesso");
    }

    public boolean statoConnessione(){
        return connection; 
    }

    public String getOS(){
        return OS;
    }

    public String getId(){
        return id;
    }
}

class Smartphone extends Dispositivo implements Connesso{
    private int batteria;
    private boolean connection;

    public Smartphone(String id, int batteria){
        super(id);
        this.batteria = batteria;
        connection = false;
    }

    public void connetti(){
        System.out.println("Smartphone" + this.getId() + "connesso");
        connection = true; 
    }

    public void disconnetti(){
        System.out.println("Smartphone" + this.getId() + "connesso");
        connection = false;
    }

    public void accendi(){
        System.out.println("Smartphone" + this.getId() + "connesso");
    }

    public void spegni(){
        System.out.println("Smartphone" + this.getId() + "connesso");
    }

    public boolean statoConnessione(){
        return connection; 
    }

    public int livelloBatteria(){
        return batteria;
    }

    public String getId(){
        return id;
    }
}

class Router implements Connesso{
    List<Dispositivo> dispositiviConnessi;
    boolean connection; 

    public Router(){
        dispositiviConnessi = new ArrayList<>();
        connection = false;
    }

    public void connettiDispositivo(Dispositivo d){
        d.connetti(); 
        dispositiviConnessi.add(d);
    }

    public void disconnettiDispositivo(Dispositivo d){
        d.disconnetti();
        dispositiviConnessi.remove(d);
    }

    public void connetti(){
        System.out.println("Router connesso");
        connection = true;
    }

    public void disconnetti(){
        System.out.println("Router disconnesso");
        connection = false;
    }

    public boolean statoConnessione(){
        return connection;
    }

}
