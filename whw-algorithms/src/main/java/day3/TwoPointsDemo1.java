package day3;

/**
 * 1: 一个有序的数组 找一个数是否存在
 * 因为数组是有序的 所以先将数组一分为二 比较中间值 mid和要找的值 x
 * x == mid 找到了
 * x < mid 然后将 0-mid位置的数据继续二分 然后比较中间的值 重复操作
 * x > mid 然后将 mid-last位置的数据继续二分 然后比较中间的值 重复操作
 * 跳出循环都没找到 说明值不存在
 */
public class TwoPointsDemo1 {


    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,11,13,24,55,64,78,99};
        int index = findPointNumberIndex(arr, 7);
        System.out.println("index--->"+index);
        System.out.println(findPointNumberIndex(arr,1));
        System.out.println(findPointNumberIndex(arr,99));
        System.out.println(findPointNumberIndex(arr,0));
        System.out.println(findPointNumberIndex(arr,100));
    }

    public static int findPointNumberIndex(int[] arr, int num) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length-1;
        /**
         * 为什么left<=right 假设数组 [0 2 3] num 1 经过二分之后
         * left = 0 right =0 如果不等于 边界就会被跳过 检查不到边界
         * 所以right = length -1 防止数组越界
         *
         */
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
