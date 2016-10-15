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

        dp[1] = 1.0; dp[2] = 1.0;
        for (int i = 3; i <= n; i++) {
            dp[i] += (dp[i - 2] + 1) * (1.0 / i) * 2;
            int mid = i / 2;
            for (int j = 2; j <= mid; j++)
                dp[i] += (dp[j - 2] + 1 + dp[i - j - 1]) * (1.0 / i) * 2;
            if ((i & 1) == 1)
                dp[i] += (dp[mid - 1] + 1 + dp[i - mid - 2]) * (1.0 / i);
        }

        out.println(dp[n]);
    }
}
