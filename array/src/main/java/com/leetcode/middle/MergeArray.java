package com.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-10-07 18:01
 * @description: 56. 合并区间
 */
public class MergeArray {
    public int[][] merge(int[][] intervals){

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

    public int[][] mergeV2(int[][] intervals) {

        // 按照区间的起始位置排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            int head = interval[0];
            int tail = interval[1];
            int size = res.size();

            // 不是开头 并且新区间的开头比上个区间的结尾小，合并区间
            if (size > 0 && head <= res.get(size - 1)[1]) {
                int[] ints = res.get(size - 1);
                res.get(size - 1)[1] = Math.max(tail, ints[1]);
            } else {
                // 最开始的区间
                res.add(interval);
            }

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new MergeArray().merge(intervals);
        for(int[] i : merge){
            System.out.println(Arrays.toString(i));
        }
    }
}
