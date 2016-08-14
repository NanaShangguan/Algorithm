package leetcode.BestTimeToBuy;

/**
 * Created by Nano on 2016/8/14.
 */
public class BestTimeToBuyAndSellStockIV {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len + 1][k + 1]; // dp[i][j]: j transactions in prices[0, i - 1]
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                int max = 0;
                for (int t = 1; t < i; t++) {
                    if (prices[t - 1] < prices[i - 1]) {
                        int profit = prices[i - 1] - prices[t - 1] + dp[t - 1][j - 1];
                        if (max < profit) max = profit;
                    }
                }
                dp[i][j] = Math.max(dp[i][j], max);
            }
        }
        return dp[len][k];
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{4,4,6,1,1,4,2,5}));
    }
}
