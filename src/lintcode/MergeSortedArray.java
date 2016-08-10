package lintcode;

import java.util.Arrays;

/**
 * Created by Nano on 2016/8/10.
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        m--; n--;
        for (int k = m + n + 1; k > -1; k--) {
            if (n < 0 || (m > -1 && A[m] > B[n])) {
                A[k] = A[m];
                m--;
            } else {
                A[k] = B[n];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,0,0};
        int[] B = {4,5};
        new MergeSortedArray().mergeSortedArray(A, 3, B, 2);
        System.out.println(Arrays.toString(A));
    }
}
