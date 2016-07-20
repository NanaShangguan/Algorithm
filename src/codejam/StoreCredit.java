package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nano on 2016/6/23.
 */
public class StoreCredit {
    static class Item implements Comparable<Item> {
        int val, index;

        public Item(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(this.val, o.val);
        }
    }
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("A-large-practice.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("A-large-practice.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int sum = in.nextInt(), len = in.nextInt();
            Item[] nums = new Item[len];
            for (int k = 1; k <= len; k++) nums[k - 1] = new Item(in.nextInt(), k);
            Arrays.sort(nums);
            int low = 0, high = len - 1;
            while (true) {
                int s = nums[low].val + nums[high].val;
                if (s == sum) break;
                if (s > sum) high--;
                else low++;
            }

            out.format("Case #%d: %d %d\n", i,
                    Math.min(nums[low].index, nums[high].index),
                    Math.max(nums[low].index, nums[high].index));
        }
    }
}
