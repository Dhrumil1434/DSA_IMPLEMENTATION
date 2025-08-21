# 🚀 Array - Problem 6: Rotate Array by K Places (Left & Right)

> Rotate an array by K positions in either direction. Includes detailed explanation of why `k = k % n` is crucial, step-by-step execution tables, and both left/right rotation approaches.

---

## 📋 Problem Statement
Given an integer array `arr` and a rotation value `k`, rotate the array by `k` positions.

- **Left Rotation**: Move first `k` elements to the end
- **Right Rotation**: Move last `k` elements to the beginning
- **Key Optimization**: `k = k % n` handles large rotation values efficiently

### 🧩 Examples
- **Left Rotation**: `[1,2,3,4,5,6]` with `k=2` → `[3,4,5,6,1,2]`
- **Right Rotation**: `[1,2,3,4,5,6]` with `k=3` → `[4,5,6,1,2,3]`
- **Large k**: `[1,2,3,4,5]` with `k=7` → same as `k=2` (because `7 % 5 = 2`)

---

## 🧠 Why `k = k % n` is Crucial

### 🔑 **Mathematical Foundation**
```
Array length = n
Rotation by k positions

Key Insight: Rotating by n positions brings array back to original state
- k = 0: No rotation
- k = n: Full rotation = original array
- k = n+1: Same as k = 1
- k = n+2: Same as k = 2
```

### 📊 **Concrete Example**
```
Array: [1, 2, 3, 4, 5, 6] with n = 6

k = 0: [1, 2, 3, 4, 5, 6] → [1, 2, 3, 4, 5, 6] (no change)
k = 1: [1, 2, 3, 4, 5, 6] → [2, 3, 4, 5, 6, 1]
k = 2: [1, 2, 3, 4, 5, 6] → [3, 4, 5, 6, 1, 2]
k = 3: [1, 2, 3, 4, 5, 6] → [4, 5, 6, 1, 2, 3]
k = 4: [1, 2, 3, 4, 5, 6] → [5, 6, 1, 2, 3, 4]
k = 5: [1, 2, 3, 4, 5, 6] → [6, 1, 2, 3, 4, 5]
k = 6: [1, 2, 3, 4, 5, 6] → [1, 2, 3, 4, 5, 6] (back to original!)
k = 7: [1, 2, 3, 4, 5, 6] → [2, 3, 4, 5, 6, 1] (same as k = 1)
k = 8: [1, 2, 3, 4, 5, 6] → [3, 4, 5, 6, 1, 2] (same as k = 2)
```

### 🎯 **Formula**
```
Effective rotation = k % n
Where: k = input rotation, n = array length

Examples:
- k = 7, n = 6: 7 % 6 = 1 → rotate by 1
- k = 12, n = 6: 12 % 6 = 0 → no rotation
- k = 23, n = 6: 23 % 6 = 5 → rotate by 5
```

---

## 🔧 Implementations

### 1) Right Rotation by K Places

#### 📝 **Algorithm Steps**
1. **Store last k elements** in temporary array
2. **Shift remaining elements** right by k positions
3. **Place temp elements** at the beginning

#### 🔍 **Step-by-Step Execution Table**

**Example**: `[1, 2, 3, 4, 5, 6]` with `k = 3`

| Step | Action | Array State | Temp Array | Explanation |
|------|---------|-------------|------------|-------------|
| 0 | Initial | `[1, 2, 3, 4, 5, 6]` | `[]` | Original array |
| 1 | k = k % n | `[1, 2, 3, 4, 5, 6]` | `[]` | 3 % 6 = 3 (no change) |
| 2 | Store last 3 | `[1, 2, 3, 4, 5, 6]` | `[4, 5, 6]` | temp[0]=arr[3], temp[1]=arr[4], temp[2]=arr[5] |
| 3 | Shift right by 3 | `[1, 2, 3, 1, 2, 3]` | `[4, 5, 6]` | arr[3]=arr[0], arr[4]=arr[1], arr[5]=arr[2] |
| 4 | Place temp at start | `[4, 5, 6, 1, 2, 3]` | `[4, 5, 6]` | arr[0]=temp[0], arr[1]=temp[1], arr[2]=temp[2] |

**Result**: `[4, 5, 6, 1, 2, 3]`

#### 💻 **Code with Comments**
```java
public static int[] rotateElementRightByKplace(int arr[], int k) {
    int n = arr.length;
    if (n < 1) return new int[0];
    
    // CRITICAL: Handle large k values efficiently
    k = k % n;
    
    // If k is 0, no rotation needed
    if (k == 0) return arr;
    
    // Step 1: Store last k elements in temp array
    int temp[] = new int[k];
    for (int i = n - k; i < n; i++) {
        temp[i - n + k] = arr[i];  // temp[0] = arr[n-k], temp[1] = arr[n-k+1], etc.
    }
    
    // Step 2: Shift remaining elements right by k positions
    for (int i = n - k - 1; i >= 0; i--) {
        arr[i + k] = arr[i];  // arr[n-1] = arr[n-k-1], arr[n-2] = arr[n-k-2], etc.
    }
    
    // Step 3: Place temp elements at beginning
    for (int i = 0; i < k; i++) {
        arr[i] = temp[i];
    }
    
    return arr;
}
```

---

### 2) Left Rotation by K Places

#### 📝 **Algorithm Steps**
1. **Store first k elements** in temporary array
2. **Shift remaining elements** left by k positions
3. **Place temp elements** at the end

#### 🔍 **Step-by-Step Execution Table**

**Example**: `[1, 2, 3, 4, 5, 6]` with `k = 2`

| Step | Action | Array State | Temp Array | Explanation |
|------|---------|-------------|------------|-------------|
| 0 | Initial | `[1, 2, 3, 4, 5, 6]` | `[]` | Original array |
| 1 | k = k % n | `[1, 2, 3, 4, 5, 6]` | `[]` | 2 % 6 = 2 (no change) |
| 2 | Store first 2 | `[1, 2, 3, 4, 5, 6]` | `[1, 2]` | temp[0]=arr[0], temp[1]=arr[1] |
| 3 | Shift left by 2 | `[3, 4, 5, 6, 5, 6]` | `[1, 2]` | arr[0]=arr[2], arr[1]=arr[3], arr[2]=arr[4], arr[3]=arr[5] |
| 4 | Place temp at end | `[3, 4, 5, 6, 1, 2]` | `[1, 2]` | arr[4]=temp[0], arr[5]=temp[1] |

**Result**: `[3, 4, 5, 6, 1, 2]`

#### 💻 **Code with Comments**
```java
public static int[] rotateArrayLeftByKPlace(int arr[], int k) {
    int n = arr.length;
    if (n == 0) return new int[0];
    
    // CRITICAL: Handle large k values efficiently
    k = k % n;
    
    // If k is 0, no rotation needed
    if (k == 0) return arr;
    
    // Step 1: Store first k elements in temp array
    int temp[] = new int[k];
    for (int i = 0; i < k; i++) {
        temp[i] = arr[i];  // temp[0] = arr[0], temp[1] = arr[1], ..., temp[k-1] = arr[k-1]
    }
    
    // Step 2: Shift remaining elements left by k positions
    for (int i = 0; i < n - k; i++) {
        arr[i] = arr[i + k];  // arr[0] = arr[k], arr[1] = arr[k+1], ..., arr[n-k-1] = arr[n-1]
    }
    
    // Step 3: Place temp elements at end
    for (int i = n - k; i < n; i++) {
        arr[i] = temp[i - n + k];  // arr[n-k] = temp[0], arr[n-k+1] = temp[1], etc.
    }
    
    return arr;
}
```

---

## 🧪 Testing & Verification

### 📊 **Test Case 1: Right Rotation**
```java
int arr[] = { 1, 2, 3, 4, 5, 6 };
System.out.println("Original: [1, 2, 3, 4, 5, 6]");
System.out.println("Right rotation by k=3:");

int result[] = TempArrayApproach.rotateElementRightByKplace(arr, 3);
System.out.println("Output: " + Arrays.toString(result));
// Expected: [4, 5, 6, 1, 2, 3]
```

### 📊 **Test Case 2: Large k Value (Demonstrates k % n)**
```java
int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
System.out.println("Original: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
System.out.println("Left rotation by k=3000001:");

int result[] = TempArrayApproach.rotateArrayLeftByKPlace(arr1, 3000001);
System.out.println("Note: 3000001 % 10 = 1, so this is same as rotating by 1");
System.out.println("Output: " + Arrays.toString(result));
// Expected: [2, 3, 4, 5, 6, 7, 8, 9, 10, 1]
```

---

## ⏱️ Complexity Analysis

### 🎯 **Time Complexity: O(n)**
- **k % n calculation**: O(1)
- **Storing elements in temp**: O(k)
- **Shifting elements**: O(n-k)
- **Placing temp elements**: O(k)
- **Total**: O(k) + O(n-k) + O(k) = O(n)

### 🎯 **Space Complexity: O(k)**
- **Temporary array**: O(k) space for storing k elements
- **No additional space**: All operations are in-place on the original array

### 🔍 **Why Not O(n²)?**
- Each element is moved exactly once
- No nested loops
- Linear time complexity regardless of k value

---

## 🚀 Alternative Approaches

### 1) **Reversal Method (O(1) Space)**
```java
// Rotate left by k using reversals
static void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

static void rotateLeftByK(int[] arr, int k) {
    int n = arr.length;
    k = k % n;
    reverse(arr, 0, k - 1);     // Reverse first k elements
    reverse(arr, k, n - 1);     // Reverse remaining elements
    reverse(arr, 0, n - 1);     // Reverse entire array
}
```

**Example**: `[1,2,3,4,5,6]` with `k=2`
1. Reverse first 2: `[2,1,3,4,5,6]`
2. Reverse last 4: `[2,1,6,5,4,3]`
3. Reverse all: `[3,4,5,6,1,2]`

### 2) **Juggling Algorithm**
- More complex but also O(1) space
- Useful for very large arrays where temp array is expensive

---

## 🎯 Key Learning Points

### 🧠 **Mathematical Insight**
- **Modular arithmetic** is crucial for handling large rotation values
- **Cyclic nature** of rotations: rotating by n positions = no change
- **Efficiency gain**: k=1000000 with n=10 becomes k=0 (no rotation needed)

### 🔄 **Algorithm Design**
- **Break down complex operations** into simple steps
- **Use temporary storage** when in-place operations are complex
- **Consider edge cases**: empty arrays, k=0, k≥n

### ⚡ **Performance Optimization**
- **k % n optimization** transforms O(k) operations to O(n) when k >> n
- **Single-pass algorithms** are often more efficient than multiple passes
- **Space-time trade-offs**: temp array vs complex in-place operations

---

## 🔗 Related Problems

### 📚 **Similar Array Manipulation**
- **Reverse Array**: Foundation for reversal-based rotation
- **Rotate by 1**: Special case of this problem
- **Circular Array**: Related concepts

### 🎯 **Advanced Variations**
- **Rotate in groups**: Rotate subarrays
- **Bidirectional rotation**: Support both left and right
- **Circular queue**: Application of rotation concepts

---

## 📎 Full Reference

```java
package STEP_3_ARRAY.EASY;

public class p6 {
    public static void main(String[] args) {
        // Test cases demonstrating both approaches
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        
        // Right rotation by 3
        int oneop[] = TempArrayApproach.rotateElementRightByKplace(arr, 3);
        
        // Left rotation by large k (demonstrates k % n)
        int twoop[] = TempArrayApproach.rotateArrayLeftByKPlace(arr1, 3000001);
    }
}
```

---

<div align="center">

### 🌟 **Array Rotation Mastery Complete!** 🌟

**Key Takeaway**: Always use `k = k % n` to handle large rotation values efficiently!

</div>

---

**Problem Type**: Array Manipulation  
**Difficulty**: ⭐⭐ Easy  
**Key Concepts**: Modular Arithmetic, In-Place Operations, Temporary Arrays  
**Time Complexity**: O(n)  
**Space Complexity**: O(k)
