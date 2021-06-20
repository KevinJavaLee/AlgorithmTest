package com.kevin.Code.DFS;

/**
 * @Project LeetCode
 * @ClassName CourseTest
 * @Description 测试
 * @Author Vinlee Xiao
 * @Date 2021/06/19/22:34
 * @Version 1.0
 */
public class CourseTest {
    public static void main(String[] args) {
        CourseScheduleii courseScheduleii = new CourseScheduleii();
        int numcourses = 4;
        int[][] pre = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = courseScheduleii.findOrder1(numcourses, pre);
        for (int i : order) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
