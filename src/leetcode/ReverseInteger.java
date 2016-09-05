package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by t-nashan on 9/5/2016.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        if (x == 0) return 0;
        while (x % 10 == 0) x /= 10;
        int res = 0;
        while (x > 0) {
            int digit = x % 10;
            int check = (Integer.MAX_VALUE - digit) / 10;
            if (res > check) return 0;
            res = res * 10 + digit;
            x /= 10;
        }
        if (flag) return -res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-123));
    }
}
