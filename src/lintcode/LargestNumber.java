package lintcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by t-nashan on 8/23/2016.
 */
public class LargestNumber {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        if (num.length == 0) return "0";
        Integer[] nums = new Integer[num.length];
        for (int i = 0; i < num.length; i++)
            nums[i] = num[i];
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String o12 = o1 + "" + o2;
                String o21 = o2 + "" + o1;
                int len = o12.length();
                for (int i = 0; i < len; i++) {
                    if (o12.charAt(i) < o21.charAt(i)) return 1;
                    else if (o12.charAt(i) > o21.charAt(i)) return -1;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        if (nums[0] == 0) return "0";
        for (int n : nums) {
            sb.append(n);
        }
        return sb.toString();
    }
}
