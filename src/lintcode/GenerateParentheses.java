package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by t-nashan on 8/5/2016.
 */
public class GenerateParentheses {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        int len = n * 2;
        ArrayList<String> list = new ArrayList<>();
        char[] str = new char[len];
        generate(str, 0, 0, 0, len, list);
        return list;
    }

    private void generate(char[] str, int curIndex, int leftCount, int rightCount, int len, ArrayList<String> list) {
        if (curIndex == len) {
            if (leftCount == rightCount) list.add(new String(str));
            return;
        }
        if (leftCount > rightCount) {
            str[curIndex] = '(';
            generate(str, curIndex + 1, leftCount + 1, rightCount, len, list);
            str[curIndex] = ')';
            generate(str, curIndex + 1, leftCount, rightCount + 1, len, list);
        } else if (leftCount == rightCount) {
            str[curIndex] = '(';
            generate(str, curIndex + 1, leftCount + 1, rightCount, len, list);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
