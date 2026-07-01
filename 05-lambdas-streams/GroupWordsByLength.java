import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class GroupWordsByLength {

    /*
        3. From words, group by length into Map<Integer, List<String>>,
        //    then print each group's words sorted alphabetically.
    */


    public static void main (String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date", "fig", "avocado");

        Map<Integer, List<String>> wordMap = words.stream()
        .collect(Collectors.groupingBy(String::length, 
            Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted().toList())));

        System.out.println(wordMap);
    }
}
