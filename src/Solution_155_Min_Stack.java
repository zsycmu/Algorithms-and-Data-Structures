import java.util.Stack;

/**
 * 
 * Min Stack
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 */
/*
 * Notice: 1. 如果当前述小于等于最小堆站定元素的话都要push。而不是只有小于。
 *		   2. 如果栈是空栈，就返回0。
 */

public class Solution_155_Min_Stack {
	Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (minStack.peek() >= x) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        } else {
            int x = stack.pop();
            if (minStack.peek() == x) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            return 0;
        }
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return 0;
        }
    }
}
