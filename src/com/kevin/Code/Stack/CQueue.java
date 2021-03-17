package com.kevin.Code.Stack;

import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: 剑指09题
 * 两个栈实现一个队列
 * 另外一个pop栈如果不为空，插入数据会导致错误
 * @create 2021-03-12 9:24
 * @project LeetCode
 * @Version 1.0
 */
public class CQueue {

    //用连个栈来实现一个队列
    Stack<Integer> firstStack = new Stack<>();
    //第二个栈中实际存储数据
    Stack<Integer> secondStack = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        //先把数值放到第一个栈中
        firstStack.add(value);

    }

    public int deleteHead() {
        if (secondStack.isEmpty()) {
            if (firstStack.isEmpty()) {
                return -1;
            }
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    public static void main(String[] args) {

    }
}
