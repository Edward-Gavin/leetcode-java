package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/10 19:12
 * @Description: 48. 旋转图像
 */
public class RotateMatrix {
    public int[][] rotate(int[][] matrix) {

        int length = matrix.length;

        int[][] res = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                res[j][length - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = res[i][j];
            }
        }
        return res;
    }

    public int[][] rotateV2(int[][] matrix) {
        int length = matrix.length;

        // 水平翻转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = temp;
            }
        }

        // 对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp =  matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;

    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] rotate = new RotateMatrix().rotateV2(matrix);
        System.out.println(rotate);
    }
}

