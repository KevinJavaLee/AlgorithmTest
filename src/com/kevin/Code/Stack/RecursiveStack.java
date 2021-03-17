package com.kevin.Code.Stack;

import java.util.Stack;

/**
 * @author Vinlee xiao
 * @create 2020-11-22 21:50
 * @project LeetCode
 */
public class RecursiveStack {

    /**
     * 用递归函数和一个栈来实现栈的逆序
     * 题目：出自代码面试指南第一章节：栈的使用
     *
     */

    public static void main(String[] args) {

        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        integers.push(2);
        integers.push(3);
//
        reverse(integers);

        //1.遍历栈
        int num;
        while(!integers.isEmpty()){
            num = integers.pop();
            System.out.print(num + " ");

        }
        //输出逆序后的栈



    }

    /**
     * 将栈底元素从栈底移除并返回
     * @param stack
     * @return
     */
    public static int removeLastElement(Stack<Integer> stack){

        int result = stack.pop();

        //为空则返回结果
        if (stack.isEmpty()){
            return result;
        }else {
            int last = removeLastElement(stack);
            stack.push(result);
            return last;
        }

    }


    public static void reverse(Stack<Integer> stack){

        if (stack.isEmpty()){
            return;
        }
        int i = removeLastElement(stack);
        reverse(stack);
        stack.push(i);

    }
}
