package cn.xuefei.剑指offer;

/**
 * @author: xuefei
 * @date: 2020-09-01
 * @version: 1.0
 * @description: TODO
 */
public class JZ1二维数组中的查找 {

    public class Solution {
        public boolean Find(int target, int[][] array) {
            int row = 0;
            int colum = array[0].length - 1;

            while (colum >= 0 && row < array.length) {
                if (array[row][colum] == target) return true;
                else if (array[row][colum] < target) row++;
                else colum--;
            }
            return false;
        }
    }

}
