package com.kevin.Code.Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Vinlee xiao
 * @Description: 剑指59 得到队列的最大值 思路和最小栈的思路差不都
 * @create 2021-03-12 15:30
 * @project LeetCode
 * @Version 1.0
 */
public class MaxQueue {

    //两个双端队列，一各用于存储数，一个用于存储最大的值
    Deque<Integer> dataQueue = new LinkedList<>();
    Deque<Integer> maxQueue = new LinkedList<>();


    public MaxQueue() {

    }

    public int max_value() {
        //如果队列为空，返回-1
        if (maxQueue.isEmpty()) {
            return -1;
        }
        //返回双端队列最后的元素
        return maxQueue.peekFirst();

    }

    /**
     * 如果新加入的数据小于maxQueue队尾的数，则maxQueue压入dataQueue队尾的数
     * 否则，直接将数压入maxQueue中
     * @param value
     */
    public void push_back(int value) {

        dataQueue.addLast(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            //把队尾小于的元素全部弹出
            maxQueue.pollLast();
        }

        maxQueue.addLast(value);
    }

    /**
     * 删除元素
     * @return
     */
    public int pop_front() {

        if (dataQueue.isEmpty()) {
            return -1;
        }
        //存储最大数的队列也从头部删除数据
        if (dataQueue.peekFirst().equals(maxQueue.peekFirst())) {
            maxQueue.pollFirst();
        }
//        maxQueue.pollFirst();


        return dataQueue.pollFirst();

    }

    public static void main(String[] args) {

        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
