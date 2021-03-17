package com.kevin.Code.Stack;

import java.util.Stack;

/**
 * 方案二不同于方案一：
 * 压栈规则和出栈规则都有不同
 *
 * @author kevin
 * @project LeetCode
 * @create 2020-11-14-11:50
 */


public class MiniStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> miniStack;


    public  MiniStack() {
        dataStack = new Stack<Integer>();
        miniStack = new Stack<Integer>();
        //防止出现空指针异常
        miniStack.push(Integer.MAX_VALUE);

    }

    /**
     *节省空间的方案
     * @param x
     */
    public void push(int x) {

//        if (this.miniStack.isEmpty()) {
//            this.miniStack.push(x);
//        } else if (x <= this.getMin()) {
//            this.miniStack.push(x);
//        }
        if (miniStack == null || x <= this.getMin()) {
//            this.dataStack.push(x);
            miniStack.push(x);
        }

        this.dataStack.push(x);


    }

    /**
     *节省空间方案
     */
    public int pop() {

//        if (this.dataStack.isEmpty()) {
//            throw new RuntimeException("栈为空！");
//        }
        int val = this.dataStack.pop();
        if (val == this.getMin()) {

            this.miniStack.pop();
        }
        return val;



    }

    public int top() {
//        if (dataStack.isEmpty()) {
//            throw new RuntimeException("栈为空");
//        }
        return this.dataStack.peek();
    }

    public int getMin() {

//        if (this.minStack.isEmpty()) {
//            throw new RuntimeException("栈为空！");
//        }
        return this.miniStack.peek();
    }

    public static void main(String[] args) {

        MiniStack miniStack = new MiniStack();
        miniStack.push(-2);
        miniStack.push(0);
        miniStack.push(-3);

        int min = miniStack.getMin();
        miniStack.pop();
        int top = miniStack.top();
        int min1 = miniStack.getMin();

        System.out.println(min);
        System.out.println(top);
        System.out.println(min1);



    }


}
