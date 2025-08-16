public class es6 {
    public static void main(String[] args) {
        Animale[] animali = {new Cane(), new Gatto()};
        for (Animale a : animali) {
            System.out.println(a.verso());
        }
    }
}

interface Animale {
    String verso();
}

class Cane implements Animale {
    public String verso() {
        return "Bau";
    }
}

class Gatto implements Animale {
    public String verso() {
        return "Miao";
    }
}
