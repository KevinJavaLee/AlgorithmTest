package com.kevin.Code.Bitwise;

/**
 * @author Vinlee Xiao
 * @Classname NumberOfArrayI
 * @Description 剑指Offer 56 II. 数组中数字出现的次数 II 中等难度 没啥思路
 * @Date 2021/9/3 16:13
 * @Version 1.0
 */
public class NumberOfArrayI {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 6, 1};

        int i = singleNumber(arr);
        System.out.println(i);
    }


    /**
     * 总体思路：统计所有数字各个位数之和对三取模  取得结果即为最后的结果
     * 剑指Offer原思路 遍历统计
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        //用于存储所有数相加
        int[] bitNumber = new int[32];

        //统计所有位数之和
        for (int i = 0; i < nums.length; i++) {

//            int bitMask = 1;
            for (int j = 0; j < 32; j++) {
//                System.out.println(nums[i] & bitMask);
                int bit = (nums[i] & 1);
//                System.out.print(bit);
                bitNumber[31 - j] += bit;
//                System.out.println();
                //向左移动
                nums[i] = nums[i] >>> 1;
            }
//            for (int j = 0; j < 32; j++) {
//                System.out.print(bitNumber[j]);
//            }
//            System.out.println();
        }

//        for (int i = 0; i < 32; i++) {
//            System.out.print(bitNumber[i]);
//        }
//        System.out.println();
        int res = 0;
        //取模恢复数组中只出现一次的数据
        for (int i = 0; i < 32; i++) {

            res = res << 1;
            res = res + (bitNumber[i] % 3);
//            System.out.println(res);
        }

        return res;


    }
}
