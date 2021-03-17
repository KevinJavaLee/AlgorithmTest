package com.kevin.Code;

import sun.font.TrueTypeFont;

import java.util.Stack;

/*
* 最小括号
*
* */

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-06-21:42
 */
public class isValidCase2 {


    public static void main(String[] args) {
        boolean flag = isValid("()()");
        System.out.println(flag);
    }


    public static boolean isValid(String s) {

        char[] ch = s.toCharArray();

        //定义一个栈 作为辅助判断是否有匹配的括号
        Stack<Character> characterStack = new Stack<>();
        for (char c : ch) {

            //如果属于左括号则进栈
            if (c == '(' || c == '[' || c == '{') {
                characterStack.push(c);
            } else {
                char tmp = '0' ;
                if (characterStack.isEmpty()) {
                    return false;
                }
                tmp =characterStack.pop();
                if (tmp == '(' && c != ')') {
                    return false;
                }else if(tmp == '[' && c != ']'){
                    return false;
                } else if (tmp == '{' && c != '}') {
                    return false;
                }
            }
//            System.out.println(c);
        }
        if (!characterStack.isEmpty()){
            return false;
        }
        return true;
    }
}
