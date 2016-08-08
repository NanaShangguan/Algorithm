package lintcode;

/**
 * Created by t-nashan on 8/8/2016.
 */
public class WildcardMatching {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        int row = s.length(), col = p.length();
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;
        for (int i = 1; i <= col; i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                char cp = p.charAt(j - 1);
                if (cp == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (cp == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if (s.charAt(i - 1) == cp) dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }
}
