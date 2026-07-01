# Exercise 5 — Lambdas & Streams

## Goal
Filter, transform, and aggregate collections using the Java 8 Streams API and lambda expressions — the biggest language change since Java 5.

## What changed since Java 5
Everything in this exercise is new since Java 5:
- **Lambda expressions**: `(x) -> x * 2` — anonymous functions inline
- **Method references**: `String::toUpperCase` — shorthand for `s -> s.toUpperCase()`
- **Streams**: a pipeline of operations on a sequence of elements, evaluated lazily
- **`Optional<T>`**: a container that may or may not hold a value — replaces returning `null`
- **`Collectors`**: terminal operations that collect stream results into lists, maps, strings, etc.

## Walkthrough
Run `Main.java`. Read each pipeline carefully — streams are chained left to right and nothing executes until a terminal operation (`collect`, `count`, `sum`, `findFirst`, etc.) is called.

Key mental model: `stream()` opens the pipe, intermediate operations (`filter`, `map`, `sorted`) transform it, terminal operations (`collect`, `count`, `reduce`) close it and produce a result.

## Challenges
Add your solutions below `// --- Challenges ---` in `Main.java`.

1. From `nums = [3,1,4,1,5,9,2,6,5,3]`, collect a **sorted list of unique even numbers** using streams. Expected: `[2, 4, 6]`.
2. From `words`, find the **longest string** using a stream. Expected: `"avocado"` (7 chars).
3. From `words`, group them by length into a `Map<Integer, List<String>>`, then print each group's words sorted alphabetically.

## Key methods reference
**Intermediate operations (lazy — return a new Stream):**
| Method | What it does |
|---|---|
| `filter(pred)` | Keep elements matching predicate |
| `map(fn)` | Transform each element |
| `mapToInt(fn)` | Map to `IntStream` for numeric ops |
| `sorted()` | Natural order sort |
| `sorted(cmp)` | Custom comparator sort |
| `distinct()` | Remove duplicates |
| `limit(n)` | Keep first n elements |

**Terminal operations (eager — consume the stream):**
| Method | What it does |
|---|---|
| `collect(Collectors.toList())` | Collect to List |
| `collect(Collectors.joining(sep))` | Join strings with separator |
| `collect(Collectors.groupingBy(fn))` | Group into `Map<K, List<V>>` |
| `count()` | Count elements |
| `sum()` / `average()` / `max()` | Numeric aggregation (on IntStream) |
| `reduce(identity, fn)` | Fold all elements into one value |
| `anyMatch(pred)` / `allMatch` / `noneMatch` | Boolean tests |
| `findFirst()` | Returns `Optional<T>` of first element |

**Optional:**
| Method | What it does |
|---|---|
| `isPresent()` | True if value exists |
| `get()` | Unwrap value — throws if empty |
| `orElse(default)` | Unwrap or return default |
| `ifPresent(fn)` | Run lambda only if present |
