package compute.util;

import java.util.Arrays;

public class StudySortUtil {

    public static final int[] ARR = {1, 9, 5, 3, 4, 8, 22, 6, 1, 7, 3, 5, 2,99,6,55,11,23,55,32,44,23};

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

}
