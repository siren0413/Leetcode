package question;

import beans.TreeNode;

/**
 * Created by siren0413 on 1/6/14.
 */
public class SumRootToLeafNumbers {
    public static int sumNumbers(TreeNode<Integer> root){
        if(root == null)
            return 0;
        return helper(root,0);
    }

    private static int helper(TreeNode<Integer> root, int n){
        if(root==null)
            return 0;
        n = n * 10 + root.val;
        return Math.max(n,helper(root.left,n)+helper(root.right,n));
    }

    public static void main(String[] args){
        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(0);
        TreeNode<Integer> n3 = new TreeNode<>(0);
        TreeNode<Integer> n4 = new TreeNode<>(1);
        n1.left = n2;
        //n1.right = n3;
        //n2.right = n4;
        System.out.println(sumNumbers(n1));
    }


}
