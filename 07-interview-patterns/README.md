# Exercise 7 — Interview Patterns

## Goal
Apply four recurring patterns that cover the majority of medium-difficulty interview problems. One worked example per pattern, then one problem per pattern to solve yourself.

## What changed since Java 5
Nothing structurally new here — this exercise applies the APIs from exercises 1-6. The modern additions that make these patterns cleaner: `merge` for frequency maps, lambda comparators for PriorityQueue, and streams for post-processing results.

## Walkthrough
Run `Main.java` and read each pattern block. Each is self-contained and labelled. Before moving to challenges, make sure you understand *why* the chosen data structure fits the problem — that's the transferable skill.

## Patterns overview
| Pattern | Reach for it when... | Key structure |
|---|---|---|
| **Frequency Map** | You need to count occurrences, find duplicates, or check equality of multisets | `HashMap` + `merge` |
| **Two Pointer** | Array is sorted (or can be sorted) and you're shrinking a search space from both ends | Two `int` indices |
| **Sliding Window** | You need the best/longest/shortest contiguous subarray or substring under some constraint | One or two `int` pointers + running total or `HashMap` |
| **Top-K** | You need the k largest, smallest, or most frequent items without full sort | `PriorityQueue` of size k |

## Challenges
Add solutions below `// --- Challenges ---` in `Main.java`.

1. **(Frequency Map)** Check if two strings are anagrams: `"listen"` / `"silent"` → `true`, `"hello"` / `"world"` → `false`.
2. **(Two Pointer)** Given a sorted `int[]`, find all **unique** pairs that sum to a target and print each pair.
   `{1, 1, 2, 3, 4, 5, 6, 7}`, target=8 → `(1,7) (2,6) (3,5)`
3. **(Sliding Window)** Find the length of the longest substring with no repeating characters.
   `"abcabcbb"` → `3` ("abc"). Use a `HashMap` to track the last seen index of each character.
4. **(Top-K)** Find the k most frequent words sorted by frequency descending, then alphabetically for ties.
   `{"the","sky","is","blue","the","sky","is","sky"}`, k=2 → `["sky", "the"]`

## Key methods quick-reference
| Method | Pattern | Use |
|---|---|---|
| `map.merge(k, 1, Integer::sum)` | Frequency Map | Increment count in one call |
| `map.entrySet().stream().max(Map.Entry.comparingByValue())` | Frequency Map | Entry with highest value |
| `Math.max(a, b)` / `Math.min(a, b)` | Sliding Window | Running best |
| `pq.offer(e); if (pq.size() > k) pq.poll();` | Top-K | Maintain min-heap of size k |
