package cn.xuefei.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xuefrye
 * Date: 2020/6/14 16:41
 * Version: 1.0
 * File: _46_全排列
 * Description:
 */
public class _46_全排列 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> permuteList = new ArrayList<>();
        used = new boolean[nums.length];

        dfs(nums,permuteList);

        return ans;
    }

    void dfs(int[] nums, List<Integer> permuteList){
        if(permuteList.size() == nums.length){
            ans.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            permuteList.add(nums[i]);
            used[i] = true;
            dfs(nums,permuteList);
            used[i] = false;
            permuteList.remove(permuteList.size()-1);
        }
    }
}
