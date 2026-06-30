import java.util.Deque;
import java.util.ArrayDeque;;

public class BalancedParentheses {
        // --- Challenges ---
        // 1. Balanced parentheses:
        //    Return true if all brackets are balanced, false otherwise.
        //    "({[]})" → true
        //    "({[})"  → false
        //    Use an ArrayDeque as a stack.


    public static void main (String[] args) {
        Deque<Character> stack = new ArrayDeque<Character>();

        String balanced = "({[]})";

        char[] parentheses = balanced.toCharArray();


        boolean result = true; 

        for (char character : parentheses) {
            if ( character == '(' || character == '{' || character == '[' ) {
                stack.push(character);
            }
            else if (character == ')') {
                if (stack.peek() == '(') {
                    stack.pop(); 
                    
                } else {
                    result = false;
                    break;
                }
            } else if (character == '}') {
                if (stack.peek() == '{') {
                    stack.pop(); 
                    
                } else {
                    result = false; 
                    break;
                }
            } else if (character == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    
                } else {
                    result = false;
                    break;
                }
            }
        }
/*
Map<Character, Character> pairs = Map.of(')', '(', '}', '{', ']', '[');

if (pairs.containsKey(character)) {
    if (stack.isEmpty() || stack.pop() != pairs.get(character)) {
        result = false; break;
    }
}
 */
        System.out.printf("Parentheses are balanced: %b %n", result);
    }
}
