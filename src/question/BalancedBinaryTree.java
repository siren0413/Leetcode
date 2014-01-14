package question;

import beans.TreeNode;

/**
 * Created by admin on 1/12/14.
 */
public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root){
        if(root == null) return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right))>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        TreeNode n10 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        n6.left = n10;
        System.out.println(isBalanced(n1));

    }
}
