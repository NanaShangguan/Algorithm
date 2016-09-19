package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by t-nashan on 9/18/2016.
 */
public class SafeSquares {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("B-large.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("B-large.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int R = in.nextInt(), C = in.nextInt(), K = in.nextInt();
            int[][] grid = new int[R][C];
            for (int j = 0; j < K; j++) {
                int row = in.nextInt(), col = in.nextInt();
                grid[row][col] = 1;
            }

            int[][] dp = new int[R + 1][C + 1];
            long count = 0;
            for (int r = 1; r <= R; r++) {
                for (int c = 1; c <= C; c++) {
                    if (grid[r - 1][c - 1] == 0) {
                        dp[r][c] = Math.min(dp[r - 1][c - 1], Math.min(dp[r][c - 1], dp[r - 1][c])) + 1;
                        count += dp[r][c];
                    }
                }
            }
            out.println("Case #" + i + ": " + count);
        }
    }
}
