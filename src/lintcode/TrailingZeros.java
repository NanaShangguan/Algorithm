package lintcode;

/**
 * Created by t-nashan on 8/22/2016.
 */
public class TrailingZeros {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        long sum = 0;
        while (n != 0) {
            sum += n / 5;
            n /= 5;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new TrailingZeros().trailingZeros(12436));
    }
}
