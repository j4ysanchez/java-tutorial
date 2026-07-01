import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class LongestWordFinder {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("banana", "apple", "cherry", "date", "fig", "avocado");

        // String longestWord = words.stream().sorted((x,y) -> y.length() - x.length()).findFirst().orElse("none");

        // String longestWord = words.stream().reduce("", (a, b) -> 
        // { 
        //     // if (a.length() > b.length()) { 
        //     //     return a; 
        //     // } else {
        //     //     return b;
        //     // }

        //     { return a.length() >= b.length() ?  a : b; }
        
        // });

        String longestWord = words.stream().max(Comparator.comparing(String::length)).orElse("none");


        System.out.println(longestWord);
    }
    
}
