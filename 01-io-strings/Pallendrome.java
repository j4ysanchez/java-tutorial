import java.util.Scanner;

public class Pallendrome {

    public static void main(String[] args) {

        System.out.print("Enter a word and I'll tell you if it's a pallendrome: ");

        Scanner scanner = new Scanner(System.in);

        String word = scanner.next();

        System.out.println(isPallendrome(word));

        scanner.close();
    }

    static boolean isPallendrome(String word) {
        char[] letters = word.toCharArray();

        for (int i = 0, j = letters.length -1; i <= j; i++, j--) {
            if (letters[i] != letters[j])
                return false;
        }

        return true;
    }

}