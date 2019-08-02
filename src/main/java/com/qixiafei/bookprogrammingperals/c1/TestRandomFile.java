package com.qixiafei.bookprogrammingperals.c1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * <P>Description: 读写文件指定行. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:    </P>
 * <P>CREATE DATE: 2019/4/16 15:19</P>
 * <P>UPDATE DATE: </P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class TestRandomFile {

    public static void main(String[] args) {
        File file = new File("D:\\self-study\\codes\\self\\book-programming-perals\\src\\main\\resources\\demo.txt");

        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            byte[] data = new byte[26];
            for (int i = 0; i < 26; i++) {
                data[i] = (byte) ('a' + i);
            }
            raf.write(data);
            byte[] fileData = new byte[50];
            raf.seek(0);
            int read = raf.read(fileData);
            System.out.println(Arrays.toString(fileData));

//            raf.seek(26);
//            raf.write('\n');
//            raf.write(data);

            raf.seek(0);
            raf.read(fileData);
            System.out.println(Arrays.toString(fileData));
            raf.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
