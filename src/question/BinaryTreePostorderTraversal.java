package question;

import java.util.ArrayList;
import beans.*;


public class BinaryTreePostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        left.addAll(right);
        left.add(root.val);
        return left;
    }
}
