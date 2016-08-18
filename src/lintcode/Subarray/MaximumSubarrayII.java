package lintcode.Subarray;

import java.util.ArrayList;

/**
 * Created by t-nashan on 8/18/2016.
 */
public class MaximumSubarrayII {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int len = nums.size();
        int[] leftDp = new int[len], rightDp = new int[len];
        int[] leftMaxSum = new int[len], rightMaxSum = new int[len];
        leftDp[0] = nums.get(0); leftMaxSum[0] = nums.get(0);
        rightDp[len - 1] = nums.get(len - 1); rightMaxSum[len - 1] = nums.get(len - 1);
        for (int i = 1; i < len; i++) {
            leftDp[i] = Math.max(leftDp[i - 1] + nums.get(i), nums.get(i));
            leftMaxSum[i] = Math.max(leftMaxSum[i - 1], leftDp[i]);
        }
        for (int i = len - 2; i > -1; i--) {
            rightDp[i] = Math.max(rightDp[i + 1] + nums.get(i), nums.get(i));
            rightMaxSum[i] = Math.max(rightMaxSum[i + 1], rightDp[i]);
        }
        int maxSum = leftMaxSum[0] + rightMaxSum[1];
        for (int i = 1; i < len - 1; i++) {
            int sum = leftMaxSum[i] + rightMaxSum[i + 1];
            if (maxSum < sum) maxSum = sum;
        }
        return maxSum;
    }
}
