package lintcode;

/**
 * Created by t-nashan on 8/22/2016.
 */
public class UpdateBits {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        int left = (j + 1) >= 32 ? 0 : ((n >>> (j + 1)) << (j + 1));
        int right = (32 - i) >= 32 ? 0 : ((n << (32 - i)) >>> (32 - i));
        int mid = m << i;
        return left + mid + right;
    }

    public static void main(String[] args) {
        System.out.println(new UpdateBits().updateBits(1,-1,0,31));
    }
}
