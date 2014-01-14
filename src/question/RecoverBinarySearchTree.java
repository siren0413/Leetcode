package question;

import beans.TreeNode;

/**
 * Created by admin on 1/14/14.
 */
public class RecoverBinarySearchTree {

    static TreeNode pre;
    static TreeNode first;
    static TreeNode second;

    public static void recoverTree(TreeNode root) {
        recoverTreeHelper(root);
        if (first != null && second != null) {
            int temp = (int) first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private static void recoverTreeHelper(TreeNode root) {
        if (root == null) return;
        recoverTreeHelper(root.left);
        if (pre == null) pre = root;
        else if ((int) pre.val > (int) root.val) {
            if (first == null) first = pre;
            second = root;
        }
        pre = root;
        recoverTreeHelper(root.right);
    }




    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(7);
        n1.left = n2;
        //n1.right = n3;
        //n2.left = n4;
        recoverTree(n1);
        inorder(n1);
    }

    private static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
