package com.kevin.Code;

/**
 * @author kevin
 * @project LeetCode
 * @create 2020-10-14-21:45
 */
public class searchInsertPosition {

    public static void main(String[] args) {


        int[] arr = new int[]{1,3,5,6};
        int target = 4;
        int i = binarySearchInsert(arr, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {


        int len = nums.length;

        for (int i = 0; i < len; i++) {


            /*1.如果在数组中就返回在数组中的下标*/
            if (nums[i] == target) {
                return i;
            } else if (target <= nums[i]) {
                return i;

            }
        }
        
        return len;
    }


    /*1.利用二分查找法来查找*/

    public static int binarySearchInsert(int[] nums, int target) {
        int low = 0;
        int middle = 0;
        int high = nums.length -1 ;
        int index = nums.length;

        while (low <= high) {

            middle = (low + high) / 2;
//            System.out.println("middle:"+middle);
//            index = middle;
            if (nums[middle] == target) {

                return middle;

            } else if (nums[middle] < target) {
                low = middle + 1;
                System.out.println("low:"+low);

            }else if (nums[middle] >= target){
                index = middle;
                high = middle -1;
//                System.out.println("high:"+high);

            }
        }



        return index;

    }
}
