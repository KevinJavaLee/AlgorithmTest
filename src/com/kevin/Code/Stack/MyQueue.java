package com.kevin.Code.Stack;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-11-14-19:02
 */

import java.util.Stack;

/**
 * 用两个栈来实现队列
 * 出自Leetcode/代码指南第一章
 */
public class MyQueue {

    Stack<Integer> popStack;
    Stack<Integer> pushStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        popStack = new Stack<>();
        pushStack = new Stack<>();

    }

    /**
     * 主要用于反转栈里面的数据 算法设计巧妙
     */
    public void inverse() {

        //栈的大小是否为零
        if (pushStack.empty()) {

            while (!popStack.isEmpty()) {
                pushStack.push(popStack.pop());
            }



        }

    }
    /** Push element x to the back of queue. */
    public void push(int x) {

        popStack.push(x);
        inverse();

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return pushStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return pushStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        inverse();
        return pushStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        int peek = myQueue.peek();// return 1
        int pop = myQueue.pop();// return 1, queue is [2]
        boolean empty = myQueue.empty();// return false
        System.out.println(peek);
        System.out.println(pop);
        System.out.println(empty);

    }
}
