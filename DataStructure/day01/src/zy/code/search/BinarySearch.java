package zy.code.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找：递归方式
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,12,12,12,12,12,45,78,100};
//        int index = binarySearch(arr, 0, arr.length - 1, 45);
//        System.out.println(index);
        List<Integer> indexs = binarySearch2(arr, 0, arr.length - 1, 12);
        System.out.println(indexs.toString());


    }

    /**
     * 二分查找，只返回一个找到的索引
     */
    public static int binarySearch(int[] arr,int left,int right,int value){
        if (left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midValue = arr[mid];

        if (value < midValue){
           return binarySearch(arr,left,mid-1,value);
        }else if(value > midValue){
            return binarySearch(arr,mid+1,right,value);
        }else{
            return mid;
        }

    }

    /**
     * 二分查找，返回找到的所有匹配值索引
     * 用数组保存索引并返回
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int value){
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right)/2;
        int midValue = arr[mid];

        if (value < midValue){
            return binarySearch2(arr,left,mid-1,value);
        }else if(value > midValue){
            return binarySearch2(arr,mid+1,right,value);
        }else{
            List<Integer> indexlist = new ArrayList<>();
            //分别向mid的左、右扫描
            int temp = mid;
            indexlist.add(mid);
            //向左扫描
            for (temp = mid -1; temp >=0 && arr[temp] == value; temp--){
                indexlist.add(temp);
            }
            //向右扫描
            for (temp = mid +1; temp < arr.length && arr[temp] == value; temp++){
                indexlist.add(temp);
            }
            return indexlist;


        }

    }

}
