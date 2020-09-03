package cn.xuefei.leetcode;

/**
 * Author: xuefrye
 * Date: 2020/6/4 18:41
 * Version: 1.0
 * File: _75_颜色分类
 * Description:
 */
public class _75_颜色分类 {
    public void sortColors(int[] nums) {
        int L = -1;
        int R = nums.length;
        int i = 0;

        while(i<R){
            if(nums[i]<1){
                int temp = nums[L+1];
                nums[L+1] = nums[i];
                nums[i] = temp;
                i++;
                L++;
            }else if(nums[i] == 1){
                i++;
            }else{
                int temp = nums[R-1];
                nums[R-1] = nums[i];
                nums[i] = temp;
                R--;
            }
        }
    }

}
