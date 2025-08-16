public class es12 {
    public static void main(String[] args) {
        String[] studenti = {"Gianni", "Luca", "Marco"};
        int[][] presenze = {
            {1, 1, 0, 1, 1}, // GIanni
            {1, 0, 1, 1, 0}, // Luca
            {1, 1, 1, 1, 1}  // Marco
        };

        for (int i = 0; i < studenti.length; i++) {
            int totale = 0;
            for (int j = 0; j < presenze[i].length; j++) {
                totale += presenze[i][j];
            }
            System.out.println(studenti[i] + ": " + totale);
        }
    }
}
