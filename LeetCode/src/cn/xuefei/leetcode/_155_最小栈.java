package cn.xuefei.leetcode;

import java.util.Stack;

/**
 * Author: xuefrye
 * Date: 2020/6/9 11:26
 * Version: 1.0
 * File: _155_最小栈
 * Description:
 */
public class _155_最小栈 {
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if(stack.size()==0){
                stack.push(x);
                minStack.push(x);
            }else{
                stack.push(x);
                Integer min = minStack.peek();
                if(x<min){
                    minStack.push(x);
                }else{
                    minStack.push(min);
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
