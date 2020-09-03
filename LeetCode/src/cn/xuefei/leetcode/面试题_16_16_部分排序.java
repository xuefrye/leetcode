package cn.xuefei.leetcode;

import java.util.TreeMap;

/**
 * Author: xuefrye
 * Date: 2020/6/5 7:41
 * Version: 1.0
 * File: 面试题_16_16_部分排序
 * Description:
 */
public class 面试题_16_16_部分排序 {
    TreeMap treeMap;
    public int[] subSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{-1, -1};
        }
        int asdfsa = 1;

        //找出最远逆序对
        int max = array[0];
        int min = array[array.length - 1];
        int reverseIndex = -1;
        int reverseIndexDesc = -1;

        for (int i = 0; i < array.length; i++) {
            //更新最大值
            if (array[i] > max) {
                max = array[i];
            }

            //更新最远逆序对的索引
            if (array[i] < max) {
                reverseIndex = i;
            }
        }

        //没有逆序对直接返回结果.
        if (reverseIndex == -1) {
            return new int[]{-1, -1};
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > min) {
                reverseIndexDesc = i;
            }
        }

        return new int[]{reverseIndexDesc,reverseIndex};
    }
}
