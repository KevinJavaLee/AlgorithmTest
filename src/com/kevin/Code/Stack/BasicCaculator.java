package com.kevin.Code.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee xiao
 * @Description: 基本计算器 II
 * 栈和队列
 * Leetcode第277题
 * @create 2021-03-11 14:47
 * @project LeetCode
 * @Version 1.0
 */
public class BasicCaculator {
    public static void main(String[] args) {
        String s = "3+2*2";
        int sum = calculate(s);
        System.out.println("sum:" + sum);
    }

    /**
     * 计算一个字符串的中得数
     * @param s
     * @return
     */
    public static int calculate(String s) {

        //默认第一个数字之前为+号
        char preChar = '+';
        int num = 0;
        int len = s.length();

        //建立一个栈
        Deque<Integer> stack =  new LinkedList<Integer>();

        for (int i = 0; i < len; i++) {

            //判断是否为数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            //判断如果不为数字
            //直到碰到下一次为运算符号或者为最后一个数时，才进行运算
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {

                switch (preChar) {
                    case '+' :
                        //如果
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop()*num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }

                preChar = s.charAt(i);
                //每次碰到是符号的时候，都对num进行重新的初始化
                num = 0;
            }
        }

        //对栈中的数据进行计算

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }



        return sum;
    }
}
