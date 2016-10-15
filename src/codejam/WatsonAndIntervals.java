package codejam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/8/28.
 */
public class WatsonAndIntervals {
    static class Interval implements Comparable<Interval> {
        long start, end;
        public Interval(long s, long e) {
            this.start = s; this.end = e;
        }

        @Override
        public int compareTo(Interval o) {
            return Long.compare(this.start, o.start);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("C-small-attempt0.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("C-small-attempt0.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int N = in.nextInt();
            long L1 = in.nextInt(), R1 = in.nextInt(),
                    A = in.nextInt(), B = in.nextInt(), C1= in.nextInt(), C2 = in.nextInt(), M = in.nextInt();
            Interval[] intervals = new Interval[N];
            intervals[0] = new Interval(L1, R1);
            long x = L1, y = R1;
            for (int j = 1; j < N; j++) {
                long xi = (A * x + B * y + C1) % M;
                long yi = (A * y + B * x + C2) % M;
                intervals[j] = new Interval(Math.min(xi, yi), Math.max(xi, yi));
                x = xi;
                y = yi;
            }
            Arrays.sort(intervals);

            if (N == 1) out.println("Case #" + i + ": 0");
            else {
                long max = Integer.MAX_VALUE;
                for (int p = 0; p < N; p++) {
                    int cover = 0;
                    long left = intervals[0].start, right = intervals[0].end;
                    if (p == 0) {
                        left = intervals[1].start;
                        right = intervals[1].end;
                    }
                    for (int k = 0; k < N; k++) {
                        if (k != p) {
                            if (intervals[k].start <= right) {
                                right = Math.max(intervals[k].end, right);
                            } else {
                                cover += right - left + 1;
                                left = intervals[k].start;
                                right = intervals[k].end;
                            }
                        }
                    }
                    cover += right - left + 1;
                    if (max > cover) max = cover;
                }
                out.println("Case #" + i + ": " + max);
            }

        }

    }
}
