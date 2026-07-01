# Exercise 6 — TreeMap & TreeSet

## Goal
Use sorted collections with O(log n) navigation operations for range queries, closest-value lookups, and ordered iteration.

## What changed since Java 5
- `NavigableMap` and `NavigableSet` interfaces (Java 6) added `floor`, `ceiling`, `lower`, `higher`, `headMap`, `tailMap`, `subMap` and their inclusive/exclusive variants — these are the methods that make TreeMap/TreeSet useful beyond "just a sorted HashMap"
- Both interfaces existed in Java 5 but without the navigation API — you had to iterate manually

## Walkthrough
Run `Main.java`. Focus on the four navigation methods (`floor`, `ceiling`, `lower`, `higher`) — they're the reason you'd reach for TreeMap/TreeSet over HashMap/HashSet. The difference between `floor`/`ceiling` (inclusive) and `lower`/`higher` (strict) trips people up; the walkthrough shows both.

## Challenges
Add your solutions below `// --- Challenges ---` in `Main.java`.

1. Given `int[] events = {10, 3, 7, 15, 1, 8}` and `int query = 6`, find the closest event time to the query (either floor or ceiling — whichever is nearer). If tied, pick the floor.
2. Given a `TreeMap<Integer, String>` of event timestamps, count how many events fall between times 5 and 12 (inclusive). Use `subMap`. Timeline: `{1:"wake", 3:"breakfast", 7:"work", 10:"lunch", 15:"dinner"}`.
3. Given `String[] words = {"cherry", "apple", "fig", "banana", "date"}`, use a `TreeSet` with a custom comparator (sort by length, then alphabetically) and print the set and its `first()` / `last()`.

## Key methods reference
**TreeSet navigation:**
| Method | What it does |
|---|---|
| `floor(e)` | Greatest element ≤ e, or `null` |
| `ceiling(e)` | Smallest element ≥ e, or `null` |
| `lower(e)` | Greatest element strictly < e, or `null` |
| `higher(e)` | Smallest element strictly > e, or `null` |
| `first()` / `last()` | Smallest / largest element |
| `headSet(e)` | View of elements strictly < e |
| `tailSet(e)` | View of elements ≥ e |
| `subSet(from, to)` | View of elements ≥ from and < to |

**TreeMap navigation (same semantics, operates on keys):**
| Method | What it does |
|---|---|
| `floorKey(k)` | Greatest key ≤ k, or `null` |
| `ceilingKey(k)` | Smallest key ≥ k, or `null` |
| `lowerKey(k)` / `higherKey(k)` | Strict variants |
| `firstKey()` / `lastKey()` | Smallest / largest key |
| `headMap(k)` | View of entries with key strictly < k |
| `tailMap(k)` | View of entries with key ≥ k |
| `subMap(from, to)` | View of entries with key ≥ from and < to |
| `descendingKeySet()` | Keys in reverse order |
