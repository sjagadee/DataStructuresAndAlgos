package sorting_searching;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by srinivas on 2/23/17.
 *
 *
 */
public class MergeKSortedArrays {

    // this solution takes O(Kn * log Kn) time complexity
    // We need to think if we can do better
    public static int[] mergeKArray(int[][] array) {
        int size = 0;
        for(int i = 0; i < array.length; i ++) {
            size += array[i].length;
        }
        int[] result = new int[size];

        int counter = 0;
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                result[counter] = array[i][j];
                counter++;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{10, 18, 22}, {19, 28, 32}, {1, 8, 29}};
        int[] res = merge(array);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }

    // this would implement it in O(kn log(n)) time complexity
    public static int[] merge(int[][] array) {
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        int size = 0;
        for(int i = 0; i < array.length; i++) {
            size += array[i].length;
            if(array[i].length > 0) {
                pq.add(new QueueNode(i, 0, array[i][0]));
            }
        }

        int[] result = new int[size];
        int counter = 0;
        while(!pq.isEmpty()) {
            QueueNode curNode = pq.poll();
            result[counter] = curNode.arrayValue;
            int newIndex = curNode.currentIndex +1;
            if(newIndex < array[curNode.arrayIndex].length) {
                pq.add(new QueueNode(curNode.arrayIndex, newIndex, array[curNode.arrayIndex][newIndex]));
            }
            counter++;
        }
        return result;
    }
}

class QueueNode implements Comparable<QueueNode> {
    int arrayIndex;
    int currentIndex;
    int arrayValue;

    public QueueNode(int arrayIndex, int currentIndex, int arrayValue) {
        this.arrayIndex = arrayIndex;
        this.currentIndex = currentIndex;
        this.arrayValue = arrayValue;
    }

    @Override
    public int compareTo(QueueNode node) {
        if(arrayValue > node.arrayValue) return 1;
        if(arrayValue < node.arrayValue) return -1;
        return 0;
    }
}
