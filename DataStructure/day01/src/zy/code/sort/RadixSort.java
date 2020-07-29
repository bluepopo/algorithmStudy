package zy.code.sort;

import java.util.Arrays;

/**
 * 基数排序（桶排序）
 * 以0~9的基数创建二维数组，将数字以个十百千位放入桶中，这样从个位开始排起一直到最高位
 * 采用：桶二维数组 + 最大位数几位就会排几次 ，以空间换时间
 * （以下算法不支持小数、负数。若数据量过大，该算法会出现OOM）
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214,10};
        radixSory(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 获取数组中，最大数的位数
     */
    public static int maxDigit(int[] arr){
        int max=arr[0];
        for (int i = 1; i < arr.length;i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        String maxStr = max + "";
        return maxStr.length();

    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSory(int[] arr){

        //创建一个桶二维数组，每一行代表一个桶，总共有10个桶
        int[][] bucket = new int[10][arr.length];
        //创建桶标志数组，标识该桶有多少个有效值
        int[] bucketElementCounts = new int[10];

        //获取最大有几位数
        int maxDigit = maxDigit(arr);
        double chu = (double) maxDigit;
        chu = Math.pow(10,chu-1);//三位数，截取百位时要除以100，四位数则除以1000


        for (int round = 1; round <= chu; round *= 10) {
            //截取位数并放入对应桶
            for (int j = 0; j < arr.length; j++) {
                int digit = arr[j] / round % 10;
                //将截取的位数放到对应下标的桶中
                int BucketColumn = bucketElementCounts[digit];//得到对应桶中已经放入多少个元素
                bucket[digit][BucketColumn] = arr[j];//放入
                bucketElementCounts[digit]++;

            }

            //将桶中的元素再顺序放回arr数组
            int index = 0;
            for (int m = 0; m < bucket.length; m++) {

                if (bucketElementCounts[m] != 0) {//如果改行有数据
                    //遍历该行
                    for (int n = 0; n < bucketElementCounts[m]; n++) {
                        arr[index++] = bucket[m][n];
                    }

                }
                //取出改行数据后，将改行数据清零
                bucketElementCounts[m] = 0;//将计数器置零

            }

        }

    }

}
