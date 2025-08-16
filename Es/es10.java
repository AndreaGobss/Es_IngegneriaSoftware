public class es10 {
    public static void main(String[] args) {
        if (args.length != 3) return;
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        String op = args[2];
        double res = 0;
        if (op.equals("+")) res = a + b;
        else if (op.equals("-")) res = a - b;
        else if (op.equals("*")) res = a * b;
        else if (op.equals("/")) res = b != 0 ? a / b : 0;
        System.out.println(res);
    }
}

