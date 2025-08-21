# 🚀 Array - Problem 7: Move All Zeros to End

> Move all zeros in an array to the end while maintaining the relative order of non-zero elements. Includes brute force (extra array) and optimal two-pointer (in-place) approaches with detailed execution tables.

---

## 📋 Problem Statement
Given an integer array `arr`, move all 0's to the end while maintaining the relative order of the non-zero elements.

### 🧩 Examples
- Input: `[1, 0, 2, 0, 0, 3]` → Output: `[1, 2, 3, 0, 0, 0]`
- Input: `[0, 0, 0, 1, 2, 3]` → Output: `[1, 2, 3, 0, 0, 0]`
- Input: `[1, 2, 3, 0, 0, 0]` → Output: `[1, 2, 3, 0, 0, 0]` (already correct)
- Input: `[0, 0, 0, 0, 0, 0]` → Output: `[0, 0, 0, 0, 0, 0]` (no change)

### ✅ Constraints & Requirements
- **Relative order preservation**: Non-zero elements must maintain their original order
- **Zero placement**: All zeros must be moved to the end
- **In-place operation**: Preferred for space efficiency
- **No extra data structures**: Minimize memory usage

---

## 🔧 Implementation Approaches

### 1) Brute Force Approach (Extra Array)

#### 📝 **Algorithm Intuition**
- Use a temporary array to collect all non-zero elements
- Copy non-zeros back to the original array starting from index 0
- Fill remaining positions with zeros

#### 🔍 **Step-by-Step Execution Table**

**Example**: `[1, 0, 2, 0, 0, 3]` with `n = 6`

| Step | Action | Array State | Temp Array | k | Explanation |
|------|---------|-------------|------------|---|-------------|
| 0 | Initial | `[1, 0, 2, 0, 0, 3]` | `[0, 0, 0, 0, 0, 0]` | 0 | Original array |
| 1 | i=0, arr[0]=1≠0 | `[1, 0, 2, 0, 0, 3]` | `[1, 0, 0, 0, 0, 0]` | 1 | temp[0]=1, k++ |
| 2 | i=1, arr[1]=0 | `[1, 0, 2, 0, 0, 3]` | `[1, 0, 0, 0, 0, 0]` | 1 | Skip zero, k unchanged |
| 3 | i=2, arr[2]=2≠0 | `[1, 0, 2, 0, 0, 3]` | `[1, 2, 0, 0, 0, 0]` | 2 | temp[1]=2, k++ |
| 4 | i=3, arr[3]=0 | `[1, 0, 2, 0, 0, 3]` | `[1, 2, 0, 0, 0, 0]` | 2 | Skip zero, k unchanged |
| 5 | i=4, arr[4]=0 | `[1, 0, 2, 0, 0, 3]` | `[1, 2, 0, 0, 0, 0]` | 2 | Skip zero, k unchanged |
| 6 | i=5, arr[5]=3≠0 | `[1, 0, 2, 0, 0, 3]` | `[1, 2, 3, 0, 0, 0]` | 3 | temp[2]=3, k++ |
| 7 | Copy temp back | `[1, 2, 3, 0, 0, 0]` | `[1, 2, 3, 0, 0, 0]` | 3 | arr[0:2] = temp[0:2] |
| 8 | Fill with zeros | `[1, 2, 3, 0, 0, 0]` | `[1, 2, 3, 0, 0, 0]` | 3 | arr[3:5] = 0 |

**Result**: `[1, 2, 3, 0, 0, 0]`

#### 💻 **Code Implementation**
```java
class BruteForce {
    public static void moveZerosToEnd(int arr[]) {
        int n = arr.length;
        if (n < 1) return;
        
        // Step 1: Create temporary array and collect non-zero elements
        int temp[] = new int[n];
        int k = 0; // Index for temp array
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[k++] = arr[i]; // Copy non-zero to temp, increment k
            }
        }
        
        // Step 2: Copy non-zero elements back to original array
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
        
        // Step 3: Fill remaining positions with zeros
        for (int i = k; i < n; i++) {
            arr[i] = 0;
        }
    }
}
```

---

### 2) Optimal Solution (Two-Pointer Technique)

#### 📝 **Algorithm Intuition**
- Use two pointers: `j` points to the first zero, `i` scans for non-zeros
- When we find a non-zero after position `j`, swap it with `arr[j]`
- Increment `j` to point to the next zero position
- This moves non-zeros to the left and zeros to the right

#### 🔍 **Step-by-Step Execution Table**

**Example**: `[1, 0, 2, 0, 0, 3]`

| Step | Action | Array State | j | i | Explanation |
|------|---------|-------------|---|---|-------------|
| 0 | Initial | `[1, 0, 2, 0, 0, 3]` | -1 | - | Original array |
| 1 | Find first zero | `[1, 0, 2, 0, 0, 3]` | 1 | - | j = 1 (first zero at index 1) |
| 2 | i=2, arr[2]=2≠0 | `[1, 2, 0, 0, 0, 3]` | 2 | 2 | Swap arr[2] with arr[1], j++ |
| 3 | i=3, arr[3]=0 | `[1, 2, 0, 0, 0, 3]` | 2 | 3 | Skip zero, j unchanged |
| 4 | i=4, arr[4]=0 | `[1, 2, 0, 0, 0, 3]` | 2 | 4 | Skip zero, j unchanged |
| 5 | i=5, arr[5]=3≠0 | `[1, 2, 3, 0, 0, 0]` | 3 | 5 | Swap arr[5] with arr[2], j++ |
| 6 | i=6, loop ends | `[1, 2, 3, 0, 0, 0]` | 3 | 6 | Final result |

**Result**: `[1, 2, 3, 0, 0, 0]`

#### 💻 **Code Implementation**
```java
class BetterSolution {
    public static void moveZerosToEnd(int arr[]) {
        if (arr.length < 1) return;
        
        // Step 1: Find the first zero (j pointer)
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        
        // If no zeros found, array is already correct
        if (j == -1) return;
        
        // Step 2: For each non-zero element after j, swap with arr[j]
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                ArrayUtils.swap(arr, i, j); // Swap non-zero with zero
                j++; // Move j to next position (which now contains a zero)
            }
        }
    }
}
```

---

## 🧠 **Why Two-Pointer Technique Works**

### 🔑 **Mathematical Foundation**
```
Key Insight: We can maintain relative order by swapping non-zeros with the leftmost zero

Let's trace through the logic:
- Original: [1, 0, 2, 0, 0, 3]
- After finding first zero: j = 1, array unchanged
- After first swap (i=2): [1, 2, 0, 0, 0, 3], j = 2
- After second swap (i=5): [1, 2, 3, 0, 0, 0], j = 3

Why this preserves order:
- Element 1 stays at position 0 (no swap)
- Element 2 moves from position 2 to position 1 (swapped with zero)
- Element 3 moves from position 5 to position 2 (swapped with zero)
- All non-zeros maintain their relative order: 1 → 2 → 3
```

### 📊 **Visual Representation**
```
Step-by-step transformation:

[1, 0, 2, 0, 0, 3]  ← Original
     ↑
     j (first zero)

[1, 2, 0, 0, 0, 3]  ← After swapping arr[2]=2 with arr[1]=0
        ↑
        j (next zero)

[1, 2, 3, 0, 0, 0]  ← After swapping arr[5]=3 with arr[2]=0
           ↑
           j (next zero)

Final result: [1, 2, 3, 0, 0, 0]
```

---

## 🧪 Testing & Verification

### 📊 **Test Case 1: Scattered Zeros**
```java
int arr[] = { 1, 0, 2, 0, 0, 3 };
System.out.println("Original: [1, 0, 2, 0, 0, 3]");
BruteForce.moveZerosToEnd(arr);
// Expected: [1, 2, 3, 0, 0, 0]
```

### 📊 **Test Case 2: Zeros at Beginning**
```java
int arr2[] = { 0, 0, 0, 1, 2, 3 };
System.out.println("Original: [0, 0, 0, 1, 2, 3]");
BetterSolution.moveZerosToEnd(arr2);
// Expected: [1, 2, 3, 0, 0, 0]
```

### 📊 **Test Case 3: Zeros at End**
```java
int arr3[] = { 1, 2, 3, 0, 0, 0 };
System.out.println("Original: [1, 2, 3, 0, 0, 0]");
BetterSolution.moveZerosToEnd(arr3);
// Expected: [1, 2, 3, 0, 0, 0] (no change)
```

### 📊 **Test Case 4: All Zeros**
```java
int arr4[] = { 0, 0, 0, 0, 0, 0 };
System.out.println("Original: [0, 0, 0, 0, 0, 0]");
BetterSolution.moveZerosToEnd(arr4);
// Expected: [0, 0, 0, 0, 0, 0] (no change)
```

---

## ⏱️ Complexity Analysis

### 🎯 **Brute Force Approach**
- **Time Complexity**: O(n)
  - First pass: O(n) to collect non-zeros
  - Second pass: O(k) to copy back non-zeros (where k ≤ n)
  - Third pass: O(n-k) to fill with zeros
  - Total: O(n) + O(k) + O(n-k) = O(n)
- **Space Complexity**: O(n)
  - Temporary array of size n

### 🎯 **Two-Pointer Approach**
- **Time Complexity**: O(n)
  - First pass: O(n) to find first zero
  - Second pass: O(n) to scan and swap
  - Total: O(n) + O(n) = O(n)
- **Space Complexity**: O(1)
  - Only constant extra space for variables

### 🔍 **Why Both Are O(n)?**
- Each element is processed at most twice
- No nested loops
- Linear time complexity regardless of zero distribution

---

## 🎯 Key Learning Points

### 🧠 **Algorithm Design Principles**
- **Space-time trade-offs**: Extra space can simplify logic
- **Two-pointer technique**: Powerful for in-place array manipulation
- **Order preservation**: Swapping maintains relative positions

### 🔄 **Problem-Solving Strategy**
- **Start with brute force**: Understand the problem clearly
- **Identify inefficiencies**: Look for unnecessary operations
- **Optimize incrementally**: Improve space complexity step by step

### ⚡ **Performance Optimization**
- **In-place operations**: Reduce memory usage
- **Single-pass algorithms**: Minimize redundant operations
- **Early termination**: Handle edge cases efficiently

---

## 🔗 Related Problems

### 📚 **Similar Array Manipulation**
- **Remove Duplicates**: Similar two-pointer approach
- **Partition Array**: Divide array based on condition
- **Sort Colors**: Three-way partitioning

### 🎯 **Advanced Variations**
- **Move Zeros to Front**: Reverse the problem
- **Move Specific Elements**: Generalize to any value
- **Stable Sort**: Maintain relative order during sorting

---

## 📎 Full Reference

```java
package STEP_3_ARRAY.EASY;

public class p7 {
    public static void main(String[] args) {
        // Test case: Array with zeros scattered throughout
        int arr[] = { 1, 0, 2, 0, 0, 3 };
        System.out.println("Original array: [1, 0, 2, 0, 0, 3]");
        System.out.println("Brute Force Approach (Extra Array):");
        BruteForce.moveZerosToEnd(arr);
        
        System.out.println("\nBetter Solution (Two-Pointer, In-Place):");
        int arr1[] = { 1, 0, 2, 0, 0, 3 };
        BetterSolution.moveZerosToEnd(arr1);
        
        // Additional test cases for comprehensive testing
        System.out.println("\nTest Case 2: [0, 0, 0, 1, 2, 3]");
        int arr2[] = { 0, 0, 0, 1, 2, 3 };
        BetterSolution.moveZerosToEnd(arr2);
        
        System.out.println("\nTest Case 3: [1, 2, 3, 0, 0, 0]");
        int arr3[] = { 1, 2, 3, 0, 0, 0 };
        BetterSolution.moveZerosToEnd(arr3);
        
        System.out.println("\nTest Case 4: [0, 0, 0, 0, 0, 0]");
        int arr4[] = { 0, 0, 0, 0, 0, 0 };
        BetterSolution.moveZerosToEnd(arr4);
    }
}
```

---

<div align="center">

### 🌟 **Move Zeros to End Mastery Complete!** 🌟

**Key Takeaway**: 
- Two-pointer technique provides O(1) space solution
- Brute force is simpler but uses O(n) extra space
- Both approaches maintain relative order of non-zero elements

</div>

---

**Problem Type**: Array Manipulation  
**Difficulty**: ⭐⭐ Easy  
**Key Concepts**: Two-Pointer Technique, In-Place Operations, Order Preservation  
**Time Complexity**: O(n) for both approaches  
**Space Complexity**: O(n) for brute force, O(1) for two-pointer
