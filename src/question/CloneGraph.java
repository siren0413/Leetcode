package question;

import beans.UndirectedGraphNode;

import java.util.*;

/**
 * Created by siren0413 on 1/5/14.
 */
public class CloneGraph {

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null)
            return null;
        Set<UndirectedGraphNode> set = new HashSet<>();
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        UndirectedGraphNode root = null;
        while(!queue.isEmpty()){
            UndirectedGraphNode oldNode = queue.poll();
            UndirectedGraphNode clonedNode = null;
            if(set.contains(oldNode))
                continue;
            set.add(oldNode);
            if(map.containsKey(oldNode)){
                clonedNode = map.get(oldNode);
            }else{
                clonedNode = new UndirectedGraphNode(oldNode.label);
                map.put(oldNode,clonedNode);
            }
            if(root == null)
                root = clonedNode;

            for(UndirectedGraphNode n: oldNode.neighbors){
                queue.add(n);
                if(map.containsKey(n)){
                    clonedNode.neighbors.add(map.get(n));
                }else{
                    UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
                    clonedNode.neighbors.add(newNode);
                    map.put(n,newNode);
                }
            }
        }
        return root;
    }



    public static void main(String[] args){
        UndirectedGraphNode n1 = new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = new UndirectedGraphNode(2);
        UndirectedGraphNode n3 = new UndirectedGraphNode(3);
        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n1);
        n3.neighbors.add(n2);

        UndirectedGraphNode node = cloneGraph(n1);
        System.out.println(node.label);
        System.out.println(node.neighbors);


    }





}
