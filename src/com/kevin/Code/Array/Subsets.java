package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName Subsets
 * @Description Leetcode78 子集 中等难度 中频  没有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/16/15:06
 * @Version 1.0
 */
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            for (Integer e : subset) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    /**
     * 思路1:迭代实现子集
     * 思路2：递归实现子集
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> maxSize = new ArrayList<>();
        maxSize.add(new ArrayList<Integer>());

        //对nums数组进行递归
        for (int num : nums) {
            //对已有集合进行遍历
            List<ArrayList<Integer>> subLists = new ArrayList<>();
            for (List<Integer> list : maxSize) {
                //从新的集合中建立数组
                ArrayList<Integer> subList = new ArrayList<>(list);
                subList.add(num);
                subLists.add(subList);

            }
            maxSize.addAll(subLists);

        }

        return maxSize;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets1(int[] nums) {

        int len = nums.length - 1;
        List<List<Integer>> maxSize = new ArrayList<>();

        return null;
    }

}
