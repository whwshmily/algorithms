package day3;

import day1.InsertSortDemo;

import java.util.Arrays;

/**
 * code2 在有序的数组中找到>=num最左位置  ？
 * <p>
 * 因为数组是有序的 所以使用二分
 * 先找到中间位置 和num 比较
 * 如果
 * 大于等于num  先记录这个数的位置ans  0-mid-1继续二分
 * 小于num mid+1-right 继续二分
 * 重复操作
 * <p>
 * 最后记录的ans-1位置就是要找的位置
 */
public class Code2AndCode3_FindNum {

    public static void main(String[] args) {
        int maxLength = 99;
        int maxValue = 999;
        int times = 10000000;
        for (int i = 0; i < times; i++) {
            int[] arr = getRandomArr(maxLength, maxValue);
            InsertSortDemo.insertSort(arr
            );
            int num = (int) (Math.random() * 999);
//            int i1 = mostLeftIndexThenEqNum(arr, num);
//            int i2 = checkCode2Result(arr, num);
            int i1 = mostRightIndexLoseEqNum(arr, num);
            int i2 = checkCode3Result(arr, num);
            if (i1 != i2) {
                System.out.println("arr->" + Arrays.toString(arr));
                System.out.println("num->" + num);
                System.out.println("i2->" + i2);
                System.out.println("i1->" + i1);
                break;
            }
        }
    }

    public static int mostLeftIndexThenEqNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans - 1;
    }

    public static int checkCode2Result(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i - 1;
            }
        }
        return -1;
    }

    public static int[] getRandomArr(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength);
        int[] arr = new int[length];
        int value = 0;
        for (int i = 0; i < length; i++) {
            value = (int) (Math.random() * maxValue);
            arr[i] = value;
        }
        return arr;
    }


    /**
     * code3 在有序的数组中找到<=num最右位置
     */
    public static int mostRightIndexLoseEqNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = -2;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= num) {
                ans = mid;
            }
            right = mid - 1;
        }
        return ans + 1;
    }

    public static int checkCode3Result(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num){
                return i+1;
            }
        }
        return -1;
    }

}
