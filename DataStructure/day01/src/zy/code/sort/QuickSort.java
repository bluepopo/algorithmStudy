package zy.code.sort;

import sun.management.jmxremote.LocalRMIServerSocketFactory;

/**
 * 快速排序
 * 采用：左右标兵扫描+递归分治，以空间换时间
 */
public class QuickSort {
    public static void main(String[] args) {

    }
    public static void quickSort(int[] arr,int left, int right){
        int l = left;
        int r= right;
        int pivot = arr[(left + right) / 2];//pivot 中轴值
        int temp = 0;//用作交换时的中间变量
        while (l < r){
            //左标兵从前往后找大数，右标兵从后往前找小数

            while (arr[l] < pivot){//大数法则
                l++;
            }
            while (arr[r] > pivot){//小数法则
                r--;
            }
            if (l > r){
                break;//在找数过程中，左右标兵碰面了，表示找数失败
            }
            //找数成功，交换左右标兵的值
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //注意一个bug,当数组中存在两个相等的pivot时，要避免死循环
            //比较交换完的元素是否有等于pivot,防止两个相等的pivot进入死循环
            if (arr[l] == pivot){
                r--;//交换完的元素可以跳过
            }
            if (arr[r] == pivot){
                l++;
            }
        }
        //如果一趟下来，l==r，必须l++,r--,将数组左右区分开
        if (l == r){
            l++;
            r--;
        }

        //向左递归
        quickSort(arr,left,r);
        //向右递归
        quickSort(arr,l,right);

    }
}
