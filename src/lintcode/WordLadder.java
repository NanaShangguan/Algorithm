package lintcode;

import codejam.Graph;
import util.DirectedGraphNode;

import java.util.*;

/**
 * Created by t-nashan on 8/31/2016.
 */
public class WordLadder {
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) return 1;
        dict.add(start); dict.add(end);
        int len = dict.size();
        HashMap<String, Integer> map = new HashMap<>(len);
        Iterator<String> iterator = dict.iterator();
        String[] arr = new String[len];
        for (int i = 0; iterator.hasNext(); i++) arr[i] = iterator.next();
        for (int i = 0; i < len; i++) map.put(arr[i], i);
        Graph graph = new Graph(len);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected(arr[i], arr[j])) graph.addEdge(i, j);
            }
        }
        //construct graph complete
        //bfs
        int s = map.get(start), e = map.get(end);
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        int path = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                visited[top] = true;
                Iterator<Integer> it = graph.adj(top).iterator();
                while (it.hasNext()) {
                    int next = it.next();
                    if (next == e) return path;
                    if (!visited[next]) queue.add(next);
                }
            }
            path++;
        }
        return 0;
    }

    private boolean isConnected(String s1, String s2) {
        int diffCount = 0;
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) diffCount++;
            if (diffCount > 1) return false;
        }
        return diffCount == 1;
    }
    public static void main(String[] args) {
        String start = "a", end = "c";
        Set<String> set = new HashSet<>();
        set.add("a"); set.add("b"); set.add("c");
        System.out.println(new WordLadder().ladderLength(start, end, set));
    }
}
