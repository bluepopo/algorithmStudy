package zy.code.search;

/**
 * 差值查找：依据公式计算mid的占比位置
 * 如果是等差数组，不管查找什么，都是一次就找到
 */
public class DValueSearch {
    public static void main(String[] args) {
        //创建数组，如果该数组是一个等差数组，不管查找什么，都是一次就找到
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++){
            arr[i] = i + 1;
        }

        int index = DValueSearch(arr, 0, arr.length - 1, 41);
        System.out.println(index);

    }

    /**
     * 差值查找算法
     */
    public static  int DValueSearch(int[] arr,int left,int right,int value){

        System.out.println("差值查找了一次");
        if (left > right || value < arr[0] || value > arr[arr.length-1]){
            return  -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (value < midValue){
            return DValueSearch(arr,left,mid-1,value);
        }else if (value > midValue){
            return DValueSearch(arr,mid+1,right,value);
        }else{
            return mid;
        }
    }

}
