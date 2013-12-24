package question;

import java.util.ArrayList;
import beans.*;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode<Integer> root) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		if (root == null) {
			return r;
		}
		r.add(root.data);
		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = preorderTraversal(root.right);
		if (left != null)
			r.addAll(left);
		if (right != null)
			r.addAll(right);
		return r;
	}
}
