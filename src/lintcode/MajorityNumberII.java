package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by t-nashan on 8/24/2016.
 */
public class MajorityNumberII {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        int n1 = 0, c1 = 0, n2 = 0, c2 = 0;
        for (int num : nums) {
            if (c1 == 0) {
                n1 = num;
                c1 = 1;
            }
            else if (num == n1) c1++;
            else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            }
            else if (num == n2) c2++;
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0; c2 = 0;
        for (int num : nums) {
            if (num == n1) c1++;
            else if (num == n2) c2++;
        }
        if (c1 > (nums.size() / 3)) return n1;
        return n2;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(new Integer[] {1,1,1,1,2,2,3,3,4,4,4});
        System.out.println(new MajorityNumberII().majorityNumber(nums));
    }
}
