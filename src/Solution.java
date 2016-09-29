import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Nano on 2016/9/29.
 */
public class Solution {
    static String[] paginate(int num, String[] results) {
        int len = results.length;
        boolean[] visited = new boolean[len];
        int numOfPage = len / num;
        String[] res = new String[numOfPage + len];
        int index = 0;
        for (int i = 0; i <= numOfPage; i++) {
            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < len && set.size() < num; j++) {
                String hostId = getHostId(results[j]);
                if (!visited[j] && !set.contains(hostId)) {
                    visited[j] = true;
                    set.add(hostId);
                    res[index++] = results[j];
                }
            }
            if (set.size() == num && i != numOfPage) {
                res[index++] = "";
            } else {
                int size = set.size();
                for (int j = 0; j < len && size < num; j++)
                    if (!visited[j]) {
                        visited[j] = true;
                        res[index++] = results[j];
                        size++;
                    }
                if (i != numOfPage) res[index++] = "";
            }
        }
        return res;
    }

    static String getHostId(String entry) {
        int index = entry.indexOf(",");
        return entry.substring(0, index);
    }

    public static void main(String[] args) {
        String[] results = {
                "131,28,300.6,San Francisco",
                "4,5,209.1,San Francisco",
                "20,7,203.4,Oakland",
                "6,8,202.9,San Francisco",
                "6,10,199.8,San Francisco",
                "1,16,190.5,San Francisco",
                "6,29,185.3,San Francisco",
                "7,20,180.0,Oakland",
                "6,21,162.2,San Francisco",
                "2,18,161.7,San Jose",
                "2,30,149.8,San Jose",
                "3,76,146.7,San Francisco",
                "2,14,141.8,San Jose"
        };
        System.out.println(Arrays.toString(paginate(5, results)));
    }
}
