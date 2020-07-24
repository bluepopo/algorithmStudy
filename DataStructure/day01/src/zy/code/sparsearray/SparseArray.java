package zy.code.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始二维数组
        // 11 *11 的棋盘大小，1表示黑棋子，2表示蓝棋子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;

        for (int[] row : chessArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();;
        }

        //计算有效值
        int val = 0;
        for (int i=0; i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr[i][j] != 0){
                    val++;
                }
            }
        }
        System.out.printf("原来二维有效值有 %d 个\n",val);

/**
 * 二维数组 转 稀疏数组的思路
 * 1. 遍历  原始的二维数组，得到有效数据的个数 sum
 * 2. 根据sum 就可以创建 稀疏数组 sparseArr   int[sum + 1] [3]。加一是因为第一列放的是原二维数组有几行几列、几个有效值。
 * 3. 将二维数组的有效数据数据存入到 稀疏数组
 */
        //创建稀疏数组
        int spareArr[][] = new int[val+1][3];
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = val;

        //定义一个稀疏数组的行计数器
        int spare_row = 0;
        for (int i = 0; i<11; i++){
            for (int j = 0; j <11; j++){
                if (chessArr[i][j] != 0){
                    spare_row++;
                    spareArr[spare_row][0] = i;
                    spareArr[spare_row][1] = j;
                    spareArr[spare_row][2] = chessArr[i][j];
                }
            }
        }
        // 遍历稀疏数组
        System.out.println("转换后的稀疏数组为：");
        for (int i = 0; i < spareArr.length; i ++){
            System.out.printf("%d\t%d\t%d\t\n",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
        }

        System.out.println();


        /**
         * 稀疏数组 转 原始的二维数组的思路
         *
         * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组大小，比如上面的  chessArr2 = int [11][11]
         * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
         */
        int row_count = spareArr[0][0];
        int column_count = spareArr[0][1];
        int chessArr_val = spareArr[0][2];
        //创建原数组大小
        int chessArr2[][] = new int[row_count][column_count];
        //遍历稀疏数组并赋值
        for (int i = 1; i<= chessArr_val; i ++){
             int r = spareArr[i][0];
             int c = spareArr[i][1];
             int v = spareArr[i][2];
             chessArr2[r][c] = v;
        }

        //输出还原数组
        System.out.println("原来的二维数组为：");
        for (int[] row : chessArr2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();;
        }
    }
}
