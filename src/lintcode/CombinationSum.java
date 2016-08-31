package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by t-nashan on 8/31/2016.
 */
public class CombinationSum {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(candidates, 0, target, 0, cur, lists);
        return lists;
    }

    public void dfs(int[] candidates, int from, int target, int curSum, List<Integer> curCombination, List<List<Integer>> lists) {
        if (curSum > target) return;
        if (curSum == target) {
            List<Integer> comb = new ArrayList<Integer>();
            for (int num : curCombination) comb.add(num);
            lists.add(comb);
            return;
        }
        for (int i = from; i < candidates.length; i++) {
            if (candidates[i] > target) return;
            int val = candidates[i];
            while (i < candidates.length && candidates[i] == val) i++;
            i--;
            curCombination.add(candidates[i]);
            dfs(candidates, i, target, curSum + candidates[i], curCombination, lists);
            curCombination.remove(curCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{30,34,25,24,29,38,36,42,45,44,31,28,26,37,23,20,47,40,49,46,39,43,33,41,27,32,35,48}, 54));
    }
}
