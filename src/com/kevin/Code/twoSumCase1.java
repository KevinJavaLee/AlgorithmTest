package com.kevin.Code;

import java.util.HashMap;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-05-7:55
 */

/*两数之和*/


public class twoSumCase1 {

    public static void main(String[] args) {

        int []arr = new int[]{1,23,4,5,6,7};
        int []index = twoSumHash(arr,9);
        System.out.println(index);
        for (int i : index) {
            System.out.println(i);
        }
    }
    public static int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        for(int i = 0; i < len;i++)
        {
            for(int j = i + 1;j<len;j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{};

    }

    /*方法二：采用hashMap()解决 以空间换时间*/

    public static int[] twoSumHash(int nums[], int target) {

        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();

        /*1.先遍历数组中所有的元素*/
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            /*target - nums[i]*/
            /*2.判断是否包含在hash数组中*/

            int result = target - nums[i];
            /*3.判断hash数组中是否有这个值*/
            if (integerIntegerHashMap.containsKey(result)) {
                return new int[]{integerIntegerHashMap.get(result),i};
            }
            else {
                integerIntegerHashMap.put(nums[i],i);
            }
        }

        return new int[]{};

    }
}
