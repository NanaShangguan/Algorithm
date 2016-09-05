package lintcode;

import java.util.ArrayList;

/**
 * Created by t-nashan on 9/5/2016.
 */
public class MinimumAdjustmentCost {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int len = A.size();
        int[][] dp = new int[len + 1][101];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= 100; j++) {
                int dis = Math.abs(j - A.get(i - 1));
                int min = Integer.MAX_VALUE;
                for (int k = Math.max(1, (j - target)); k <= Math.min((j + target), 100); k++)
                    if (dp[i - 1][k] < min) min = dp[i - 1][k];
                dp[i][j] = dis + min;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++)
            if (min > dp[len][i]) min = dp[len][i];
        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);A.add(4);A.add(2);A.add(3);
        System.out.println(new MinimumAdjustmentCost().MinAdjustmentCost(A, 2));
    }
}
