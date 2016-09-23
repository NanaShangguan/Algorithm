package leetcode;

/**
 * Created by t-nashan on 9/23/2016.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int i = 0;
        while (k > 0 && i < num.length()) {
            k--;
            while (i + 1 < num.length() && num.charAt(i) <= num.charAt(i + 1)) i++;
            String prefix = num.substring(0, i);
            String postfix = "";
            if (i + 1 < num.length()) postfix = num.substring(i + 1);
            num = prefix + postfix;
            if (i > 0) i--;
        }
//        if (k > 0) num = num.substring(0, num.length() - k);
        i = 0;
        while (i < num.length() && num.charAt(i) == '0') i++;
        if (i == num.length()) return "0";
        return num.substring(i);
    }
}
