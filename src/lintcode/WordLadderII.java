package lintcode;

import codejam.Graph;
import util.DirectedGraphNode;

import java.util.*;

/**
 * Created by t-nashan on 9/1/2016.
 */
public class WordLadderII {
    static class ReverseDirectionNode {
        int node;
        List<ReverseDirectionNode> parent;
        public ReverseDirectionNode(int node) {
            this.node = node;
            parent = new ArrayList<ReverseDirectionNode>();
        }
    }
    /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> lists = new ArrayList<List<String>>();
        if (start.equals(end)) return lists;
        dict.add(start); dict.add(end);
        int len = dict.size();
        HashMap<String, Integer> map = new HashMap<>(len);
        HashMap<Integer, String> reverseMap = new HashMap<>(len);
        Iterator<String> iterator = dict.iterator();
        String[] arr = new String[len];
        for (int i = 0; iterator.hasNext(); i++) arr[i] = iterator.next();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
            reverseMap.put(i, arr[i]);
        }
        Graph graph = new Graph(len);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected(arr[i], arr[j])) graph.addEdge(i, j);
            }
        }
        HashMap<Integer, ReverseDirectionNode> map1 = new HashMap<Integer, ReverseDirectionNode>();
        int s = map.get(start), e = map.get(end);
        int[] visited = new int[len];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        map1.put(s, new ReverseDirectionNode(s));
        map1.get(s).parent.add(new ReverseDirectionNode(s));
        int path = 1;
        visited[s] = path;
        boolean isContinue = true;
        while (!queue.isEmpty() && isContinue) {
            path++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.poll();
                Iterator<Integer> it = graph.adj(top).iterator();
                while (it.hasNext()) {
                    int adj = it.next();
                    if (adj == e) isContinue = false;
                    if (visited[adj] == 0) {
                        visited[adj] = path;
                        queue.add(adj);
                    }
                    if (!map1.containsKey(adj)) {
                        map1.put(adj, new ReverseDirectionNode(adj));
                        map1.get(adj).parent.add(map1.get(top));
                    }
                    else if ((path - 1) == visited[map1.get(adj).parent.get(0).node]) map1.get(adj).parent.add(map1.get(top));
                }
            }
        }

        if (map1.containsKey(e)) {
            int[] recorder = new int[path];
            dfs(map1.get(e), recorder, 0, reverseMap, lists);
        }
        return lists;

    }

    void dfs(ReverseDirectionNode node, int[] recorder, int index, HashMap<Integer, String> map,
             List<List<String>> lists) {
        if (index >= recorder.length) {
            List<String> list = new ArrayList<String>();
            for (int i = recorder.length - 1; i > -1; i--) list.add(map.get(recorder[i]));
            lists.add(list);
            return;
        }
        List<ReverseDirectionNode> parent = node.parent;
        recorder[index] = node.node;
        for (ReverseDirectionNode p : parent) {
            dfs(p, recorder, index + 1, map, lists);
        }
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
//        String start = "hit", end = "cog";
//        Set<String> set = new HashSet<>();
//        set.add("hot"); set.add("dot"); set.add("dog");set.add("lot"); set.add("log");
        String start = "hot", end = "dog";
        Set<String> set = new HashSet<>();
        set.add("hot"); set.add("dog");
        System.out.println(new WordLadderII().findLadders(start, end, set));
    }
}
