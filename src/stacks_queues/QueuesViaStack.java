package stacks_queues;

import java.util.NoSuchElementException;

/**
 * Created by srinivas on 2/7/17.
 *
 * We can use 2 stacks
 */
public class QueuesViaStack {

    static MyStack<Integer> s1;
    static MyStack<Integer> s2;

    public QueuesViaStack() {
        s1 = new MyStack<>();
        s2 = new MyStack<>();
    }

    public void add(Integer data) {

        while (!s1.isEmpty()) {
            Integer item = s1.pop();
            s2.push(item);
        }
        s1.push(data);
        while (!s2.isEmpty()) {
            Integer item = s2.pop();
            s1.push(item);
        }
    }

    public Integer remove() {
        if(s1.isEmpty()) {
            throw new NoSuchElementException();
        }
        Integer item = s1.pop();
        return item;
    }

    public Integer peek() {

        Integer item = s1.peek();
        return item;
    }

    public static void main(String[] args) {

        QueuesViaStack queue = new QueuesViaStack();

        queue.add(10);
        queue.add(12);
        queue.add(18);
        queue.add(16);
        queue.add(7);
        queue.add(1);

        boolean val = true;

        while(val) {
            Integer item = queue.peek();
            if(item == null) {
                val = false;
            } else {
                System.out.print(queue.remove() + " ");
            }
        }
    }

}
