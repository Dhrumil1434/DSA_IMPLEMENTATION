# 🚀 Array - Problem 8: Linear Search

> Find the first occurrence of a target element in an array and return its index. Includes basic linear search, optimized versions for sorted arrays, and extensions for counting occurrences with detailed execution tables.

---

## 📋 Problem Statement
Given an integer array `arr` and a target value `k`, find the first occurrence of `k` in the array and return its index. If `k` is not found, return `-1`.

### 🧩 Examples
- Input: `[1, 2, 3, 4, 5, 6, 7, 8]`, target = `8` → Output: `7`
- Input: `[1, 2, 3, 4, 5, 6, 7, 8]`, target = `10` → Output: `-1`
- Input: `[1, 2, 3, 4, 5, 6, 7, 8]`, target = `1` → Output: `0`
- Input: `[1, 2, 2, 2, 3, 4, 2, 5]`, target = `2` → Output: `1` (first occurrence)

### ✅ Constraints & Requirements
- **Return first occurrence**: If target appears multiple times, return the lowest index
- **Handle edge cases**: Empty arrays, single elements, target not found
- **Efficiency**: Optimize for different array characteristics (sorted vs unsorted)
- **Memory**: Minimize extra space usage

---

## 🔧 Implementation Approaches

### 1) Basic Linear Search

#### 📝 **Algorithm Intuition**
- Scan the array sequentially from left to right
- Compare each element with the target value
- Return the index immediately when a match is found
- Return -1 if no match after scanning the entire array

#### 🔍 **Step-by-Step Execution Table**

**Example**: `[1, 2, 3, 4, 5, 6, 7, 8]` with target = `6`

| Step | i | arr[i] | arr[i] == 6? | Action | Return Value |
|------|---|---------|---------------|---------|--------------|
| 0 | 0 | 1 | False | Continue loop | - |
| 1 | 1 | 2 | False | Continue loop | - |
| 2 | 2 | 3 | False | Continue loop | - |
| 3 | 3 | 4 | False | Continue loop | - |
| 4 | 4 | 5 | False | Continue loop | - |
| 5 | 5 | 6 | **True** | **Return i** | **5** |

**Result**: Target `6` found at index `5`

#### 💻 **Code Implementation**
```java
public static int linearSearch(int arr[], int k) {
    // Edge case: empty array
    if (arr.length < 1) {
        return -1;
    }
    
    // Scan array sequentially from left to right
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == k) {
            return i; // Found target, return index immediately
        }
    }
    
    return -1; // Target not found after scanning entire array
}
```

---

### 2) Optimized Linear Search (Sorted Arrays)

#### 📝 **Algorithm Intuition**
- If the array is sorted in ascending order, we can optimize
- Stop searching when we encounter an element greater than the target
- All subsequent elements will be larger, so target cannot exist
- Provides early termination for better average case performance

#### 🔍 **Step-by-Step Execution Table**

**Example**: `[1, 2, 3, 4, 5, 6, 7, 8]` with target = `4`

| Step | i | arr[i] | arr[i] == 4? | arr[i] > 4? | Action | Return Value |
|------|---|---------|---------------|--------------|---------|--------------|
| 0 | 0 | 1 | False | False | Continue loop | - |
| 1 | 1 | 2 | False | False | Continue loop | - |
| 2 | 2 | 3 | False | False | Continue loop | - |
| 3 | 3 | 4 | **True** | False | **Return i** | **3** |

**Result**: Target `4` found at index `3` (early termination possible)

#### 💻 **Code Implementation**
```java
public static int optimizedLinearSearch(int arr[], int k) {
    if (arr.length < 1) {
        return -1;
    }
    
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == k) {
            return i; // Found target
        }
        // Optimization for sorted arrays: early termination
        if (arr[i] > k) {
            break; // No need to search further
        }
    }
    
    return -1; // Target not found
}
```

---

### 3) Linear Search with Count

#### 📝 **Algorithm Intuition**
- Find the first occurrence of the target
- Count how many times the target appears in the array
- Return both the first index and the total count
- Useful for frequency analysis and duplicate detection

#### 🔍 **Step-by-Step Execution Table**

**Example**: `[1, 2, 2, 2, 3, 4, 2, 5]` with target = `2`

| Step | i | arr[i] | arr[i] == 2? | firstIndex | count | Action |
|------|---|---------|---------------|------------|-------|---------|
| 0 | 0 | 1 | False | -1 | 0 | Continue loop |
| 1 | 1 | 2 | **True** | **1** | **1** | Set firstIndex=1, count++ |
| 2 | 2 | 2 | **True** | 1 | **2** | count++ |
| 3 | 3 | 2 | **True** | 1 | **3** | count++ |
| 4 | 4 | 3 | False | 1 | 3 | Continue loop |
| 5 | 5 | 4 | False | 1 | 3 | Continue loop |
| 6 | 6 | 2 | **True** | 1 | **4** | count++ |
| 7 | 7 | 5 | False | 1 | 4 | Continue loop |

**Result**: `{firstIndex: 1, count: 4}`

#### 💻 **Code Implementation**
```java
public static int[] linearSearchWithCount(int arr[], int k) {
    if (arr.length < 1) {
        return new int[]{-1, 0}; // {index, count}
    }
    
    int firstIndex = -1;
    int count = 0;
    
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == k) {
            if (firstIndex == -1) {
                firstIndex = i; // Record first occurrence
            }
            count++; // Increment count
        }
    }
    
    return new int[]{firstIndex, count}; // Return {first_index, total_count}
}
```

---

## 🧠 **Why Linear Search Works**

### 🔑 **Mathematical Foundation**
```
Key Insight: Sequential scanning guarantees finding the first occurrence

Let's trace through the logic:
- Array: [1, 2, 3, 4, 5, 6, 7, 8]
- Target: 6
- Scan order: 0→1→2→3→4→5→6→7

Why this finds first occurrence:
- We scan from left to right (index 0 to n-1)
- When we find a match, we return immediately
- No subsequent elements can have a lower index
- Therefore, we return the first occurrence
```

### 📊 **Search Patterns**
```
Different search scenarios:

1. Target at beginning: [6, 1, 2, 3, 4, 5] → O(1) best case
2. Target at end: [1, 2, 3, 4, 5, 6] → O(n) worst case  
3. Target in middle: [1, 2, 6, 3, 4, 5] → O(n/2) average case
4. Target not found: [1, 2, 3, 4, 5, 6] → O(n) worst case
```

---

## 🧪 Testing & Verification

### 📊 **Test Case 1: Basic Linear Search**
```java
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
System.out.println("Array: [1, 2, 3, 4, 5, 6, 7, 8]");
System.out.println("Searching for 8:");
System.out.println("Index: " + linearSearch(arr, 8));
// Expected: 7
```

### 📊 **Test Case 2: Target Not Found**
```java
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
System.out.println("Searching for 10:");
System.out.println("Index: " + linearSearch(arr, 10));
// Expected: -1
```

### 📊 **Test Case 3: Target at Beginning**
```java
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
System.out.println("Searching for 1:");
System.out.println("Index: " + linearSearch(arr, 1));
// Expected: 0
```

### 📊 **Test Case 4: Target in Middle**
```java
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
System.out.println("Searching for 4:");
System.out.println("Index: " + linearSearch(arr, 4));
// Expected: 3
```

### 📊 **Test Case 5: Optimized Search on Sorted Array**
```java
int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
System.out.println("Optimized search for 6:");
System.out.println("Index: " + optimizedLinearSearch(arr, 6));
// Expected: 5
```

### 📊 **Test Case 6: Search with Count**
```java
int arrWithDuplicates[] = { 1, 2, 2, 2, 3, 4, 2, 5 };
System.out.println("Array with duplicates: [1, 2, 2, 2, 3, 4, 2, 5]");
System.out.println("Searching for 2:");
int result[] = linearSearchWithCount(arrWithDuplicates, 2);
System.out.println("First index: " + result[0] + ", Count: " + result[1]);
// Expected: {1, 4}
```

### 📊 **Test Case 7: Empty Array**
```java
int emptyArr[] = {};
System.out.println("Empty array search for 5:");
System.out.println("Index: " + linearSearch(emptyArr, 5));
// Expected: -1
```

---

## ⏱️ Complexity Analysis

### 🎯 **Basic Linear Search**
- **Time Complexity**: O(n)
  - Best Case: O(1) - target found at first position
  - Average Case: O(n/2) - target found in middle on average
  - Worst Case: O(n) - target not found or at last position
- **Space Complexity**: O(1)
  - Only constant extra space for loop variables

### 🎯 **Optimized Linear Search (Sorted Arrays)**
- **Time Complexity**: O(n)
  - Best Case: O(1) - target found at first position
  - Average Case: O(n/2) - target found in middle on average
  - Worst Case: O(n) - target not found or at last position
  - **Early termination** can improve average case performance
- **Space Complexity**: O(1)
  - Only constant extra space

### 🎯 **Linear Search with Count**
- **Time Complexity**: O(n)
  - Must scan entire array to count all occurrences
  - No early termination possible
- **Space Complexity**: O(1)
  - Only constant extra space for counters

### 🔍 **Comparison with Binary Search**
| Aspect | Linear Search | Binary Search |
|--------|---------------|---------------|
| **Time Complexity** | O(n) | O(log n) |
| **Space Complexity** | O(1) | O(1) |
| **Array Requirement** | Any array | Sorted array only |
| **Implementation** | Simple | More complex |
| **Best For** | Small arrays, unsorted data | Large sorted arrays |

---

## 🎯 Key Learning Points

### 🧠 **Algorithm Design Principles**
- **Sequential scanning**: Simple but effective for small datasets
- **Early termination**: Optimize when possible (sorted arrays)
- **Edge case handling**: Empty arrays, single elements, not found

### 🔄 **Problem-Solving Strategy**
- **Start simple**: Basic linear search is often sufficient
- **Consider constraints**: Array size, sorting, memory limitations
- **Optimize incrementally**: Add improvements based on requirements

### ⚡ **Performance Optimization**
- **Best case optimization**: Return immediately when found
- **Early termination**: Stop when further search is futile
- **Memory efficiency**: Use constant extra space

---

## 🔗 Related Problems

### 📚 **Similar Search Problems**
- **Binary Search**: O(log n) search on sorted arrays
- **Jump Search**: O(√n) search on sorted arrays
- **Interpolation Search**: O(log log n) on uniformly distributed sorted arrays

### 🎯 **Advanced Variations**
- **Find last occurrence**: Scan from right to left
- **Find k-th occurrence**: Count occurrences until k-th
- **Find closest element**: Track minimum difference
- **Range search**: Find elements within a range

---

## 📎 Full Reference

```java
package STEP_3_ARRAY.EASY;

public class p8 {
    // Basic linear search implementation
    public static int linearSearch(int arr[], int k) { /* as above */ }
    
    // Optimized linear search for sorted arrays
    public static int optimizedLinearSearch(int arr[], int k) { /* as above */ }
    
    // Linear search with count of occurrences
    public static int[] linearSearchWithCount(int arr[], int k) { /* as above */ }
    
    public static void main(String[] args) {
        // Comprehensive test cases covering all scenarios
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        
        // Basic search tests
        System.out.println("Basic search for 8: " + linearSearch(arr, 8));
        System.out.println("Search for 10: " + linearSearch(arr, 10));
        System.out.println("Search for 1: " + linearSearch(arr, 1));
        System.out.println("Search for 4: " + linearSearch(arr, 4));
        
        // Optimized search tests
        System.out.println("Optimized search for 6: " + optimizedLinearSearch(arr, 6));
        
        // Count search tests
        int arrWithDuplicates[] = { 1, 2, 2, 2, 3, 4, 2, 5 };
        int result[] = linearSearchWithCount(arrWithDuplicates, 2);
        System.out.println("First index: " + result[0] + ", Count: " + result[1]);
        
        // Edge case tests
        int emptyArr[] = {};
        System.out.println("Empty array search: " + linearSearch(emptyArr, 5));
    }
}
```

---

<div align="center">

### 🌟 **Linear Search Mastery Complete!** 🌟

**Key Takeaway**: 
- Linear search is simple and works on any array
- Optimize with early termination for sorted arrays
- Consider binary search for large sorted datasets

</div>

---

**Problem Type**: Array Search  
**Difficulty**: ⭐ Beginner  
**Key Concepts**: Sequential Scanning, Early Termination, Edge Case Handling  
**Time Complexity**: O(n) worst case, O(1) best case  
**Space Complexity**: O(1) for all approaches
