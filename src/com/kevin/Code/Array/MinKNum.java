package com.kevin.Code.Array;

/**
 * @author Vinlee Xiao
 * @Classname MinKNum
 * @Description 剑指 Offer 40. 最小的k个数 简单题 值得再做
 * @Date 2021/9/10 9:05
 * @Version 1.0
 */
public class MinKNum {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 2, 0, 5,
                0};
        int[] numbers = getLeastNumbers(arr, 2);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    /**
     * 根据快速排序分区的思想：时间复杂度O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {


        if (k == 0) {
            return new int[]{};
        }

        //得到快速排序的分区情况
        //输出k个最小值
        int start = 0;
        int end = arr.length - 1;

        int index = getPartition(arr, start, end);
        while (index != k - 1) {


            //如果当前的快速排序的分区index大于k-1，则应该将end减1
            if (start < end && index > k - 1) {

                end = index - 1;
                index = getPartition(arr, start, end);
            } else {
                if (start < end) {
                    start = index + 1;
                    index = getPartition(arr, start, end);
                }


            }

        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    /**
     * 用于实现快速排序返回分区下标
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int getPartition(int[] arr, int start, int end) {

        int num = arr[start];

        int low = start;
        int high = end;
//        System.out.println(low);
//        System.out.println(high);

        while (low < high) {

            //当arr[high]大于num时下标递减
            while (low < high && arr[high] >= num) {

                high--;
            }

            while (low < high && arr[low] <= num) {
                low++;
            }

            //进行两个数的交换
            if (low < high) {
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }

        }

        //交换基数


        arr[start] = arr[high];
        arr[high] = num;


        return high;
    }

}
