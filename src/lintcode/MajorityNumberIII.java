package lintcode;

import java.util.*;

/**
 * Created by t-nashan on 8/24/2016.
 */
public class MajorityNumberIII {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(k);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                if (map.size() < k) map.put(num, 1);
                else {
                    Iterator<Integer> it = map.keySet().iterator();
                    while (it.hasNext()) {
                        int key = it.next();
                        if (map.get(key) == 1) it.remove();
                        else map.put(key, map.get(key) - 1);
                    }
                }
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            map.put(key, 0);
        }
        for (int num : nums)
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
        it = map.keySet().iterator();
        while (it.hasNext()) {
            int key = it.next();
            if (map.get(key) > (nums.size() / k)) return key;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(new Integer[] {3,1,2,3,2,3,3,4,4,4,5,5,6,6});
        System.out.println(new MajorityNumberIII().majorityNumber(nums, 4));
    }
}
