# Exercise 3 — ArrayList, HashMap, HashSet

## Goal
Use the three most common Java collections for interview problems: ordered list, key-value map, and membership set.

## What changed since Java 5
- `getOrDefault(key, default)` — eliminates the null-check boilerplate on HashMap
- `putIfAbsent(key, value)` — set only if the key is missing
- `computeIfAbsent(key, fn)` — compute and insert if missing (useful for map-of-lists)
- `merge(key, value, fn)` — combine an existing value with a new one in one call; the go-to for frequency counting
- `forEach((k, v) -> ...)` — iterate map entries with a lambda instead of a for-each on `entrySet()`

## Walkthrough
Run `Main.java` and read each block's output. The HashMap section shows the modern patterns that replace the verbose null-check-then-put pattern from Java 5. Pay special attention to `merge` — you'll use it constantly for frequency counting.

## Challenges
Add your solutions below `// --- Challenges ---` in `Main.java`.

1. Count the frequency of each character in `"programming"`. Print each character and its count.
2. **Two Sum**: given `int[] nums = {2, 7, 11, 15}` and `int target = 9`, find and print the two indices that add up to the target. Use a HashMap for O(n).
3. Given `String[] words = {"cat", "dog", "cat", "bird", "dog", "dog"}`, print only the words that appear more than once (order doesn't matter).

## Key methods reference
| Method | What it does | Gotcha |
|---|---|---|
| `list.get(i)` | Element at index | Throws `IndexOutOfBoundsException` |
| `list.remove(i)` | Remove by index | `remove(int)` vs `remove(Object)` — be explicit with Integer lists |
| `list.contains(x)` | Linear scan O(n) | Use `HashSet` for O(1) membership |
| `map.getOrDefault(k, v)` | Get or return default | Does NOT insert the default |
| `map.putIfAbsent(k, v)` | Insert only if key missing | Returns old value (or null if inserted) |
| `map.computeIfAbsent(k, fn)` | Insert `fn` result if key missing | Returns the (possibly new) value |
| `map.merge(k, v, fn)` | Combine existing + new value | `map.merge(k, 1, Integer::sum)` for counting |
| `map.entrySet()` | Set of key-value pairs | Use in for-each to get both key and value |
| `map.forEach((k, v) -> ...)` | Lambda iteration over entries | Shorter than entrySet for-each |
| `set.add(x)` | Returns `false` if already present | Use the return value for dedup detection |
