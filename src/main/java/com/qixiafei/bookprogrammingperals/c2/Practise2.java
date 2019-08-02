package com.qixiafei.bookprogrammingperals.c2;

import java.io.*;
import java.util.BitSet;
import java.util.Random;

/**
 * <P>Description: 问题2 .给定包含4 300 000 000个32位整数的顺序文件，如何找出一个出现至少两次的整数？. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:    </P>
 * <P>CREATE DATE: 2019/4/16 21:26</P>
 * <P>UPDATE DATE: </P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class Practise2 {

    private static final String PATH = "D:\\self-study\\codes\\self\\book-programming-perals\\src\\main\\resources\\c2\\p2.log";

    public static void main(String[] args) throws IOException {
//        genQuestionFile();
        findTwice();
    }

    /**
     * 生成待解决问题数据文件.
     *
     * @throws IOException
     */
    public static void genQuestionFile() throws IOException {

        File directory = new File(PATH.substring(0, PATH.lastIndexOf("\\")));
        directory.mkdirs();
        File file = new File(PATH);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        Random ran = new Random();
        for (long i = 0; i < 4300000000L; i++) {
            String number = String.valueOf(ran.nextInt(Integer.MAX_VALUE));
            bw.write(number, 0, number.length());
            bw.newLine();
            bw.flush();
        }
        bw.close();
        fw.close();
    }

    public static int findTwice() throws IOException {
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        File file = new File(PATH);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String temp;
        try {
            while ((temp = br.readLine()) != null) {
                int num = Integer.parseInt(temp);
                if (bitSet.get(num)) {
                    return num;
                } else {
                    bitSet.set(num);
                }
            }
        } finally {
            br.close();
            fr.close();
        }
        return -1;
    }
}
