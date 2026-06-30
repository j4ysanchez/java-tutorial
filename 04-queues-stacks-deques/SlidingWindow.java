import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Collections;
public class SlidingWindow {
    /*
    * 2. **Sliding window maximum**: given `int[] nums = {1,3,-1,-3,5,3,6,7}` and `k = 3`, 
    * print the maximum in each window of size k. 
    * Expected: `[3, 3, 5, 5, 6, 7]`. Use a `Deque` of indices to solve in O(n).
     */

    public static void main(String[] args) {

        int[] nums = {1, 3, -1,-3,5,3,6,7};
        int k = 3;

        // Deque<Integer> window = new ArrayDeque<>();

        // for (int i = 0; i < nums.length-2; i++) {
        //     window.offer(nums[i]);
        //     window.offer(nums[i+1]);
        //     window.offer(nums[i+2]);
        //     findMax(window);

        //     window.pollFirst();

        // }

        Deque<Integer> indices = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            while(!indices.isEmpty() && nums[indices.peekLast()] < nums[i]) {
                indices.pollLast();
            }
            indices.offerLast(i); 
            // i = 0 [0]
            // i = 1 [1] (val=3)
            // i = 2 [1,2] (val = 3, -1)
            // i = 3 val = -3 [1,2,3]
            // i = 4 val = 5 [4]
            // i = 5 val = 3 [4,5]

            
            
            if (indices.peekFirst() != null && indices.peekFirst() <= i-k) {
                indices.pollFirst();
            }

            // i = 3 val = -3 [1,2,3]
            // i = 5 val = 3 [4,5]


            if ( i >= k - 1) {
                System.out.println(nums[indices.peekFirst()]);
                // i=2 print nums[1]=3
                // i=3 print nums[1]=3
                // i=4 print nums[4]=5
                // i=5 print nums[4]=5
            }
        }

        // System.out.println(indices);


    }

    static int findMax(Deque<Integer> deque) {

        int max = Integer.MIN_VALUE;

        for (int number : deque) {
            if (number > max) {
                max = number;
            }
        }        

        System.out.printf("Max: %d%n", max);

        return max;
    }
}
