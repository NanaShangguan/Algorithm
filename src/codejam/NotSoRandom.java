package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Nano on 2016/6/26.
 */
public class NotSoRandom {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C-small-attempt0.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("C-small-attempt0.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(), x = in.nextInt(), k = in.nextInt();
            double a = in.nextInt() / 100d, b = in.nextInt() / 100d, c = in.nextInt() / 100d;
            int max = (int) Math.pow(3, 10);
            int[][] output = new int[11][max];
            double[][] proba = new double[11][max];
            output[0][0] = x;
            proba[0][0] = 1d;
            int count = 1;
            for (int p = 0; p < n; p++) {
                for (int q = 0; q < count; q++) {
                    output[p + 1][q * 3 + 0] = (output[p][q] & k);
                    output[p + 1][q * 3 + 1] = (output[p][q] | k);
                    output[p + 1][q * 3 + 2] = (output[p][q] ^ k);
                    proba[p + 1][q * 3 + 0] = proba[p][q] * a;
                    proba[p + 1][q * 3 + 1] = proba[p][q] * b;
                    proba[p + 1][q * 3 + 2] = proba[p][q] * c;
                }
                count *= 3;
            }
            double expected = 0;
            for (int p = 0; p < count; p++) {
                expected += proba[n][p] * output[n][p];
            }
            out.format("Case #%d: %.10f\n", i, expected);
        }
    }
}

