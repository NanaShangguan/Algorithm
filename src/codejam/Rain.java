package codejam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by nana_ on 2016/7/10.
 */
public class Rain {
    static class Cell implements Comparable<Cell> {
        int height;
        int row, col;
        public Cell(int height, int row, int col) {
            this.height = height;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.height, o.height);
        }
    }
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("B-large-practice.in");
        System.setIn(fis);
        PrintStream ps = new PrintStream(new FileOutputStream("B-large-practice.out"));
        System.setOut(ps);

        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

        int t = in.nextInt();
        for (int k = 1; k <= t; k++) {
            int r = in.nextInt(), c = in.nextInt();
            int[][] matrix = new int[r][c];
            boolean[][] visited = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            int sum = 0;
            PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
            int total = r * c - 4;
            visited[0][0] = true; visited[0][c - 1] = true;
            visited[r - 1][0] = true; visited[r - 1][c - 1] = true;
            for (int i = 1; i < c - 1; i++) {
                queue.add(new Cell(matrix[0][i], 0, i));
                queue.add(new Cell(matrix[r - 1][i], r - 1, i));
                visited[0][i] = true; visited[r - 1][i] = true;
            }
            total -= 2 * (c - 2);
            for (int i = 1; i < r - 1; i++) {
                queue.add(new Cell(matrix[i][0], i, 0));
                queue.add(new Cell(matrix[i][c - 1], i, c - 1));
                visited[i][0] = true; visited[i][c - 1] = true;
            }
            total -= 2 * (r - 2);
            while (total > 0) {
                Cell min = queue.poll();
                int row = min.row, col = min.col;
                int[] rowIndex = { row - 1, row + 1, row, row };
                int[] colIndex = { col, col, col - 1, col + 1 };
                for (int i = 0; i < 4; i++) {
                    if (rowIndex[i] > -1 && rowIndex[i] < r
                            && colIndex[i] > -1 && colIndex[i] < c
                            && !visited[rowIndex[i]][colIndex[i]]) {
                        if (matrix[rowIndex[i]][colIndex[i]] < min.height) {
                            sum += min.height - matrix[rowIndex[i]][colIndex[i]];
                            matrix[rowIndex[i]][colIndex[i]] = min.height;
                        }
                        queue.add(new Cell(matrix[rowIndex[i]][colIndex[i]], rowIndex[i], colIndex[i]));
                        visited[rowIndex[i]][colIndex[i]] = true;
                        total -= 1;
                    }
                }
            }

            out.format("Case #%d: %d\n", k, sum);
        }
    }
}
