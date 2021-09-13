package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vinlee Xiao
 * @Classname ContinuumArray
 * @Description 剑指 Offer 57 - II. 和为s的连续正数序列 简单题  双指针的思路
 * @Date 2021/9/13 17:10
 * @Version 1.0
 */
public class ContinuumArray {
    public static void main(String[] args) {
        int[][] continuousSequence = findContinuousSequence(15);

//        System.out.println(continuousSequence.length);
        for (int[] results : continuousSequence) {
            for (int res : results) {
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }


    /**
     * 双指针的思路：left right
     *
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {

        if (target == 1) {
            return new int[][]{};
        }

        int left = 1;
        int right = 2;


        ArrayList<int[]> sumList = new ArrayList<>();

        int sum = 0;
        while (left < right && right <= target) {


            sum = (left + right) * (right - left + 1) / 2;

            if (sum == target) {
                int start = left;
                int end = right;

                int[] arr = new int[right - left + 1];

                int index = 0;
                for (int i = start; i <= end; i++) {
                    arr[index] = i;
                    index++;
                }
                sumList.add(arr);

                right++;

            } else if (sum < target) {
                right++;

            } else if (sum > target) {
                left++;
            }

        }


        return sumList.toArray(new int[sumList.size()][]);
    }


}
