package compute.day1;

import compute.util.StudySortUtil;

/**
 * 插入排序
 * 当数组长度为 1 是自然有序
 * 当数组长度为 2 他和前面的比较 比他小 交换位置
 * 当数值长度为 3  他和前面的比较 比他小 交换位置 不比他小 停在当前位置
 * 这样前面的都是有序的 每一次后面的数都和前面的进行比较 找到自己的位置 这样就都是有序的了
 */
public class InsertSortDemo {


    public static void main(String[] args) {
        int[] arr = StudySortUtil.ARR;
        insertSort(arr);
        StudySortUtil.printArr(arr);
    }


    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        /**
         * 索引
         * 0-0 是自然有序的
         * 0-1 是需要比较 交换位置的
         * 0-2 一样
         * 索引遍历从1 开始  0-0是有序的  所以新来的end 位置 是无序的 是需要比较的
         * 排序是从end开始的
         */
        //第一个位置是有序的
        //第二个位置和第一个位置进行排序 得到前两个位置是有序的
        //第三个位置和前面两个进行排序  得到前三个位置有序 ...

        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newValueIndex = end;
            //和前面有序的数值的值进行排序 如果比前面的值小就往前面移动 不小就找到位置了
            while (newValueIndex - 1 >= 0 && arr[newValueIndex] < arr[newValueIndex - 1]) {
                StudySortUtil.swap(arr, newValueIndex, newValueIndex - 1);
                newValueIndex--;
            }
//            for (int i = end; i > 0; i--) {
//                if (arr[i] < arr[i - 1]) {
//                    StudySortUtil.swap(arr, i, i - 1);
//                } else {
//                    break;
//                }
//            }
        }


    }
}
