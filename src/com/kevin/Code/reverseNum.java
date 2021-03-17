package com.kevin.Code;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-10-11:52
 */
public class reverseNum {

    public static void main(String[] args) {

        int num = reverse(1534236469);
        System.out.println(num);
    }

    public static int reverse(int x) {


        int num ;
       /*1.先转换成字符串*/
        if (x < 0) {
            num = -x;
        }else {
            num = x;
        }
        char[] arr =String.valueOf(num).toCharArray();
        System.out.println(num);
        char tmp ;
        int len = arr.length;
        for (int i = 0; i < len/2; i++) {
            tmp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = tmp;

        }


        String str = new String(arr);
//        System.out.println(str);
//        System.out.println(Integer.parseUnsignedInt(new String(arr)));

        int inter = 0;
        try {
            inter = Integer.parseUnsignedInt(new String(arr));
        } catch (NumberFormatException e) {
            return  0;
        }


//        int inter = Integer.parseInt(arr.toString());
        System.out.println();
        if (x < 0) {
            return -inter;
        }


        return inter;
    }
}
