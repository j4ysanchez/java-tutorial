import java.util.*;

public class Main {

    public static void main(String[] args) {

        // === ARRAYDEQUE AS STACK (LIFO) ===
        // Don't use java.util.Stack — it's legacy (extends synchronized Vector)
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());    // 3 (top, not removed)
        System.out.println(stack.pop());     // 3
        System.out.println(stack.pop());     // 2
        System.out.println(stack.size());    // 1
        System.out.println(stack.isEmpty()); // false

        // === ARRAYDEQUE AS QUEUE (FIFO) ===
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);   // enqueue at back
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());    // 1 (front, not removed)
        System.out.println(queue.poll());    // 1 (dequeue from front)
        System.out.println(queue.poll());    // 2
        System.out.println(queue.size());    // 1

        // === ARRAYDEQUE AS DOUBLE-ENDED DEQUE ===
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerFirst(0);
        // deque: [0, 1, 2]
        System.out.println(deque.peekFirst()); // 0
        System.out.println(deque.peekLast());  // 2
        System.out.println(deque.pollFirst()); // 0
        System.out.println(deque.pollLast());  // 2
        System.out.println(deque);             // [1]

        // === PRIORITYQUEUE (min-heap by default) ===
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5);
        minHeap.offer(2);
        minHeap.offer(8);
        minHeap.offer(1);
        System.out.println(minHeap.peek());  // 1 (minimum always at top)
        System.out.println(minHeap.poll());  // 1
        System.out.println(minHeap.poll());  // 2

        // Max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // equivalently: new PriorityQueue<>((a, b) -> b - a)
        maxHeap.offer(5);
        maxHeap.offer(2);
        maxHeap.offer(8);
        maxHeap.offer(1);
        System.out.println(maxHeap.peek());  // 8 (maximum at top)
        System.out.println(maxHeap.poll());  // 8
        System.out.println(maxHeap.poll());  // 5

        // PriorityQueue with custom objects sorted by a field
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // sort by element[1]
        pq.offer(new int[]{1, 3});
        pq.offer(new int[]{2, 1});
        pq.offer(new int[]{3, 2});
        System.out.println(Arrays.toString(pq.poll())); // [2, 1] — smallest element[1]=1
        System.out.println(Arrays.toString(pq.poll())); // [3, 2] — next smallest element[1]=2

        // --- Challenges ---
        // 1. Balanced parentheses:
        //    Return true if all brackets are balanced, false otherwise.
        //    "({[]})" → true
        //    "({[})"  → false
        //    Use an ArrayDeque as a stack.

        // 2. Sliding window maximum:
        //    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7}, k = 3
        //    Print the max value in each window of size k.
        //    Expected: [3, 3, 5, 5, 6, 7]
        //    Use a Deque<Integer> of indices — store indices of useful candidates only.

        // 3. Kth largest:
        //    int[] nums = {3, 2, 1, 5, 6, 4}, k = 2
        //    Find the kth largest element. Expected: 5
        //    Use a min-heap PriorityQueue of size k.
    }
}
