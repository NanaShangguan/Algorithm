package lintcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by t-nashan on 8/16/2016.
 */
public class LargestRectangleInHistogram {
    class Bar {
        int height, index;
        public Bar(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        if(len == 0) return 0;
        Stack<Bar> stack = new Stack<Bar>();
        Bar[] bars = new Bar[len + 1];
        for (int i = 0; i < len; i++) {
            bars[i] = new Bar(height[i], i);
        }
        bars[len] = new Bar(0, len);
        int maxArea = 0;
        for (int i = 0; i <= len; ) {
            if (stack.isEmpty() || stack.peek().height <= bars[i].height) {
                stack.push(bars[i]);
                i++;
            } else {
                Bar top = stack.pop();
                int area = top.height * (stack.isEmpty() ? i : (i - stack.peek().index - 1));
                if (maxArea < area) maxArea = area;
            }
        }
        return maxArea;
    }

    private int divideAndConquer(int[] height, int from, int to) {
        if (from > to) return 0;
        if (from == to) return height[from];
        int minIndex = from;
        for (int i = from + 1; i <= to; i++)
            if (height[i] < height[minIndex]) minIndex = i;
        int area = (to - from + 1) * height[minIndex];
        int leftMaxArea = divideAndConquer(height, from, minIndex - 1);
        int rightMaxArea = divideAndConquer(height, minIndex + 1, to);
        return Math.max(area, Math.max(leftMaxArea, rightMaxArea));
    }

    public static void main(String[] args) {
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }
}
