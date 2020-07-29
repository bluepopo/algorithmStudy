package zy.code.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,2,1,4,3,25,12,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 插入排序，将无序列的数据插入到有序列
     * 采用移动元素的算法
     * @param arr
     */
    public static void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i-1]){
                //将当前元素插入到前面,依次判断前面的元素大小,越小越往前，直到比某个数大
                int temp = arr[i];
                int j;
                //挪动元素
                for (j = i -1; j >= 0 && temp < arr[j] ; j--){
                    //大数后移
                    arr[j+1] = arr[j];
                }
                //当temp >= arr[j]时扫描结束，在arr[j]的后面插入temp
                arr[j+1] = temp;

            }
        }
    }
}
