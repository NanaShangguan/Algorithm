package util;

import java.util.ArrayList;

/**
 * Created by t-nashan on 8/31/2016.
 */
public class DirectedGraphNode {
    int label;
    public ArrayList<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    @Override
    public String toString() {
        return Integer.toString(label);
    }
}
