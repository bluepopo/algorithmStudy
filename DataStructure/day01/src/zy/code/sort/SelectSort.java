package zy.code.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,12,12,60,4,8,1};

        System.out.println(Arrays.toString(arr));

    }

    public static void selectSort1(int[] arr){

        for (int i = 0;i < arr.length - 1;i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    //选取更小的往前替换
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }

    //选择排序
    public static void selectSort2(int[] arr) {
        //每次选取后面的最小元素与之替换
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            //向后遍历扫描最小元素
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }
            // 将最小值，放在arr[i], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

        }
    }

}
