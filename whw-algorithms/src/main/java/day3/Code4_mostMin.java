package day3;

import java.util.Arrays;

/**
 * 一个数组无序 任意相邻位置不等 局部最小
 * 局部最小定义 arr[0]<arr[1] 0位置局部最小
 * arr[n-1] <arr[n-2] n-1位置局部最小
 * arr[i-1] > arr[i] arr[i]<arr[i+1] i 位置局部最小
 * 找到任意一个
 * <p>
 * 任意数组相邻位置不等 无序
 * 1 数组长度为1 不存在
 * 2 数组长度大于1 先找头尾 位置 符合直接返回
 * 3 若头尾都不符合 说明 arr[0] > arr[1]  arr[length-1] > arr[length-2]
 * 这个曲线是先下降 到尾部右上升 又因为相邻不等 所以 必有最小值
 * 所以继续用二分法
 * 先找中间位置 若中间位置 符合直接返回
 * 若不符合 中间位置比左边大 左半边必有最小值 左半边继续二分
 * 比左边小 说明右边必有最小值 右半边继续二分
 */
public class Code4_mostMin {


    public static void main(String[] args) {
        int maxLength = 99;
        int maxValue = 999;
        int times = 1000000;
        int count = 0;
        for (int i = 0; i < times; i++) {
            count++;
            int[] arr = getRandomArr(maxLength, maxValue);
            int index = mostMinValueIndex(arr);
            if (!checkResult(arr, index)) {
                System.out.println("arr->" + Arrays.toString(arr));
                System.out.println("index->" + index);
                break;
            }
        }
        System.out.println("count->"+count);
    }

    public static int mostMinValueIndex(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        /**
         * 为什么left<=right-1 防止边界问题
         * 假设数组是 3 2 3 4
         * 第一次二分 mid = 2 是 3 不符合继续二分
         * 第二次 right= 1 mid = 0
         * 然后 mid-1 就会越界
         * 如果跳出循环都没有返回 说明这时比较的就只剩余两个数了
         * 这时哪个数最小 就是局部最小值
         */
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] > arr[mid] && arr[mid + 1] > arr[mid]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return arr[right] > arr[left] ? left : right;
    }

    public static int[] getRandomArr(int maxLength, int maxValue) {
        int length = (int) (Math.random() * maxLength);
        int[] arr = new int[length];
        /**
         * 生成一个相邻不等的数组
         *
         * 先生成第一个位置的值
         * 后面的位置要求不能与前一个位置的值相等
         * 所以生成之后的数组是一个相邻不等的数组
         */
        if (length > 0) {
            arr[0] = (int) (Math.random() * maxValue);
            for (int i = 1; i < length; i++) {
                do {
                    arr[i] = (int) (Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }
        return arr;
    }

    public static boolean checkResult(int[] arr, int index) {
        if (index == -1) {
            int mostMinValueIndex = getMostMinValueIndex(arr);
            return mostMinValueIndex == -1;
        }
        if (index == 0 && arr[0] < arr[1]) {
            return true;
        }
        if (index == arr.length - 1 && arr[arr.length - 1] < arr[arr.length - 2]) {
            return true;
        }
        return arr[index - 1] > arr[index] && arr[index + 1] > arr[index];
    }

    public static int getMostMinValueIndex(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
