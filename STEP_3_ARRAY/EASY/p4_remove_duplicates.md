# 🚀 Array - Problem 4: Remove Duplicates / Count Unique Elements

> Return the count of unique elements in an array and optionally compress the array in-place. Includes a HashSet approach (works for any array) and a two-pointer optimal approach (requires sorted array).

---

## 📋 Problem Statement
Given an integer array `arr`, remove duplicate values and return the number of unique elements.

- You may modify the array in-place to place the unique elements in the first `k` positions, where `k` is the number of unique elements returned.
- If the array is not sorted and you need in-place compression, either sort it first or use the HashSet approach (which does not preserve order).

### 🧩 Examples
- Input: `[1,1,1,1,1,1,2,3,4,5,6,7,7]` → Unique count = `7`; in-place (sorted) → `[1,2,3,4,5,6,7, ...]`
- Input: `[]` → Unique count = `-1` per current implementation (you may prefer `0`)
- Input: `[5]` → Unique count = `1`
- Input: `[3,1,3,2]` (unsorted) → HashSet unique count = `3` (order unspecified)

### ✅ Constraints & Notes
- Duplicates allowed
- Negative numbers allowed
- Two-pointer approach requires array to be sorted in non-decreasing order

---

## 🔧 Implementations (from `STEP_3_ARRAY/EASY/p4.java`)

### 1) HashSet Approach (Works for any array)
- Insert all elements into a `HashSet` (unique by definition)
- Copy set elements back into the array prefix if desired
- Return the set size

```java
package STEP_3_ARRAY.EASY;

import java.util.HashSet;

public class p4 {
    public static int countDuplicateElement(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        if (arr.length < 1) {
            return -1; // Alternative: return 0 for empty array
        }
        for (int x : arr) {
            set.add(x);
        }
        int i = 0;
        for (int x : set) { // Order is unspecified
            arr[i++] = x;
        }
        return set.size();
    }
}
```

- **Time Complexity**: O(n) expected (hash insertions)
- **Space Complexity**: O(n) for the set
- **Pros**: Simple, works for unsorted arrays
- **Cons**: Does not preserve order; extra space used

---

### 2) Optimal Two-Pointer (In-Place, Sorted Array)
- Requires the array to be sorted in non-decreasing order
- Maintain a slow pointer `i` for the last unique element
- Move fast pointer `j` forward; when `arr[j] != arr[i]`, increment `i` and copy `arr[j]` to `arr[i]`
- Return `i + 1` as the count of unique elements

```java
class OptimalSolution {
    static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
```

- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Pros**: In-place, preserves relative order of unique values
- **Cons**: Requires sorted input; otherwise sort first (O(n log n))

---

## 🧠 Reasoning & Correctness
- HashSet guarantees uniqueness by design; iteration order is unspecified. It’s ideal when sorting is not allowed or unnecessary.
- Two-pointer leverages the sorted property: all duplicates group together, so comparing only adjacent elements suffices to deduplicate in-place.
- If input may be unsorted but in-place dedup is required, sort first then apply two-pointer. Overall time becomes O(n log n).

---

## 🔍 Edge Cases Covered
- Empty array → current code returns `-1` (common alternative: return `0`)
- All elements identical: `[2,2,2]` → count `1`; array becomes `[2, ...]`
- All unique: `[1,2,3]` → count `3`; array unchanged
- Negative and mixed values handled in both approaches

---

## 🧪 Testing Snippets

```java
int[] a1 = {1,1,1,1,1,1,2,3,4,5,6,7,7};
System.out.println("Unique (HashSet): " + p4.countDuplicateElement(a1));

int[] a2 = {1,1,2,2,2,3,4,4,5};
System.out.println("Unique (Two-pointer): " + OptimalSolution.removeDuplicates(a2));
// a2 prefix now: [1,2,3,4,5, ...]

int[] a3 = {};
System.out.println("Empty: " + p4.countDuplicateElement(a3)); // -1 per current code

int[] a4 = {3,1,3,2};
System.out.println("HashSet unique: " + p4.countDuplicateElement(a4)); // 3 (order unspecified)
```

---

## ⏱️ Complexity Deep-Dive
- **HashSet**: O(n) expected time; O(n) space
- **Two-pointer on sorted**: O(n) time; O(1) space
- **If sorting then two-pointer**: O(n log n) total; O(1) extra space (beyond sorting’s stack if any)

---

## 🧭 Summary
- Use HashSet when the array is unsorted and order is irrelevant
- Use two-pointer for sorted arrays to deduplicate in-place with O(1) extra space
- For unsorted but in-place requirement, sort first then apply two-pointer

---

## 📎 Full Reference (Main + Calls)

```java
package STEP_3_ARRAY.EASY;

import java.util.HashSet;

public class p4 {
    public static int countDuplicateElement(int arr[]) { /* as above */ }
    public static void main(String[] args) {
        int arr[] = { 1,1,1,1,1,1,2,3,4,5,6,7,7 };
        System.out.println("Unique Element :" + countDuplicateElement(arr));
        System.out.println("Unique Element Optimal :" + OptimalSolution.removeDuplicates(arr));
    }
}

class OptimalSolution { /* as above */ }
```
