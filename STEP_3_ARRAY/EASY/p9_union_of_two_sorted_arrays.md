# 🚀 Array - Problem 9: Union of Two Sorted Arrays

> Compute the union (unique elements) of two sorted arrays. Includes a HashSet-based approach and an optimal two-pointer technique with detailed tabular dry runs and a tricks section to remember the algorithm.

---

## 📋 Problem Statement
Given two arrays `arr1` and `arr2`, return their union as a sorted list of unique elements.

- Arrays may contain duplicates
- If arrays are not sorted, sort them first or use a set-based approach
- Output should not contain duplicates

### 🧩 Examples
- `arr1 = [1,2,2,3,3,4,5]`, `arr2 = [6,7,1,2,3,7,8]` → Union: `[1,2,3,4,5,6,7,8]`
- `arr1 = [1,2,3]`, `arr2 = [1,1,1]` → Union: `[1,2,3]`
- `arr1 = []`, `arr2 = []` → Union: `[]`

### ✅ Constraints & Notes
- If arrays are not sorted and you need stable sorted union, either sort or use TreeSet (Java)
- If order doesn't matter, HashSet is simplest
- Optimal two-pointer method requires sorted arrays

---

## 🔧 Approaches

### 1) Brute Force — HashSet (Works for any input order)
- Insert all elements from both arrays into a `HashSet`
- Convert the set into an array/list
- If you need sorted output, sort the result at the end or use a `TreeSet`

```java
class BruteForce {
    public static int[] unionOfTwoSortedArray(int arr1[], int arr2[]) {
        if (arr1.length < 1 && arr2.length < 1) return new int[0];
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr1) set.add(x);
        for (int x : arr2) set.add(x);
        int n = set.size();
        int[] temp = new int[n];
        int i = 0;
        for (int x : set) temp[i++] = x; // Note: iteration order is unspecified
        Arrays.sort(temp); // Optional: ensure sorted union
        return temp;
    }
}
```

- Time: O(n + m) expected for hashing + O(u log u) if you sort the result (u = unique count)
- Space: O(u)

---

### 2) Optimal — Two Pointers (Requires sorted inputs)
- Maintain two indices `i` and `j` for `arr1` and `arr2`
- At each step, push the smaller value if it is different from the last pushed
- If equal, push once and move both pointers
- After one array finishes, append remaining unique elements from the other

```java
class Optimal {
    public static void unionOfTwoSortedArray(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < arr1.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }

        while (j < arr2.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }

        // Print or return
        for (int x : union) System.out.print(" " + x);
    }
}
```

- Time: O(n + m)
- Space: O(u) for the union list

---

## 🔬 Tabular Dry Run (Two-Pointer Method)

Input (already sorted):
- `arr1 = [1,2,2,3,3,4,5]`
- `arr2 = [1,2,3,3,4,4,5,5]`

Start: `i=0`, `j=0`, `union=[]`

| Step | i | arr1[i] | j | arr2[j] | Condition | Action | union |
|------|---|---------|---|---------|-----------|--------|--------|
| 1 | 0 | 1 | 0 | 1 | arr1[i] <= arr2[j] | add 1; i++ | [1] |
| 2 | 1 | 2 | 0 | 1 | arr1[i] > arr2[j] | add 1? no (dup); j++ | [1] |
| 3 | 1 | 2 | 1 | 2 | <= | add 2; i++ | [1,2] |
| 4 | 2 | 2 | 1 | 2 | <= | add 2? no (dup); i++ | [1,2] |
| 5 | 3 | 3 | 1 | 2 | > | add 2? no (dup); j++ | [1,2] |
| 6 | 3 | 3 | 2 | 3 | <= | add 3; i++ | [1,2,3] |
| 7 | 4 | 3 | 2 | 3 | <= | add 3? no (dup); i++ | [1,2,3] |
| 8 | 5 | 4 | 2 | 3 | > | add 3? no (dup); j++ | [1,2,3] |
| 9 | 5 | 4 | 3 | 3 | > | add 3? no (dup); j++ | [1,2,3] |
| 10 | 5 | 4 | 4 | 4 | <= | add 4; i++ | [1,2,3,4] |
| 11 | 6 | 5 | 4 | 4 | > | add 4? no (dup); j++ | [1,2,3,4] |
| 12 | 6 | 5 | 5 | 4 | > | add 4? no (dup); j++ | [1,2,3,4] |
| 13 | 6 | 5 | 6 | 5 | <= | add 5; i++ | [1,2,3,4,5] |
| 14 | 7 | - | 6 | 5 | i end | process leftover arr2 | [1,2,3,4,5] |
| 15 | - | - | 6 | 5 | leftover | add 5? no (dup); j++ | [1,2,3,4,5] |
| 16 | - | - | 7 | 5 | leftover | add 5? no (dup); j++ | [1,2,3,4,5] |
| 17 | - | - | 8 | - | done | - | [1,2,3,4,5] |

Final union: `[1,2,3,4,5]`

---

## 🧠 Tricks to Remember
- "MERGE once, SKIP duplicates": Treat it like merge step of merge sort, but only append when different from last appended
- "LOOK-BACK guard": Always check `union.isEmpty() || union.get(last) != candidate` before appending
- "EQUAL → MOVE BOTH": If `arr1[i] == arr2[j]`, append once and advance pointer of the appended side; the code above appends from the `<=` side which effectively moves one, then the other matches as duplicate and is skipped
- "LEFTOVERS are UNIQUE-checked": After main loop, continue for leftover elements with the same duplicate guard

---

## 🧪 Testing Snippets
```java
int arr1[] = {1,2,2,3,3,4,5};
int arr2[] = {6,7,1,2,3,7,8};
Arrays.sort(arr1);
Arrays.sort(arr2);
int ans[] = BruteForce.unionOfTwoSortedArray(arr1, arr2);
System.out.println("BruteForce: " + java.util.Arrays.toString(ans)); // [1,2,3,4,5,6,7,8]

int arr3[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
int arr4[] = { 1, 2, 3, 3, 4, 4, 5, 5 };
System.out.print("Optimal: ");
Optimal.unionOfTwoSortedArray(arr3, arr4); // 1 2 3 4 5 6 7 8 9 10
```

---

## ⏱️ Complexity Analysis
- **HashSet approach**: O(n + m) expected; O(u) space; add O(u log u) if you sort the result
- **Two-pointer approach**: O(n + m); O(u) space for the output

n = len(arr1), m = len(arr2), u = number of unique elements in union

---

## 📎 Full Reference (Main + Calls)
```java
package STEP_3_ARRAY.EASY;

public class p9 {
    public static void main(String[] args) {
        int arr1[] = {1,2,2,3,3,4,5};
        int arr2[] = { 6, 7, 1, 2, 3, 7, 8 };
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans[] = BruteForce.unionOfTwoSortedArray(arr1, arr2);
        System.out.println("BruteForce Answer :");
        if (ans.length < 1) {
            System.out.println("invalid data was provided !");
        }
        for (int x : ans) {
            System.out.print(" " + x);
        }
        System.out.println();
        System.out.println();
        System.out.println("Optimal Answer");
        int arr3[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int arr4[] = { 1, 2, 3, 3, 4, 4, 5, 5 };
        Optimal.unionOfTwoSortedArray(arr3, arr4);
    }
}
```

---

<div align="center">

### 🌟 Union of Two Sorted Arrays — Mastery Complete! 🌟

**Key Takeaway**: Think of it as a merge with a duplicate guard; always check last appended value before pushing.

</div>
