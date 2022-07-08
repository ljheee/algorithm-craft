package com.ljheee.algorithm.binary;

/**
 * 寻找最左边界
 * Created by lijianhua04 on 2020/6/9.
 */
public class LeftestBound {


    /**
     * 有序数组，查找target 出现的位置
     * 元素不重复
     * [1,2,3,4,5,6]
     *
     * @param arr
     * @param target
     * @return
     */
    public static int index(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 有序数组，查找target 出现的位置
     * 元素有重复
     * <p>
     * [1,1,2,2,2,3,4,5,6]
     *
     * @param arr
     * @param target
     * @return
     */
    public static int indexOf(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left] == target ? left : -1;
    }


    /**
     * 数组中只有0、1
     * 找出最左侧的1
     *
     * @param arr
     * @return
     */
    public static int firstIndex(int[] arr) {

        int leftest = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);

//            if (arr[mid] == 1) {
//                right = mid;
//                leftest = mid;
//            } else {
//                left = mid + 1;
//            }

            if (arr[mid + 1] != 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left + 1] == 1 ? left + 1 : -1;
    }


    public static void main(String[] args) {

        System.out.println(index(new int[]{1, 2, 3}, 2));//1
        System.out.println(indexOf(new int[]{1, 1, 2, 2, 2, 3}, 2));//2

//        System.out.println(firstIndex(new int[]{0, 1, 1, 1, 0, 0, 0}));
//        System.out.println(firstIndex(new int[]{0, 0, 1, 1, 0, 0, 0}));
        System.out.println(firstIndex(new int[]{1, 0, 1, 1, 0, 0, 0}));
    }
}
