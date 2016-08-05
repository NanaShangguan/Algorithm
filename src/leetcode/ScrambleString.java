package leetcode;

/**
 * Created by t-nashan on 8/5/2016.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        boolean[][][] dp = new boolean[len + 1][len + 1][len + 1];
        dp[len][len][0] = true;
        for (int i = len - 1; i > -1; i--) {
            for (int j = len - 1; j > -1; j--) {
                dp[i][j][0] = true;
                int minLen = Math.min(len - i, len - j);
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                for (int l = 2; l <= minLen; l++) {
                    for (int subLen = 1; subLen < l; subLen++) {
                        dp[i][j][l] = (dp[i][j][subLen] && dp[i + subLen][j + subLen][l - subLen])
                                || (dp[i][j + l - subLen][subLen] && dp[i + subLen][j][l - subLen]);
                        if (dp[i][j][l]) break;
                    }
                }
            }
        }
        return dp[0][0][len];
    }

    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("great", "taegr"));
    }
}
