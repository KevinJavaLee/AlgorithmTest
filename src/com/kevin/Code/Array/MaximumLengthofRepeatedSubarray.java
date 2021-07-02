package com.kevin.Code.Array;

/**
 * @Project LeetCode
 * @ClassName MaximumLengthofRepeatedSubarray
 * @Description Leetcode718 最长重复子数组 难度中等 高频 动态规划
 * @Author Vinlee Xiao
 * @Date 2021/05/14/19:57
 * @Version 1.0
 */
public class MaximumLengthofRepeatedSubarray {
    public static void main(String[] args) {

        int[] nums1 = new int[]{0,1,1,1,1};
        int[] nums2 = new int[]{1,0,1,0,1};
        int i = findLength2(nums1, nums2);
        System.out.println(i);

    }


    /**
     * 暴力法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        //
        int cnt =0;
        int result = 0;
        for (int i = 0; i < len1; i++) {

            for (int k = 0; k < len2; k++) {

                //
                while (i + cnt < len1 && k + cnt < len2 && nums1[i + cnt] == nums2[k + cnt]) {

                    cnt++;
                }
                result = Math.max(result, cnt);
                cnt=0;
            }

        }

        return result;
    }

    /**
     * 改进1：动态规划  最长子前缀
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength1(int[] nums1, int[] nums2) {
        int len1 = nums1.length ;
        int len2 = nums2.length;

        int[][] arr = new int[len1 + 1][len2 + 1];

        //arr[i][j]表示 nums1[i:] 和nums2[j:]最长子前缀长度
        int result = 0;
        for (int i = len1 - 1; i >= 0; i--) {

            for (int j = len2 - 1; j >= 0; j--) {

                if (nums1[i] == nums2[j]) {
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                } else {
                    arr[i][j] = 0;
                }
                result = Math.max(arr[i][j], result);
            }

        }

        //最大值为arr[i][j]的最大值



        return result;
    }

    /**
     * 改进2：滑动窗口  解法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength2(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        //保持A不变，B滑动
        int result = 0;
        int maxlen = 0;
        for (int i = 0; i < len1; i++) {

            int n = Math.min(len1-i, len2);
            maxlen = maxLength(nums1, nums2, i, 0, n);
            result = Math.max(maxlen, result);
        }


        for (int i = 0; i < len2; i++) {
            int n = Math.min(len2 - i, len1);
            maxlen = maxLength(nums1, nums2, 0, i, n);
            result = Math.max(maxlen, result);
        }

        return result;
    }

    /**
     * 从相同的位置开始滑动,找出最长公共子串
     *
     * @return
     */
    public static int maxLength(int[] nums1, int[] nums2, int addA, int addB, int len) {
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[addA + i] == nums2[addB + i]) {
                cnt++;
            }else {
                cnt=0;
            }
            result = Math.max(result, cnt);
        }
        return result;
    }


}
