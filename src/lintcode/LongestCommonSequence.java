package lintcode;

/**
 * Created by t-nashan on 7/25/2016.
 */
public class LongestCommonSequence {
    public static int longestCommonSequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.equals("") || B.equals("")) return 0;
        int row = A.length(), col = B.length();
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                char s = A.charAt(i - 1);
                char t = B.charAt(j - 1);
                if (s == t) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSequence("ABCD", "CBCE"));
    }
}
