package com.kevin.Code.Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个队列来实现栈
 * @author kevin
 * @project LeetCode
 * @create 2020-11-14-19:30
 */
public class implementStackUsingQueues {

    /**
     * 用队列来实现栈
     * @param args
     */
    //用于存储栈内的元素
    Queue<Integer> stack ;
    //起辅助的作用
    Queue<Integer> assistanStack;

    /**
     * 构造函数
     */
    public implementStackUsingQueues() {
        stack = new LinkedList<>();
        assistanStack = new LinkedList<>();
    }


    /** Push element x onto stack. */
    public void push(int x) {
        //1.新元素先入队到assistantStack,然后将stack中的元素出队到assistantStack,
        //最后交换两个栈
        assistanStack.add(x);
        //如果fu
        while (!stack.isEmpty()) {
            assistanStack.add(stack.poll());
        }
        //交换两个栈
        Queue<Integer> tmp = new LinkedList<Integer>();

        tmp = assistanStack;
        assistanStack = stack;
        stack = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.poll();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //1.声明一个对象
        implementStackUsingQueues stack = new implementStackUsingQueues();
        stack.push(1);
        stack.push(3);
        stack.push(10);
        stack.push(4);
        //2.
        int pop = stack.pop();
        int peek = stack.top();
        boolean empty = stack.empty();

        System.out.println(pop);
        System.out.println(peek);
        System.out.println(empty);
    }
}
