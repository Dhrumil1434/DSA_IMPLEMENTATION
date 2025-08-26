# 🚀 Array - Problem 10: Intersection of Two Sorted Arrays

> Return the intersection (common elements) of two sorted arrays. Includes a nested-loop approach with visitation tracking and an optimal two-pointer technique. Each approach is explained with theory, example, tabular dry run, code, and complexity.

---

## 📋 Problem Statement
Given two sorted arrays `arr1` and `arr2`, print or return their intersection (elements present in both). If an element appears multiple times in both arrays, include it as many times as it appears in both (multiset intersection).

- Arrays may be empty
- Arrays are assumed sorted (if not, sort first or adapt approach)

### 🧩 Examples
- `arr1 = [1,2,3,3,4,5]`, `arr2 = [1,3,3,6]` → Intersection: `[1,3,3]`
- `arr1 = [1,2,3]`, `arr2 = []` → `[]`
- `arr1 = []`, `arr2 = []` → `[]`

---

## 1) Brute Force with Visitation Array

### 🧠 Theory
- For each element in `arr1`, scan `arr2` for a match
- Use an auxiliary visitation array `v` for `arr2` to ensure each matched element is used only once (handles duplicates correctly)
- Early break when `arr2[j] > arr1[i]` leveraging sorted order to avoid unnecessary checking

### 🔍 Example
- `arr1 = [1,2,3,3,4,5]`
- `arr2 = [1,3,3,6]`

### 🧪 Dry Run (Tabular)

| i | arr1[i] | j | arr2[j] | v[j] | Match? | Action |
|---|---------|---|---------|------|--------|--------|
| 0 | 1 | 0 | 1 | 0 | Yes | add 1; v[0]=1; break j-loop |
| 1 | 2 | 0.. | 1 | 1 | No | j moves 0→1→2; arr2[j]=3>2 → break |
| 2 | 3 | 0 | 1 | 1 | No | j→1 |
| 2 | 3 | 1 | 3 | 0 | Yes | add 3; v[1]=1; break |
| 3 | 3 | 0 | 1 | 1 | No | j→1→2 |
| 3 | 3 | 2 | 3 | 0 | Yes | add 3; v[2]=1; break |
| 4 | 4 | 0.. | 1/3/3 | 1 | No | arr2[j] (3) < 4 → j++, then 6 > 4 → break |
| 5 | 5 | ... | 6 | - | No | 6 > 5 → break |

Result: `[1, 3, 3]`

### 💻 Code
```java
class BruteForce {
    public static void interSection(int arr1[], int arr2[]) {
        int n = arr1.length, m = arr2.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int v[] = new int[m]; // visitation array for arr2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j] && v[j] == 0) {
                    ans.add(arr1[i]);
                    v[j] = 1; // mark this arr2 position as used
                    break;    // move to next i
                }
                if (arr2[j] > arr1[i]) {
                    break;    // sorted shortcut
                }
            }
        }
        for (int x : ans) System.out.print(" " + x);
    }
}
```

### ⏱️ Complexity
- Time: O(n × m) in worst case; with early breaks on sorted arrays, often better
- Space: O(m) for visitation array + O(k) for output (k = intersection size)

---

## 2) Optimal Two-Pointer Technique

### 🧠 Theory
- Use two pointers `i` and `j` for `arr1` and `arr2`
- If `arr1[i] < arr2[j]`, advance `i`
- If `arr2[j] < arr1[i]`, advance `j`
- If equal, add to result and advance both
- Naturally handles duplicates by matching equal runs pairwise

### 🔍 Example
- `arr1 = [1,2,3,3,4,5]`
- `arr2 = [1,3,3,6]`

### 🧪 Dry Run (Tabular)

| i | arr1[i] | j | arr2[j] | Comparison | Action | Result |
|---|---------|---|---------|------------|--------|--------|
| 0 | 1 | 0 | 1 | == | add 1; i++; j++ | [1] |
| 1 | 2 | 1 | 3 | 2 < 3 | i++ | [1] |
| 2 | 3 | 1 | 3 | == | add 3; i++; j++ | [1,3] |
| 3 | 3 | 2 | 3 | == | add 3; i++; j++ | [1,3,3] |
| 4 | 4 | 3 | 6 | 4 < 6 | i++ | [1,3,3] |
| 5 | 5 | 3 | 6 | 5 < 6 | i++ | [1,3,3] |
| 6 | - | 3 | 6 | i end | stop | [1,3,3] |

Result: `[1, 3, 3]`

### 💻 Code
```java
class OptimalSolution {
    public static void interSection(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr2[j] < arr1[i]) {
                j++;
            }
            else { // equal
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        for (int x : ans) System.out.print(" " + x);
    }
}
```

### ⏱️ Complexity
- Time: O(n + m)
- Space: O(k) for output

---

## 🧠 Tricks to Remember
- "Two pointers meet at equals": advance the smaller; on equal, record and advance both
- "Early stop on end": loop stops when any array finishes
- "Duplicates handled naturally": equal runs across arrays contribute min(count1, count2) times
- For brute force: "visit once per position" — use a visitation array for arr2 to avoid recounting

---

## 🧪 Testing Snippets
```java
System.out.println("Brute Force Approach :");
int arr1[] = { 1, 2, 3, 3, 4 , 5, 6, 7, 8 , 9 , 10};
int arr2[] = { 1, 3, 3, 6 };
BruteForce.interSection(arr1, arr2);

System.out.println("\n\nOptimal approach :");
int arr3[] = { 1, 2, 3, 3, 4 };
int arr4[] = { 1, 3, 3, 6 };
OptimalSolution.interSection(arr3, arr4);
```

---

## 📎 Full Reference (Main + Calls)
```java
package STEP_3_ARRAY.EASY;

public class p10 {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 3, 4 , 5, 6, 7, 8 , 9 , 10};
        int arr2[] = { 1, 3, 3, 6 };
        System.out.println("Brute Force Approach :");
        BruteForce.interSection(arr1, arr2);
        
        System.out.println("\n\nOptimal approach :");
        int arr3[] = { 1, 2, 3, 3, 4 };
        int arr4[] = { 1, 3, 3, 6 };
        OptimalSolution.interSection(arr3, arr4);
    }
}
```

---

## ⏱️ Summary Complexity
- Brute Force: O(n × m) time, O(m + k) space
- Two Pointers: O(n + m) time, O(k) space

n = len(arr1), m = len(arr2), k = size of intersection
