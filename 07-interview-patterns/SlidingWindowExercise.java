import java.util.*;

public class SlidingWindowExercise {
    /*
    3. **(Sliding Window)** Find the length of the longest substring with no repeating characters.
   `"abcabcbb"` → `3` ("abc"). Use a `HashMap` to track the last seen index of each character.
     */

    public static void main(String[] args) {

        // String string = "abcabcbb";
        String string = "pwwkew";

        char[] characters = string.toCharArray();
    
        int longestStartIndex = 0;
        int longestEndIndex = 0;

        int i = 0;
        int j = 0;
        int maxLength = 0;

        Map<Character, Integer> lastSeenIndex = new HashMap<>();

        while (i < characters.length && j < characters.length) {
        
            if (!lastSeenIndex.containsKey(characters[j])) {
                lastSeenIndex.put(characters[j], j);
            }

            if (lastSeenIndex.get(characters[j]) < j && lastSeenIndex.get(characters[j]) >= i) {
                // we have a double, record the string

                String substring = string.substring(i, j);
                System.out.println(substring);
                // lastSeenIndex.put(characters[j], j);

                if ((j-i) > (longestEndIndex - longestStartIndex)) {
                    longestStartIndex = i;
                    longestEndIndex = j;
                }
                // reset the window
                i = j;
            }
            lastSeenIndex.put(characters[j],j);
            j++;

        }

        if((j-i) >= (longestEndIndex - longestEndIndex)) {
            longestEndIndex = j;
            longestStartIndex = i;
        }

        System.out.printf("longest substring length %d%n", string.substring(longestStartIndex, longestEndIndex).length());

    }

    
}
