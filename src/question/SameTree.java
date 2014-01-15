package question;

import beans.TreeNode;

/**
 * Created by admin on 1/14/14.
 */
public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null) || ((int) p.val != (int) q.val)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
