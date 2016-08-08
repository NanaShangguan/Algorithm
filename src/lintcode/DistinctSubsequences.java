package lintcode;

/**
 * Created by t-nashan on 8/8/2016.
 */
public class DistinctSubsequences {
    /**
     * @param s, t: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String s, String t) {
        int row = s.length(), col = t.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) dp[i][0] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] += dp[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }
}
