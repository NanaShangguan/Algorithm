package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Nano on 2016/6/14.
 */
public class BadHorse {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("A-small-practice-2.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("A-small-practice-2.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            //input
            int m = in.nextInt();
            Graph graph = new Graph(2 * m);
            int index = 0;
            HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
            //construct graph
            while (m > 0) {
                m--;
                String first = in.next(), last = in.next();
                int firstIndex, lastIndex;
                //transform name to index
                if (indexMap.containsKey(first)) firstIndex = indexMap.get(first);
                else {
                    firstIndex = index++;
                    indexMap.put(first, firstIndex);
                }
                if (indexMap.containsKey(last)) lastIndex = indexMap.get(last);
                else {
                    lastIndex = index++;
                    indexMap.put(last, lastIndex);
                }
                //add edge
                graph.addEdge(firstIndex, lastIndex);
            }

            //two color
            TwoColor twoColor = new TwoColor(graph);
            out.format("Case #%d: %s\n", i + 1, twoColor.isBipartite() ? "Yes" : "No");
        }
    }
}
