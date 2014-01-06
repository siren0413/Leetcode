package beans;

import java.util.ArrayList;

/**
 * Created by siren0413 on 1/5/14.
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
