package zy.code.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 归并排序：采取分而治之的思想
 * 采用：分割数组成小块区域，再整合小区域思想
 * 采用：递归分治 + temp临时中间数组 ，以空间换时间
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arr =  { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 分而治之思想，使用递归去分割数组，然后再合并
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left+right)/2;
            //向左递归分解
            mergeSort(arr,left,mid,temp);
            //向右递归分解
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);

        }

    }


    /**
     * 合并算法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;//用于对temp数组的遍历

        //1.
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        //2.//把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3.
        //将temp数组的元素拷贝到arr
        //注意，并不是每次都拷贝所有
        //第一次合并 tempLeft = 0 , right = 1 //  tempLeft = 2  right = 3 // tL=0 ri=3
        t = 0;
        int tempindex = left;
        while (tempindex <= right){
            arr[tempindex] = temp[t];
            t++;
            tempindex++;
        }

    }
}
