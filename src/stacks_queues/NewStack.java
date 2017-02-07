package stacks_queues;

/**
 * Created by srinivas on 2/7/17.
 *
 * get minimum value in the stack at any given time with O(1) time complexity
 *
 * This solution would create a stack which would contain min value, when we push
 * a new value it would check against the min value stack and push the min value,
 * into the stack, if the value popped is the min value, we should pop the value from the stack too.
 */
public class NewStack extends MyStack<Integer> {
    MyStack<Integer> stack;

    public NewStack() {
        stack = new MyStack<>();
    }

    public void push(Integer value) {

        // checking if the value to be pushed is less than or equal to the min
        // and then pushing it to the stack
        if(value <= min()) {
            stack.push(value);
        }
        super.push(value);
    }


    public Integer pop() {

        // checking if the popped value is equal to the current min in the stack
        // if so, then popping the current min present in the stack too
        Integer value = super.pop();
        if(value == min()) {
            stack.pop();
        }
        return value;
    }


    public Integer min() {
        // checking if the stack is empty, if so then returning the max value
        if(stack.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        // if the stack is not empty, then getting the top of the stack
        else {
            return stack.peek();
        }
    }

}
