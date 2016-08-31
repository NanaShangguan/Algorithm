package lintcode;

import java.util.HashMap;
import java.util.Set;

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
        dict.add(start); dict.add(end);
        int len = dict.size();
        HashMap<String, Integer> map = new HashMap<>(len);
        String[] arr = (String[]) dict.toArray();
        for (int i = 0; i < len; i++) map.put(arr[i], i);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ()
            }
        }
    }

    private boolean isE
}
