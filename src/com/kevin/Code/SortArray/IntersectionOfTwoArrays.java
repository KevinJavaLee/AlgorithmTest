package com.kevin.Code.SortArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * @Project LeetCode
 * @ClassName IntersectionOfTwoArrays
 * @Description Leetcode 349题两个数组的交集 简单
 * @Author Vinlee Xiao
 * @Date 2021/05/04/16:11
 * @Version 1.0
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1};
        int[] arr1 = new int[]{2, 2};
        int[] ints = intersection(arr, arr1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * Hash表来解决问题
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                set.add(nums2[i]);
            }
        }

        int[] intersectionArray = new int[set.size()];
//        int[] intArray = set.stream().mapToInt(Integer::valueOf).toArray();
        int index = 0;
        for (Integer integer : set) {
            intersectionArray[index++] = integer;
        }

        return intersectionArray;
    }

}
