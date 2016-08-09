package leetcode;

/**
 * Created by t-nashan on 8/9/2016.
 */
public class InterleavingString {
    private boolean flag = false;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        helper(s1, s2, s3, 0, "", "");
        return flag;
    }

    private void helper(String s1, String s2, String s3, int i, String t1, String t2) {
        if (flag) return;
        if (i == s3.length()) {
            if (t1.equals(s1) && t2.equals(s2)) flag = true;
            return;
        }
        if (t1.length() > s1.length()) return;
        if (t2.length() > s2.length()) return;
        helper(s1, s2, s3, i + 1, t1 + s3.charAt(i), t2);
        helper(s1, s2, s3, i + 1, t1, t2 + s3.charAt(i));
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("abaaacbacaab", "bcccababccc", "bcccabaaaaabccaccbacabb"));
//        "abaaacbacaab"
//        "bcccababccc"
//        "bcccabaaaaabccaccbacabb"
    }
}
