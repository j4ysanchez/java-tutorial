import java.util.Scanner;
/*
Read a sentence. Count and print the number of vowels (`a e i o u`, case-insensitive).
 */

public class VowelCount {
    public static void main(String[] args) {

        System.out.println("Enter a string and I'll count the vowels for you: ");
        Scanner inputScanner = new Scanner(System.in);

        String sentence = inputScanner.nextLine();

        String lowerCaseSentence = sentence.toLowerCase();

        char[] characters = lowerCaseSentence.toCharArray();

        int vowelCount = 0;
        for (int i = 0; i < characters.length; i++) {
            if (isVowel(characters[i])) {
                vowelCount++;
            }
        }

        System.out.println("Number of vowels: " + vowelCount);


    }

    static boolean isVowel(char character) {
        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
            return true;
        }
        else {
            return false;
        }
    }
}
