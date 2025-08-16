public class es31 {
    public static void main(String[] args) {
        java.util.HashMap<String, String> utenti = new java.util.HashMap<>();
        utenti.put("mario", "pass1");
        utenti.put("gianni", "pass2");
        utenti.put("asasa", "pass3");

        if (args.length < 2) return;
        String username = args[0];
        String password = args[1];

        if (utenti.containsKey(username) && utenti.get(username).equals(password)) {
            System.out.println("Login riuscito");
        } else {
            System.out.println("Credenziali errate");
        }
    }
}
