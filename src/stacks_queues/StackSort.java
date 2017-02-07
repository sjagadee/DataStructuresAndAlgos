package stacks_queues;

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

        while (!s1.isEmpty()) {
            isMax(s1.pop());
        }

        while (!s2.isEmpty()) {
            System.out.print(s2.pop() + " ");
        }

    }

    public static void isMax(Integer data) {
        Integer val = s2.peek();
        if(val == null) {
            s2.push(data);
        } else if( val < data) {
            val = s2.pop();
            isMax(data);
            isMax(val);
        } else {
            s2.push(data);
        }
    }
}
