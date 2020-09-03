package cn.xuefei.剑指offer;

/**
 * @author: xuefei
 * @date: 2020-09-02
 * @version: 1.0
 * @description: TODO
 */
public class JZ7斐波那契数列 {
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int n1 = 0;
        int n2 = 1;
        n = n - 1;
        while (n-- > 0) {
            int temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }

        return n2;
    }

    public static void main(String[] args) {
        JZ7斐波那契数列 solution = new JZ7斐波那契数列();
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.Fibonacci(i));
        }
    }
}
