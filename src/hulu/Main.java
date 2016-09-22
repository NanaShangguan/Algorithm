package hulu;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by t-nashan on 9/22/2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        int[] s = new int[10];
        for (int i = 0; i < 10; i++) {
            s[i] = i * i * i;
        }
        while (in.hasNext()) {
            int m = in.nextInt(), n = in.nextInt();
            boolean flag = true;
            for (int i = m; i <= n; i++) {
                int orig = i, sum = 0;
                while (orig > 0) {
                    int digit = orig % 10;
                    sum += s[digit];
                    orig /= 10;
                }
                if (sum == i) {
                    out.print(i + " ");
                    flag = false;
                }
            }
            if (flag) out.println("no");
            else out.println();
        }
    }
}
