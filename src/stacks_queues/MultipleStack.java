package stacks_queues;

/**
 * Created by srinivas on 2/6/17.
 *
 * We have one array we need to add multiple stacks in that single array
 *
 * topOfStack = {-1, -1, -1}
 *
 */
public class MultipleStack {
   int[] topOfStack;
   int[] dataElements;
   int[] nextIndex;

   int nextAvailable = 0;

   // stackNum = no of stacks
   // capacity = is the size of the array which we can go on adding values
   public MultipleStack(int stackNum, int capacity) {
       topOfStack = new int[stackNum];
       for(int i = 0; i < topOfStack.length; i++) {
           topOfStack[i] = -1;
       }
       dataElements = new int[capacity];
       nextIndex = new int[capacity];
       for(int i = 0; i < nextIndex.length -1; i++) {
           nextIndex[i] = i+1;
       }
       // we are setting last element with -1 (that means we cannot add any more data)
       nextIndex[nextIndex.length -1] = -1;
    }


    public void push(int stackNum, int value) {
       if(stackNum < 0 || stackNum >= topOfStack.length) {
           throw new IndexOutOfBoundsException();
       }

       // if nextAvailable is less than 0 then we cannot push any new elements
       if(nextAvailable < 0) {
           return;
       }

       int currentIndex = nextAvailable;
       dataElements[currentIndex] = value;
       nextAvailable = nextIndex[currentIndex];
       nextIndex[currentIndex] = topOfStack[stackNum];
       topOfStack[stackNum] = currentIndex;

    }

    public int pop(int stackNum) {
       if(stackNum < 0 || stackNum >= topOfStack.length || topOfStack[stackNum] == -1) {
           throw new IndexOutOfBoundsException();
       }
       int currentIndex = topOfStack[stackNum];
       int elementToBePopped = dataElements[currentIndex];
       topOfStack[stackNum] = nextIndex[currentIndex];
       nextIndex[currentIndex] = nextAvailable;
       nextAvailable = currentIndex;
       return elementToBePopped;
    }

}
