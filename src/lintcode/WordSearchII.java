package lintcode;

import java.util.*;

/**
 * Created by t-nashan on 9/5/2016.
 */
public class WordSearchII {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, List<String> words) {
        ArrayList<String> list = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();
        for (String word : words) {
            if (!visited.contains(word)) {
                visited.add(word);
                if (isContain(board, word)) {
                    list.add(word);
                }
            }
        }
        return list;
    }

    boolean isContain(char[][] board, String word) {
        int row = board.length;
        if (row == 0) return word.equals("");
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isContainFrom(board, row, col, i, j, word, 0, visited)) return true;
            }
        }

        return false;
    }

    boolean isContainFrom(char[][] board, int row, int col, int rowIndex, int colIndex,
                          String word, int index, boolean[][] visited) {
        if (index >= word.length()) return true;
        if (rowIndex >= row || colIndex >= col || rowIndex < 0 || colIndex < 0) return false;

        if (visited[rowIndex][colIndex]) return false;
        if (board[rowIndex][colIndex] == word.charAt(index)) {
            visited[rowIndex][colIndex] = true;
            boolean flag = false;
            if (isContainFrom(board, row, col, rowIndex - 1, colIndex, word, index + 1, visited)
                    || isContainFrom(board, row, col, rowIndex + 1, colIndex, word, index + 1, visited)
                    || isContainFrom(board, row, col, rowIndex, colIndex - 1, word, index + 1, visited)
                    || isContainFrom(board, row, col, rowIndex, colIndex + 1, word, index + 1, visited))
                flag = true;
            visited[rowIndex][colIndex] = false;
            return flag;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                "doaf".toCharArray(),
                "agai".toCharArray(),
                "dcan".toCharArray()
        };
        List<String> words = Arrays.asList(new String[]{"dog", "dad", "dgdg", "can", "again"});
        System.out.println(new WordSearchII().wordSearchII(board, words));
    }
}
