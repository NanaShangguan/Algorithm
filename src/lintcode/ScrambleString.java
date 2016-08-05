package lintcode;

/**
 * Created by t-nashan on 8/5/2016.
 */
public class ScrambleString {
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        return helper(s1.toCharArray(), 0, len - 1, s2.toCharArray(), 0, len - 1);
    }

    private boolean helper(char[] s1, int from1, int to1, char[] s2, int from2, int to2) {
        if (from1 > to1) return true;
        if (from1 == to1) {
            return s1[from1] == s2[from2];
        }
        for (int i = from1; i < to1; i++) {
            boolean left = helper(s1, from1, i, s2, from2, from2 + (i - from1));
            boolean right = helper(s1, i + 1, to1, s2, from2 + (i - from1) + 1, to2);
            if (left && right) return true;
            left = helper(s1, from1, i, s2, to2 - (i - from1), to2);
            right = helper(s1, i + 1, to1, s2, from2, from2 + (to1 - i - 1));
            if (left && right) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ScrambleString().isScramble("great", "taerg"));
    }
}
