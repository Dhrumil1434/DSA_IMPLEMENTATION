# 🚀 Array - Problem 3: Check if Array is Sorted

> Determine whether an array is sorted in strictly increasing order. Includes O(n^2) and O(n) approaches, with notes on duplicates and non-decreasing variants.

---

## 📋 Problem Statement
Given an integer array `arr`, return whether it is sorted in strictly increasing order.

- Strictly increasing means: for all valid i, `arr[i] < arr[i+1]`.
- If the array has fewer than 2 elements, the check is invalid in this implementation and throws an error (as in your code). You may adapt to return `true` by definition if preferred.

### 🧩 Examples
- `[10, 20, 30, 40]` → `true`
- `[10, 20, 30, 30, 40]` → `false` (strictly increasing disallows equal neighbors)
- `[10, 20, 30, 25]` → `false` (inversion: 30 > 25)
- `[5]` → error per current implementation; commonly defined as `true` in alternative designs

### ✅ Constraints & Edge Cases
- Length < 2 → code throws `IllegalArgumentException`
- Duplicates cause `false` for strictly increasing variant
- Consider using a non-decreasing variant if duplicates should be allowed

---

## 🔧 Implementations (from `STEP_3_ARRAY/EASY/p3.java`)

### 1) Brute Force (Double Loop) — Inversion Check
Checks that there exists no pair `(i, j)` with `i < j` and `arr[j] < arr[i]`.

```java
package STEP_3_ARRAY.EASY;

public class p3 {
    public static boolean isSortedDoubleLoop(int arr[]) {
        boolean isSorted = true;
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array is not containing enough elements !!");
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    isSorted = false;
                    break;
                }
            }
        }
        return isSorted;
    }
}
```

- **Time Complexity**: O(n^2)
- **Space Complexity**: O(1)
- **Notes**: Educational; detects any inversion by exhaustive check

---

### 2) Optimal (Single Pass) — Adjacent Comparison
Check that each adjacent pair maintains strict increase.

```java
package STEP_3_ARRAY.EASY;

public class p3 {
    public static boolean isSorted(int arr[]) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array is not containing enough elements !!");
        }
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!(arr[i] < arr[i + 1])) {
                flag = false;
            }
        }
        return flag;
    }
}
```

- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Notes**: Efficient; mirrors the implementation in `p3.java`

---

## 🧠 Reasoning & Variants
- Strictly increasing uses `<` and disallows duplicates. If duplicates should be allowed, use non-decreasing (`<=` between neighbors) instead:

```java
// Non-decreasing variant (allows duplicates)
for (int i = 0; i < arr.length - 1; i++) {
    if (arr[i] > arr[i + 1]) return false;
}
return true;
```

- If you prefer not to throw for arrays of length < 2, you can define them as sorted by convention and return `true`.

---

## 🔍 Edge Cases Covered
- `[10, 20, 30, 30]` → false (strict)
- `[10, 10, 10]` → false (strict); true in non-decreasing variant
- `[42]` → error in current version; often defined as true
- `[]` → error in current version; often defined as true

---

## 🧪 Testing Snippets

```java
int[] a1 = {10, 20, 30, 40};
System.out.println(p3.isSorted(a1));           // true
System.out.println(p3.isSortedDoubleLoop(a1)); // true

int[] a2 = {10, 20, 30, 25};
System.out.println(p3.isSorted(a2));           // false

int[] a3 = {10, 20, 30, 30};
System.out.println(p3.isSorted(a3));           // false (strict)

int[] a4 = {5};
// p3.isSorted(a4) -> throws IllegalArgumentException per current implementation
```

---

## ⏱️ Complexity Deep-Dive
- **Double Loop**: O(n^2) compares, checks all pairs; unnecessary for sortedness which only requires adjacent checks
- **Single Pass**: O(n) compares, examines adjacent pairs; asymptotically optimal and simplest
- **Space**: O(1) in both approaches

---

## 🧭 Summary
- Prefer the single-pass adjacent comparison for efficiency
- Choose strictly increasing vs non-decreasing depending on whether duplicates are allowed
- Decide policy for arrays with < 2 elements (throw vs return true by convention)

---

## 📎 Full Reference (Main + Calls)

```java
package STEP_3_ARRAY.EASY;

public class p3 {
    public static boolean isSortedDoubleLoop(int arr[]) { /* as above */ }
    public static boolean isSorted(int arr[]) { /* as above */ }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,25 };
        System.out.println(isSorted(arr));
        System.out.println(isSortedDoubleLoop(arr));
    }
}
```
