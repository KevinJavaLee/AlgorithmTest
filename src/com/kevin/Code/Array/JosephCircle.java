package com.kevin.Code.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinlee Xiao
 * @Classname JosephCircle
 * @Description 剑指 Offer 62. 圆圈中最后剩下的数字 简单题
 * @Date 2021/9/15 10:42
 * @Version 1.0
 */
public class JosephCircle {
    public static void main(String[] args) {
        int i = lastRemaining(5, 3);
        System.out.println(i);
    }


    /**
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {


        //
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }


        int cur = -1;
        while (list.size() > 1) {

            cur += m;

            if (cur > list.size() - 1) {
                //cur下标超过n的大小
                cur = cur % list.size();
            }
//            System.out.println(cur);
            list.remove(cur);
            //重新开始的下标为cur--
            cur--;
        }

        return list.get(0);
    }
}
