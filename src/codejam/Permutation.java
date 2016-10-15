package codejam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/8/28.
 */
public class Permutation {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("D-small-practice.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("D-small-practice.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt(), M = in.nextInt();
            long[][] f = new long[N + 1][N + 1];
            f[1][1] = 1;
            long prod = 1;
            for (int j = 2; j <= N; j++) {
                f[j][1] = prod;
//                f[j][j] = 1;
                for (int k = 1; k < j; k++) {
                    for (int q = 1; q <= (j - k); q++) {
                        f[j][1 + q] += f[k][1] * f[j - k][q];
                    }
//                    for (int p = 1; p <= k; p++) {
//                        for (int q = 1; q <= (j - k); q++) {
//                            if (p + q < j) f[j][p + q] += f[k][p] * f[j - k][q];
//                        }
//                    }
                }
                prod *= j;
            }
            long res = 0;
            for (int k = 1; k <= N; k++) {
                long n = f[N][k];
                if (n > 0) {
                    res = ((((n % M) *(k % M) * (k % M)) % M) + res) % M;
                }
            }
            out.println("Case #" + i  + ": " + res);
        }
    }
}
