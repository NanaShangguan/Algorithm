package lintcode;

import java.util.Arrays;

/**
 * Created by t-nashan on 8/5/2016.
 */
public class SortLettersByCase {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null) return;
        int len = chars.length;
        int low = 0, high = len - 1;
        while (low < high) {
            while (low < high && !isUpperCaseLetter(chars[low])) low++;
            while (low < high && isUpperCaseLetter(chars[high])) high--;
            swap(chars, low, high);
        }
    }
    private boolean isUpperCaseLetter(char c) {
        int val = c - 'A';
        return val >= 0 && val < 26;
    }
    private void swap(char[] chars, int i, int j) {
        char copy = chars[i];
        chars[i] = chars[j];
        chars[j] = copy;
    }

    public static void main(String[] args) {
        char[] chars = "A".toCharArray();
        new SortLettersByCase().sortLetters(chars);
        System.out.println(Arrays.toString(chars));
    }
}
