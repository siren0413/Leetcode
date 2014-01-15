package question;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by admin on 1/14/14.
 */
public class BinaryTreeInorderTraversal {

    // recursive solution
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        inorderTraversalHelper(root, list);
        return list;
    }

    private static void inorderTraversalHelper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        inorderTraversalHelper(root.left, list);
        list.add((int) root.val);
        inorderTraversalHelper(root.right, list);
    }


    // iterator solution
    public static ArrayList<Integer> inorderTraversal2(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            list.add((int)root.val);
            root = root.right;
        }
        return list;
    }



    //test
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        System.out.println(inorderTraversal2(n1));
    }
}
