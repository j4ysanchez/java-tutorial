import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        // === BASIC OPERATIONS ===
        int[] nums = {5, 2, 8, 1, 9, 3};
        System.out.println(Arrays.toString(nums));    // [5, 2, 8, 1, 9, 3]

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));    // [1, 2, 3, 5, 8, 9]

        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] slice = Arrays.copyOfRange(nums, 1, 4);
        System.out.println(Arrays.toString(copy));    // [1, 2, 3, 5, 8, 9]
        System.out.println(Arrays.toString(slice));   // [2, 3, 5]

        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println(Arrays.toString(filled));  // [7, 7, 7, 7, 7]

        int idx = Arrays.binarySearch(nums, 5);
        System.out.println("Index of 5: " + idx);    // 3

        // === LAMBDA COMPARATORS ===
        // Java 5: new Comparator<String>() { public int compare(String a, String b) { return b.compareTo(a); } }
        // Java 8+: (a, b) -> b.compareTo(a)
        String[] words = {"banana", "apple", "cherry", "date"};

        // Ascending natural order
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));   // [apple, banana, cherry, date]

        // Descending
        Arrays.sort(words, (a, b) -> b.compareTo(a));
        System.out.println(Arrays.toString(words));   // [date, cherry, banana, apple]

        // By length
        Arrays.sort(words, Comparator.comparing(String::length));
        System.out.println(Arrays.toString(words));   // [date, apple, banana, cherry]

        // By length, then alphabetically for ties
        Arrays.sort(words, Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println(Arrays.toString(words));   // [date, apple, banana, cherry]

        // === 2D ARRAYS ===
        int[][] grid = new int[3][3];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                grid[i][j] = i * 3 + j;
        System.out.println(Arrays.deepToString(grid)); // [[0, 1, 2], [3, 4, 5], [6, 7, 8]]

        // === int[] vs Integer[] ===
        // Lambda comparators require object types. Use Integer[] when you need custom sort on numeric data.
        Integer[] boxed = {5, 2, 8, 1};
        Arrays.sort(boxed, (a, b) -> b - a);           // descending via subtraction trick
        System.out.println(Arrays.toString(boxed));     // [8, 5, 2, 1]

        Arrays.sort(boxed, Comparator.reverseOrder());  // same result, more readable
        System.out.println(Arrays.toString(boxed));     // [8, 5, 2, 1]

        // --- Challenges ---
        // 1. Sort by length (shortest first) and print:
        //    String[] fruits = {"kiwi", "strawberry", "fig", "mango"};

        // 2. Find the second-largest WITHOUT sorting:
        //    int[] values = {3, 1, 4, 1, 5, 9, 2, 6};

        // 3. Merge two sorted arrays into one sorted array and print it:
        //    int[] a = {1, 3, 5, 7};
        //    int[] b = {2, 4, 6, 8};
        //    Expected: [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
