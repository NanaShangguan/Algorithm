package lintcode;

/**
 * Created by Nano on 2016/8/2.
 */
public class AddBinary {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        int minLen = Math.min(a.length(), b.length());
        char[] sum = new char[len + 1];
        int carry = 0;
        for (int i = 0; i < minLen; i++) {
            int a1 = a.charAt(a.length() - 1 - i) - '0';
            int b1 = b.charAt(b.length() - 1 - i) - '0';
            int s = a1 + b1 + carry;
            sum[len - i] = (char)((s % 2) + '0');
            if (s >= 2) carry = 1;
            else carry = 0;
        }
        String maxStr = a.length() > b.length() ? a : b;
        for (int i = minLen; i < len; i++) {
            int m = maxStr.charAt(len - 1 - i) - '0';
            int s = m + carry;
            sum[len - i] = (char)((s % 2) + '0');
            if (s >= 2) carry = 1;
            else carry = 0;
        }
        if (carry == 1) {
            sum[0] = '1';
            return new String(sum);
        }
        return new String(sum, 1, len);
    }

    public static void main(String[] args) {
        String s = new AddBinary().addBinary("1010", "1011");
        System.out.println(s);
    }
}
