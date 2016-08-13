package lintcode.KSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nano on 2016/8/13.
 */
public class ThreeSumClosest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        Arrays.sort(numbers);
        int len = numbers.length;
        int threeSumTarget = target;
        int minDistance = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < len - 2; i++) {
            int twoSumTarget = threeSumTarget - numbers[i];
            int low = i + 1, high = len - 1;
            while (low < high) {
                int sum = numbers[low] + numbers[high];
                if (sum == twoSumTarget) {
                    return threeSumTarget;
                } else {
                    int distance = Math.abs(sum - twoSumTarget);
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestSum = sum + numbers[i];
                    }
                    if (sum < twoSumTarget) low++;
                    else high--;
                }
            }
            while (i < len - 2 && numbers[i] == numbers[i + 1]) i++;
        }
        return closestSum;
    }
}
