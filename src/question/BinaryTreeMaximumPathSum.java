package question;

import beans.TreeNode;

import java.util.*;


/**
 * Created by siren0413 on 1/6/14.
 */
public class BinaryTreeMaximumPathSum {

    static int max;

    public static int maxPathSum(TreeNode<Integer> root) {
        max = Integer.MIN_VALUE;
        if(root == null) return 0;
        int ret = maxPathSumHelper(root);
        if(ret > max) max = ret;
        return max;
    }

    private static int maxPathSumHelper(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        // find out the max sum
        if(max < left ) max = left;
        if(max < right) max = right;
        if(max < ((int)root.val + left + right)) max = (int)root.val + left + right; // keep the max value, because we can't return this value but keep it in a variable.

        return Math.max((int)root.val, Math.max((int)root.val + left, (int)root.val + right)); // choose either left or right or just the root. so that we only return a path, not both of left and right.
    }

    public static void main(String[] args) {
        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(2);
        TreeNode<Integer> n3 = new TreeNode<>(3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(maxPathSum(n1));

    }

}
