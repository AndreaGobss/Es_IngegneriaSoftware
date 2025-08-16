public class es14 {
    public static void main(String[] args) {
        for (String parola : args) {
            if (parola.length() > 5) {
                System.out.println(parola);
            }
        }
    }
}