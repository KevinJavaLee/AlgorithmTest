package com.kevin.Code;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-10-21:46
 */
public class removeElement {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,3};
        int i = removeElement(arr, 3);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {


        int len = nums.length;

        int i = 0;
        for (int j = 0; j < len ; j++) {

            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }



        return i;
    }
}
