package com.kevin.Code.Stack;

import java.util.Stack;

/**
 * @author Vinlee xiao
 * @create 2020-11-22 22:07
 * @project LeetCode
 */
public class SortedStackByStack {

    /**
     * 用一个栈实现另外一个栈的排序
     * 思路：help作为辅助栈，在stack执行pop操作，弹出的元素记为cur,
     * 如果cur小于help栈顶的元素，则入栈到help中，否则
     * help中的元素出栈，直到cur小于或者等于help栈顶的元素
     * @param args
     */
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(10);
        stack.push(0);
        stack.push(9);
        stack.push(7);

        //调用函数
        sortByStack(stack);
        //输出排序后的结果

//        while (!stack.isEmpty()) {
//            System.out.print(stack.pop() + " ");
//        }

    }

    public static void sortByStack(Stack<Integer> stack){

        //辅助栈
        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            //第二步：如果cur > help的栈顶，则入栈
            while (!help.isEmpty() && cur > help.peek()) {
                stack.push(help.pop());

            }
            help.push(cur);

        }

        //按照从栈顶到栈底从大到小的顺序
        while (!help.isEmpty()) {
            System.out.println(help.peek());
            stack.push(help.pop());
        }
    }



}
