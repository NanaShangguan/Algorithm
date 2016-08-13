package lintcode.KSum;

import java.util.Arrays;

/**
 * Created by Nano on 2016/8/13.
 */
public class TwoSum {
    class Number implements Comparable<Number> {
        int val;
        int index;
        public Number(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Number o) {
            return Integer.compare(this.val, o.val);
        }
    }
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        Number[] nums = new Number[len];
        for (int i = 0; i < len; i++) {
            nums[i] = new Number(numbers[i], i);
        }
        Arrays.sort(nums);
        int low = 0, high = len - 1;
        int[] res = new int[2];
        while (low < high) {
            int sum = nums[low].val + nums[high].val;
            if (sum == target) {
                if (nums[low].index > nums[high].index) {
                    res[1] = nums[low].index + 1;
                    res[0] = nums[high].index + 1;
                } else {
                    res[0] = nums[low].index + 1;
                    res[1] = nums[high].index + 1;
                }
                return res;
            } else if (sum > target) high--;
            else low++;
        }
        return res;
    }
}
