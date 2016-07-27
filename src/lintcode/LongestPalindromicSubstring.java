package lintcode;

/**
 * Created by t-nashan on 7/27/2016.
 */
public class LongestPalindromicSubstring {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        return ON(s);
    }

    private String ON(String s) {
        int len = s.length();
        char[] str = new char[len * 2 + 1];
        for (int i = 0; i < len; i++) {
            str[i * 2] = '#'; str[i * 2 + 1] = s.charAt(i);
        }
        str[len * 2] = '#';

        int C = 0, R = 0;
        int[] p = new int[str.length];
        int maxC = 0;
        for (int i = 1; i < str.length; i++) {
            if (R < i) {
                int l = i - 1, r = i + 1;
                while (l >= 0 && r < str.length && str[l] == str[r]) {
                    l--; r++;
                }
                p[i] = i - (l + 1);
            } else {
                int i1 = 2 * C - i;
                if (p[i1] < (R - i)) p[i] = p[i1];
                else {
                    int l = 2 * i - R - 1, r = R + 1;
                    while (l >= 0 && r < str.length && str[l] == str[r]) {
                        l--; r++;
                    }
                    p[i] = i - (l + 1);
                }
            }
            if (i + p[i] > R) {
                R = i + p[i];
                C = i;
            }
            if (p[maxC] < p[i]) maxC = i;
        }
        StringBuilder sb = new StringBuilder();
        int l = maxC - p[maxC], r = maxC + p[maxC];
        for (int i = l; i <= r; i++) {
            if (str[i] != '#') sb.append(str[i]);
        }
        return sb.toString();
    }

    private String ON2(String s) {
        String sub = "";
        if (s != null) {
            int len = s.length();
            if (len > 0) {
                int max = 1;
                int left = 0, right = 0;
                boolean[][] dp = new boolean[len][len];
                for (int i = len - 1; i >= 0; i--) {
                    for (int j = 0; j < len; j++) {
                        if (i >= j) dp[i][j] = true;
                        else if (s.charAt(i) == s.charAt(j))
                            dp[i][j] = dp[i + 1][j - 1];
                        else dp[i][j] = false;
                        if (dp[i][j] && max < (j - i + 1)) {
                            max = j - i + 1;
                            left = i;
                            right = j;
                        }
                    }
                }
                sub = s.substring(left, right + 1);
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aa"));
    }
}
