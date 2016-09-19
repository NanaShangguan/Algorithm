package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by t-nashan on 9/18/2016.
 */
public class MonsterPath {
    static double max = 0;
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("A-large.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("A-large.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int R = in.nextInt(), C = in.nextInt(), Rs = in.nextInt(), Cs = in.nextInt(), S = in.nextInt();
            double P = in.nextDouble(), Q = in.nextDouble();
            char[][] grid = new char[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++)
                    grid[r][c] = in.next().charAt(0);
            }
            int[][] visited = new int[R][C];
            max = 0;
            //top
            dfs(grid, R, C, visited, Rs - 1, Cs, 0, S, 0d, P, Q);
            //bottom
            dfs(grid, R, C, visited, Rs + 1, Cs, 0, S, 0d, P, Q);
            //left
            dfs(grid, R, C, visited, Rs, Cs - 1, 0, S, 0d, P, Q);
            //right
            dfs(grid, R, C, visited, Rs, Cs + 1, 0, S, 0d, P, Q);
            out.format("Case #%d: %.7f\n", i, max);
        }
    }

    static void dfs(char[][] grid, int R, int C, int[][] visited, int r, int c
            , int step, int S, double expected, double P, double Q) {
        if (step == S) {
            if (expected > max) max = expected;
            return;
        }
        if (r >= R || c >= C || r < 0 || c < 0) return;
        double baseP = (grid[r][c] == 'A') ? P : Q;
        expected += Math.pow(1 - baseP, visited[r][c]) * baseP;
        visited[r][c]++;
        //top
        dfs(grid, R, C, visited, r - 1, c, step + 1, S, expected, P, Q);
        //bottom
        dfs(grid, R, C, visited, r + 1, c, step + 1, S, expected, P, Q);
        //left
        dfs(grid, R, C, visited, r, c - 1, step + 1, S, expected, P, Q);
        //right
        dfs(grid, R, C, visited, r, c + 1, step + 1, S, expected, P, Q);
        visited[r][c]--;
    }
}
