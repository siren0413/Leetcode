package question;

import beans.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by admin on 1/12/14.
 */
public class MinimumDepthOfBinaryTree {

    //DFS
    public static int minDepth(TreeNode root){
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left!=null && root.right!=null)
            return Math.min(minDepth(root.left)+1,minDepth(root.right)+1);
        else if(root.left !=null)
            return minDepth(root.left)+1;
        else
            return minDepth(root.right)+1;
    }

    // BFS
    public static int minDepth2(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            Queue<TreeNode> currQ = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    return depth;
                if(node.left!=null) currQ.add(node.left);
                if(node.right!=null) currQ.add(node.right);
            }
            queue = currQ;
        }
        return 0;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        TreeNode n10 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        //n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        n6.left = n10;
        System.out.println(minDepth(n1));
        System.out.println(minDepth2(n1));
    }

}
