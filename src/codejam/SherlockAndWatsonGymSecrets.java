package codejam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/8/28.
 */
public class SherlockAndWatsonGymSecrets {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("B-small-attempt0.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("B-small-attempt0.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int A = in.nextInt(), B = in.nextInt(), N = in.nextInt(), K = in.nextInt();
            int count = 0;
            for (int p = 1; p <= N; p++) {
                for (int q = 1; q <= N; q++) {
                    if (p != q) {
                        int a = get(p, A, K);
                        int b = get(q, B, K);
                        if ((a + b) % K == 0) count = (count + 1) % 1000000007;
                    }
                }
            }
            out.println("Case #" + i + ": " + count);
        }
    }

    public static int get(int a, int b, int c) {
        int ans = 1; //a的b次方余c的快速幂取余法
        a = a % c;
        while(b>0)
        {
            if(b%2==1)
                ans = (ans * a) % c;
            b = b/2;
            a = (a*a) % c;
        }
        return ans;
    }
}
