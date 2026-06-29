import java.util.*;

public class Main {

    public static void main(String[] args) {

        // === ARRAYLIST ===
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add(1, "avocado");              // insert at index 1
        System.out.println(list);            // [apple, avocado, banana, cherry]
        System.out.println(list.get(2));     // banana
        System.out.println(list.size());     // 4
        System.out.println(list.contains("banana")); // true

        list.remove("banana");               // remove by value
        list.remove(0);                      // remove by index
        System.out.println(list);            // [avocado, cherry]

        Collections.sort(list);
        System.out.println(list);            // [avocado, cherry]
        Collections.reverse(list);
        System.out.println(list);            // [cherry, avocado]


        System.out.println("--------- HashMap ---------");
        // === HASHMAP ===
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 92);
        System.out.println(scores.get("Alice"));       // 90
        System.out.println(scores.get("Unknown"));     // null

        // Java 5: if (map.get(k) == null) { map.put(k, default); }
        // Java 8+:
        scores.getOrDefault("Dave", 0);                // 0 — does NOT insert
        scores.putIfAbsent("Alice", 100);              // ignored — Alice already exists
        scores.putIfAbsent("Dave", 70);                // inserted — Dave was missing
        System.out.println(scores.get("Dave"));        // 70

        scores.merge("Alice", 5, Integer::sum);        // Alice: 90 + 5 = 95
        System.out.println(scores.get("Alice"));       // 95


        System.out.println("--------- Frequency Counting ---------");
        // Frequency counting with merge — the standard pattern
        String[] words = {"the", "cat", "sat", "on", "the", "mat", "the"};
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.merge(w, 1, Integer::sum);
        }
        System.out.println(freq); // {the=3, cat=1, sat=1, on=1, mat=1}

        System.out.println("--------- Iterate Entries ---------");
        // Iterate entries — two styles
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        freq.forEach((k, v) -> System.out.println(k + ": " + v)); // same, shorter

        System.out.println("--------- ComputeIfAbsent ---------");
        // computeIfAbsent: map of lists pattern
        String[] allWords = {"the", "cat", "sat", "on", "the", "mat", "the"};
        Map<Integer, List<String>> byLength = new HashMap<>();
        for (String w : allWords) {
            byLength.computeIfAbsent(w.length(), key -> new ArrayList<>()).add(w);
        }
        System.out.println(byLength); // {2=[on], 3=[the, cat, sat, the, mat, the]}


        System.out.println("--------- HashSet ---------");
        // === HASHSET ===
        Set<String> seen = new HashSet<>();
        seen.add("apple");
        seen.add("banana");
        seen.add("apple");               // duplicate — silently ignored
        System.out.println(seen.size()); // 2
        System.out.println(seen.contains("apple")); // true

        boolean isNew = seen.add("cherry"); // true — was not present
        boolean isDup = seen.add("apple");  // false — already present
        System.out.println(isNew + " " + isDup); // true false

        // --- Challenges ---
        // 1. Count the frequency of each character in "programming".
        //    Print each character and its count.

        // 2. Two Sum: find indices of two numbers that add up to target.
        //    int[] nums = {2, 7, 11, 15}; int target = 9;
        //    Expected output: 0 1
        //    Hint: store (value -> index) in a HashMap as you iterate.

        // 3. Find duplicates: print words that appear more than once.
        //    String[] input = {"cat", "dog", "cat", "bird", "dog", "dog"};
        //    Expected: cat, dog (order doesn't matter)
    }
}
