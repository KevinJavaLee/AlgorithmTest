package com.kevin.Code.SortArray;

import java.util.Arrays;

/**
 * @Project LeetCode
 * @ClassName MergeSort
 * @Description 手撕归并排序 Leetcode 912 排序数组 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/04/30/11:35
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int []arr = {7,6,7,11,5,12,3,0,1};
        System.out.println("排序前："+ Arrays.toString(arr));
        int[] sortArray = sortArray(arr);
        System.out.println(Arrays.toString(sortArray));
    }


    /**
     * 手撕归并排序
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums){

        MergeSort(nums, 0, nums.length-1);

        return nums;
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void MergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSort(arr, low, mid);
            MergeSort(arr, mid + 1, high);
            Merge(arr, low, mid, high);
        }
    }

    /**
     * 将两个有序数组合并
     * @param arr
     * @param low
     * @param mid
     * @param high
     *
     */
    public static void Merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0;
//        System.out.println("Low:" + low);
//        System.out.println("mid:" + mid);
//        System.out.println("high:" + high);
        //将两个有序序列合并成一个
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tmp[index] = arr[i++];

            } else {
                tmp[index] = arr[j++];

            }
            index++;
        }


        //将两个有序数组中还未添加的元素添加进临时数组中
        while (i <= mid) {
//            tmp[i++] = arr[i++];
//            System.out.println("len:" + (high - low + 1));
//            System.out.println("Index:" + index);
            tmp[index] = arr[i++];
            index++;
        }

        while (j <= high) {
            tmp[index++] = arr[j++];

        }

        //再将临时数组中的数赋值给原来的数组
        for (int k = 0; k < index; k++) {
            //
            arr[low+k] = tmp[k];
        }
    }
}
