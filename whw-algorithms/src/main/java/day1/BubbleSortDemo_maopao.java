package day1;

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

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int end = arr.length - 1;

        for (int i = end; i >= 0; i--) {  // 每一次循环找到最大的数当前循环最后的位置

            for (int j = 1; j <= i; j++) { //每循环完一次 就会找到一个最大的数放入相对最后的位置
                //两两比较 大的往后面换
                if (arr[j] < arr[j - 1]) {
                    StudySortUtil.swap(arr, j, j - 1);
                }
            }

        }


    }


}
