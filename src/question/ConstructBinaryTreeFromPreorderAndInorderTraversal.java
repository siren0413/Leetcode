package question;

import beans.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 1/13/14.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        if(inorder.length == 0 || preorder.length ==0 ) return null;
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i],i);
        }
        return buildTreeHelper(inorder, preorder, inMap, 0, inorder.length-1,0);
    }

    private static TreeNode buildTreeHelper(int[] inorder,int[] preorder, Map<Integer,Integer> inMap, int inStart, int inEnd, int preStart){
        if(inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inMap.get(preorder[preStart]);
        root.left = buildTreeHelper(inorder,preorder,inMap,inStart,rootIndex-1,preStart+1);
        root.right = buildTreeHelper(inorder,preorder,inMap, rootIndex+1, inEnd,preStart+1+rootIndex-inStart);
        return root;
    }


    public static void main(String[] args){
        int[] inorder = {2,7,4,5,1};
        int[] preorder = {5,7,2,4,1};
        TreeNode node = buildTree(preorder,inorder);
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
