package com.kevin.Code.Array;

import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Project LeetCode
 * @ClassName WordSearch
 * @Description Leetcode 79. 单词搜索 中等难度 回溯算法 经典 有思路
 * @Author Vinlee Xiao
 * @Date 2021/05/28/16:23
 * @Version 1.0
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";
        boolean b = exist(board, word);
        System.out.println(b);
    }

    /**
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {

        //第一步：首先找到word首字母在矩阵中的位置
        int row = board.length;
        int col = board[0].length;
        //记录已经访问的点
        boolean[][] visited = new boolean[row][col];
        List<List<Integer>> indexList = new ArrayList<>();

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<Integer> list = new ArrayList<>();
//                    System.out.print(i + " ");
//                    System.out.print(j+ " ");
//                    System.out.println();
                    list.add(i);
                    list.add(j);
                    indexList.add(list);

                }
            }

        }

        if (indexList.size() == 0) {
            return false;
        }
        for (List<Integer> list : indexList) {
            boolean b = dfs(board,visited, list.get(0), list.get(1), word, 0);
//            System.out.println("b:" + b);
            if (b) {
                return b;
            }
        }

        return false;
    }


    /**
     * 加一个visited数组
     * 深度优先遍历
     */
    public static boolean dfs(char[][] board,boolean[][] visited, int startX, int startY, String word,int index) {
        if (startX < 0 || startX >= board.length || startY < 0 || startY >= board[0].length || index>= word.length() || visited[startX][startY]) {
            return false;
        }
        boolean flag = false;
        if (board[startX][startY] == word.charAt(index)) {
//            System.out.println("index:" + index);
//            System.out.println(startX+":"+startY+board[startX][startY]);
            visited[startX][startY] = true;
            flag = dfs(board, visited, startX + 1, startY, word, index + 1) ||
                    dfs(board, visited, startX, startY + 1, word, index + 1) ||
                    dfs(board, visited, startX - 1, startY, word, index + 1) || dfs(board, visited, startX, startY - 1, word, index + 1)||index+1==word.length();
            visited[startX][startY] = false;
            return flag;
        }



        return flag;
    }
}

