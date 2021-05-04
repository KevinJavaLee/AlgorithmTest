package com.kevin.Code.SortArray;

/**
 * @Project LeetCode
 * @ClassName QuickSort
 * @Description 手撕快速排序 Leetcode 912. 排序数组 中等难度
 * @Author Vinlee Xiao
 * @Date 2021/04/30/11:33
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        int[] sortArr = sortArray(nums);

        for (int i = 0; i < sortArr.length; i++) {
            System.out.println(sortArr[i]);
        }
//        Arrays.toString(nums);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {

        int len = nums.length;
//        Sort(nums,0,len-1);
          quickSort(nums,0,len-1);

        return nums;
    }


    /**
     * 得到分区的数
     * @param arr
     * @param low
     * @param high
     */
    public static void Sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int tmp = arr[low];
        int i = low, j = high;

        while (i < j) {
            while ( i < j && tmp <= arr[j] ) {
                j--;
            }

            while (i < j && tmp >= arr[i]) {
                i++;
            }

            //交换两个数
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //最后将基准数和j交换
        arr[low] = arr[j];
        arr[j] = tmp;

        Sort(arr,low,j-1);
        Sort(arr,j+1,high);
    }


    /**
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int getPartition(int[] arr, int low, int high) {

        int i = low, j = high;

        int tmp = arr[low];

        while (i < j) {

            while (i < j && tmp <= arr[j]) {
                j--;
            }

            while (i < j && tmp >= arr[i]) {
                i++;
            }

            while (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        //对基准数据进行排序
        arr[low] = arr[j];
        arr[j] = tmp;

        return j;
    }

    /**
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int base = getPartition(arr, low, high);
        quickSort(arr, low, base - 1);
        quickSort(arr, base + 1, high);
    }

}
