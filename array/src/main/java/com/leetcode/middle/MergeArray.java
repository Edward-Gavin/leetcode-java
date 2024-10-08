package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-10-07 18:01
 */
public class MergeArray {
    public int[][] merge(int[][] intervals){

        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            int m = res.size();
            if (m > 0 && interval[0] <= res.get(m - 1)[1]) {
                res.get(m - 1)[1] = Math.max(res.get(m - 1)[1], interval[1]);
            } else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);

    }
}
