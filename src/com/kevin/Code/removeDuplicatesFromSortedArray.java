package com.kevin.Code;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-10-21:23
 */
public class removeDuplicatesFromSortedArray {


    public static void main(String[] args) {

        int []arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(arr);
        System.out.println(len);
    }

    public static int removeDuplicates(int[] nums) {

        int len = nums.length;
        int cnt = 0;

        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int i = 0;

        for (int j = 1; j < len; j++) {
            if (nums[i] < nums[j]) {
                cnt++;
                i++;
                nums[i] = nums[j];
            }
        }

        return cnt + 1;
    }
}
