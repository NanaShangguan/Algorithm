package lintcode;

/**
 * Created by t-nashan on 9/5/2016.
 */
public class MaximumSubarrayIII {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        int len = nums.length;
        int[][] maxSubInRange = new int[len][len];
        for (int i = 0; i < len; i++) {
            int[] dp = new int[len];
            dp[i] = nums[i];
            maxSubInRange[i][i] = nums[i];
            for (int j = i + 1; j < len; j++) {
                dp[j] = Math.max(nums[j], nums[j] + dp[j - 1]);
                maxSubInRange[i][j] = Math.max(maxSubInRange[i][j - 1], dp[j]);
            }
        }
        int[][] dp = new int[len][k + 1];
        dp[0][1] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i][1] = maxSubInRange[0][i];
            int maxJ = Math.min(i + 1, k);
            for (int j = 2; j <= maxJ; j++) {
                int max = Integer.MIN_VALUE;
                if (i >= j) max = dp[i - 1][j];
                for (int s = j - 1; s <= i; s++) {
                    int sum = dp[s - 1][j - 1] + maxSubInRange[s][i];
                    if (max < sum) max = sum;
                }
                dp[i][j] = max;
            }
        }
        return dp[len - 1][k];
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarrayIII().maxSubArray(new int[]{-1,-2,-3,-100,-1,-50}, 4));
    }
}
