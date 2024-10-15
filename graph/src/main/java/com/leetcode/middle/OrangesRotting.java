package com.leetcode.middle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shiwei10
 * @Date: 2024/10/14 19:31
 * @Description: 994. 腐烂的橘子
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        // 腐烂的橘子
        Queue<int[]> queue = new LinkedList<>();

        // 新鲜的橘子个数
        int count = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];

                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count --;
                    queue.add(new int[]{r - 1, c});
                }

                if (r + 1 < M && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[]{r + 1, c});
                }

                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    queue.add(new int[]{r, c - 1});
                }

                if (c + 1 < N && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }

        return count > 0 ? -1 : round;
    }
}
