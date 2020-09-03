package cn.xuefei.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: xuefrye
 * Date: 2020/6/9 11:41
 * Version: 1.0
 * File: _239_滑动窗口最大值
 * Description:
 */
public class _239_滑动窗口最大值 {
    Deque<Integer> deque = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length == 0 || k == 0) return null;
        if(k==1) return nums;

        int[] arr = new int[nums.length - (k - 1)];
        int arrIndex = 0;

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) { // 当宽度还没达到k时
                addAndEnsureMono(deque, nums, i);
            } else { //宽度已经达到k
                addAndEnsureMono(deque, nums, i);
                ensureUpToDate(deque,i-(k-1));
                arr[arrIndex++] = nums[deque.peekFirst()];
            }
        }

        return arr;
    }

    //加入时确保队列单调
    public void addAndEnsureMono(Deque<Integer> deque, int[] nums, int index) {
        if (deque.size() == 0) {//如果没有元素
            deque.addLast(index);//加入下标
        } else if (nums[deque.peekLast()] <= nums[index]) {//扫描的值大于等于队列尾部,开始弹出.
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[index]) {
                deque.pollLast();
            }
            deque.addLast(index);
        }else{
            deque.addLast(index);
        }
    }

    //确保队列头元素没有过期
    public void ensureUpToDate(Deque<Integer> deque, int headIndex) {
        while (deque.size() > 0 && deque.peekFirst() < headIndex) {
            deque.pollFirst();
        }
    }

    public static void main(String[] args) {
       _239_滑动窗口最大值 problem =  new _239_滑动窗口最大值();

       problem.maxSlidingWindow(new int[]{7,2,4},2);
    }
}
