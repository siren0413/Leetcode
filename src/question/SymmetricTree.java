package question;

import beans.TreeNode;

/**
 * Created by admin on 1/13/14.
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricHelper(root.left,root.right);
    }

    private static boolean isSymmetricHelper(TreeNode rootA, TreeNode rootB){
        if(rootA == null && rootB == null) return true;
        if((rootA == null && rootB!=null) || (rootA!=null && rootB==null) || (rootA.val != rootB.val)) return false;
        return isSymmetricHelper(rootA.left,rootB.right) && isSymmetricHelper(rootA.right,rootB.left);
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        System.out.println(isSymmetric(n1));

    }

}
