package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by t-nashan on 7/13/2016.
 */
public class ClashRoyale {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("D-large-practice.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("D-large-practice.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int k = 1; k <= t; k++) {
            int coins = in.nextInt(), numOfCards = in.nextInt();
            int[] maxLevel = new int[numOfCards + 1];
            int[] curLevel = new int[numOfCards + 1];
            int[][] attackPower = new int[numOfCards + 1][];
            int[][] cost = new int[numOfCards + 1][];
            for (int i = 1; i <= numOfCards; i++) {
                maxLevel[i] = in.nextInt();
                curLevel[i] = in.nextInt();
                attackPower[i] = new int[maxLevel[i] + 1];
                for (int j = 1; j <= maxLevel[i]; j++)
                    attackPower[i][j] = in.nextInt();
                cost[i] = new int[maxLevel[i]];
                for (int j = 1; j < maxLevel[i]; j++)
                    cost[i][j] = in.nextInt();
            }

            int[][][] dp = new int[numOfCards + 1][coins + 1][9];
            for (int i = 1; i <= numOfCards; i++) {
                int max = Math.min(8, i);
                int[] cards = new int[i + 1];
                for (int j = 1; j <= i; j++)
                    cards[j] = attackPower[j][curLevel[j]];
                Arrays.sort(cards);
                int sum = 0;
                for (int j = 1; j <= max; j++) {
                    sum += cards[i + 1 - j];
                    dp[i][0][j] = sum;
                }
            }
            for (int i = 1; i <= numOfCards; i++) {
                for (int c = 1; c <= coins; c++) {
                    int maxJ = Math.min(8, i);
                    for (int j = 1; j <= maxJ; j++) {
                        int max = dp[i - 1][c][j - 1] + attackPower[i][curLevel[i]];
                        int sumCost = 0;
                        for (int level = curLevel[i]; level < maxLevel[i]; level++) {
                            sumCost += cost[i][level];
                            if (c < sumCost) break;
                            if (c >= sumCost) {
                                int attack = dp[i - 1][c - sumCost][j - 1] + attackPower[i][level + 1];
                                if (attack > max) max = attack;
                            }
                        }
                        if (j <= Math.min(8, i - 1) && dp[i - 1][c][j] > max)
                            max = dp[i - 1][c][j];
                        dp[i][c][j] = max;
                    }
                }
            }
            out.format("Case #%d: %d\n", k, dp[numOfCards][coins][8]);
        }
    }
}
