package zy.code.sparsearray;

/**
* 抽取普通二维数组与稀疏数组的转换。封装成工具方法
 */
public class SpareArryUtil {


    /**
     * 普通二维数组转换为稀疏数组
     */
    public static int[][] arrayTYoSpare(int[][] chessArr){
        //计算有效值
        int val = 0;
        for (int i=0; i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr[i][j] != 0){
                    val++;
                }
            }
        }

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


        return spareArr;
    }


    /**
     * 稀疏数组还原回普通二维数组
     */
    public static int[][] spareToArray(int[][] spareArr){

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

        return chessArr2;
    }
}
