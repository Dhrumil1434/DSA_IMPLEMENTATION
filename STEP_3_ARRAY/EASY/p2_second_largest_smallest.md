# 🚀 Array - Problem 2: Second Largest and Second Smallest in an Array

> Return the second largest and second smallest distinct elements from an integer array. Covers brute-force, better, and optimal approaches with correctness and complexity analysis.

---

## 📋 Problem Statement
Given an array of integers `arr`, find:
- The second largest distinct element
- The second smallest distinct element

If a second largest or second smallest does not exist (e.g., fewer than 2 distinct values), return `-1` for that value.

### 🧩 Examples
- Input: `[2, 2, 2, 9]` → Second Largest = `2`, Second Smallest = `9`
- Input: `[1, 2, 3, 4, 4]` → Second Largest = `3`, Second Smallest = `2`
- Input: `[5, 5, 5]` → Second Largest = `-1`, Second Smallest = `-1` (no second distinct values)
- Input: `[7]` → Second Largest = `-1`, Second Smallest = `-1` (length < 2)
- Input: `[-5, -2, -10, -2]` → Second Largest = `-5`, Second Smallest = `-5`

### ✅ Constraints & Edge Cases
- Length can be `0` or `1` → no second values exist
- Duplicates allowed
- Negative numbers allowed
- We consider distinct second values (i.e., not equal to the largest/smallest)

---

## 🔧 Implementations (from `STEP_3_ARRAY/EASY/p2.java`)

### 1) Brute Force (Sort and Scan)
- Sort array
- For second largest: scan from right to find first value < largest
- For second smallest: scan from left to find first value > smallest

```java
package STEP_3_ARRAY.EASY;

import java.util.Arrays;

public class p2 {
    public static int secondLargestElement(int arr[]) {
        if (arr.length < 2) return -1;
        Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        int secondLargest = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) { secondLargest = arr[i]; break; }
        }
        return secondLargest; // -1 if not found
    }

    public static int secondSmallestElement(int arr[]) {
        if (arr.length < 2) return -1;
        Arrays.sort(arr);
        int smallest = arr[0];
        int secondSmallest = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != smallest) { secondSmallest = arr[i]; break; }
        }
        return secondSmallest; // -1 if not found
    }
}
```

- **Time Complexity**: O(n log n) (sorting dominates)
- **Space Complexity**: O(log n) average (quicksort recursion stack)
- **Notes**: Simple; does extra work if you only need second values

---

### 2) Better Solution (Two Passes, No Sort)
- First pass: find `small` and `large`
- Second pass: find the best candidates strictly between extremes

```java
class BetterSolution {
    public static int[] secondLargestAndSmallestElement(int arr[]) {
        int ans[] = { -1, -1 };
        if (arr.length < 2) return ans;

        int large = arr[0], small = arr[0];
        for (int value : arr) {
            large = Math.max(large, value);
            small = Math.min(small, value);
        }

        int secondLarge = Integer.MIN_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value > secondLarge && value != large) secondLarge = value;
            if (value < secondSmall && value != small) secondSmall = value;
        }

        // If not found, keep -1 in the final answer
        ans[0] = (secondLarge == Integer.MIN_VALUE) ? -1 : secondLarge;
        ans[1] = (secondSmall == Integer.MAX_VALUE) ? -1 : secondSmall;
        return ans;
    }
}
```

- **Time Complexity**: O(n) + O(n) = O(n)
- **Space Complexity**: O(1)
- **Notes**: Robust; handles duplicates; returns `-1` if second distinct not found

---

### 3) Optimal Solution (Single Pass, No Sort)
- Track two best values for largest and smallest in a single traversal
- Update candidates carefully to maintain distinctness

```java
class OptimalSolution {
    public static int secondLargest(int arr[]) {
        if (arr.length < 2) return -1;
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > large) {
                secondLarge = large; // demote previous large
                large = value;
            } else if (value > secondLarge && value != large) {
                secondLarge = value;
            }
        }
        return (secondLarge == Integer.MIN_VALUE) ? -1 : secondLarge;
    }

    public static int secondSmallest(int arr[]) {
        if (arr.length < 2) return -1;
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value < small) {
                secondSmall = small; // promote new smallest
                small = value;
            } else if (value < secondSmall && value != small) {
                secondSmall = value;
            }
        }
        return (secondSmall == Integer.MAX_VALUE) ? -1 : secondSmall;
    }
}
```

- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Notes**: Most efficient; mirrors code in `p2.java`

---

## 🧠 Reasoning & Correctness
- We require the second distinct values, so equality checks (`!= large` / `!= small`) are mandatory to avoid duplicates being selected.
- Any algorithm must examine all elements to be certain about ordering → lower bound Ω(n). Thus the O(n) solutions are time-optimal when sorting is not necessary for other reasons.
- Sentinel initialization (`Integer.MIN_VALUE`/`MAX_VALUE`) is convenient but must be normalized to `-1` if no candidates are found.

---

## 🔍 Edge Cases Covered
- `[]` or `[x]` → both second values are `-1`
- All elements equal: `[5,5,5]` → both `-1`
- Exactly two distinct values: `[2,2,9]` → secondLargest=`2`, secondSmallest=`9`
- Negative numbers: `[-10,-10,-2]` → secondLargest=`-10`, secondSmallest=`-10`

---

## 🧪 Testing Snippets

```java
int[] a1 = {2, 2, 2, 9};
System.out.println(p2.secondLargestElement(a1));          // 2
System.out.println(p2.secondSmallestElement(a1));         // 9
System.out.println(Arrays.toString(BetterSolution.secondLargestAndSmallestElement(a1))); // [2, 9]

int[] a2 = {1, 2, 3, 4, 4};
System.out.println(OptimalSolution.secondLargest(a2));    // 3
System.out.println(OptimalSolution.secondSmallest(a2));   // 2

int[] a3 = {5, 5, 5};
System.out.println(OptimalSolution.secondLargest(a3));    // -1
System.out.println(OptimalSolution.secondSmallest(a3));   // -1

int[] a4 = {-5, -2, -10, -2};
System.out.println(OptimalSolution.secondLargest(a4));    // -5
System.out.println(OptimalSolution.secondSmallest(a4));   // -5
```

---

## ⏱️ Complexity Deep-Dive

- **Brute (Sort + Scan)**
  - Time: O(n log n) due to sorting
  - Space: O(log n) average (quicksort recursion stack)
  - Stability: Not required for this problem
  - When okay: If sorting is already needed elsewhere

- **Better (Two Passes)**
  - Time: O(n)
  - Space: O(1)
  - Trade-offs: Two passes; simpler to reason about

- **Optimal (Single Pass)**
  - Time: O(n)
  - Space: O(1)
  - Trade-offs: Slightly trickier updates; most efficient

---

## 🧭 Summary
- Use the single-pass optimal approach for best performance
- Normalize results to `-1` when a second distinct value is absent
- Sorting-based approach is educational but suboptimal if you only need second values

---

## 📎 Full Reference (Main + Calls)

```java
package STEP_3_ARRAY.EASY;

import java.util.Arrays;

public class p2 {
    public static int secondLargestElement(int arr[]) { /* as above */ }
    public static int secondSmallestElement(int arr[]) { /* as above */ }
    public static void main(String[] args) {
        int arr[] = { 2,2,2,9};
        System.out.println("Second Largest :" + secondLargestElement(arr));
        System.out.println("Second Smallest :" + secondSmallestElement(arr));
        int ans[] = BetterSolution.secondLargestAndSmallestElement(arr);
        for(int x: ans) System.out.println(x);
        System.out.println("Optimal Second Largest :" + OptimalSolution.secondLargest(arr));
        System.out.println("Optimal Second Smallest :"+ OptimalSolution.secondSmallest(arr));
    }
}
```
