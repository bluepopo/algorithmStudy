package zy.code.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,10,10,20,25,30,100};
        bubble(arr);
        System.out.println(Arrays.toString(arr));



    }

    public static void bubble(int[] arr){

        for (int i = 0; i < arr.length - 1; i++){
            //System.out.println("第"+ (i+1) + "趟排序");
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }

            if (!flag){
                break;
            }
        }
    }
}
