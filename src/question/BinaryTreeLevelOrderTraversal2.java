package question;

import beans.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by admin on 1/13/14.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        if(root == null) return totalList;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            for(TreeNode n: queue)
                list.add((int)n.val);
            totalList.add(list);
            ArrayList<TreeNode> currQ = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.remove(0);
                if(node.left!=null) currQ.add(node.left);
                if(node.right!=null) currQ.add(node.right);
            }
            queue = currQ;
        }
        Collections.reverse(totalList);
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
        System.out.println(levelOrderBottom(n1));
    }
}
