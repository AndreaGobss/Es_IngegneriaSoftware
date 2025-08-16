public class es13 {
    public static void main(String[] args) {
        Macchina auto = new Auto();
        Macchina moto = new Moto();
        auto.avvia();
        moto.avvia();
    }
}

abstract class Macchina {
    abstract void avvia();
}

class Auto extends Macchina {
    void avvia() {
        System.out.println("Auto avviata");
    }
}

class Moto extends Macchina {
    void avvia() {
        System.out.println("Moto avviata");
    }
}