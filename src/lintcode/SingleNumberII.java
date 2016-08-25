package lintcode;

/**
 * Created by t-nashan on 8/24/2016.
 */
public class SingleNumberII {
    /**
     * @param A : An integer array
     * @return : An integer
     */
    public int singleNumberII(int[] A) {
        int base = 1;
        int num = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int a : A) {
                if ((a & base) == base) count++;
            }
            if (count % 3 != 0) num += base;
            base <<= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumberII().singleNumberII(new int[]{1,1,2,3,3,3,2,2,4,1}));
    }
}
