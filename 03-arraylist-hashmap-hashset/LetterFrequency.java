import java.util.Map;
import java.util.HashMap;

public class LetterFrequency {
    // 1. Count the frequency of each character in `"programming"`. Print each
    // character and its count.

    public static void main(String[] args) {

        String word = "programming";

        Map<Character, Integer> characterFrequency = frequencyCounter(word);

        System.out.println(characterFrequency);

    }

    static Map<Character, Integer> frequencyCounter(String word) {

        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : word.toCharArray()) {
            // frequency.putIfAbsent(c, 0); // not needed
            frequency.merge(c, 1, (a,b) -> a+b);
        }


        return frequency;
    }
}
