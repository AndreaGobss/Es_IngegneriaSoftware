import java.io.*;
import java.util.*;

public class es26 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("studenti.txt"));
        ArrayList<Integer> voti = new ArrayList<>();
        String riga;
        while ((riga = br.readLine()) != null) {
            String[] parti = riga.split(",");
            if (parti.length == 2) {
                voti.add(Integer.parseInt(parti[1].trim()));
            }
        }
        br.close();
        double media = voti.stream().mapToInt(i -> i).average().orElse(0);
        BufferedWriter bw = new BufferedWriter(new FileWriter("media.txt"));
        bw.write("Media voti: " + media);
        bw.close();
    }
}
