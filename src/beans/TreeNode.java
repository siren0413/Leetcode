package beans;

public class TreeNode <T>{
	public T val;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode<T> parent;
	public boolean visited = false;
	
	public TreeNode(){}
	public TreeNode(T data){
		this.val = data;
	}
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
		this.val = data;
		this.left = left;
		this.right = right;	
	}
	
	public String toString(){
		return ""+val;
	}
}
