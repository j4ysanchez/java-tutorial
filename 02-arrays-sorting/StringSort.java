import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
    // 1. Sort `String[] fruits = {"kiwi", "strawberry", "fig", "mango"}` by length (shortest first). Print the result.

    public static void main(String[] args) {

        String[] fruits = {"kiwi", "strawberry", "fig", "mango"};

        Arrays.sort(fruits, Comparator.comparing(String::length));

        System.out.println(Arrays.toString(fruits));

        // Arrays.sort(fruits, Comparator.comparing(String::length).reversed().thenComparing(Comparator.reverseOrder()));

        // System.out.println(Arrays.toString(fruits));
    }
}
