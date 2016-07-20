package leetcode;

import java.util.*;

/**
 * Created by Nano on 2016/7/20.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String hashKey = sortString(str);
            if (map.containsKey(hashKey)) map.get(hashKey).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(hashKey, list);
            }
        }
        List<String> res = new ArrayList<>();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            List<String> list = map.get(it.next());
            if (list.size() > 1) res.addAll(list);
        }
        return res;
    }
    public String hash(String s) {
        return countLetters(s);
    }

    public String countLetters(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (letters[i] > 0) {
                sb.append((char) ('a' + i));
                sb.append(letters[i]);
            }
        }
        return sb.toString();
    }

    public String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
