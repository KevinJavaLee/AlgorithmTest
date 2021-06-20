package com.kevin.Code.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName CourseSchedule
 * @Description Leetcode 207 课程表 中等难度 深度优先 图算法 拓扑排序 低频 没啥思路 不太明白
 * @Author Vinlee Xiao
 * @Date 2021/06/17/21:55
 * @Version 1.0
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}, {0, 1}};
        boolean b = canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

    /**
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjacent = new ArrayList<>();
        //记录要访问的
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacent.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adjacent.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacent, visited, i)) {
                return false;
            }
        }
        return true;
    }


    /**
     *
     * @param adjacent
     * @param visited
     * @param index
     * @return
     */
    public static boolean dfs(List<List<Integer>> adjacent, int[] visited, int index) {

        //停止迭代条件
        //说明已经被访问过，存在环
        if (visited[index] == 1) {
            return false;
        }

        //被其他dfs访问过
        if (visited[index] == -1) {
            return true;
        }

        visited[index] = 1;

        //访问其相邻节点
        for (Integer e : adjacent.get(index)) {
            if (!dfs(adjacent, visited, e)) {
                return false;
            }
        }

        visited[index] = -1;

        return true;
    }
}
