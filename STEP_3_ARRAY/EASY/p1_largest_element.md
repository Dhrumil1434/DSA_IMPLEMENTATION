# 🚀 Array - Problem 1: Largest Element in an Array

> Find the maximum element in an integer array. Includes brute-force and optimal approaches with detailed complexity analysis.

---

## 📋 Problem Statement
Given an array of integers `arr`, return the largest element. If the array is empty, return `-1`.

### 🧩 Examples
- Input: `[1, 2, 33, 44, 66, 454, 22, 11]` → Output: `454`
- Input: `[]` → Output: `-1`
- Input: `[5]` → Output: `5`
- Input: `[-10, -20, -3]` → Output: `-3`

### ✅ Constraints & Edge Cases
- Array can be empty → return `-1`
- Works with negative numbers
- Duplicates are allowed

---

## 🔧 Approaches

### 1) Brute Force (Sort and Pick Last)
- Sort the whole array and return the last element
- In Java, `Arrays.sort(int[])` uses Dual-Pivot QuickSort (in-place)

```java
package STEP_3_ARRAY.EASY;

import java.util.Arrays;

public class p1 {
    public static int largestElement(int arr[]) {
        if (arr.length == 0) {
            return -1;
        }
        Arrays.sort(arr);                 // O(n log n)
        return arr[arr.length - 1];       // Last element is the maximum
    }
}
```

- **Time Complexity**: O(n log n)
- **Space Complexity**: O(log n) average (recursion stack of quicksort)
- **When to use**: Rarely ideal for just finding a max; useful if you already needed the array sorted for other reasons.

---

### 2) Optimal (Single Pass Linear Scan)
- Track the running maximum in one pass
- Does not modify the array

```java
package STEP_3_ARRAY.EASY;

class BetterApproach {
    public static int largestElement(int arr[]) {
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0];                  // Initialize with first element
        for (int i = 1; i < arr.length; i++) {  // Single pass
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
```

- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **When to use**: Almost always. This is the standard approach to find a maximum.

---

## 🧠 Reasoning Walkthrough

- We only need the largest value, not the order of elements → sorting the entire array is extra work.
- A single scan comparing each element against the current maximum yields the result directly.
- The linear scan is optimal because any algorithm must inspect each element at least once to guarantee correctness (lower bound Ω(n)).

---

## 🧪 Testing

```java
int[] a1 = {1, 2, 33, 44, 66, 454, 22, 11};
System.out.println(p1.largestElement(a1));           // 454 (brute)
System.out.println(BetterApproach.largestElement(a1)); // 454 (optimal)

int[] a2 = {};
System.out.println(BetterApproach.largestElement(a2)); // -1

int[] a3 = {5};
System.out.println(BetterApproach.largestElement(a3)); // 5

int[] a4 = {-10, -20, -3};
System.out.println(BetterApproach.largestElement(a4)); // -3
```

---

## ⏱️ Complexity Deep-Dive

- **Brute (Sort) Approach**
  - Time: O(n log n) due to sorting all elements
  - Space: O(log n) average for quicksort recursion stack in `Arrays.sort(int[])`
  - Stability: Not needed; we only need the max
  - Drawback: Unnecessary extra work if sorting is not otherwise required

- **Optimal (Linear Scan)**
  - Time: O(n) — inspects each element exactly once
  - Space: O(1) — constant auxiliary memory
  - Lower bound: Any correct algorithm must be Ω(n) because you must consider each element at least once to be certain of the maximum

---

## 🧭 Summary
- **Best Approach**: Single-pass linear scan → O(n) time, O(1) space
- **Edge Cases**: Empty array → return `-1`; works with negatives; duplicates are fine
- **Tip**: Prefer linear scan unless you already need the array sorted for other operations

---

## 📎 Full Reference (As in `STEP_3_ARRAY/EASY/p1.java`)

```java
package STEP_3_ARRAY.EASY;

import java.util.Arrays;

public class p1 {
    public static int largestElement(int arr[]) {
        if (arr.length == 0) {
            return -1;
        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 33, 44, 66, 454, 22, 11 };
        System.out.println(largestElement(arr));
        System.out.println(BetterApproach.largestElement(arr));
    }
}

class BetterApproach {
    public static int largestElement(int arr[]) {
        if (arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
```
