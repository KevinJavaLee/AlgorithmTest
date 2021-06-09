package com.kevin.Code.DFS;

import com.kevin.Code.TreeNode;

import java.util.Enumeration;
import java.util.HashMap;

/**
 * @Project LeetCode
 * @ClassName HouseRobberiii
 * @Description LeetCode 337 打家劫舍  中等难度 dfs bfs 低频 思路不正确
 * @Author Vinlee Xiao
 * @Date 2021/06/09/16:46
 * @Version 1.0
 */
public class HouseRobberiii {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(1);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.right = treeNode5;

        int rob = rob(treeNode);

        System.out.println(rob);
    }

    /**
     *
     * @param root
     * @return
     */
    public static int rob(TreeNode root) {

        int num1 = dfs(root.left, false) + dfs(root.right, false);
        int num2 = root.val + dfs(root.left, true) + dfs(root.right, true);
        return Math.max(num1, num2);
    }

    /**
     * 自己思路
     * 超过时间限制 原始思路
     * @param root
     * @param isParent 父节点是否参与运算
     * @return
     */
    public static int dfs(TreeNode root,boolean isParent) {

        if (root == null) {
            return 0;
        }
        int num = 0;
        if (!isParent) {
            num = root.val + dfs(root.left, true)+ dfs(root.right, true);
        }
        num = Math.max(num, dfs(root.left, false) + dfs(root.right, false));

        return num;
    }

    /**
     * 动态规划
     * @param root
     * @return
     */
    public static int rob1(TreeNode root) {
        //用于存储被选择时的最大值
        HashMap<TreeNode, Integer> f = new HashMap<>();
        //用于存储不被选择时的最大值
        HashMap<TreeNode, Integer> g = new HashMap<>();
        help(root,f,g);
        int num = Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
        return num;
    }

    /**
     *
     * @param root
     * @param f
     * @param g
     */
    public static void help(TreeNode root, HashMap<TreeNode, Integer> f, HashMap<TreeNode, Integer> g) {

        if (root == null) {
            return;
        }
        help(root.left,f,g);
        help(root.right,f,g);
        //如果当前节点被选中了
        f.put(root, root.val + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        //如果当前节点没有被选中,则取得值为max(f(left),g(left))+max(f(right),g(right)
        int num = Math.max(f.getOrDefault(root.left, 0), g.getOrDefault(root.left, 0))
                + Math.max(f.getOrDefault(root.right, 0), g.getOrDefault(root.right, 0));
        g.put(root,num);
    }
}
