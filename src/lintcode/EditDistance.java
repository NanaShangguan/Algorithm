package lintcode;

/**
 * Created by t-nashan on 8/5/2016.
 */
public class EditDistance {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        int row = word1.length(), col = word2.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) dp[i][0] = i;
        for (int i = 1; i <= col; i++) dp[0][i] = i;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("mart", "karma"));
    }
}
