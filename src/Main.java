import java.io.PrintStream;
import java.util.*;

/**
 * Created by nana_ on 2016/8/28.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int n = in.nextInt();
        double[] dp = new double[n + 1];
        double[] sum = new double[n + 1];

        dp[1] = 1.0; dp[2] = 1.0;
        sum[1] = 1.0; sum[2] = 2.0;
        for (int i = 3; i <= n; i++) {
            dp[i] += (dp[i - 2] + 1) * (1.0 / i) * 2;
            dp[i] += (sum[i - 3] * 2 + (i - 2)) / i;
            sum[i] = sum[i - 1] + dp[i];
        }

        out.println(dp[n]);
    }
}
