# 🚀 Array - Problem 12: Max Consecutive Ones

> Given a binary array (containing only 0s and 1s), find the maximum number of consecutive 1s. Includes theory, examples, step-by-step tabular dry runs, clean code, tricks to remember, and complexity.

---

## 📋 Problem Statement
- Input: Binary array `arr` of size `n`
- Output: The maximum length of a contiguous subarray consisting only of 1s

### 🧩 Examples
- `[1, 0, 1, 1, 0, 1]` → `2` (best run is `1,1`)
- `[1, 1, 1, 1]` → `4`
- `[0, 0, 0]` → `0`
- `[]` → `0`

---

## 🧠 Theory (Single Pass Counter)
- Maintain two counters:
  - `count`: length of current run of 1s
  - `maxCount`: maximum run seen so far
- For each element:
  - If `arr[i] == 1`, increment `count` and update `maxCount = max(maxCount, count)`
  - Else (`arr[i] == 0`), reset `count = 0`
- Return `maxCount`

Why it works: Each run of consecutive 1s is counted exactly once. A 0 breaks the run, so resetting `count` ensures we only measure contiguous sequences.

---

## 🔍 Dry Run (Tabular)

Array: `[1, 0, 1, 1, 0, 1]`

| i | arr[i] | Action | count (curr run) | maxCount |
|---|--------|--------|------------------|----------|
| 0 | 1 | count++ | 1 | 1 |
| 1 | 0 | count=0 | 0 | 1 |
| 2 | 1 | count++ | 1 | 1 |
| 3 | 1 | count++ | 2 | 2 |
| 4 | 0 | count=0 | 0 | 2 |
| 5 | 1 | count++ | 1 | 2 |

Result: `maxCount = 2`

---

## 💻 Code (Clean Implementation)
```java
public class p12 {
    public static int consecutiveOnes(int[] arr) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 0, 1 };
        System.out.println(consecutiveOnes(arr)); // 2
    }
}
```

---

## 🧪 Additional Examples

1) `[1,1,1,1]` → `4`

| i | arr[i] | count | maxCount |
|---|--------|-------|----------|
| 0 | 1 | 1 | 1 |
| 1 | 1 | 2 | 2 |
| 2 | 1 | 3 | 3 |
| 3 | 1 | 4 | 4 |

2) `[0,1,1,1,0,1,1]` → `3`

| i | arr[i] | count | maxCount |
|---|--------|-------|----------|
| 0 | 0 | 0 | 0 |
| 1 | 1 | 1 | 1 |
| 2 | 1 | 2 | 2 |
| 3 | 1 | 3 | 3 |
| 4 | 0 | 0 | 3 |
| 5 | 1 | 1 | 3 |
| 6 | 1 | 2 | 3 |

---

## 🧠 Tricks to Remember
- "Run and Reset": Increment run on 1, reset on 0
- "Track the Peak": Always update `maxCount` when you grow a run
- "Zero is a Wall": A 0 breaks the streak; start counting from the next 1

---

## ⏱️ Complexity
- Time: O(n) — single pass
- Space: O(1) — constant extra memory

---

## 📎 Full Reference (Aligned with `p12.java`)
```java
public class p12 {
    public static int consecutiveOnes(int[] arr) { /* as above */ }
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 0, 1 };
        System.out.println(consecutiveOnes(arr));
    }
}
```
