package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/9/27 15:32
 * @Description: 73. 矩阵置零
 */
public class SetZero {

    public void setZeroes(int[][] matrix) {
        int length = matrix.length;
        int height = matrix[0].length;
        List<Integer> iList = new ArrayList<>();
        List<Integer> jList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (matrix[i][j] == 0) {
                    iList.add(i);
                    jList.add(j);
                }
            }
        }

        for (int i = 0; i < iList.size(); i++) {
            action(matrix, iList.get(i), jList.get(i));
        }
    }

    public void action(int[][] matrix, int i0, int j0) {
        int length = matrix.length;
        int height = matrix[0].length;

        for (int j = 0; j < height; j++) {
            matrix[i0][j] = 0;
        }

        for (int i = 0; i < length; i++) {
            matrix[i][j0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        SetZero setZero = new SetZero();
        setZero.setZeroes(matrix);
    }
}
