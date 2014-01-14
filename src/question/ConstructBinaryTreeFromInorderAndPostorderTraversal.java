package question;

import beans.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 1/13/14.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if(inorder.length == 0 || postorder.length ==0 ) return null;
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i],i);
        }
        return buildTreeHelper(inorder, postorder, inMap, 0, inorder.length-1,postorder.length-1);
    }

    private static TreeNode buildTreeHelper(int[] inorder,int[] postorder, Map<Integer,Integer> inMap, int inStart, int inEnd, int postEnd){
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = inMap.get(postorder[postEnd]);
        root.left = buildTreeHelper(inorder,postorder,inMap,inStart,rootIndex-1,postEnd-1-inEnd+rootIndex);
        root.right = buildTreeHelper(inorder,postorder,inMap, rootIndex+1, inEnd,postEnd-1);
        return root;
    }


    public static void main(String[] args){
        int[] inorder = {5,4,3,2,1};
        int[] postorder = {1,2,3,4,5};
        TreeNode node = buildTree(inorder,postorder);
        inorder(node);
    }

    private static void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
