package com.kevin.Code.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName CourseScheduleii
 * @Description Leetcode 210 课程列表II 中等难度 dfs bfs 图 拓扑排序 没啥思路
 * @Author Vinlee Xiao
 * @Date 2021/06/19/20:43
 * @Version 1.0
 */
public class CourseScheduleii {
    int index ;
    boolean isValid;
    public  int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> edges = new ArrayList<>();

        //存储已经访问的节点
        int[] visited = new int[numCourses];
        //存储最终的结果集
        int[] result = new int[numCourses];
        //用于判断是否出现环
        isValid = true;

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        //遍历每个结点，同时存入每个结点的边结点
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        index = numCourses - 1;
        //用result数组模拟栈，最先加入数组中的数处于栈底。
        for (int i = 0; i < numCourses && isValid; i++) {
            if (visited[i] == 0) {
                dfs(edges, visited, result, i);
            }

        }

        //如果存在环，则返回空数组
        if (!isValid) {
            return new int[0];
        }

        return result;
    }


    /**
     *
     * @param edges
     * @param visited
     * @param result
     *
     * @param u
     */
    public  void dfs(List<List<Integer>> edges,int[] visited, int[] result,int u) {

        //将当前结点标记为访问结点
        visited[u] = 1;

        //访问当前结点的相邻结点
        for (Integer v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(edges, visited, result,v);

                //如果存在环，则直接返回
                if (!isValid) {

                    return;
                }
            } else if (visited[v] == 1) {
                //将isValid置为false,直接返回函数
                isValid = false;
                return;
            }

        }

        //将结点u置为已经访问
        visited[u] = 2;
        //将当前结点置为数组底部
        if (index >= 0) {
            result[index--] = u;

        }




    }
}
