package question;

import beans.TreeNode;

/**
 * Created by admin on 1/13/14.
 */
public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

}
