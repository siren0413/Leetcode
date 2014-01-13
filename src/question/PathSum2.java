package question;

import beans.TreeNode;

import java.util.ArrayList;

/**
 * Created by admin on 1/12/14.
 */
public class PathSum2 {
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        if(root == null)
            return result;
        pathSumHelper(root,sum,result,subList);
        return result;
    }

    public static void pathSumHelper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subList){
        if(root== null){
            if(sum == 0){
                ArrayList list = new ArrayList(subList);
                result.add(list);
            }
            return;
        }
        subList.add((int)root.val);
        if(root.left!=null){
            pathSumHelper(root.left, sum - (int)root.val,result,subList);
        }
        if(root.right!=null){
            pathSumHelper(root.right, sum - (int)root.val,result,subList);
        }
        if(root.left==null && root.right == null){
            pathSumHelper(root.left, sum - (int)root.val,result,subList);
        }

        if(!subList.isEmpty())
            subList.remove(subList.size()-1);
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
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        n6.left = n10;
        System.out.println(pathSum(n1, 22));
    }

}
