import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date", "fig", "avocado");

        // === FILTER & COLLECT ===
        List<Integer> evens = nums.stream()
            .filter(n -> n % 2 == 0)            // filter even numbers
            .collect(Collectors.toList());      // turn this into a list
        System.out.println(evens);  // [4, 2, 6]

        // === MAP ===
        List<Integer> doubled = nums.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
        System.out.println(doubled);

        // Method reference shorthand for lambdas with one argument calling one method
        List<String> upper = words.stream()
            .map(String::toUpperCase)          // same as w -> w.toUpperCase()
            .collect(Collectors.toList());
        System.out.println(upper);

        // === MAPTOINT: numeric aggregation ===
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        double avg = nums.stream().mapToInt(Integer::intValue).average().orElse(0);
        int max = nums.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("sum=" + sum + " avg=" + avg + " max=" + max);

        // === DISTINCT, SORTED, LIMIT ===
        List<Integer> topThreeUnique = nums.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println(topThreeUnique);   // [9, 6, 5]

        // === COUNT, ANYMATCH, ALLMATCH ===
        long evenCount = nums.stream().filter(n -> n % 2 == 0).count();
        boolean anyNeg  = nums.stream().anyMatch(n -> n < 0);
        boolean allPos  = nums.stream().allMatch(n -> n > 0);
        System.out.println("evenCount=" + evenCount + " anyNeg=" + anyNeg + " allPos=" + allPos);
        // evenCount=3 anyNeg=false allPos=true

        // === REDUCE ===
        int product = nums.stream().reduce(1, (a, b) -> a * b);
        System.out.println("product=" + product);

        // === COLLECTORS.JOINING ===
        String joined = words.stream().collect(Collectors.joining(", "));
        System.out.println(joined);  // banana, apple, cherry, date, fig, avocado

        // === COLLECTORS.GROUPINGBY ===
        // banana=6, apple=5, cherry=6, date=4, fig=3, avocado=7
        Map<Integer, List<String>> byLength = words.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println(byLength);  // {3=[fig], 4=[date], 5=[apple], 6=[banana, cherry], 7=[avocado]}

        Map<Integer, Long> countByLength = words.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(countByLength); // {3=1, 4=1, 5=1, 6=2, 7=1}

        // === SORTED WITH COMPARATOR.COMPARING ===
        List<String> sortedWords = words.stream()
            .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
            .collect(Collectors.toList());
        System.out.println(sortedWords); // [fig, date, apple, banana, cherry, avocado]

        // === OPTIONAL ===
        Optional<String> miss = words.stream().filter(w -> w.startsWith("z")).findFirst();
        System.out.println(miss.isPresent());    // false
        System.out.println(miss.orElse("none")); // none

        Optional<String> hit = words.stream().filter(w -> w.startsWith("a")).findFirst();
        System.out.println(hit.get());           // apple
        hit.ifPresent(w -> System.out.println("Found: " + w)); // Found: apple

        // --- Challenges ---
        // 1. From nums, collect a sorted list of UNIQUE even numbers.
        //    Expected: [2, 4, 6]

        // 2. From words, find the longest string.
        //    Expected: avocado

        // 3. From words, group by length into Map<Integer, List<String>>,
        //    then print each group's words sorted alphabetically.
    }
}
