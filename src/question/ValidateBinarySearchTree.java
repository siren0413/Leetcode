package question;

import beans.TreeNode;

/**
 * Created by admin on 1/14/14.
 */
public class ValidateBinarySearchTree {
    static TreeNode pre = null;
    public static boolean isValidBST(TreeNode root){
        if(root==null) return true;
        boolean left = isValidBST(root.left);
        if(pre!=null && (int)pre.val >= (int)root.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }


// test
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(-1);
        n1.left = n2;
        System.out.println(isValidBST(n1));
    }
}
