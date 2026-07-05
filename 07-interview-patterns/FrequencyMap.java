import java.util.*;

public class FrequencyMap {
    /*
     * 1. **(Frequency Map)**
     * Check if two strings are anagrams: `"listen"` / `"silent"` → `true`,
     * `"hello"` / `"world"` → `false`.
     */

    public static void main(String[] args) {

        String first = args[0];
        String second = args[1];


        if (first.length() != second.length()) {
            System.out.println("false");
        }


        Map<Character,Integer> firstCharacterFrequency = stringToLetterMap(first);
        Map<Character,Integer> secondCharacterFrequency = stringToLetterMap(second);

        boolean isAnagram = true;


        try {
            for (Character letter : firstCharacterFrequency.keySet()) {
                if(firstCharacterFrequency.get(letter).intValue() != secondCharacterFrequency.get(letter).intValue()) {
                    isAnagram = false;
                }
            }
        }
        catch (Exception e)  {
            isAnagram = false;
        }
        
        System.out.printf("%s and %s are anagrams: %b", first, second, isAnagram);
    }

    static Map<Character, Integer> stringToLetterMap(String string) {

        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (Character letter : string.toCharArray()) {
            characterFrequency.merge(letter, 1, (a, b) -> a + b);
        }

        return characterFrequency;
    }
}
