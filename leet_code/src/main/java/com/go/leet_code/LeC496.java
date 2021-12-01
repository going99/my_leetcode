package com.go.leet_code;

/**
 * Description: (下一个更大元素)-简单
 * 给定两个没有重复元素的数组 nums1与 nums2,其中 nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中的数字x的下一个更大元素是指 x 的 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1
 * <p>
 * 示例1：
 * 输入nums1=[4,1,2],nums2=[1,3,4,2]
 * 输出 [-1,3,-1]
 * 解释：对于nums1 中的那数字4，你无法在第二个数组中找到下一个更大的数字，因此输出-1；
 * 对于nums1中的数字1，第二个数组中数字1右边的下一个较大的数字是3;
 * 对于nums1中的数字2，第二个数组中没有下一个更大的数字，因此输出-1.
 * Created on 2021/12/1.
 *
 * @author go
 */
public class LeC496 {

    private static void printArr(int[] arr) {
        if (null == arr) {
            return;
        }
        for (int i : arr) {
            System.out.println(" " + i);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] element = nextMoreGreaterElement(nums1, nums2);
        printArr(element);
    }

    /**
     * 生成下一个更大的元素
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static int[] nextMoreGreaterElement(int[] nums1, int[] nums2) {

        return null;
    }

}
