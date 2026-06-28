# Exercise 2 — Arrays & Sorting

## Goal
Create, copy, fill, and sort arrays. Write custom sort orders using lambda comparators.

## What changed since Java 5
- **Lambda comparators** replace anonymous `Comparator` classes: `(a, b) -> b - a` is descending sort in one line vs. 5 lines of anonymous class boilerplate
- `Arrays.toString()` and `Arrays.deepToString()` print arrays without manual loops
- `Comparator.comparing(fn)` and `.thenComparing(fn)` chain sort keys cleanly
- `Comparator.naturalOrder()` / `Comparator.reverseOrder()` as readable static helpers

## Walkthrough
Run `Main.java` and study the output for each block. The key section is the lambda comparator examples — notice how they replace the verbose anonymous class pattern from Java 5.

## Challenges
Add your solutions below `// --- Challenges ---` in `Main.java`.

1. Sort `String[] fruits = {"kiwi", "strawberry", "fig", "mango"}` by length (shortest first). Print the result.
2. Find the second-largest number in `int[] values = {3, 1, 4, 1, 5, 9, 2, 6}` without sorting.
3. Merge `int[] a = {1, 3, 5, 7}` and `int[] b = {2, 4, 6, 8}` into one sorted array and print it.

## Key methods reference
| Method | What it does | Gotcha |
|---|---|---|
| `Arrays.sort(arr)` | Sort ascending in-place | Works on primitives and objects |
| `Arrays.sort(arr, cmp)` | Sort with custom comparator | Only works on Object arrays (`String[]`, `Integer[]`) — not `int[]` |
| `Arrays.copyOf(arr, n)` | Copy first n elements into new array | Original unchanged |
| `Arrays.copyOfRange(arr, i, j)` | Copy slice from i to j-1 | j is exclusive |
| `Arrays.fill(arr, val)` | Set all elements to val | In-place |
| `Arrays.toString(arr)` | `"[1, 2, 3]"` printable string | 1D only — use `deepToString` for 2D |
| `Arrays.binarySearch(arr, key)` | Index of key | Array must be pre-sorted |
| `Comparator.comparing(fn)` | Compare by extracted key | e.g. `Comparator.comparing(String::length)` |
| `.thenComparing(cmp)` | Break ties with second comparator | Chain onto any Comparator |
| `Comparator.reverseOrder()` | Descending natural order | Requires Object array, not primitive |
