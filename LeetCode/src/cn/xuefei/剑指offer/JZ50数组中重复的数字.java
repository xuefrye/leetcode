package cn.xuefei.剑指offer;

import java.util.HashMap;

/**
 * @author: xuefei
 * @date: 2020-08-31
 * @version: 1.0
 * @description: TODO
 */
public class JZ50数组中重复的数字 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            if(!map.containsKey(number)){
                map.put(number,1);
            }else{
                duplication[0] = number;
                return true;
            }
        }

        return false;
    }
}
