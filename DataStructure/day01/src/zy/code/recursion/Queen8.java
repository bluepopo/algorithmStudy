package zy.code.recursion;

/**
 * 递归穷举法：八皇后问题
 * 递归的判断至少有一万多次
 */
public class Queen8 {
    int max = 8;
    int[] arr = new int[max];
    int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        //从第一个皇后开始探索
        queen8.check(0);
        System.out.printf("总共的摆放组合有 %d 个\n",queen8.count);

    }


    /**
     * 放置第 n 个皇后
     * check方法中有一个循环，每递归一层都会有一个for循环
     * 如果底层完毕，就会回溯上一层
     * 上一层就会接着for循环，而新的循环又会产生一个新的递归，新的递归树里面皇后的位置会改变，产生不同的结果
     */
    public void check(int n){
        if (n == max){
            //当n等于最大数时，说明所有的皇后已经摆放完毕，这个递归的出口到了。
           print();//打印目前的arr数组
            return;//结束递归，返回上层
        }
        //从第0列开始试着放置皇后
        for (int i = 0;i < max;i++){
            //先试着放置皇后
            arr[n] = i;
            if (judge(n)){
                //不冲突，该位置暂时可以放置，继续放置下一个皇后，即开始递归
                check(n+1);
            }
                //冲突，当前位置暂时不可以放置，继续试着放置到下一列

        }



    }



    /**
     * 判断第n个皇后的摆放位置是否正确
     */
    public boolean judge(int n){
        for (int i = 0;i < n; i++){
            if (arr[i] == arr[n] || Math.abs(i-n) == Math.abs(arr[i]-arr[n])){
                return false;
            }
        }
        return true;
    }

    /**
     * 写一个方法，可以将皇后摆放的位置输出
     */
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
