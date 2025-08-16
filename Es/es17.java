public class es17 {
    public static void main(String[] args) {
        String[][] scacchiera = new String[8][8];
        String[] pezzi = {"Torre", "Cavallo", "Alfiere", "Regina", "Re", "Alfiere", "Cavallo", "Torre"};
        for (int i = 0; i < 8; i++) {
            scacchiera[0][i] = pezzi[i];
        }
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                scacchiera[i][j] = "";
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print((scacchiera[i][j].isEmpty() ? "." : scacchiera[i][j]) + "\t");
            }
            System.out.println();
        }
    }
}

