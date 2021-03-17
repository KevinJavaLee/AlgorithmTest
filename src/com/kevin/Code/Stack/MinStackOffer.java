package com.kevin.Code.Stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: 剑指offer 第50
 * @create 2021-03-12 9:00
 * @project LeetCode
 * @Version 1.0
 */
public class MinStackOffer {

    //两个栈 一个用于存储数据，一个用于存储最小值
    Stack<Integer> stackData = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();



    public MinStackOffer() {

    }

    /**
     * 弹出规则：
     * @param x
     */
    public void push(int x) {
        //1.如果存储数据的栈为空，则把数据和值全部压入数据栈中和存储最小值的栈中
        if (stackData.isEmpty()) {
            stackData.push(x);
            stackMin.push(x);

        }else {
            //2.如果不为空,则比较
            stackData.push(x);
            //
            if (x < stackMin.peek()) {
                stackMin.push(x);
            }else{
                //如果大于或者等于，则往最小栈里面压入最小栈栈顶的元素
                stackMin.push(stackMin.peek());
            }
        }
    }

    /**
     * 压入规则：
     */
    public void pop() {
        if (!stackData.isEmpty() && !stackMin.isEmpty()) {
            stackData.pop();
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }

    public static void main(String[] args) {

        MinStackOffer minStack = new MinStackOffer();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());

    }
}
