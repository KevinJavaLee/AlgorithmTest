package com.kevin.Code.Array;

/**
 * @author Vinlee Xiao
 * @Classname isStraight
 * @Description 剑指 Offer 61. 扑克牌中的顺子 中等难度 可以再做
 * @Date 2021/9/14 20:48
 * @Version 1.0
 */
public class isStraight {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 12, 0, 3};
        quickSort(arr, 0, arr.length - 1);
//        for (int i : arr) {
//            System.out.println(i);
//        }
        boolean b = isStraight(arr);
        System.out.println(b);

    }

    /**
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {

        int len = nums.length;
        //先对数组进行排序
        quickSort(nums, 0, len - 1);

        int countZero = 0;


        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                countZero++;
            }

            if (nums[i] != 0) {
                break;
            }
        }

        //把不符合情况都算出来
        for (int i = countZero; i < len - 1; i++) {
            System.out.println(i);
            int diff = nums[i + 1] - nums[i];

            if (diff > countZero + 1) {
                return false;
            }


        }

        return true;
    }


    /**
     * 对数组进行排序
     *
     * @param nums
     */
    public static void quickSort(int nums[], int l, int h) {

        if (l >= h) {
            return;
        }

        int low = l;
        int high = h;

        int num = nums[low];

        while (low < high) {

            while (low < high && nums[high] >= num) {

                high--;
            }

            while (low < high && nums[low] <= num) {

                low++;
            }

            if (low < high) {
                int tmp = nums[high];
                nums[high] = nums[low];
                nums[low] = tmp;
            }

        }

        nums[l] = nums[high];
        nums[high] = num;

        quickSort(nums, l, high - 1);
        quickSort(nums, high + 1, h);
    }
}
