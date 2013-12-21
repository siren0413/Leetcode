import java.util.*;

public class CloneGraph1 {

	public static <T> GraphNode<T> cloneGraph(GraphNode<T> node){
		GraphNode<T> root = null;
		GraphNode<T> cloned = null;
		Queue<GraphNode> queue = new LinkedList<>();
		Map<GraphNode<T>,GraphNode<T>> map = new HashMap<>();
		Set<GraphNode<T>> visitSet = new HashSet<>();
		queue.add(node);
		while(!queue.isEmpty()){
			GraphNode<T> origin = queue.poll();
			if(visitSet.contains(origin))
				continue;
			if(!map.containsKey(origin)){
				cloned = new GraphNode<>(origin.data);
				map.put(origin,cloned);
			}
			else
				cloned = map.get(origin);
			if(root == null)
					root = cloned;
			for(GraphNode<T> n : origin.neighbors){
				if(!map.containsKey(n)){
					GraphNode<T> newNode = new GraphNode(n.data);
					map.put(n,newNode);
					cloned.neighbors.add(newNode);
				}else{
					cloned.neighbors.add(map.get(n));
				}
				queue.add(n);
			}
			visitSet.add(origin);
		}
		
		return root;	
	}

	// test
	public static void main(String[] args) {
		GraphNode<Integer> node1 = new GraphNode<>(1);
		GraphNode<Integer> node2 = new GraphNode<>(2);
		GraphNode<Integer> node3 = new GraphNode<>(3);
		GraphNode<Integer> node4 = new GraphNode<>(4);
		GraphNode<Integer> node5 = new GraphNode<>(5);
		node1.neighbors.add(node2);
		node1.neighbors.add(node5);
		node2.neighbors.add(node4);
		node3.neighbors.add(node1);
		node3.neighbors.add(node2);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		node4.neighbors.add(node5);
		node5.neighbors.add(node2);
		
		GraphNode<Integer> root = cloneGraph(node1);
		Set<GraphNode<Integer>> visitSet = new HashSet<>();
		Queue<GraphNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			GraphNode<Integer> node = queue.poll();
			if(!visitSet.contains(node)){
				System.out.println("node"+node.data+": "+node.neighbors);
				for(GraphNode<Integer> n: node.neighbors){
					queue.add(n);
				}
			}
			visitSet.add(node);
		}
		
	}
}

class GraphNode <T>{
	public List<GraphNode> neighbors;
	public T data;
	
	public GraphNode(T data){
		this.data = data;
		neighbors = new LinkedList<>();
	}
	public GraphNode(T data, List<GraphNode> neighbors){
		this.data = data;
		this.neighbors = neighbors;
	}
	public String toString(){
		return data+"";
	}
	
}

