package com.weibo.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/23 19:29
 */
public class M2 {
    class RTModel {
        int id;
        List<String> rtImport = new ArrayList<>();
        List<String> rtExport = new ArrayList<>();
    }

    public static List<List<String>> rt(List<RTModel> rtModelList) {
        List<List<String>> result = new ArrayList<>();

        //
        for (int i = rtModelList.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                ArrayList<String> strings = new ArrayList<>();
                if (connect(rtModelList.get(i), rtModelList.get(j))) {
                    strings.add(String.valueOf(rtModelList.get(i).id));
                    strings.add(String.valueOf(rtModelList.get(j).id));
                    result.add(strings);
                }
            }
        }
        return result;
    }

    public static boolean connect(RTModel r1, RTModel r2) {
        boolean iFlag = false;
        boolean eFlag = false;
        for (String s : r1.rtImport) {
            if (r2.rtExport.contains(s)) {
                iFlag = true;
                break;
            }
        }
        for (String s : r1.rtExport) {
            if (r2.rtImport.contains(s)) {
                eFlag = true;
                break;
            }
        }
        return iFlag && eFlag;
    }

    public static void main(String[] args) {
    }
}
