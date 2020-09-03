package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/15 14:20
 * Version: 1.0
 * File: _34_在排序数组中查找元素的第一个和最后一个位置
 * Description:
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int l = 0;
        int r = nums.length - 1;

        //找左边界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                r = mid - 1;
            }
        }

        // 如果没有找到target说明没有边界一说
        if (l  >= nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        int lBorder = l;

        l = 0;
        r = nums.length - 1;
        //找右边界
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int rBorder = r;

        return new int[]{lBorder,rBorder};
    }

    public static void main(String[] args) {
        _34_在排序数组中查找元素的第一个和最后一个位置 p = new _34_在排序数组中查找元素的第一个和最后一个位置();

        int[] arr = new int[]{2,2};
        int[] ans = p.searchRange(arr, 1);
        System.out.printf("%d,%d",ans[0],ans[1]);
    }
}
