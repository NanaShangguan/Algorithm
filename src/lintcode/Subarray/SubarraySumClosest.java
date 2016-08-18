package lintcode.Subarray;

import java.util.Arrays;

/**
 * Created by t-nashan on 8/18/2016.
 */
public class SubarraySumClosest {
    class SubarraySum implements Comparable<SubarraySum> {
        int sum, endIndex;
        public SubarraySum(int sum, int endIndex) {
            this.sum = sum;
            this.endIndex = endIndex;
        }

        @Override
        public int compareTo(SubarraySum o) {
            return Integer.compare(this.sum, o.sum);
        }
    }
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int len = nums.length;
        SubarraySum[] sum = new SubarraySum[len];
        sum[0] = new SubarraySum(nums[0], 0);
        for (int i = 1; i < len; i++) {
            sum[i] = new SubarraySum(sum[i - 1].sum + nums[i], i);
        }
        Arrays.sort(sum);
        int minDis = Integer.MAX_VALUE;
        int firstIndex = 0, lastIndex = 0;
        for (int i = 1; i < len; i++) {
            int dis = Math.abs(sum[i].sum - sum[i - 1].sum);
            if (minDis > dis) {
                minDis = dis;
                firstIndex = Math.min(sum[i].endIndex, sum[i - 1].endIndex) + 1;
                lastIndex = Math.max(sum[i].endIndex, sum[i - 1].endIndex);
            }
        }
        return new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SubarraySumClosest().subarraySumClosest(new int[]{-3,1,1,-3,5})));
    }
}
