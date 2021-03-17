package com.kevin.Code.Stack;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Vinlee xiao
 * @Description: 逆波兰表达式
 * Leetcode第150题
 * 思路：1.中缀表达式转逆波兰表达式
 *      2.逆波兰表达式求值
 * @create 2021-03-11 15:38
 * @project LeetCode
 * @Version 1.0
 */
public class evaluateReversePolishNotation {
    public static void main(String[] args) {

//        1 + (( 2 + 3 ) x 4 ) - 5
         String []s = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"} ;

//         StringBuffer s1 = reversePolish(s);
//         System.out.println(s1);

        int i = evalRPN(s);
        System.out.println(i);


    }


    /**
     * 将中缀表达式转换为后缀表达式
     * @param s
     */
    public static StringBuffer reversePolish(String[] s) {

        //用于存储中间的结果
        Stack<String> stack = new Stack<String>();
        //队列
        Deque<String> queue = new LinkedList<>();

        int len = s.length;

        for (int i = 0; i < len; i++) {

            //1.碰到操作符
            //采用正则表达式来判断是否为数字
            if (s[i].matches("[0-9]*")) {
                queue.add(s[i]);
                //2.首先判断是不是操作符
                // 操作符的优先级低于或者等于栈底的优先级
            } else if (s[i].matches("/|\\*|\\+|-")) {

                if (stack.isEmpty()) {
                    stack.push(s[i]);

                }else {

                    //如果碰到操作运算符，且操作符权限比栈顶的权限小于或者等于，则将操作符出栈压入队列中，
                    while (!stack.isEmpty() && stack.peek()!="(" && getPatternPriority(s[i]) <= getPatternPriority(stack.peek())) {
                        queue.add(stack.pop());
                    }
                    stack.push(s[i]);
                }

                //3.碰到括号的做法
            } else if (s[i].equals("(")) {
                stack.push(s[i]);
            } else if (s[i].equals(")")) {

                //如果碰到右括号则将括号中得值全部压入队列之中
                while (!stack.peek().equals("(")) {
                    queue.add(stack.pop());
                }

                //最后把左括号弹出栈
                stack.pop();
            }
//            System.out.println("stack:" + stack.toString());
//            System.out.println("queue:" + queue.toString());
        }
        //4.将栈中为弹出的元素全部压入队列中
        while (!stack.isEmpty()) {
            queue.add(stack.pop());

        }
//        System.out.println(queue.toString());
//        String s1 = queue.toString();
//        System.out.println(s1);
//        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
//        //将队列中得元素转换为字符串数组
        while (!queue.isEmpty()) {

            stringBuffer.append(queue.pop());

        }
//
//        return stringBuilder.toString() ;
        return stringBuffer;
    }

    /**
     * 计算运算符的优先级
     * @param s
     * @return
     */
    public static int getPatternPriority(String s) {

        int ans = 0;
        switch (s) {
            case "+":
                ans = 1;
                break;
            case "-":
                ans = 1;
                break;
            case "*":
                ans = 2;
                break;
            case "/":
                ans = 2;
                break;
            default:
                break;

        }
        return ans;
    }


    public static int caculatorNum() {

        return 0;
    }

    /**
     *
     * @param tokens
     * @return
     */
    public static int evalRPN1(String[] tokens) {

        Stack<Integer> num = new Stack<>();

        //1.首先通过计算得到后缀表达式
        StringBuffer buffer = reversePolish(tokens);

        //2.计算
        //1.碰到数字，则进栈，
        for (int i = 0; i < buffer.length(); i++) {
            if (Character.isDigit(buffer.charAt(i))) {
                num.push(buffer.charAt(i) - '0');
            }else{
                //出栈两个数
                //栈顶的元素
                Integer num1 = num.pop();
                Integer num2 = num.pop();
                int sum = 0;
                switch (buffer.charAt(i)) {
                    case '+':
                        sum = num2 + num1;
                        break;
                    case '-':
                        sum = num2 - num1;
                        break;
                    case '*':
                        sum = num2 * num1;
                        break;
                    case '/':
                        sum = num2 /num1;
                        break;
                    default:
                        break;
                }

                num.push(sum);
            }
        }



        //2.碰到运算符，则对出栈的两个数进行运算，最后把结果返回栈中

        return num.pop();
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();


        //1.碰到数字，则进栈，
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("[0-9]*|^-[0-9]*[1-9][0-9]*$")) {
                num.push(Integer.parseInt(tokens[i]));
            }else{

                //出栈两个数
                //栈顶的元素
                Integer num1 = num.pop();
                Integer num2 = num.pop();
                int sum = 0;

                switch (tokens[i]) {
                    case "+":
                        sum = num2 + num1;
                        break;
                    case "-":
                        sum = num2 - num1;
                        break;
                    case "*":
                        sum = num2 * num1;
                        break;
                    case "/":
                        sum = num2 /num1;
                        break;
                    default:
                        break;
                }

                num.push(sum);
                sum = 0;
            }
        }

        //2.碰到运算符，则对出栈的两个数进行运算，最后把结果返回栈中

        return num.pop();
    }
}
