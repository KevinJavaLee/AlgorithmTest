package com.kevin.Code.Stack;

import java.util.Stack;

/**
 * 用两个栈来实现求出栈中最小的值
 *
 * @author kevin
 * @project LeetCode
 * @create 2020-11-14-11:28
 */
public class MinStack {

    //1.用于保存栈的数据
    private Stack<Integer> stackData ;
    //2.用于保存栈中最小的值
    private Stack<Integer> stackMin ;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    /**
     * 压栈的规则，如果StackMin为空，则把数据同时压入stackData和stackMin
     * 否则，如果要压入的值大于stackMin的值则把stackMin栈顶的值压入stackMin;
     * 而当压入的值小于stackMin栈顶的值时，则把值同时压入两个栈
     * @param x
     */
    public void push(int x) {

        if (this.stackMin.isEmpty()) {
            stackMin.push(x);

        } else {

            if (x <= this.getMin()) {
                this.stackMin.push(x);

            } else {
                int newMin = this.stackMin.peek();
                this.stackMin.push(newMin);
            }
        }

        this.stackData.push(x);


    }


    /**
     * 出栈规则
     *
     */
    public void pop() {

        if (this.stackData.isEmpty()) {
            throw new RuntimeException("栈为空");
        } else {
            this.stackData.pop();
            this.stackMin.pop();
        }


    }

    public int top() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stackData.peek();
    }

    public int getMin() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("");

        }
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        int min = minStack.getMin();
        minStack.pop();
        int top = minStack.top();
        int min1 = minStack.getMin();

        System.out.println(min);
        System.out.println(top);
        System.out.println(min1);
    }
}
