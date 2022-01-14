package day2;

import day1.BubbleSortDemo_maopao;
import day1.InsertSortDemo;
import day1.SelectSortDemo;

import java.util.Arrays;

/**
 * 检查数组排序后 时候正确
 */
public class CheckArrSort {


    public static void main(String[] args) {
        int times = 1000000;
        for (int i = 0; i < times; i++) {
            int[] arr = lengthRandomAndValueRandom(999,99999);
            int[] copyArr1 = copyArr2New(arr);
            int[] copyArr2 = copyArr2New(arr);
            int[] copyArr3 = copyArr2New(arr);
            InsertSortDemo.insertSort(arr);
            BubbleSortDemo_maopao.bubbleSort(copyArr1);
            SelectSortDemo.selectSort(copyArr2);
            if (!isSortSuccess(arr)){
                System.out.println("原数组"+ Arrays.toString(copyArr3));
                System.out.println("after sort"+ Arrays.toString(arr));
                System.out.println("插入排序失败");
                break;
            }
            if (!isSortSuccess(copyArr1)){
                System.out.println("冒泡排序失败");
            }
            if (!isSortSuccess(copyArr2)){
                System.out.println("选择排序失败");
            }
        }
    }

    /**
     * 获取随机的数组 用来检测数组排序是否正确
     * 根据 Math.random() 均等概率的获取0-1的值
     */
    public static int[] lengthRandomAndValueRandom(int maxLength, int maxValue) {
        int randomLength = (int) (Math.random() * maxLength);
        int[] arr = new int[randomLength];
        for (int i = 0; i < randomLength; i++) {
            int randomValue = (int) (Math.random() * maxValue);
            arr[i] = randomValue;
        }
        return arr;
    }
    //复制一个新数组
    public static int[] copyArr2New(int[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    //检查数据排序是否成功
    public static boolean isSortSuccess(int[] arr){
        if(arr == null || arr.length < 2){
            return true;
        }
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minValue > arr[i]){
                return false;
            }
            minValue = arr[i];
        }
        return true;
    }


}
