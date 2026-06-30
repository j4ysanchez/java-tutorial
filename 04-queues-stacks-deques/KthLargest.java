import java.util.PriorityQueue;

public class KthLargest {
        // 3. Kth largest:
        //    int[] nums = {3, 2, 1, 5, 6, 4}, k = 2
        //    Find the kth largest element. Expected: 5
        //    Use a min-heap PriorityQueue of size k.

    public static void main(String[] args) {

        int[] nums ={3,2,1,5,6,4};
        int k = 2;

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // for (int num : nums) {
        //     minHeap.offer(num);
        // }

        // for (int i = 0; i < nums.length-k; i++) {
        //     minHeap.poll();
        // }

        // System.out.println(minHeap.poll());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {

            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                // 3
                // 2-3

                // 1 -> 2-3 //discard
                // 5 -> 2-3
                // 6 -> 3-5
                // 4 -> 5-6

                if (num < minHeap.peek()) {
                    continue;
                } else {
                    minHeap.poll(); 
                    minHeap.offer(num);
                }
            }
        }

        System.out.println(minHeap.peek());

    }
}
