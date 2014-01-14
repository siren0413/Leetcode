package question;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by admin on 1/13/14.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if(root == null) return totalList;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            ArrayList<TreeNode> currQ = new ArrayList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for(TreeNode n : queue){
                list.add((int)n.val);
            }
            if(reverse) Collections.reverse(list);
            totalList.add(list);
            reverse = !reverse;
            while(!queue.isEmpty()){
                TreeNode node = queue.remove(0);
                if(node.left!=null) currQ.add(node.left);
                if(node.right!=null) currQ.add(node.right);
            }
            queue = currQ;
        }
        return totalList;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(zigzagLevelOrder(n1));
    }


}
