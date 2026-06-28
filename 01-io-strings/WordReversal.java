import java.util.Scanner;


public class WordReversal {
    // --- Challenges ---
    // 1. Read a word from sc. Print it reversed WITHOUT using sb.reverse().
    //    Use toCharArray() and a loop.

    public static void main(String[] args) {
        System.out.println("Enter a word you want reversed: ");
        Scanner scanner = new Scanner(System.in);

        String word = scanner.next(); 
        char[] charArray = word.toCharArray();

        StringBuilder reversedString = new StringBuilder();
        for (int i = charArray.length -1; i >= 0; i--) {
            reversedString.append(charArray[i]);
        }

        scanner.close();;

        System.out.println(reversedString);
    }

}
