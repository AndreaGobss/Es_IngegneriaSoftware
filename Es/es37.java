public class es37 {
    public static void main(String[] args) {
        int[] voti = {28, 30, 25, 28, 30, 27, 28};
        System.out.println("Media: " + media(voti));
        System.out.println("Moda: " + moda(voti));
        System.out.println("Mediana: " + mediana(voti));
    }

    public static double media(int[] arr) {
        int sum = 0;
        for (int v : arr) sum += v;
        return arr.length > 0 ? (double) sum / arr.length : 0;
    }

    public static int moda(int[] arr) {
        java.util.HashMap<Integer, Integer> freq = new java.util.HashMap<>();
        for (int v : arr) freq.put(v, freq.getOrDefault(v, 0) + 1);
        int moda = arr[0], max = 0;
        for (int k : freq.keySet()) {
            if (freq.get(k) > max) {
                max = freq.get(k);
                moda = k;
            }
        }
        return moda;
    }

    public static double mediana(int[] arr) {
        int[] copy = arr.clone();
        java.util.Arrays.sort(copy);
        int n = copy.length;
        if (n % 2 == 1) return copy[n / 2];
        return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
    }
}
