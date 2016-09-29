package leetcode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by t-nashan on 9/27/2016.
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        int len = values.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(equations[i][0])) {
                map.put(equations[i][0], new HashMap<String, Double>());
            }
            map.get(equations[i][0]).put(equations[i][1], values[i]);
            if (!map.containsKey(equations[i][1])) {
                map.put(equations[i][1], new HashMap<String, Double>());
            }
            map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
        }

        len = queries.length;
        double[] answers = new double[len];
        for (int i = 0; i < len; i++) {
            String a = queries[i][0], b = queries[i][1];
            answers[i] = -1.0;
            if (map.containsKey(a)) {
                HashMap<String, Double> res = map.get(a);
                if (res.containsKey(b)) answers[i] = res.get(b);
                else {
                    Iterator<String> it = res.keySet().iterator();
                    while (it.hasNext()) {
                        String c = it.next();
                        if (map.containsKey(c) && map.get(c).containsKey(b)) {
                            answers[i] = res.get(c) * map.get(c).get(b);
                            break;
                        }
                    }
                }
            }
        }
        return answers;
    }
}
