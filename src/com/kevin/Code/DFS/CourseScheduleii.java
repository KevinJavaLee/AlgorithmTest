package com.kevin.Code.DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
    boolean isValid;
    //记录相邻结点
    List<List<Integer>> edges;
    //记录最终结果
    int[] result;
    //记录每个结点的角度
    int[] infoes;
    //下标
    int index;
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

    /**
     *
     * 具体思路：广度优先遍历
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public  int[] findOrder1(int numCourses, int[][] prerequisites){
        index = 0;
        //对列用于保存
        Deque<Integer> deque = new LinkedList<>();
        //记录每个结点的相邻结点
        edges = new ArrayList<>();
        //用于要记录访问的顺序
        result = new int[numCourses];
        //记录每个结点的入度
        infoes = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());

        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            //当前结点的入度增加
            ++infoes[prerequisite[0]];
        }

        //将入度为零的结点放入对列中
        for (int i = 0; i < numCourses; i++) {
            if (infoes[i] == 0) {
                //加入对列中
                deque.addLast(i);
            }
        }


        //循环遍历对列
        while (!deque.isEmpty()) {
            //得到结点
            int u = deque.pollFirst();
            System.out.println(u);
            result[index++] = u;
            //遍历u结点的相邻结点v
            for (int v : edges.get(u)) {

                //u结点的相邻结点的入度减少
                infoes[v]--;
                if (infoes[v] == 0) {
                    deque.addLast(v);

                }
            }
        }

        //存在环，所以应该返回空数组
        if (index != numCourses) {
            return new int[0];
        }
        return result;

    }


}
