# Exercise 4 — Queues, Stacks, Deques & PriorityQueue

## Goal
Use the right queue/stack structure for interview problems. Understand `ArrayDeque` as both stack and queue, and `PriorityQueue` as a heap.

## What changed since Java 5
- **`Stack` is legacy** — use `ArrayDeque` instead. `Stack` extends `Vector`, which is synchronized (slow) and has confusing inherited methods
- **`Deque` interface** (Java 6) formalizes double-ended queue operations with unambiguous naming
- `ArrayDeque` is the standard stack AND queue for interview code
- **`PriorityQueue`** existed in Java 5 but custom comparators now use lambdas instead of anonymous classes

## Walkthrough
Run `Main.java`. The same `ArrayDeque` class is used as both a stack and a queue — the only difference is which methods you call. Read the method name table in the reference section to keep them straight.

## Challenges
Add your solutions below `// --- Challenges ---` in `Main.java`.

1. **Balanced parentheses**: given `String s = "({[]})"`, return `true` if all brackets are properly closed in the correct order. Test also with `"({[})"` which should return `false`. Use an `ArrayDeque` as a stack.
2. **Sliding window maximum**: given `int[] nums = {1,3,-1,-3,5,3,6,7}` and `k = 3`, print the maximum in each window of size k. Expected: `[3, 3, 5, 5, 6, 7]`. Use a `Deque` of indices to solve in O(n).
3. **Kth largest**: given `int[] nums = {3,2,1,5,6,4}` and `k = 2`, find the kth largest element. Expected: `5`. Use a min-heap `PriorityQueue` of size k.

## Key methods reference
**ArrayDeque as stack (LIFO):**
| Method | What it does |
|---|---|
| `push(e)` | Add to front (same as `addFirst`) |
| `pop()` | Remove and return front (same as `removeFirst`) |
| `peek()` | Return front without removing (same as `peekFirst`) |

**ArrayDeque as queue (FIFO):**
| Method | What it does |
|---|---|
| `offer(e)` | Add to back (same as `addLast`) |
| `poll()` | Remove and return front — returns `null` if empty |
| `peek()` | Return front without removing — returns `null` if empty |

**ArrayDeque as double-ended deque:**
| Method | What it does |
|---|---|
| `offerFirst(e)` / `offerLast(e)` | Add to front / back |
| `pollFirst()` / `pollLast()` | Remove from front / back |
| `peekFirst()` / `peekLast()` | Inspect front / back |

**PriorityQueue:**
| Method | What it does | Gotcha |
|---|---|---|
| `offer(e)` | Insert element | O(log n) |
| `poll()` | Remove and return min (or max) | Returns `null` if empty |
| `peek()` | Return min without removing | Returns `null` if empty |
| `size()` | Number of elements | |
| `new PriorityQueue<>(Collections.reverseOrder())` | Max-heap | Or use `(a, b) -> b - a` |
