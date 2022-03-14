package com.go.leet_code.net;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description: 739 请根据每日气温列表，重新生成一个列表，对应位置的输出为：要想观测到更高的气温，至少需要等待的天数，如果气温在这之后都不会升高，则在该位置用0来位置
 * Created on 2021/12/1.
 * 单调栈算法
 *
 * @author go
 */
public class LeC739 {

    public static void main(String[] args) {
        int[] arr = new int[]{73,74,75,71,69,72,76,73};
        int[] sort = sort(arr);
        System.out.println("sort = " + Arrays.toString(sort));
    }

    private static int[] sort(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

}
