package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 16:12
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {

        ArrayList<Integer> res = new ArrayList<>();

        if (matrix.length == 0) {
            return res;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        boolean[][] visited = new boolean[rows][columns];

        // 右 下 左 上 螺旋的方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int total = rows * columns;

        int row = 0;
        int column = 0;
        int direction = 0;

        for (int i = 0; i < total; i++) {
            res.add(matrix[row][column]);
            visited[row][column] = true;

            int nextRow = row + directions[direction][0];
            int nextColumn = column + directions[direction][1];

            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                direction = (direction + 1) % 4;
            }

            // 下一个位置
            row += directions[direction][0];
            column += directions[direction][1];

        }

        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> list = spiralOrder.spiralOrder(matrix);
        System.out.println(list);
    }
}
