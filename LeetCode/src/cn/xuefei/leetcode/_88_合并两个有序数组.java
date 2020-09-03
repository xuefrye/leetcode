package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/4 15:13
 * Version: 1.0
 * File: _88_合并两个有序数组
 * Description:
 */
public class _88_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i<m && j<n){
            if(nums1[i] < nums2[j]){
                temp[k++] = nums1[i++];
            }else{
                temp[k++] = nums2[j++];
            }
        }

        while(i<m){
            temp[k++] = nums1[i++];
        }

        while(j<n){
            temp[k++] = nums2[j++];
        }

        System.arraycopy(temp, 0, nums1, 0, temp.length);
    }

    /**
     * 最简做法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;

        while(j>=0 && i>=0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}
