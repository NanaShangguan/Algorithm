package leetcode;

/**
 * Created by t-nashan on 8/5/2016.
 */
public class DecodeWays {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        if (s == null) return 0;
        int len = s.length();
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if (i > 1 &&
                    (s.charAt(i - 2) == '1' ||
                            (s.charAt(i - 2) == '2' && s.charAt(i - 1) - '0' <= 6)))
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }
}
