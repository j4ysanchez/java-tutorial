import java.util.List;
import java.util.Arrays;

public class EvenNumsCollector {
    /*
    1. From `nums = [3,1,4,1,5,9,2,6,5,3]`, 
    collect a **sorted list of unique even numbers** using streams. Expected: `[2, 4, 6]`. 
    */

    public static void main (String[] args) {

        List<Integer> nums = Arrays.asList(3,1,4,1,5,9,2,6,5,3);

        List<Integer> sortedList = nums.stream().distinct().filter(x -> x % 2 == 0).sorted().toList();

        System.out.println(sortedList);
    }
}
