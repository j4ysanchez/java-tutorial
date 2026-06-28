import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === INPUT ===
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name + "!");

        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.printf("%d + %d = %d%n", a, b, a + b);
        sc.nextLine(); // flush leftover newline after nextInt()

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.println("Word count: " + sentence.split("\\s+").length);

        // === STRING METHODS ===
        String s = "Hello, World!";
        System.out.println(s.length());                    // 13
        System.out.println(s.charAt(7));                   // W
        System.out.println(s.substring(7));                // World!
        System.out.println(s.substring(7, 12));            // World
        System.out.println(s.toLowerCase());               // hello, world!
        System.out.println(s.toUpperCase());               // HELLO, WORLD!
        System.out.println(s.contains("World"));           // true
        System.out.println(s.replace("World", "Java"));   // Hello, Java!
        System.out.println(s.indexOf("o"));                // 4 (first occurrence)
        System.out.println(s.lastIndexOf("o"));            // 8
        System.out.println("  hi  ".trim());               // hi

        // split
        String csv = "apple,banana,cherry";
        String[] parts = csv.split(",");
        for (String part : parts) {
            System.out.println(part);  // apple / banana / cherry
        }

        // toCharArray
        char[] chars = "hello".toCharArray();
        for (char c : chars) {
            System.out.print(c + " ");  // h e l l o
        }
        System.out.println();

        // === STRINGBUILDER ===
        StringBuilder sb = new StringBuilder();
        sb.append("Hello").append(", ").append("World");
        System.out.println(sb);            // Hello, World
        System.out.println(sb.length());   // 12
        System.out.println(sb.charAt(0));  // H

        sb.insert(5, "!");
        System.out.println(sb);            // Hello!, World

        sb.deleteCharAt(5);
        System.out.println(sb);            // Hello, World

        sb.reverse();
        System.out.println(sb);            // dlroW ,olleH

        // === FORMATTED OUTPUT ===
        System.out.printf("%-10s %5d%n", "Alice", 95);   // Alice          95
        System.out.printf("%-10s %5d%n", "Bob", 100);    // Bob           100
        String formatted = String.format("Score: %d / %d", 42, 100);
        System.out.println(formatted);                    // Score: 42 / 100

        // --- Challenges ---
        // 1. Read a word from sc. Print it reversed WITHOUT using sb.reverse().
        //    Use toCharArray() and a loop.

        // 2. Read a sentence from sc. Count and print the number of vowels
        //    (a e i o u), case-insensitive.

        // 3. Read a word from sc. Print true if it is a palindrome, false otherwise.
        //    Do not use StringBuilder.reverse().

        sc.close();
    }
}
