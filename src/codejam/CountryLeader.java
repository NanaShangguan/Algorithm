package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/7/10.
 */
public class CountryLeader {
    static int countLetter(String name) {
        boolean[] letters = new boolean[26];
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != ' ') {
                int index = name.charAt(i) - 'A';
                if (!letters[index]) {
                    count++;
                    letters[index] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("A-large.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("A-large.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            in.nextLine();
            String leader = null;
            int count = 0;
            while (n > 0) {
                n--;
                String name = in.nextLine();
                if(leader == null) {
                    leader = name;
                    count = countLetter(name);
                    continue;
                }
                int c = countLetter(name);
                if (c > count) {
                    leader = name;
                    count = c;
                } else if (c == count) {
                    leader = leader.compareTo(name) < 0 ? leader : name;
                }
            }
            out.format("Case #%d: %s\n", i, leader);
        }
    }
}
