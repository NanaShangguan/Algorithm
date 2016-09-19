package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by t-nashan on 9/18/2016.
 */
public class Evaluation {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("C-large.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("C-large.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            String[] statement = new String[n];
            for(int j = 0; j < n; j++){
                statement[j] = in.next();
            }
            List[] graph = new List[n];
            HashMap<String,Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                graph[j] = new ArrayList<Integer>();
                String[] split = statement[j].split("=");
                map.put(split[0],j);
            }
            boolean isContinue = true;
            for(int j = 0; j < n && isContinue; j++){
                String right = statement[j].split("=")[1];
                int start = right.indexOf('(');
                int end = right.indexOf(')');
                right = right.substring(start + 1,end);
                String[] params = right.split(",");
                for(int p = 0; p < params.length && isContinue; p++){
                    if(params[p].equals("")) continue;
                    if(map.containsKey(params[p])){
                        int index = map.get(params[p]);
                        if(index == j) {
                            out.println("Case #" + i + ": BAD");
                            isContinue = false;
                        }else{
                            graph[j].add(index);
                        }
                    }else{
                        out.println("Case #" + i + ": BAD");
                        isContinue = false;
                    }
                }
            }
            if (isContinue) {
                int[] visit = new int[graph.length];
                for (int j = 0; j < graph.length; j++) {
                    if (!dfs(j, graph, visit)){
                        out.println("Case #" + i + ": BAD");
                        isContinue = false;
                        break;
                    }
                }
                if (isContinue) out.println("Case #" + i + ": GOOD");
            }
        }
    }

    static boolean dfs(int start, List[] edge, int[] visit) {
        if (visit[start] == 0) {
            visit[start] = 1;
            for (int i = 0; i < edge[start].size(); i++) {
                if (!dfs((int) edge[start].get(i), edge, visit))
                    return false;
            }
            visit[start] = 2;
            return true;
        } else if (visit[start] == 1) {
            return false;
        } else {
            return true;
        }
    }
}
