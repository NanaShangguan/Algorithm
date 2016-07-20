package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Nano on 2016/6/26.
 */
public class RobotRockBand {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("B-large.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("B-large.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt(), k = in.nextInt();
            int[][] fourList = new int[4][n];
            for (int p = 0; p < 4; p++) {
                for (int q = 0; q < n; q++)
                    fourList[p][q] = in.nextInt();
            }

            long count = 0;
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    for (int c = 0; c < n; c++) {
                        for (int d = 0; d < n; d++) {
                            if ((fourList[0][a] ^ fourList[1][b] ^ fourList[2][c] ^ fourList[3][d]) == k)
                                count++;
                        }
                    }
                }
            }
            out.format("Case #%d: %l\n", i, count);
        }
    }
}
