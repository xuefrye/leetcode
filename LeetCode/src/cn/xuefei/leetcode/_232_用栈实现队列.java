package cn.xuefei.leetcode;

import java.util.Stack;

/**
 * Author: xuefrye
 * Date: 2020/5/29 1:54
 * Version: 1.0
 * File: _232_用栈实现队列
 * Description:
 */
public class _232_用栈实现队列 {
    class MyQueue {
        Stack<Integer> inStack = new Stack<Integer>();
        Stack<Integer> outStack = new Stack<Integer>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            inStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (outStack.size() == 0) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }

            return outStack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (outStack.size() == 0) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }

            return outStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }

}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
