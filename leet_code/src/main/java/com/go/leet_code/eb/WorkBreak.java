package com.go.leet_code.eb;

import cn.hutool.core.collection.CollectionUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Description: WorkBreak
 * Created on 2022/5/25.
 * <p>
 * Given a string s and a dictionary of words dict, determine if s can be segmented into
 * a space-separated sequence of one or more dictionary words. For example, given s =
 * "leetcode", dict = ["leet", "code"]. Return true because "leetcode" can be segmented as
 * "leet code".
 *
 * @author go
 */
public class WorkBreak {

    public static void main(String[] args) {
        String s = "programcreek";
        HashSet<String> dict = CollectionUtil.set(false, "programcree", "program", "creek");
        boolean b = wordBreakHelper(s, dict, 0);
        System.out.println("b = " + b);
        boolean b1 = dynamicProgramWordBreak(s, dict);
        System.out.println("b1 = " + b1);
    }

    public static boolean wordBreakHelper(String s, Set<String> dict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (String a : dict) {
            int len = a.length();
            int end = start + len;
            //end index should be <= string length
            if (end > s.length()) {
                continue;
            }
            if (s.substring(start, start + len).equals(a)) {
                if (wordBreakHelper(s, dict, start + len)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dynamicProgramWordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        //set first to be true, why?
        //Because we need initial state
        for (int i = 0; i < s.length(); i++) {
            //should continue from match position
            if (!t[i]) {
                continue;
            }
            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length()) {
                    continue;
                }
                if (t[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }
        return t[s.length()];
    }

}
