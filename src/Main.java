import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/8/28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int n = in.nextInt();
        double[][] s = new double[n + 1][n + 1];
        s[1][1] = 1.0;
        s[2][1] = 1.0;
        s[3][1] = 1.0 / 3.0;
        s[3][2] = 2.0 / 3.0;

        for (int i = 4; i <= n; i++) {
            //1 last
            for (int a = 0; a <= i - 2; a++)
                if (s[i - 2][a] != 0) {
                    s[i][a + 1] = (1.0 / i) * s[i - 2][a] * 2;
                }
            //middle
            int mid = i / 2;
            for (int p = 3; p <= mid; p++) {
                for (int a = 0; a <= p - 2; a++)
                    for (int b = 0; b <= i - p - 1; b++)
                        if (s[p - 2][a] != 0 && s[i - p - 1][b] != 0) {
                            s[i][a + b + 1] += s[p - 2][a] * s[i - p - 1][b] * (1.0 / i) * 2;
                        }
            }
        }
        double exp = 0;
        for (int i = 1; i <= n; i++)
            exp += s[n][i] * i;
        out.println(exp);
    }
}
