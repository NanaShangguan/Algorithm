package codejam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/8/28.
 */
public class SherlockAndParentheses {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("A-large.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("A-large.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int l = in.nextInt(), r = in.nextInt();
            long min = Math.min(l, r);
            out.println("Case #" + i + ": " + (min + 1) * min / 2);
        }
    }
}
