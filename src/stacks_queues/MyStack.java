package stacks_queues;

import java.util.EmptyStackException;

/**
 * Created by srinivas on 2/6/17.
 *
 * This is my basic stack implementation
 */
public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data){
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(T data) {
        StackNode<T> t = new StackNode<T>(data);
        t.next = top;
        top = t;
    }

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if(top == null) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

