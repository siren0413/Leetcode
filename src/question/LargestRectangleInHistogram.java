package question;

import java.util.*;

/**
 * Created by admin on 1/16/14.
 */
public class LargestRectangleInHistogram {

    // O(N)
    public static int largestRectangleArea3(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        while (i < h.length) {
            if (stack.isEmpty() || h[i] >= h[stack.peek()] ) {
                stack.push(i++);
            } else {
                int t = stack.pop();
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }

    // O(N^2)
    public static int largestRectangleArea(int[] height) {
        int max = 0;
        int preHeight = -1;
        for (int i = 0; i < height.length; i++) {
            if (preHeight != -1 && preHeight == height[i]) continue;
            max = Math.max(max, largestRectangleAreaLeft(height, i, height[i]) + largestRectangleAreaRight(height, i, height[i]) - height[i]);
            preHeight = height[i];
        }
        return max;
    }

    private static int largestRectangleAreaLeft(int[] height, int i, int h) {
        if (i < 0 || height[i] < h) return 0;
        return largestRectangleAreaLeft(height, i - 1, h) + h;
    }

    private static int largestRectangleAreaRight(int[] height, int i, int h) {
        if (i > height.length - 1 || height[i] < h) return 0;
        return largestRectangleAreaRight(height, i + 1, h) + h;
    }

    // O(N^2)
    public static int largestRectangleArea2(int[] height) {
        Set<Integer> set = new TreeSet<>();
        int max = 0;
        for (int i : height) set.add(i);
        int sum = 0;
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int h = iter.next();
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= h) sum += h;
                else {
                    max = Math.max(sum, max);
                    sum = 0;
                }
            }
            max = Math.max(sum, max);
            sum = 0;
        }
        return max;
    }




//test
    public static void main(String[] args) {
        int[] height = {2,3,4,3,7,8};
        System.out.println(largestRectangleArea3(height));
    }
}
