package lintcode;

/**
 * Created by t-nashan on 8/16/2016.
 */
public class FindPeakElement {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        int len = A.length;
        int low = 1, high = len - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) return mid;
            else if (A[mid] > A[mid - 1]) low = mid + 1;
            else high = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeak(new int[]{1,2,1}));
    }
}
