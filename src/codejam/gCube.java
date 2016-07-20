package codejam;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/7/10.
 */
public class gCube {
    public static void main(String[] args) throws Exception {
//        FileInputStream fis = new FileInputStream("B-small-practice.in");
//        System.setIn(fis);
//        PrintStream ps = new PrintStream(new FileOutputStream("B-small-practice.out"));
//        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] dimens = new int[n];
            for (int k = 0; k < n; k++) dimens[k] = in.nextInt();
            out.format("Case #%d:\n", i);
            while (m > 0) {
                m--;
                int l = in.nextInt(), r = in.nextInt();
                double volume = 0;
                for (int k = l; k <= r; k++)
                    volume += Math.log(dimens[k]);
                int numOfD = r - l + 1;
//                double d = Math.pow(volume, 1d / numOfD);
                double pow = volume / numOfD;
                double res = Math.pow(Math.E, pow);
                out.format("%.9f\n", res);
            }
        }
    }
}
