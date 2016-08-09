package lintcode;

import java.util.Stack;

/**
 * Created by t-nashan on 8/8/2016.
 */
public class SimplifyPath {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < path.length(); ) {
            while (i < path.length() && path.charAt(i) == '/') i++;
            int end = i + 1;
            while (end < path.length() && path.charAt(end) != '/') end++;
            if (i < path.length()) {
                String part = path.substring(i, end);
                if (part.equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                }
                else if (!part.equals(".") && !part.equals("")) stack.push(part);
            }
            i = end;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/");
            sb.insert(1, stack.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
