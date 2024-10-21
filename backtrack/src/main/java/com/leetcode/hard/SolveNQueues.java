package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/10/21 19:20
 */
public class SolveNQueues {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }

        dfs(n, 0, chessboard);

        return res;
    }

    private void dfs(int n, int row, char[][] chessboard) {

        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : chessboard) {
                list.add(String.copyValueOf(chars));
            }
            res.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                dfs(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }


    private boolean isValid(int row, int col, int n, char[][] chessboard) {

        //
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
