package com.kevin.Code.SortArray;

import java.util.Arrays;

/**
 * @Project LeetCode
 * @ClassName MinNumber
 * @Description 剑指 Offer 45. 把数组排成最小的数 中等难度 高频 类似Leetcode第179题
 * @Author Vinlee Xiao
 * @Date 2021/05/03/20:30
 * @Version 1.0
 */
public class MinNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,0};
        String s = minNumber1(arr);
        System.out.println(s);
    }

    /**
     * 类似于Leetcode的最大数
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {

        int len = nums.length;
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        String[] str = new String[len];
        //第一步先将整形数组转换为字符数组
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str,(s1,s2)->{
            return (s1 + "" + s2).compareTo(s2 + "" + s1);
        });

        StringBuilder builder = new StringBuilder();
        for (String s : str) {
//            if (builder.length() == 0 && s.equals("0")) {
//                continue;
//            }
            builder.append(s);
        }

        if (builder.length() == 0) {
            return "0";
        }

        return builder.toString();
    }

    /**
     * 自定义排序算法
     * @param nums
     * @return
     */
    public static String minNumber1(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return String.valueOf(nums[0]);
        }

        String[] str = new String[len];
        //第一步先将整形数组转换为字符数组
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        QuickSort(str, 0, len - 1);

        StringBuilder builder = new StringBuilder();
        for (String s : str) {
            builder.append(s);
        }

        return builder.toString();
    }


    /**
     * 对组合字符串进行快速排序
     * @param arr
     * @param low
     * @param high
     */
    public static void QuickSort(String[] arr, int low, int high) {

        if (low > high) {
            return;
        }

        int i = low, j = high;
        String tmp = arr[low];

        while (i < j) {

            while (i < j && (arr[j] + "" + tmp).compareTo(tmp + "" + arr[j]) >= 0) {
                j--;
            }

            while (i < j && (arr[i] + "" + tmp).compareTo(tmp + "" + arr[i]) <= 0) {
                i++;
            }

            if (i < j) {
                String cmp = arr[i];
                arr[i] = arr[j];
                arr[j] = cmp;
            }

        }
        arr[low] = arr[j];
        arr[j] = tmp;
        QuickSort(arr, low, j - 1);
        QuickSort(arr, j + 1, high);

    }
}
