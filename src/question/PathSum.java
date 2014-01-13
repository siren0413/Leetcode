package question;

import beans.TreeNode;

/**
 * Created by admin on 1/12/14.
 */
public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum){
        return root!=null && hasPathSumHelper(root,sum);
    }

    private static boolean hasPathSumHelper(TreeNode root, int sum){
        if(root == null)
            return  sum==0;
        return (root.left!=null && hasPathSumHelper(root.left, sum - (int)root.val)) | (root.right!=null && hasPathSumHelper(root.right, sum - (int)root.val)) | (root.left==null &&root.right==null&& hasPathSumHelper(root.left, sum - (int)root.val));

    }

    public static void main(String[] args){
//        TreeNode n1 = new TreeNode(5);
//        TreeNode n2 = new TreeNode(4);
//        TreeNode n3 = new TreeNode(8);
//        TreeNode n4 = new TreeNode(11);
//        TreeNode n5 = new TreeNode(13);
//        TreeNode n6 = new TreeNode(4);
//        TreeNode n7 = new TreeNode(7);
//        TreeNode n8 = new TreeNode(2);
//        TreeNode n9 = new TreeNode(1);
//        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n4.left = n7;
//        n4.right = n8;
//        n3.left = n5;
//        n3.right = n6;
//        n6.right = n9;
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
       // n2.left = n3;
       // n3.left = n4;
       // n4.left = n5;
        System.out.println(hasPathSum(n1,3));
    }
}
