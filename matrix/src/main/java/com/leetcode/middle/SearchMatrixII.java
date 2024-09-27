package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 17:28
 * @Description: 240. 搜索二维矩阵II
 */
public class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {

        int length = matrix.length;
        int height = matrix[0].length;

        int x = 0;
        int y = height - 1;

        while (x < length && y >= 0) {

            if (matrix[x][y] == target) {
                return true;
            }

            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }

        return false;
    }
}
