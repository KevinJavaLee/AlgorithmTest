package com.kevin.Code;



/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-10-21:55
 */
public class implementStrstr {

    public static void main(String[] args) {
        /*
        * "mississippi"
"issipi"
        * */
        String str = "abcaabbcabcaabdab";
        int[] next = getNext(str);
        for (int i = 1; i <str.length(); i++) {
            System.out.print(next[i]);

        }



    }

    public static int strStr(String haystack, String needle) {

        int lenh = haystack.length();
        int lenn = needle.length();
//        System.out.println("lenh:" + lenh);
        if (lenn == 0) {
            return 0;

        } else if (lenh == 0 || lenh < lenn) {
//            System.out.println("-1");
            return -1;
        }

        int cnt ;
        int index = 0;
        for (int i = 0; i <= lenh - lenn; i++) {

            index = i;
            cnt = 0;

            for (int j = 0; j < lenn; j++) {

                if (haystack.charAt(index) != needle.charAt(j)) {

                    break;

                }  else{
//                    System.out.println(cnt);

                    index++;
                    cnt++;
//                    System.out.println("cnt:" + cnt);
//                    System.out.println("index:" + index);

                }
                    /*如果haystack字符串中出现第一个匹配的字符串，则返回下标*/
                    if (cnt == lenn) {
                        return i;
                    }
            }
            }

        return -1;

        }


    /**
     *
     * @param hstack
     * @param needle
     * @param next
     * @return
     */
    public static int Kmp(String hstack,String needle,int next[]) {

        int i = 0;
        int j = 0;
        while (i < hstack.length() && j < needle.length()) {

            if (j == 0 || hstack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }

            if (j > needle.length()) {
                return i - needle.length();
            } else {
                return 0;
            }
        }

        return 0;
    }


    /**
     *
     * @param pat
     * @return
     */
    public static void getNextArr(String pat,int next[]) {

        int len = pat.length();



        int i = 1;
        int j = 0;

        /*将next数组中下标为1的数置为0*/
        next[1] = 0;

        while (i < len) {

            if (j == 0 || pat.charAt(i) == pat.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;

            } else {
                j = next[j];
            }
        }


        System.out.println("**********************");
        for (int k = 1; k < next.length; k++) {
            System.out.print(next[k]);
        }

    }

    public static int[] getNext(String sub) {
        int[] n = new int[sub.length()];
        int x = 0;
        for (int i = 1; i < sub.length(); i++) {
            while (x > 0 && sub.charAt(x) != sub.charAt(x)) {
                x = n[x - 1];
            }

            if (sub.charAt(i) == sub.charAt(x)) {
                x++;
            }

            n[i] = x;
        }
        return n;

    }



    }

