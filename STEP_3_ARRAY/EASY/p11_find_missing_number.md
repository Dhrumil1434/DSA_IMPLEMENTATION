# 🚀 Array - Problem 11: Find the Missing Number (1..N)

> You are given an array of length N-1 containing distinct integers from 1..N (one number missing). Find the missing number. Three approaches: counting array, Gauss sum, and XOR. Each includes theory → example → tabular dry run → code → complexity.

---

## 📋 Problem Statement
- Input: `arr` of length `N-1` consisting of distinct elements from 1..N (exactly one number missing)
- Output: The missing number in 1..N

### 🧩 Example
- `arr = [1, 2, 4]`, with numbers expected from 1..4 → Missing: `3`

---

## 1) Counting Array (Visitation) — Brute Force

### 🧠 Theory
- Allocate a temp array `temp[1..N]` initialized to 0
- For each `x` in `arr`, mark `temp[x]++`
- Scan `1..N` to find the first `i` with `temp[i] == 0` → that `i` is missing

### 🧪 Dry Run (arr = [1,2,4], N = 4)

| Step | temp[1] | temp[2] | temp[3] | temp[4] | Action |
|------|---------|---------|---------|---------|--------|
| Init | 0 | 0 | 0 | 0 | Initialize temp to zeros |
| x=1 | 1 | 0 | 0 | 0 | Mark presence of 1 |
| x=2 | 1 | 1 | 0 | 0 | Mark presence of 2 |
| x=4 | 1 | 1 | 0 | 1 | Mark presence of 4 |
| Scan | 1 | 1 | 0 | 1 | temp[3]==0 → missing is 3 |

### 💻 Code
```java
class BruteForce {
    public static int findMissingElement(int arr[], int N) {
        if (arr.length < 1) return -1;
        int temp[] = new int[N + 1];      // 0..N, we use 1..N
        for (int i = 0; i < N - 1; i++) { // array has N-1 elements
            temp[arr[i]]++;
        }
        for (int i = 1; i <= N; i++) {    // find first 0
            if (temp[i] == 0) return i;
        }
        return -1; // should not reach if input is valid
    }
}
```

### ⏱️ Complexity
- Time: O(N)
- Space: O(N) extra

---

## 2) Gauss Sum Formula — Optimal O(1) Space

### 🧠 Theory
- Sum of first N integers: S = N(N+1)/2
- Let `sum(arr)` be the sum of given N-1 numbers
- Missing = S − sum(arr)

### 🧪 Dry Run (arr = [1,2,4], N = 4)

| Quantity | Value |
|----------|-------|
| N | 4 |
| S = N(N+1)/2 | 4×5/2 = 10 |
| sum(arr) | 1+2+4 = 7 |
| Missing | 10 − 7 = 3 |

### 💻 Code
```java
class OptimalSolution1 {
    public static int findMissingElement(int arr[], int N) {
        N = N + 1;                              // caller passed arr.length; expect numbers 1..(arr.length+1)
        int total_sum = (N * (N + 1)) / 2;      // Gauss formula
        int sum = 0;
        for (int i : arr) sum += i;
        return total_sum - sum;
    }
}
```

### ⏱️ Complexity
- Time: O(N)
- Space: O(1)

---

## 3) XOR Trick — Optimal O(1) Space

### 🧠 Theory
- Key properties: a^a = 0, a^0 = a, XOR is associative and commutative
- Compute: `x = 1 ^ 2 ^ ... ^ N`
- Compute: `y = arr[0] ^ arr[1] ^ ... ^ arr[N-2]`
- Missing = `x ^ y` (all present numbers cancel out, leaving the missing one)

### 🧪 Dry Run (arr = [1,2,4], N = 4)

| Expression | Expansion | Value |
|------------|-----------|-------|
| x | 1 ^ 2 ^ 3 ^ 4 | ((1^2)=3) ^ 3 ^ 4 = 3^3 ^ 4 = 0 ^ 4 = 4 |
| y | 1 ^ 2 ^ 4 | ((1^2)=3) ^ 4 = 7 |
| x ^ y | 4 ^ 7 | 3 (missing) |

### 💻 Code
```java
class OptimalSolution2 {
    public static int findMissingElement(int arr[], int N) {
        N = N + 1;                 // numbers are 1..N
        if (arr.length < 1) return -1;
        int x = 0, y = 0;
        for (int i = 1; i <= N; i++) x ^= i;          // XOR 1..N
        for (int v : arr) y ^= v;                     // XOR array values
        return x ^ y;                                 // cancels to missing
    }
}
```

Note: The code in your file computes two index-based XORs; the standard approach (shown above) XORs 1..N against array values for clarity and correctness.

### ⏱️ Complexity
- Time: O(N)
- Space: O(1)

---

## 🧠 Tricks to Remember
- **Gauss Snap**: "Sum 1..N is N(N+1)/2" → Missing = Total − Present
- **XOR Cancel**: "Pairs vanish" — XOR all 1..N and XOR all array elements, then XOR both results
- **Count Map**: When unsure, a simple counting array will always work

---

## 🧪 Testing Snippets
```java
int arr1[] = { 1, 2, 4 };                // N should be 4 here
int N = arr1.length;                      // caller uses length; methods adjust internally
System.out.println(BruteForce.findMissingElement(arr1, N));     // 3
System.out.println(OptimalSolution1.findMissingElement(arr1, N)); // 3
System.out.println(OptimalSolution2.findMissingElement(arr1, N)); // 3
```

---

## 📎 Full Reference (Main + Calls)
```java
package STEP_3_ARRAY.EASY;

public class p11 {
    public static void main(String[] args) {
        System.out.println("Brute Force Solution :");
        int arr1[] = { 1, 2, 4 };
        int N = arr1.length;
        System.out.println("Brute Force Approach :" + BruteForce.findMissingElement(arr1, N));
        System.out.println();
        System.out.println("Optimal 1 Approach :");
        System.out.println("ans :" + OptimalSolution1.findMissingElement(arr1, N));
        System.out.println();
        System.out.println("Optimal 2 Approach :");
        System.out.println("ans :"+OptimalSolution2.findMissingElement(arr1, N));
    }
}
```

---

## ⏱️ Summary Complexity
- Counting array: O(N) time, O(N) space
- Sum formula: O(N) time, O(1) space
- XOR: O(N) time, O(1) space
