package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nano on 2016/8/2.
 */
public class WordBreak {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("lint");
        set.add("code");
        System.out.println(new WordBreak().wordBreak("", set));
    }
}
