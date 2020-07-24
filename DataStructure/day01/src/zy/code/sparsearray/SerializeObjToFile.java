package zy.code.sparsearray;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 将对象序列化到磁盘文件
 */
public class SerializeObjToFile {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\test\\data\\spareArr.data"));

        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        int[][] spareArr = SpareArryUtil.arrayTYoSpare(chessArr);
        int[][] chessArr2 = SpareArryUtil.spareToArray(spareArr);
        /**
         * 序列化对象到磁盘
         */
        oos.writeObject(spareArr);
        oos.flush();
        oos.close();

    }

}
