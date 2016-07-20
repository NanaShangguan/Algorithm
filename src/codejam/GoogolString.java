package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/7/10.
 */
public class GoogolString {
    static int getBit(int n, long k) {
        if (n == 1) return 0;
        int log = (int) (Math.log(k) / Math.log(2)) + 1;
        if (n > log) return getBit(log, k);
        long middle = (long) Math.pow(2, n - 1);
        if (k == middle) return 0;
        if (k > middle) return getBit(n - 1, middle - (k - middle))^1;
        return getBit(n - 1, k);
    }
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("A-large-practice.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("A-large-practice.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            long k = in.nextLong();
            int log = (int) (Math.log(k) / Math.log(2)) + 1;
            int bit = getBit(log, k);
            out.format("Case #%d: %d\n", i, bit);
        }
    }
}
