package question;

/**
 * Created by admin on 1/22/14.
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int start = 0, end = height.length - 1, max = -1;
        while (start < end) {
            if (Math.min(height[start], height[end]) * (end - start) > max)
                max = Math.min(height[start], height[end]) * (end - start);
            if (height[start] == height[end]) {
                start++;
                end--;
            } else if (height[start] < height[end]) start++;
            else end--;
        }
        return max;
    }


    //test
    public static void main(String[] args) {
        int[] height = {4, 3, 2, 1, 5, 6, 2};
        System.out.println(maxArea(height));
    }
}
