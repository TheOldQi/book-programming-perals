package com.qixiafei.bookprogrammingperals.c2;

import com.qixiafei.bookprogrammingperals.c1.BitSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <P>Description: 2.1 三個問題 C問題. </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:    </P>
 * <P>CREATE DATE: 2019/4/16 18:06</P>
 * <P>UPDATE DATE: </P>
 *
 * @author qixiafei
 * @version 1.0
 * @since java 1.8.0
 */
public class QuestionC {


    public static void main(String[] args) {
        final List<String> question = new ArrayList<>();
        question.add("abc");
        question.add("bca");
        question.add("cab");
        question.add("ddfsaf");
        question.add("fsadfa");
        question.add("ddfsfa");
        question.add("ddfafs");
        question.add("ddsaff");
        question.add("dfsafd");
        question.add("fsafdd");
        question.add("abcd");
        question.add("efg");
        question.add("hijk");
        question.add("lmn");
        question.add("opq");
        question.add("rst");
        question.add("uvw");
        question.add("xyz");
        System.out.println(findAnagram(question));
    }


    public static List<List<String>> findAnagram(final List<String> question) {
        final Map<String, List<String>> groupMap = new HashMap<>();
        for (String word : question) {
            char[] sort = BitSort.sort(word.toCharArray(), Character.MAX_VALUE);
            final String sorted = new String(sort);
            List<String> group = groupMap.computeIfAbsent(sorted, k -> new ArrayList<>());
            group.add(word);

        }

        final List<List<String>> result = new ArrayList<>();
        for (List<String> item : groupMap.values()) {
            if (item.size() == 1) {
                continue;
            }
            result.add(item);
        }

        return result;
    }


}
