package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by t-nashan on 9/1/2016.
 */
public class SubsetsII {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(List<Integer> S) {
        Collections.sort(S);
        int[] subset = new int[S.size()];
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        recursion(S, 0, subset, 0, lists);
        lists.add(new ArrayList<Integer>());
        return lists;
    }

    void recursion(List<Integer> s, int curIndex, int[] subset, int index, ArrayList<ArrayList<Integer>> lists) {
        if (curIndex >= s.size()) return;
        for (int i = curIndex; i < s.size(); ) {
            subset[index] = s.get(i);
            //add subset to list
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j =  0; j <= index; j++) list.add(subset[j]);
            lists.add(list);
            recursion(s, i + 1, subset, index + 1, lists);
            int val = s.get(i);
            while (i < s.size() && s.get(i) == val) i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsII().subsetsWithDup(Arrays.asList(new Integer[]{1,2,2})));
    }
}
