package stacks_queues;

import java.util.Stack;

/**
 * Created by srinivas on 2/7/17.
 *
 * Can not use any other data structure
 * but can use another stack
 *
 * Used a recursive solution to solve this problem
 */
public class StackSort {

    static MyStack<Integer> s1 = new MyStack<>();
    static MyStack<Integer> s2 = new MyStack<>();

    public static void main(String[] args) {
        s1.push(10);
        System.out.print(s1.peek() + " ");
        s1.push(12);
        System.out.print(s1.peek() + " ");
        s1.push(18);
        System.out.print(s1.peek() + " ");
        s1.push(8);
        System.out.print(s1.peek() + " ");
        s1.push(2);
        System.out.print(s1.peek() + " ");
        s1.push(1);
        System.out.print(s1.peek() + " ");
        s1.push(9);
        System.out.print(s1.peek() + " ");
        System.out.println();

        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(10);
        stack.push(45);
        stack.push(6);
        stack.push(18);

        while (!s1.isEmpty()) {
            stackSortRecursive(s1.pop());
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop() + " ");
        }

        Stack<Integer> res = new Stack<>();
        System.out.println();
        while(!stack.isEmpty()) {
            res = stackSortIterative(stack);
        }

        while(res == null || !res.isEmpty()) {
            System.out.print(res.pop() + " ");
        }

    }

    public static Stack<Integer> stackSortIterative(Stack<Integer> stack) {

//      I dont know why this is not working, if I use this check then
//      control should not enter the condition, but it is entering.
//      Hence I am checking it before passing stack
//      if(stack == null || !stack.isEmpty()) {
//          return stack;
//      }

        Stack<Integer> newStack = new Stack<>();
        newStack.push(stack.pop());

        while(!stack.isEmpty()) {
            int temp = stack.pop();
            while(!newStack.isEmpty() && temp > newStack.peek()) {
                stack.push(newStack.pop());
            }
            newStack.push(temp);

        }
        return newStack;
    }



    public static void stackSortRecursive(Integer data) {
        Integer val = s2.peek();
        if(val == null) {
            s2.push(data);
        } else if( val < data) {
            val = s2.pop();
            stackSortRecursive(data);
            stackSortRecursive(val);
        } else {
            s2.push(data);
        }
    }
}
