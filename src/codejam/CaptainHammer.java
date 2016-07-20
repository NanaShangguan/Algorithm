package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Nano on 2016/6/14.
 */
public class CaptainHammer {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("B-small-practice.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("B-small-practice.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            BigDecimal v = new BigDecimal(in.nextInt());
            BigDecimal d = new BigDecimal(in.nextInt());
            BigDecimal g = new BigDecimal(9.8d);
            BigDecimal sin2a = g.multiply(d).divide(v.multiply(v), 10, BigDecimal.ROUND_HALF_UP);
            double a = Math.asin(sin2a.doubleValue());
            out.format("Case #%d: %f\n", i, a* 90 / Math.PI);
        }
    }
}
