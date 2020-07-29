package zy.code.sort;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Arrays;

/**
 * 希尔排序：改进的插入排序
 * 采用：步长分组+分组内插入排序算法
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
    * 希尔排序之交换法
     */
    public static void shellSort(int[] arr){

        for (int gap = arr.length/2; gap > 0; gap/= 2){
            for (int i = gap; i < arr.length; i++){
                int j = i;//用于分组扫描
                //同组以每隔一个步长扫描上一个元素并比较大小
                while (j-gap >= 0 && arr[j-gap] > arr[j]){
                    //交换
                    int temp = arr[j];
                    arr[j] = arr[j-gap];
                    arr[j-gap] = temp;
                    //j继续向前扫描同组上一个元素
                    j -= gap;
                }
            }
        }
    }


    /**
     * 希尔排序之移动法
     */
    public static void shellSort2(int arr[]){
        for (int gap = arr.length/2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++){
                int j = i;//用于分组扫描
                int temp = arr[j];//用于保存待插入的无序数

                while (j - gap >= 0 &&  arr[j-gap] > temp){
                    //大数后移
                   arr[j] = arr[j-gap];//以步长为单位进行后移
                    j -= gap;
                }
                //将待插入元素放到 j-gap 的后面
                arr[j] = temp;

            }

        }


    }
}
