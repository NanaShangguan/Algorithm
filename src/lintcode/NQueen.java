package lintcode;

import java.util.ArrayList;

/**
 * Created by t-nashan on 9/1/2016.
 */
public class NQueen {
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        int[] pos = new int[n];
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        recursion(n, 0, pos, lists);
        return lists;
    }

    void recursion(int n, int cur, int[] pos, ArrayList<ArrayList<String>> lists) {
        if (cur >= n) {
            ArrayList<String> list = new ArrayList<String>();
            for (int p : pos) {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    if (i == p) sb.append('Q');
                    else sb.append('.');
                }
                list.add(sb.toString());
            }
            lists.add(list);
            return;
        }
        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < cur; j++) {
                if (i == pos[j] || (cur - j) == Math.abs(i - pos[j])) flag = false;
            }
            if (flag) {
                pos[cur] = i;
                recursion(n, cur + 1, pos, lists);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().solveNQueens(4));
    }
}
