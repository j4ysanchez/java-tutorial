import java.util.Arrays;
import java.util.Comparator;

public class IntSearch {
    
    // 2. Find the second-largest number in `int[] values = {3, 1, 4, 1, 5, 9, 2, 6}` without sorting.

    public static void main(String args[]) {
        int[] intArray = {3, 1, 4, 1, 5, 9, 2, 6};

        int largest = 0;
        int secondLargest = largest;

        for (int i : intArray) {

            System.out.printf("Current int is %d, largest=%d, secondLargest=%d %n", i, largest, secondLargest);
            if (i > largest) {

                secondLargest = largest;
                largest = i;
            
            }

            if (i > secondLargest && i < largest) {
                secondLargest = i;
            }
        }

        System.out.printf("Second largest int = %d %n", secondLargest);
    }
}
