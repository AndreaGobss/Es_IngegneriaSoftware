public class es7 {
    public static void main(String[] args) {
        Integer[] numeri = {1, 2, 3, 4, 5};
        String[] parole = {"ciao", "mondo", "java"};

        Contatore<Integer> contNum = new Contatore<>(numeri);
        Contatore<String> contStr = new Contatore<>(parole);

        System.out.println("Numeri: " + contNum.conta());
        System.out.println("Stringhe: " + contStr.conta());
    }
}

class Contatore<T> {
    private T[] elementi;

    public Contatore(T[] elementi) {
        this.elementi = elementi;
    }

    public int conta() {
        return elementi.length;
    }
}
