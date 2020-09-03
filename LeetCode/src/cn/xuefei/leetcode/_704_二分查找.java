package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/14 0:49
 * Version: 1.0
 * File: _704_二分查找
 * Description:
 */
public class _704_二分查找 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l] == target ? l : -1;
    }
}
