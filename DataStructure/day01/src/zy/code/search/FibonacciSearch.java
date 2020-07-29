package zy.code.search;

import sun.reflect.generics.tree.ReturnType;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * 斐波那契查找：黄金分割点
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibSearch(arr, 8));// 0

    }

    /**
     * 获取一个长度为 n 的 斐波那契数组
     */
    public static int[] fib(int m){
        int[] f = new int[m];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < m; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     * 斐波那契黄金分割点查找
     * f[k] > arr.length ,f[k]为一个黄金长度，在查找前要将arr填充成黄金长度
     */
    public static int fibSearch(int[] arr,int value){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        int k = 0;
        int[] f = fib(20);
        //获取到斐波那契分割数值的下标.f[k]是一个黄金长度
        while (f[k]  < arr.length){
            k++;
        }
        //f[k]的值可能大于数组arr的长度
        // 为了使得数组个数要达到 f[k]-1,因此需要把原数组arr填充一下
        //temp后面多出来的元素会默认用0填充
        int[] temp = Arrays.copyOf(arr,f[k]);

        //让temp比arr多出的元素，用arr最后一个元素填充
        for (int i = high + 1; i < f[k]; i++){
            temp[i] = arr[high];
        }

        //查找
        while (low <= high){
            mid = low + f[k - 1] - 1;//计算黄金分割点
            if (value < temp[mid]){
                high = mid - 1;
                k--;//往前有f[k-1]个元素，为了下次循环，计算折断后的新的黄金分割点
            }else if (value > temp[mid]){
                low = mid + 1;
                k -= 2;//往后有f[k-2] 个元素，计算折断后的新的黄金分割点
            }else{
                //找到，返回下标
                if (mid <= high){
                    return mid;
                }else{
                    return high;//还记得填充数组temp的长度其实是比arr大的吗
                }

            }

        }
        return -1;

    }

}
