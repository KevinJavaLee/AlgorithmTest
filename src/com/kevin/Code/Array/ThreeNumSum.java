package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @Project LeetCode
 * @ClassName ThreeNumSum
 * @Description Leetcode 15 三数之和 中等难度 高频题 无思路
 * @Author Vinlee Xiao
 * @Date 2021/05/12/20:56
 * @Version 1.0
 */
public class ThreeNumSum {
    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list.size());
        for (List<Integer> integers : list) {

            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }

    /**
     * 三数之和
     * 1.先排序
     * 2.双指针 避免产生重复
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length < 3) {
            return result;
        }
        int len = nums.length - 1;
        //1.先对数组进行排序 快速排序
//        QuickSort(nums, 0, len);
        Arrays.sort(nums);
        //利用双指针法来对数据进行处理
        for (int i = 0; i <= len; i++) {

            //从第二数开始与前一个数相比较
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            //如果第二重循坏开始的数与前一个数相同则跳过循环
            int third = len;

            for (int k = i + 1; k <= len; k++) {
                int target = -nums[i];
                if (k > i+1 && nums[k] == nums[k - 1]) {
                    continue;
                }

                //始终保持第二个指针在第一个指针的右边
                while (k < third && nums[third] + nums[k] > target) {
                    third--;
                }
                //如果第k==third相同则跳出
                if (k == third) {
                    break;
                }
                //target为第一重循环的数 third为第三重循环的数  k 为第二重
                if (nums[third] + nums[k] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[k]);
                    list.add(nums[third]);
                    result.add(list);
                }

            }
        }


        return result;

    }


    /**
     * 快速排序
     */
    public static void QuickSort(int[] nums, int low, int high) {

        if (high <= low) {
            return;
        }

        int tmp = nums[low];
        int i = low, j = high;
        while (i < j) {

            while ( i < j && nums[j] >= tmp) {
                j--;
            }

            while ( i < j && nums[i] <= tmp) {
                i++;
            }

            //交换一个数
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }
        nums[low] = nums[j];
        nums[j] = tmp;

        QuickSort(nums, low, j - 1);
        QuickSort(nums, j + 1, high);
    }
}
