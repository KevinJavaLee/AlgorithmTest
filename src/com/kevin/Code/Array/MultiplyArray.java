package com.kevin.Code.Array;

/**
 * @author Vinlee Xiao
 * @Classname MultiplyArray 剑指 Offer 66. 构建乘积数组 中等难度
 * @Description
 * @Date 2021/9/14 11:23
 * @Version 1.0
 */
public class MultiplyArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] arr1 = constructArr(arr);
        for (int i : arr1) {
            System.out.println(i);
        }
    }

    /**
     * @param a
     * @return
     */
    public static int[] constructArr(int[] a) {

        int len = a.length;
        if (len == 1 || len == 0) {

            return new int[]{};
        }

        int[] help = new int[a.length];
        help[0] = 1;

        //求c[i-1]
        for (int i = 1; i < len; i++) {
            help[i] = help[i - 1] * a[i - 1];
//            System.out.print(help[i]+" ");

        }
        System.out.println();

        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {

            //
            help[i + 1] = help[i + 1] * temp;
            temp = temp * a[i + 1];

        }
        help[0] = temp;


        return help;
    }
}
