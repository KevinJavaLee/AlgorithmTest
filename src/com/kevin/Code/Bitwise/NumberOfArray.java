package com.kevin.Code.Bitwise;

/**
 * @author Vinlee Xiao
 * @Classname NumberOfArray
 * @Description 剑指 Offer 56 - I. 数组中数字出现的次数 中等难度 没啥思路 可以再做
 * @Date 2021/9/3 11:24
 * @Version 1.0
 */
public class NumberOfArray {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 4, 6};
        int[] numbers = singleNumbers(arr);

    }


    /**
     * 4,1,4,6
     *
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {


        int ret = 0;
        for (int num : nums) {

            ret = ret ^ num;

        }

//        System.out.println(ret);


        //找到两个数异或结果中 任意一个位置不为1的位置
        int position = 1;

        while ((ret & position) == 0) {
            //向左移动
            position = position << 1;
        }

        //分别用于存储最终的结果
        int a = 0, b = 0;
        for (int num : nums) {

            if ((position & num) == 0) {
                a = a ^ num;
            } else {
                b = b ^ num;

            }

        }

//        System.out.println(a);
//        System.out.println(b);

        return new int[]{a, b};
    }
}
