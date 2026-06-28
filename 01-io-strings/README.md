# Exercise 1 — Input/Output & Strings

## Goal
Read user input from the console, manipulate strings, and print formatted output — the core loop of any console application.

## What changed since Java 5
- `printf` / `String.format` with `%n` (portable newline) is now standard
- `StringBuilder` is preferred over `StringBuffer` for single-threaded code — same API, no synchronization overhead
- `var` keyword (Java 10) can infer local variable types — you'll see it in modern code but it's optional

## Walkthrough
Run `Main.java` and follow the prompts. Each section is labelled. Read the code and its output before moving to the challenges.

**Scanner gotcha:** after `nextInt()` or `nextDouble()`, a `\n` remains in the buffer. The next `nextLine()` call reads it immediately and returns an empty string. Fix it with an extra `sc.nextLine()` after any numeric read — see the comment in the code.

## Challenges
Add your solutions below the `// --- Challenges ---` comment in `Main.java`.

1. Read a word from input. Print it reversed **without** using `StringBuilder.reverse()` — use `toCharArray()` and a loop.
2. Read a sentence. Count and print the number of vowels (`a e i o u`, case-insensitive).
3. Read a word. Print `true` if it is a palindrome, `false` otherwise. Do not use `StringBuilder.reverse()`.

## Key methods reference
| Method | What it does | Gotcha |
|---|---|---|
| `sc.nextLine()` | Read a full line as String | Returns empty string right after `nextInt()` |
| `sc.nextInt()` | Read next int token | Leaves `\n` in buffer |
| `sc.hasNextLine()` | Check if more input exists | Useful in loops reading until EOF |
| `s.split(regex)` | Split by delimiter | Argument is a regex — escape `.` as `\\.` |
| `s.charAt(i)` | Char at index i | Throws if out of range |
| `s.substring(i, j)` | Chars from i to j-1 | `j` is exclusive |
| `s.trim()` | Strip leading/trailing whitespace | Returns new String — does not mutate |
| `sb.append(x)` | Append to builder | Chainable: `sb.append("a").append("b")` |
| `sb.reverse()` | Reverse in place | Mutates the builder |
| `sb.deleteCharAt(i)` | Remove char at index | Mutates the builder |
| `sb.toString()` | Convert to String | Always call this to get the final result |
