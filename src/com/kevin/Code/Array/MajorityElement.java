package com.kevin.Code.Array;

import java.util.HashMap;

/**
 * @Project LeetCode
 * @ClassName MajorityElement
 * @Description Leetcode 169 多数元素 简单 高频 有思路 剑指Offer39
 * @Author Vinlee Xiao
 * @Date 2021/05/15/11:39
 * @Version 1.0
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int i = majorityElement1(nums);
        System.out.println(i);
    }

    /**
     * 思路1：堆排序+
     * 思路2：hash算法 时间复杂度n,空间复杂度n
     * 思路3：随机操作
     * @param nums
     * @return
     */
    public  static int majorityElement(int[] nums) {

        int len = nums.length;
        int cnt = len / 2;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int count = hashMap.getOrDefault(nums[i], 0);
            hashMap.put(nums[i], count + 1);
            if (count + 1 > cnt) {

                return nums[i];
            }
        }

        return 0;
    }

    /**
     * 根据快速分区的思想进行处理：
     * 时间复杂度O(logN)
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int middle = len / 2;
        int start = 0;
        int end = len - 1;

        int index = getPartition(nums, start, end);

        while (index != middle) {


            //如果当前的快速排序的分区index大于k-1，则应该将end减1
            if (start < end && index > middle) {

                end = index - 1;
                index = getPartition(nums, start, end);
            } else {
                if (start < end) {
                    start = index + 1;
                    index = getPartition(nums, start, end);
                }


            }

        }

        return nums[middle];
    }


    /**
     * 根据数据的特点进行处理
     * <p>
     * [1, 2, 3, 2, 2, 2, 5, 4, 2]
     *
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {

        int len = nums.length;
//        int cnt = 0;


        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < len; i++) {

            if (cnt == 0) {
                res = nums[i];
                cnt++;
            } else if (res == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        return res;
    }


    /**
     * 用于实现快速排序返回分区下标
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int getPartition(int[] arr, int start, int end) {

        int num = arr[start];

        int low = start;
        int high = end;
//        System.out.println(low);
//        System.out.println(high);

        while (low < high) {

            //当arr[high]大于num时下标递减
            while (low < high && arr[high] >= num) {

                high--;
            }

            while (low < high && arr[low] <= num) {
                low++;
            }

            //进行两个数的交换
            if (low < high) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }

        }

        //交换基数


        arr[start] = arr[high];
        arr[high] = num;


        return high;
    }
}
