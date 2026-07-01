import java.util.Comparator;
import java.util.TreeSet;

public class TreeSorter {

    /*
    3. Given `String[] words = {"cherry", "apple", "fig", "banana", "date"}`, 
    use a `TreeSet` with a custom comparator (sort by length, then alphabetically) 
    and print the set and its `first()` / `last()`.
    */
    
    public static void main(String[] args) {
        String[] words = {"cherry", "apple", "fig", "banana", "date"};


        TreeSet<String> wordSet = new TreeSet<>(
            Comparator.comparing(String::length).thenComparing((x,y) -> x.compareTo(y)));

        for(String word : words) {
            wordSet.add(word);
        }

        System.out.println(wordSet);
        System.out.printf("word set first: %s last: %s %n", wordSet.first(), wordSet.last());

    }
}
