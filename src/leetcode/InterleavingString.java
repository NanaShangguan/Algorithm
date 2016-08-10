package leetcode;

/**
 * Created by t-nashan on 8/9/2016.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int row = s1.length(), col = s2.length();
        if (row + col != s3.length()) return false;
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;
        for (int i = 1; i <= row; i++)
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) ? dp[i - 1][0] : false;
        for (int i = 1; i <= col; i++)
            dp[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) ? dp[0][i - 1] : false;
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= col; j++) {
                char c3 = s3.charAt(i + j - 1);
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                if (c3 == c1 && c3 != c2) dp[i][j] = dp[i - 1][j];
                else if (c3 != c1 && c3 == c2) dp[i][j] = dp[i][j - 1];
                else if (c3 == c1 && c3 == c2) dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
//        "abaaacbacaab"
//        "bcccababccc"
//        "bcccabaaaaabccaccbacabb"
    }
}
