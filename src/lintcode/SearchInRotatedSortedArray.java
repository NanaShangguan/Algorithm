package lintcode;

/**
 * Created by t-nashan on 8/15/2016.
 */
public class SearchInRotatedSortedArray {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        int len = A.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == A[mid]) return mid;
            else if (target > A[mid]) {
                if (A[mid] < A[high] && A[high] < A[low]) {
                    if (target > A[high]) high = mid - 1;
                    else low = mid + 1;
                } else if (A[mid] > A[low] && A[low] > A[high]) {
                    low = mid + 1;
                } else {
                    return generalSearch(A, target, low, high);
                }
            } else {
                if (A[mid] < A[high] && A[high] < A[low]) {
                    high = mid - 1;
                } else if (A[mid] > A[low] && A[low] > A[high]) {
                    if (target > A[high]) high = mid - 1;
                    else low = mid + 1;
                } else {
                    return generalSearch(A, target, low, high);
                }
            }
        }
        return -1;
    }

    private int generalSearch(int[] A, int target, int from, int to) {
        for (int i = from; i <= to; i++) {
            if (A[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1}, -9));
    }
}
