package leetcode;

/**
 * Created by t-nashan on 8/8/2016.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        return backtracking(s, 0, p, 0);
    }

    private boolean backtracking(String s, int from, String p, int from1) {
        if (from1 >= p.length()) return from >= s.length();
        if (from >= s.length()) {
            for (int i = from1; i < p.length(); i++)
                if (p.charAt(i) != '*') return false;
            return true;
        }
        if (p.charAt(from1) == '?') return backtracking(s, from + 1, p, from1 + 1);
        if (p.charAt(from1) != '*') return s.charAt(from) == p.charAt(from1) ? backtracking(s, from + 1, p, from1 + 1) : false;
        //p.charAt(from1) == '*'
        from1++;
        while (from1 < p.length() && (p.charAt(from1) == '*' || p.charAt(from1) == '?')) {
            if (p.charAt(from1) == '?') from++;
            from1++;
        }
        if (from1 == p.length()) {
            if (from > s.length()) return false;
            return true;
        }
        while (from < s.length()) {
            while (from < s.length() && s.charAt(from) != p.charAt(from1)) from++;
            if (backtracking(s, from, p, from1)) return true;
            from++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("b", "*?*?"));
    }
}
