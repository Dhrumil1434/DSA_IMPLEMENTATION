# 🚀 Array - Problem 5: Rotate Array Left by One Place

> Shift all elements one position to the left and move the first element to the end. Includes O(n) time brute-force (extra array) and optimal in-place O(1) space solution.

---

## 📋 Problem Statement
Given an integer array `arr`, rotate it left by one position.

- Left rotation by 1 transforms `[a0, a1, a2, ..., a(n-1)]` → `[a1, a2, ..., a(n-1), a0]`.
- Return the rotated array (either a new array or the same array modified in-place).

### 🧩 Examples
- Input: `[1, 2, 3, 4, 5, 5]` → Output: `[2, 3, 4, 5, 5, 1]`
- Input: `[]` → Output: `[]` (per current implementation)
- Input: `[7]` → Output: `[7]`

### ✅ Constraints & Edge Cases
- Works with duplicates and negative numbers
- Empty array returns an empty array
- For in-place approach, the input is modified

---

## 🔧 Implementations (from `STEP_3_ARRAY/EASY/p5.java`)

### 1) Brute Force (Extra Array)
- Copy elements 1..n-1 to a new array shifted left by 1
- Place original first element at the end

```java
class BruteForce {
    public static int[] rotateArrayLeftByOnePlace(int arr[]) {
        if (arr.length < 1) {
            return new int[0];
        }
        int temp[] = new int[arr.length];
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp[i - 1] = arr[i];
        }
        temp[temp.length - 1] = first;
        return temp;
    }
}
```

- **Time Complexity**: O(n)
- **Space Complexity**: O(n)
- **Notes**: Simple; does not mutate the original array

---

### 2) Optimal Solution (In-Place)
- Save the first element in a temporary variable
- Shift elements left within the same array
- Place saved first element at the last index

```java
class OptimalSolution {
    public static int[] rotateArrayLeftByOnePlace(int arr[]) {
        if (arr.length < 1) {
            return new int[0];
        }
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = first;
        return arr;
    }
}
```

- **Time Complexity**: O(n)
- **Space Complexity**: O(1)
- **Notes**: Efficient; modifies the input array

---

## 🧠 Reasoning & Extensions
- Left rotation by 1 is a special case of rotation by `k` where `k = 1`.
- For rotation by `k` in-place, you can use the reversal algorithm:

```java
// Rotate left by k (0 <= k < n) using reversals
static void reverse(int[] a, int l, int r) { while (l < r) { int t = a[l]; a[l++] = a[r]; a[r--] = t; } }
static void rotateLeftByK(int[] a, int k) {
    int n = a.length; if (n == 0) return; k %= n;
    reverse(a, 0, k - 1);     // reverse prefix
    reverse(a, k, n - 1);     // reverse suffix
    reverse(a, 0, n - 1);     // reverse whole
}
```

- The reversal method runs in O(n) time and O(1) space.

---

## 🔍 Edge Cases Covered
- `[]` → returns `[]`
- `[x]` → returns `[x]`
- Duplicates preserved; relative order among shifted elements maintained

---

## 🧪 Testing Snippets

```java
int[] a1 = {1, 2, 3, 4, 5, 5};
System.out.println(java.util.Arrays.toString(BruteForce.rotateArrayLeftByOnePlace(a1))); // [2, 3, 4, 5, 5, 1]

int[] a2 = {1, 2, 3, 4, 5};
System.out.println(java.util.Arrays.toString(OptimalSolution.rotateArrayLeftByOnePlace(a2))); // [2, 3, 4, 5, 1]

int[] a3 = {};
System.out.println(java.util.Arrays.toString(OptimalSolution.rotateArrayLeftByOnePlace(a3))); // []

int[] a4 = {7};
System.out.println(java.util.Arrays.toString(OptimalSolution.rotateArrayLeftByOnePlace(a4))); // [7]
```

---

## ⏱️ Complexity Deep-Dive
- Both methods do a single pass over the array → O(n) time
- Brute force uses O(n) extra memory; optimal uses O(1)
- Reversal-based rotation by k also achieves O(n) time and O(1) space

---

## 🧭 Summary
- For a single left rotation, prefer the in-place approach for O(1) extra space
- For general `k`, use reversal method to stay O(n)/O(1)
- Handle empty arrays gracefully; behavior matches your implementation

---

## 📎 Full Reference (Main + Calls)

```java
package STEP_3_ARRAY.EASY;

public class p5 {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 5 };
        int ans[] = BruteForce.rotateArrayLeftByOnePlace(arr);
        System.out.println("Brute Force Output : ");
        for (int x : ans) System.out.println(x);
        System.out.println("Optimal Solution Output :");
        int oans[] = OptimalSolution.rotateArrayLeftByOnePlace(arr);
        for (int x : oans) System.out.println(x);
    }
}
```
