package stacks_queues;

/**
 * Created by srinivas on 2/7/17.
 *
 * Implementation MyStack and NewStack(getting min in O(1))
 */
public class StackDemo {

    private static MyStack<Integer> myStack = new MyStack<>();
    private static NewStack minStack = new NewStack();

    public static void main(String[] args) {

        myStackDemo();
        minStackDemo();

    }

    private static void minStackDemo() {

        minStack.push(10);
        System.out.print(minStack.peek() + " ");
        minStack.push(11);
        System.out.print(minStack.peek() + " ");
        minStack.push(80);
        System.out.print(minStack.peek() + " ");
        minStack.push(13);
        System.out.print(minStack.peek() + " ");
        minStack.push(6);
        System.out.print(minStack.peek() + " ");
        minStack.push(2);
        System.out.print(minStack.peek() + " ");
        minStack.push(60);
        System.out.print(minStack.peek() + " ");

        System.out.println();

        while(!minStack.isEmpty()) {
            System.out.println("popped value: " + minStack.pop().intValue() + " current min: " + minStack.min());
        }
    }

    private static void myStackDemo() {

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);
        myStack.push(60);

        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop().intValue() + " ");
        }
        System.out.println();
    }

}
