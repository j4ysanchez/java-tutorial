import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        // === PATTERN 1: FREQUENCY MAP ===
        // Use case: count occurrences, find duplicates, check anagrams
        System.out.println("=== Pattern 1: Frequency Map ===");

        int[] nums = {1, 2, 3, 1, 2, 1};
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }
        System.out.println(freq); // {1=3, 2=2, 3=1}

        int mostFrequent = freq.entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .get().getKey();
        System.out.println("Most frequent: " + mostFrequent); // 1

        // === PATTERN 2: TWO POINTER ===
        // Use case: sorted array pair problems, reverse in place, palindrome check
        System.out.println("=== Pattern 2: Two Pointer ===");

        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        int left = 0, right = sorted.length - 1;
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                System.out.println(sorted[left] + " + " + sorted[right] + " = " + target);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        // Prints: 1+9, 2+8, 3+7, 4+6

        // === PATTERN 3: SLIDING WINDOW ===
        // Use case: best subarray/substring of fixed size or under a constraint
        System.out.println("=== Pattern 3: Sliding Window ===");

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int windowSum = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i >= k) {
                windowSum -= arr[i - k]; // slide: drop the element leaving the window
            }
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        System.out.println("Max sum of window size " + k + ": " + maxSum); // 9

        // === PATTERN 4: TOP-K WITH PRIORITYQUEUE ===
        // Use case: kth largest/smallest element, k most frequent items
        System.out.println("=== Pattern 4: Top-K ===");

        int[] input = {1, 1, 1, 2, 2, 3};
        int topK = 2;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int n : input) counts.merge(n, 1, Integer::sum);

        // Min-heap of size k — the smallest-frequency entry gets evicted when we exceed k.
        // What remains after processing all entries are the k highest-frequency entries.
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> e : counts.entrySet()) {
            heap.offer(e);
            if (heap.size() > topK) heap.poll(); // evict lowest frequency
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) result.add(heap.poll().getKey());
        Collections.reverse(result); // heap gives lowest-freq first; reverse for highest-first
        System.out.println("Top " + topK + " frequent: " + result); // [1, 2]

        // --- Challenges ---
        // 1. (Frequency Map) Check if two strings are anagrams.
        //    "listen" and "silent" → true
        //    "hello"  and "world"  → false

        // 2. (Two Pointer) Given a sorted int[], find ALL unique pairs that sum to target.
        //    int[] a = {1, 1, 2, 3, 4, 5, 6, 7}; int target2 = 8;
        //    Expected: (1,7) (2,6) (3,5)   — skip duplicate pairs

        // 3. (Sliding Window) Find the length of the longest substring with no repeating characters.
        //    String s = "abcabcbb"; → 3  ("abc")
        //    Hint: use a HashMap<Character, Integer> mapping each char to its last seen index.
        //    When a duplicate is found, advance the window start past the previous occurrence.

        // 4. (Top-K) Find the k most frequent words, sorted by frequency desc then alpha for ties.
        //    String[] w = {"the","sky","is","blue","the","sky","is","sky"}; int k2 = 2;
        //    Expected: [sky, the]
    }
}
