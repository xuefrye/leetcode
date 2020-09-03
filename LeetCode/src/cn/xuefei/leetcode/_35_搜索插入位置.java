package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/13 21:32
 * Version: 1.0
 * File: _35_搜索插入位置
 * Description:
 */
public class _35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    //减而治之
    public int searchInsert1(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
//        System.out.printf("%d\t%d\n",left,nums[left]);
//        return nums[left] < target ? left + 1: left ;
    }

    public int searchInsert2(int[] nums, int target) {
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 严格小于 target 的元素一定不是解
            if (nums[mid] < target) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        _35_搜索插入位置 p =  new _35_搜索插入位置();
        System.out.println(p.searchInsert1(new int[]{1, 3, 4, 6}, 77));
        System.out.println(p.searchInsert2(new int[]{1, 3, 4, 6}, 77));
    }
}
