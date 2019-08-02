package com.qixiafei.bookprogrammingperals.c1;

import java.util.BitSet;
import java.util.Random;

/**
 * <P>Description: 位排序 - 解决资源有限的不重复数字排序问题. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:    </P>
 * <P>CREATE DATE: 2019/4/16 11:12</P>
 * <P>UPDATE DATE: </P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class BitSort {

    public static void main(String[] args) {
//        // 问题规模
//        int n = 100000000;
//        // 最大数
//        int max = 500000000;
//        // 最小数
//        int min = 0;
//        // 计算最大数是几倍的问题规模，确保生成问题数据时不会超过max
//        int nums = (max - min) / n;
//
//        int[] question = new int[n];
//        question[0] = min;
//        Random rd = new Random();
//        int rdNums = nums - 1;
//        for (int i = 1; i < n; i++) {
//            question[i] = question[i - 1] + 1 + rd.nextInt(rdNums);
//        }
//        shuffle(question);
//        for (int i = 0; i < 10; i++) {
//            long start = System.currentTimeMillis();
//            int[] result1 = BitSort.sort(question, max);
//            System.out.println("位图排序耗时:" + (System.currentTimeMillis() - start));
//            int[] result2 = question.clone();
//            start = System.currentTimeMillis();
//            Arrays.sort(result2);
//            System.out.println("Arrays.sort()排序耗时:" + (System.currentTimeMillis() - start));
//            checkOrder(result1);
//            checkOrder(result2);
//
//        }

        BitSet bitSet = new BitSet(1000);
        bitSet.set(2);
        BitSet bitSet1 = bitSet.get(0, 3);
        System.out.println(bitSet1.toLongArray()[0]);


    }

    public static int[] sort(int[] question, int max) {
        int n = question.length;
        BitSet bitSet = new BitSet(max);
        for (int i = 0; i < n; i++) {
            bitSet.set(question[i]);
        }

        int[] result = new int[n];
        for (int i = 0, j = 0; i < max; i++) {
            if (bitSet.get(i)) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }

    public static char[] sort(char[] question, int max) {
        int n = question.length;
        BitSet bitSet = new BitSet(max);
        for (int i = 0; i < n; i++) {
            bitSet.set(question[i]);
        }

        char[] result = new char[n];
        for (char i = 0, j = 0; i < max; i++) {
            if (bitSet.get(i)) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }

    private static void checkOrder(int[] question) {
        int last = question[0];
        for (int i = 1, len = question.length; i < len; i++) {
            if (question[i] < last) {
                throw new RuntimeException("排序失败");
            }
            last = question[i];
        }
    }

    /**
     * 将数组随机打乱.
     *
     * @param target 要打乱的数组
     */
    public static void shuffle(int[] target) {
        final Random random = new Random();
        for (int i = 0, len = target.length; i < len; i++) {
            int j;
            do {
                j = (int) (random.nextDouble() * len);
            } while (i == j);

            // 交换两个位置.
            int io = target[i];
            target[i] = target[j];
            target[j] = io;

        }
    }
}
