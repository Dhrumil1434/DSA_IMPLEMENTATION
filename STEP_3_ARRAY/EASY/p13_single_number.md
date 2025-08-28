# 🚀 Array - Problem 13: Single Number (All Others Appear Twice)

> Find the element that appears exactly once in an integer array where every other element appears exactly twice. We’ll progress from brute force to hashmap to XOR, explicitly noting limitations and how each next approach overcomes them.

---

## 📋 Problem Statement
Given an array `arr` of integers, every element appears exactly twice except for one element which appears once. Return that single element.

### 🧩 Examples
- `[2, 2, 1]` → `1`
- `[4, 1, 2, 1, 2]` → `4`
- `[7]` → `7`

---

## 1) Brute Force 1 — Double Loop Counting

### 🧠 Theory
- For each element `arr[i]`, loop over the entire array and count its occurrences
- If an element has count `1`, return it

### 🔍 Limitations
- Time complexity O(n²) — expensive for large arrays
- Repeats counting for the same elements many times

### 💡 Overcomes
- Next approach uses extra memory to avoid repeated counting: reduces time at the cost of space

### 🧪 Dry Run
Array: `[2, 2, 1]`

| i | num | Count in arr | Action |
|---|-----|--------------|--------|
| 0 | 2 | 2 | continue |
| 1 | 2 | 2 | continue |
| 2 | 1 | 1 | return 1 |

### 💻 Code
```java
class BruteForce1 {
    public static int OnceOccuredNumber(int arr[]) {
        if (arr.length < 1) return -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int num = arr[i], cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == num) cnt++;
            }
            if (cnt == 1) return num;
        }
        return -1;
    }
}
```

### ⏱️ Complexity
- Time: O(n²)
- Space: O(1)

---

## 2) Brute Force 2 — Counting Array (Indexable Domain)

### 🧠 Theory
- Maintain a frequency array `temp[value]++`
- Scan for the index with count 1 and return it

### 🔍 Limitations
- Requires values to be non-negative and small (for array indexing)
- Breaks for large values, negatives, or wide ranges (memory blow-up)

### 💡 Overcomes
- Next approach generalizes counting to arbitrary integers using a `HashMap`

### 💻 Code
```java
class BruteForce2 {
    public static int OnceOccuredNumber(int arr[]) {
        if (arr.length < 1) return -1;
        int temp[] = new int[arr.length + 1]; // only safe for small, non-negative data
        for (int i = 0; i < arr.length; i++) temp[arr[i]]++;
        for (int i = 0; i < temp.length; i++) if (temp[i] == 1) return i;
        return -1;
    }
}
```

### ⏱️ Complexity
- Time: O(n + K) where K is the temp array size
- Space: O(K) — can be large or invalid for general inputs

---

## 3) Better — HashMap Frequency

### 🧠 Theory
- Count occurrences using `HashMap<Integer,Integer>`
- Return the key with value 1

### 🔍 Limitations
- Extra O(n) space for the map
- Slower than bitwise XOR due to hashing overhead

### 💡 Overcomes
- Next approach eliminates extra memory and leverages XOR properties

### 🧪 Dry Run
Array: `[4, 1, 2, 1, 2]`

| Step | Map State | Action |
|------|-----------|--------|
| 1 | {4:1} | add 4 |
| 2 | {4:1, 1:1} | add 1 |
| 3 | {4:1, 1:1, 2:1} | add 2 |
| 4 | {4:1, 1:2, 2:1} | inc 1 |
| 5 | {4:1, 1:2, 2:2} | inc 2 |
| Scan | value==1 → key=4 | return 4 |

### 💻 Code
```java
class BetterSolution1 {
    public static int getSingleElement(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }
        for (Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) return it.getKey();
        }
        return -1;
    }
}
```

### ⏱️ Complexity
- Time: O(n) expected
- Space: O(n)

---

## 4) Optimal — XOR Trick (O(1) Space)

### 🧠 Theory
- XOR properties: `a ^ a = 0`, `a ^ 0 = a`, associative, commutative
- XOR all elements: pairs cancel out, leaving the unique one

### 🔍 Limitations
- Assumes exactly one single and all others appear exactly twice
- If constraints differ (e.g., thrice), need other bitwise techniques

### 💡 Overcomes
- No extra memory; linear time; robust to value ranges (negatives allowed)

### 🧪 Dry Run
Array: `[4, 1, 2, 1, 2]`

| Step | xor (running) | Next | Result |
|------|----------------|------|--------|
| 0 | 0 | 4 | 4 |
| 1 | 4 | 1 | 4^1 |
| 2 | 4^1 | 2 | (4^1)^2 |
| 3 | (4^1)^2 | 1 | ((4^1)^2)^1 = 4^(1^1)^2 = 4^0^2 = 4^2 |
| 4 | 4^2 | 2 | 4^(2^2) = 4^0 = 4 |

Result: `4`

### 💻 Code
```java
class OptimalSolution {
    public static int getSingleElement(int arr[]) {
        int xor = 0;
        for (int x : arr) xor ^= x;
        return xor;
    }
}
```

### ⏱️ Complexity
- Time: O(n)
- Space: O(1)

---

## 🧠 Tricks to Remember
- **XOR Cancel**: pairs vanish; only the single remains
- **Map It**: when unsure, hashmap frequency always works
- **Double Loop is pain**: O(n²) — acceptable only for tiny inputs
- **Counting array is risky**: Only for small non-negative domains

---

## 🧪 Testing Snippets
```java
int arr1[] = { 2, 2, 1 };
System.out.println(BruteForce1.OnceOccuredNumber(arr1));
System.out.println(BruteForce2.OnceOccuredNumber(arr1));
System.out.println(BetterSolution1.getSingleElement(arr1));
System.out.println(OptimalSolution.getSingleElement(arr1));
```

---

## 📎 Full Reference (Main + Calls)
```java
package STEP_3_ARRAY.EASY;

public class p13 {
   public static void main(String[] args) {
       System.out.println("Initial Brute Force to get the once occured number: ");
       int arr1[] = { 2, 2, 1 };
       System.out.println("brute force 1 output : " + BruteForce1.OnceOccuredNumber(arr1));
       System.out.println("brute force 2 output : " + BruteForce2.OnceOccuredNumber(arr1));
       System.out.println();
       System.out.println("Initial Better solution to get the once occured number:");
       System.out.println("better solution 1 output :" + BetterSolution1.getSingleElement(arr1));
        System.out.println();
       System.out.println("Initial Optimal solution to get the once occured number:");
       System.out.println("optimal output :"+ OptimalSolution.getSingleElement(arr1));
   }
}
```

---

## ⏱️ Summary Complexity
- Brute Force (double loop): O(n²) time, O(1) space
- Brute Force (counting array): O(n + K) time, O(K) space (domain-limited)
- HashMap: O(n) time, O(n) space
- XOR: O(n) time, O(1) space
