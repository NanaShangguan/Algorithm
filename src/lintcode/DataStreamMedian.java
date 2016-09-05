package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by t-nashan on 9/5/2016.
 */
public class DataStreamMedian {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int len = nums.length;
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        PriorityQueue<Integer> right = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        int[] medians = new int[len];
        for (int i = 0; i < len; i++) {
            if (left.isEmpty()) left.add(nums[i]);
            else {
                if (nums[i] > left.peek()) {
                    if (left.size() > right.size()) right.add(nums[i]);
                    else {
                        right.add(nums[i]);
                        left.add(right.poll());
                    }
                } else {
                    if (left.size() > right.size()) {
                        right.add(left.poll());
                        left.add(nums[i]);
                    } else left.add(nums[i]);
                }
            }
            medians[i] = left.peek();
        }
        return medians;
    }
}
