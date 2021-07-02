package com.kevin.Code.SortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Project LeetCode
 * @ClassName MergeIntervals
 * @Description Leetcode56 合并区间  中等难度 Leetcode高频
 * @Author Vinlee Xiao
 * @Date 2021/04/30/11:39
 * @Version 1.0
 */
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] twoArrays = merge(intervals);
        System.out.println(twoArrays.length);

        for (int i = 0; i < twoArrays.length; i++) {
            System.out.println(twoArrays[i][0] + "----" + twoArrays[i][1]);

        }

    }

    /**
     * 首先,对数组进行排序
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {

        //对二维数组进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        //对数组进行判断
        ArrayList<int[]> mergeList = new ArrayList<int[]>();

        //若
        for (int i = 0; i < intervals.length; i++) {
            //左右边界
            int left = intervals[i][0];
            int right = intervals[i][1];

            //如果列表里面的值为0，或者列表末尾的数小于right的数，则添加进列表
            if (mergeList.size() == 0 || mergeList.get(mergeList.size() - 1)[1] < left) {

                mergeList.add(new int[]{left, right});
            } else {
                //修改
                mergeList.get(mergeList.size() - 1)[1] = Math.max(mergeList.get(mergeList.size() - 1)[1], right);
            }
        }

        //将列表转换为二维数组

        return mergeList.toArray(new int[mergeList.size()][]);
    }
}
