package com.kevin.Code.Tree;

/**
 * @author Vinlee Xiao
 * @Classname Node
 * @Description TODO
 * @Date 2021/8/6 15:57
 * @Version 1.0
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
