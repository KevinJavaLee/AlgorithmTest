package com.kevin.Code;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-10-15:08
 */
public class romanToInt {

    public static void main(String[] args) {
        int num = romanToInt("DCXXI");
        System.out.println(num);
    }

    public static int romanToInt(String s) {


        int sum = 0;
        int len = s.length();
        
        /*1.遍历*/

        char word ;
        for (int i = 0; i < len; i++) {

            word = s.charAt(i);

            if (word == 'I') {
                if ((i + 1) < len && s.charAt(i + 1) == 'V') {
                    sum += 4;
                    i++;
                } else if ((i + 1) < len && s.charAt(i + 1) == 'X') {
                    sum += 9;
                    i++;
                }else {
                    sum += 1;
                }
            } else if (word == 'X') {

                if ((i + 1) < len && s.charAt(i + 1) == 'L') {
                    sum += 40;
                    i++;
                } else if ((i + 1) < len && s.charAt(i + 1) == 'C') {
                    sum += 90;
                    i++;
                }else {
                    sum += 10;
                }

            } else if (word == 'C') {

                if ((i + 1) < len && s.charAt(i + 1) == 'D') {
                    sum += 400;
                    i++;
                } else if ((i + 1) < len && s.charAt(i + 1) == 'M') {
                    sum += 900;
                    i++;
                }else {
                    sum += 1;
                }

            } else  {
                switch (word) {
                    case 'V':
                        sum += 5;
                        break;
                    case 'L':
                        sum += 50;
                        break;
                    case 'D':
                        sum += 500;
                        break;
                    case 'M':
                        sum += 1000;
                        break;

                }
            }
        }
        return sum;
    }
}
