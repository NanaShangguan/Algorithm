package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by t-nashan on 9/1/2016.
 */
public class PermutationsII {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(List<Integer> nums) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int[] permutation = new int[nums.size()];
        boolean[] visited = new boolean[nums.size()];
        recursion(nums, permutation, 0, visited, lists);
        return lists;
    }

    void recursion(List<Integer> nums, int[] permutation, int index, boolean[] visied, ArrayList<ArrayList<Integer>> lists) {
        if (index >= nums.size()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int n : permutation) list.add(n);
            lists.add(list);
            return;
        }
        for (int i = 0; i < nums.size(); ) {
            if (!visied[i]) {
                visied[i] = true;
                permutation[index] = nums.get(i);
                recursion(nums, permutation, index + 1, visied, lists);
                visied[i] = false;
                int val = nums.get(i);
                while (i < nums.size() && nums.get(i) == val) i++;
            }
            else i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(Arrays.asList(new Integer[]{1,2,2})));
    }
}
