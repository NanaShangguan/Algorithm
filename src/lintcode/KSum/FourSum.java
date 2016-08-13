package lintcode.KSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nano on 2016/8/13.
 */
public class FourSum {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int len = numbers.length;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < len - 3; i++) {
            int threeSumTarget = target - numbers[i];
            for (int j = i + 1; j < len - 2; j++) {
                int twoSumTarget = threeSumTarget - numbers[j];
                int low = j + 1, high = len - 1;
                while (low < high) {
                    int sum = numbers[low] + numbers[high];
                    if (sum == twoSumTarget) {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[low]);
                        list.add(numbers[high]);
                        lists.add(list);
                        int lowVal = numbers[low], highVal = numbers[high];
                        while (low < high && numbers[low] == lowVal) low++;
                        while (low < high && numbers[high] == highVal) high--;
                    } else if (sum < twoSumTarget) low++;
                    else high--;
                }
                while (j < len - 2 && numbers[j] == numbers[j + 1]) j++;
            }
            while (i < len - 3 && numbers[i] == numbers[i + 1]) i++;
        }
        return lists;
    }
}
