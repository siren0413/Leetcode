package question;

import beans.TreeLinkNode;

/**
 * Created by admin on 1/11/14.
 */
public class PopulatingNextRightPointersInEachNode2 {

    public static void connect(TreeLinkNode root) {
        if (root == null)
            return;
        connect(root.left);
        connect(root.right);
        connectHelper(root.left,root.right);
    }

    private static void connectHelper(TreeLinkNode left, TreeLinkNode right){
        if(left == null || right == null)
            return;
        if(left.next == null)
            left.next = right;
        connectHelper(left.left,right.left);
        connectHelper(left.left,right.right);
        connectHelper(left.right,right.left);
        connectHelper(left.right,right.right);
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n7;
        n3.right = n6;
        n6.right = n8;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
//        n3.left = n6;
//        n3.right = n7;
        connect(n1);
        inorder(n1);
    }

    private static void inorder(TreeLinkNode node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.println("node:" + node.val + " node.next:" + (node.next == null ? null : node.next.val));
        inorder(node.right);
    }
}
