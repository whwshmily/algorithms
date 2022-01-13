package compute.day1;

import compute.util.StudySortUtil;

/**
 * 冒泡排序
 * 第一个数和他后面的数进行比较 比后面的大交换位置
 * 第二个数和他后面的数进行比较 比后面的大交换位置...
 * 循环一轮 可以找出最大的一位数
 * 依次找出所有
 */
public class BubbleSortDemo_maopao {

    public static void main(String[] args) {
        int[] arr = StudySortUtil.ARR;
        bubbleSort(arr);
        StudySortUtil.printArr(arr);
    }

    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int end = arr.length - 1;

        for (int i = end; i >= 0; i--) {  // 每一次循环找到最大的数当前循环最后的位置
            // 1 2 每一次都和他后面的数比较 大的往后排
            // 3 4
            // 5 6
            for (int second = i - 1; second >= 0; second--) { //挨个比较 最大的数往后排
                if (arr[i] < arr[second]) {
                    StudySortUtil.swap(arr, i, second);
                }
            }
        }


    }


}
