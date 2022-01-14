package day1;

import compute.util.StudySortUtil;

import java.util.Arrays;
/**
 * 选择排序 索引
 * 0 -N-1 选出最小的位置放入 0的位置
 * 1 -N-1 选出最小的位置放入 1的位置
 * 2 -N-1 选出最小的位置放入 2的位置
 * 3 -N-1 选出最小的位置放入 3的位置...
 * 选出最小的放入指定位置
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        int[] arr = StudySortUtil.ARR;
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int end = arr.length-1;

//        for (int i = end; i >=0 ; i--) {
//            int newValueIndex = i;
//            for (int prev = i-1; prev >=0 ; prev--) {
//                if (arr[newValueIndex] < arr[prev]) {
//                    newValueIndex = prev;
//                }
//            }
//            StudySortUtil.swap(arr, i, newValueIndex);
//        }

        for (int i = 0; i <= end; i++) { //外层循环是为了 对应 0~N 每一次找到最小值放入指定位置
            int minValueIndex = i;
//        先记录当前i的位置 若数组当前的位置的值大于他前面位置的值 说明他不是最小值 记录最小值的索引
//        一值记录最小值的索引 然后把值放入指定位置
            //后面不用管记录过最小值的位置 从他之后继续这个操作 然后排序
            for (int next = i + 1; next <= end; next++) { //这层循环是为了找到最小值
//                if (arr[minValueIndex] > arr[next]) {
//                    minValueIndex = next;
//                }
                minValueIndex = arr[minValueIndex] >arr[next] ? next : minValueIndex;
            }
            StudySortUtil.swap(arr, i, minValueIndex);
        }
    }


}
