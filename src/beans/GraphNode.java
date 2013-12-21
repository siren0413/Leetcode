package beans;

import java.util.*;

public class GraphNode <T>{
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
