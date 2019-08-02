package com.qixiafei.bookprogrammingperals.c2;

import java.util.BitSet;

/**
 * <P>Description: 2.1 三個問題 B問題 将给定n个字符数组进行向左i位移位，越位字母从右侧补齐，例如abc移位2，结果cab，要求时间复杂度为字母数组长度，
 * 并且只使用几十字节的额外存储. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:    </P>
 * <P>CREATE DATE: 2019/4/16 16:58</P>
 * <P>UPDATE DATE: </P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class PractiseB {

    public static void main(String[] args) {

        final String question = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0, len = question.length(); i < len; i++) {
            System.out.println("移位：" + i);
            char[] chars = question.toCharArray();
            System.out.println("结果：" + new String(moveLeft(chars, i)));
            char[] chars2 = question.toCharArray();
            aba(chars2, i);
            System.out.println("结果：" + new String(chars2));

        }
    }

    /**
     * 将字符串中字符向左旋转n位.
     *
     * @param array 原字符串
     * @param n     移位数
     * @return 移位后的字符串
     */
    public static char[] moveLeft(char[] array, int n) {
        int len = array.length;
        int mod = n % len;
        if (mod == 0) {
            return array;
        }
        int times = 0;
        BitSet used = new BitSet(mod);

        for (int i = 0; i < mod; i++) {
            if (used.get(i)) {
                continue;
            }
            int start = len - mod + i;
            if (start < mod) {
                used.set(start);
            }
            char targetVal;
            char cache = array[start];
            array[start] = array[i];
            times++;
            for (int target = (start - mod) < 0 ? len + (start - mod) : (start - mod); ; target = (target - mod) < 0 ? len + (target - mod) : (target - mod)) {
                if (target == start) {
                    break;
                }
                if (target < mod) {
                    used.set(target);
                }
                targetVal = array[target];
                array[target] = cache;
                cache = targetVal;
                times++;
            }
        }

        System.out.println("时间复杂度：" + times);
        return array;
    }


    /**
     * 用ab交换成ba的思想递归解法.
     *
     * @param array 待移位目标数组
     * @param i     移位数
     */
    public static void aba(char[] array, int i) {
        if (i == 0) {
            return;
        }
        internalAba(array, i, 0, array.length, true);
    }

    /**
     * 内部aba解法递归方法.
     *
     * @param array    待移位数组
     * @param i        移位数量
     * @param start    开始操作索引
     * @param end      终止操作索引
     * @param positive 是否正向 true，每次移位end-i移位完毕，递归向左侧收紧，false则想反
     */
    private static void internalAba(char[] array, int i, int start, int end, boolean positive) {
        // 剩余待处理字母数量
        int length = end - start;

        if (length <= i) {
            return;
        }

        // 如果移位数量刚好在字母中间，一次交换即结果.
        if (i == (length - i)) {
            exchange(array, i, start, end - i);
            return;
        }

        // 如果移位数量超过了待处理字母数量一半，将较小的一部分作为新的移位数量，并翻转方向
        // 是否翻转标识
        boolean reverse = false;
        if (i > (length - i)) {
            i = length - i;
            reverse = true;
        }

        exchange(array, i, start, end - i);

        if (positive == reverse) {
            // 若方向正，需要翻转，则接下来逆向递归，若方向反，不需要翻转，接下来也是逆向递归
            internalAba(array, i, start + i, end, false);
        } else {
            internalAba(array, i, start, end - i, true);
        }

    }

    /**
     * 将array数组从start1 到 start1+n 的元素和 start2 到 start2+n 的元素交换位置，不使用额外空间.
     *
     * @param array  待处理数组
     * @param n      移位数量
     * @param start1 左侧交换元素起点
     * @param start2 右侧交换元素起点
     */
    private static void exchange(char[] array, int n, int start1, int start2) {
        char temp;
        for (int i = 0; i < n; i++) {
            temp = array[start1 + i];
            array[start1 + i] = array[start2 + i];
            array[start2 + i] = temp;
        }
    }
}
