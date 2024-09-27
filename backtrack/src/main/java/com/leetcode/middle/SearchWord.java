package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 14:36
 * @Description: 79. 单词搜索
 */
public class SearchWord {


    // 访问标记
    boolean[][] visited;

    // 移动方向
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public boolean exist(char[][] board, String word) {
        int length = board.length;
        int height = board[0].length;
        visited = new boolean[length][height];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                boolean b = backTrack(board, i, j, word, 0);
                if (b) {
                    return true;
                }
            }
        }

        return false;
    }


    public boolean backTrack(char[][] board, int i, int j, String s, int k) {

        int length = board.length;
        int height = board[0].length;

        boolean result = false;

        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if (newI >= 0 && newI < length && newJ >= 0 && newJ < height) {
                if (!visited[newI][newJ]) {
                    boolean flag = backTrack(board, newI, newJ, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }

        // 回溯
        visited[i][j] = false;
        return result;
    }
}
