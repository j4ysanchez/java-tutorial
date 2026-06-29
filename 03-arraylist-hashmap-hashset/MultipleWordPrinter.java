import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class MultipleWordPrinter {
    /**
     * 3. Given `String[] words = {"cat", "dog", "cat", "bird", "dog", "dog"}`, 
     * print only the words that appear more than once (order doesn't matter)
     */

    public static void main(String[] args) {


        String[] words = {"cat", "dog", "cat", "bird", "dog", "dog"};
        
        Map<String, Integer> counter = new HashMap<String, Integer>();

        for (String word : words) {
            counter.merge(word, 1, Integer::sum);
        }


        counter.forEach((k, v) -> { if (v > 1) System.out.println(k);});
        

    }
}
