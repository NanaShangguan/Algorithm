package lintcode.KSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nano on 2016/8/13.
 */
public class ThreeSum {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;
        int threeSumTarget = 0;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < len - 2; i++) {
            int twoSumTarget = threeSumTarget - numbers[i];
            int low = i + 1, high = len - 1;
            while (low < high) {
                int sum = numbers[low] + numbers[high];
                if (sum == twoSumTarget) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[low]);
                    list.add(numbers[high]);
                    lists.add(list);
                    int lowVal = numbers[low], highVal = numbers[high];
                    while (low < high && numbers[low] == lowVal) low++;
                    while (low < high && numbers[high] == highVal) high--;
                } else if (sum < twoSumTarget) low++;
                else high--;
            }
            while (i < len - 2 && numbers[i] == numbers[i + 1]) i++;
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
