package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/7/10.
 */
public class FlowerShop {

    public static double irr(double[] values, int m, double r) {
        double sum = 0;
        r++;
        for (int i = 0; i <= m; i++) {
            sum += (values[i] * Math.pow(r, m - i));
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("C-large-practice.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("C-large-practice.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int m = in.nextInt();
            double[] pro = new double[m + 1];
            pro[0] = -in.nextDouble();
            for (int k = 1; k <= m; k++) pro[k] = in.nextDouble();

            double low = -1, high = 1, middle = 0;
            double sum = 1;
            double threshold = Math.pow(10, -15);
            double unit = Math.pow(10, -15);
            while (Double.compare(low, high) < 0) {
                middle = (low + high) / 2;
                sum = irr(pro, m, middle);
                if (Double.compare(Math.abs(sum - 0), threshold) < 0) break;
                if (sum > 0) low = middle + unit;
                else high = middle - unit;
            }
            DecimalFormat df = new DecimalFormat("0.000000000000");
            df.setRoundingMode(RoundingMode.FLOOR);

            out.format("Case #%d: %s\n", i, df.format(middle));
        }
    }
}
