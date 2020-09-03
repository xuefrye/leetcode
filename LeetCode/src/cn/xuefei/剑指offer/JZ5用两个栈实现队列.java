package cn.xuefei.剑指offer;

import java.util.Stack;

/**
 * @author: xuefei
 * @date: 2020-09-02
 * @version: 1.0
 * @description: TODO
 */
public class JZ5用两个栈实现队列 {
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            stack1.push(node);
        }

        public int pop() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
