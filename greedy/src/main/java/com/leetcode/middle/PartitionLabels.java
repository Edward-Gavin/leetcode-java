package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/10/11 13:13
 * @Description: 763. 划分字母区间
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int length = s.length();
        int[] last = new int[26];

        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> list = partitionLabels.partitionLabels(s);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
