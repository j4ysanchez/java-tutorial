import java.util.*;

public class Main {

    public static void main(String[] args) {

        // === TREESET ===
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(2);
        set.add(8);
        set.add(1);
        set.add(9);
        set.add(4);
        System.out.println(set);               // [1, 2, 4, 5, 8, 9] — always sorted

        System.out.println(set.first());       // 1
        System.out.println(set.last());        // 9

        // floor/ceiling: inclusive (≤ and ≥)
        System.out.println(set.floor(6));      // 5 — greatest element ≤ 6
        System.out.println(set.ceiling(6));    // 8 — smallest element ≥ 6

        // lower/higher: strict (< and >)
        System.out.println(set.lower(5));      // 4 — greatest element < 5
        System.out.println(set.higher(5));     // 8 — smallest element > 5

        // Range views
        System.out.println(set.headSet(5));    // [1, 2, 4]    strictly < 5
        System.out.println(set.tailSet(5));    // [5, 8, 9]    >= 5
        System.out.println(set.subSet(2, 8));  // [2, 4, 5]    >= 2 and < 8

        // === TREEMAP ===
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("banana", 3);
        map.put("apple", 5);
        map.put("cherry", 1);
        map.put("date", 4);
        System.out.println(map);  // {apple=5, banana=3, cherry=1, date=4} — sorted by key

        System.out.println(map.firstKey());          // apple
        System.out.println(map.lastKey());           // date
        System.out.println(map.floorKey("c"));       // banana — greatest key ≤ "c"
        System.out.println(map.ceilingKey("c"));     // cherry — smallest key ≥ "c"
        System.out.println(map.lowerKey("cherry"));  // banana — strictly <
        System.out.println(map.higherKey("cherry")); // date   — strictly >

        // Range views — subMap/headMap/tailMap return live views of the map
        System.out.println(map.headMap("cherry"));         // {apple=5, banana=3}
        System.out.println(map.tailMap("cherry"));         // {cherry=1, date=4}
        System.out.println(map.subMap("banana", "date"));  // {banana=3, cherry=1}

        System.out.println(map.descendingKeySet()); // [date, cherry, banana, apple]

        // === CUSTOM COMPARATOR ===
        // TreeSet with sort order: by length, then alphabetically for ties
        TreeSet<String> byLength = new TreeSet<>(
            Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())
        );
        byLength.add("banana");
        byLength.add("apple");
        byLength.add("fig");
        byLength.add("date");
        System.out.println(byLength);       // [fig, date, apple, banana]
        System.out.println(byLength.first()); // fig
        System.out.println(byLength.last());  // banana

        // --- Challenges ---
        // 1. Find the closest event time to a query (floor or ceiling, whichever is nearer).
        //    If tied, pick the floor.
        //    int[] events = {10, 3, 7, 15, 1, 8}; int query = 6;
        //    Expected: 7 (floor=5... wait, 5 is not in events. floor=3, ceiling=7; |7-6|=1 < |3-6|=3 → 7)

        // 2. Count events between timestamps 5 and 12 (inclusive) using subMap.
        //    TreeMap<Integer, String> timeline:
        //    {1:"wake", 3:"breakfast", 7:"work", 10:"lunch", 15:"dinner"}
        //    Expected: 2 (work at 7, lunch at 10)

        // 3. Add these words to a TreeSet sorted by length then alphabetically, then print set + first/last:
        //    String[] words = {"cherry", "apple", "fig", "banana", "date"};
    }
}
