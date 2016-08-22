package lintcode;

/**
 * Created by t-nashan on 8/22/2016.
 */
public class FastPower {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (n == 0) return 1 % b;
        if (n == 1) return a % b;
        int half = n / 2;
        long res = fastPower(a, b, half);
        res = (res * res) % b;
        if ((n & 1) == 1) res = (res * (a % b)) % b;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new FastPower().fastPower(109, 10000007, 1000001));
    }
}
