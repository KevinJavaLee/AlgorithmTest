package com.kevin.Code.SortArray;

import java.util.Arrays;

/**
 * @Project LeetCode
 * @ClassName HeapSort
 * @Description 手撕堆排序 Leetcode 912 排序数组 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/04/30/11:34
 * @Version 1.0
 */
public class HeapSort {
    public static void main(String[] args) {
        int []arr = {7,6,7,11,5,12,3,0,1};
        System.out.println("排序前："+ Arrays.toString(arr));
        int[] sortArray = sortArray(arr);
        System.out.println(Arrays.toString(sortArray));


    }

    /**
     *
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {

        int len = nums.length;

        //创建大根堆
        //从第一个非叶子节点开始，从左到右，从下到上调整
        for (int i = len / 2 - 1; i >=0; i--) {
            adjustHeap(nums,i,len);
        }

        for (int i = len-1; i > 0 ; i--) {
            swap(nums,0,i);
            adjustHeap(nums,0, i);
        }

        return nums;
    }

    /**
     *
     * @param arr
     * @param i
     * @param len
     */
    public static void adjustHeap(int[] arr, int i, int len) {

        //记录临时节点
        int temp = arr[i];

        //进行堆调整
        for (int k = 2 * i + 1; k < len; k = k * 2 + 1) {

            //如果兄弟节点更大则指向兄弟节点
            if (k < len-1 && arr[k] < arr[k+1]) {
                k++;
            }

            //如果子节点大于父节点，则将子节点赋值给父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }

    /**
     * @Desciption 交换两个数
     * @param arr
     * @param num1
     * @param num2
     */
    public static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
}
