package question;

import beans.TreeLinkNode;

/**
 * Created by admin on 1/11/14.
 */
public class PopulatingNextRightPointersInEachNode {
    public static void connect(TreeLinkNode root) {
        if (root == null)
            return;
        connect(root.left);
        connect(root.right);
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
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
