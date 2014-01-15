package question;

import beans.TreeNode;

import java.util.*;

/**
 * Created by admin on 1/14/14.
 */
public class UniqueBinarySearchTree2 {
    public static ArrayList<TreeNode> generateTrees(int n){
        ArrayList<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        generateTreesHelper(n,null,null,true,set,list);
        return list;
    }

    private static void generateTreesHelper(int n,TreeNode root, TreeNode parent, boolean left, Set<Integer> set, ArrayList<TreeNode> list){
        for(int i = 1; i <= n; i++){
            if(parent!=null){
                if(left && i > (int)parent.val) continue;
                if(!left && i < (int)parent.val) continue;
            }
            if(!set.contains(i)){
                TreeNode node = new TreeNode(i);
                if(parent == null){root=node;}
                else if (left) parent.left = node;
                else if (!left) parent.right = node;
                if(set.size() == n-1){
                    TreeNode copy = new TreeNode(root.val);
                    copy.left = root.left;
                    copy.right = root.right;
                    list.add(copy);
                    return;
                }
                set.add(i);
                generateTreesHelper(n,root,node,true,set,list);
                generateTreesHelper(n,root,node,false,set,list);
                set.remove(i);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<TreeNode> list = generateTrees(3);
        System.out.println(list);
    }

}
