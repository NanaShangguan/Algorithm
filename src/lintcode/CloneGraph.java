package lintcode;

import java.util.*;

/**
 * Created by t-nashan on 9/1/2016.
 */
public class CloneGraph {
    static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();
            ArrayList<UndirectedGraphNode> neighbors = top.neighbors;
            for (UndirectedGraphNode n : neighbors) {
                if (!map.containsKey(n)) {
                    queue.add(n);
                    map.put(n, new UndirectedGraphNode(n.label));
                }
            }
        }
        queue.add(node);
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        visited.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();
            ArrayList<UndirectedGraphNode> neighbors = top.neighbors;
            for (UndirectedGraphNode n : neighbors) {
                map.get(top).neighbors.add(map.get(n));
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
        return map.get(node);
    }
}
