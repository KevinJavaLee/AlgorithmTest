package com.kevin.Code.SortArray;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Project LeetCode
 * @ClassName LargestNum
 * @Description Leetcode 179最大数 中等难度 高频
 * @Author Vinlee Xiao
 * @Date 2021/05/03/20:27
 * @Version 1.0
 */
public class LargestNum {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0};
        String s = largestNumber(nums);
        System.out.println(s);
    }

    /**
     * 思路：将数字转换为字符串后来进行排序
     * @param nums
     * @return
     */
    public  static String largestNumber(int[] nums) {

        if (nums.length == 1 ) {

            return String.valueOf(nums[0]);
        }


        //将字符数组转换为流
        IntStream stream = Arrays.stream(nums);

        //将流中每个数字转换为字符串
        Stream<Object> objectStream = stream.mapToObj((s) -> {
            return String.valueOf(s);
        });

        //转换为字符数组
        String[] strings = objectStream.toArray(String[]::new);


        //运用Arrays.sort进行排序
        Arrays.sort(strings,(s1,s2)->{
            return (s2+""+s1).compareTo(s1+""+s2);
        });

        //将字符串添加进入字符数组
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            //判断是否连续以0开头
            if (stringBuilder.length() == 0 && s.equals("0")) {
                continue;
            }
            stringBuilder.append(s);
        }

        //数组数据全为0,返回0
        if (stringBuilder.length() == 0) {
            return "0";
        }

        return stringBuilder.toString();
    }
}
