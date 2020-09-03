package cn.xuefei.剑指offer;

/**
 * @author: xuefei
 * @date: 2020-09-02
 * @version: 1.0
 * @description: TODO
 */
public class JZ8跳台阶 {
    public int JumpFloor(int target) {
        if(target == 0) return 1;
        if(target == 1) return 1;

        int n1 = 1;
        int n2 = 1;
        target--;
        while(target-- >0){
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }
        return n2;
    }
}
