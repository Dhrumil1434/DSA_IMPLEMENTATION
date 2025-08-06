# 🚀 Problem 15: Quick Sort Algorithm

> **Master the Divide-and-Conquer sorting algorithm with recursive implementation**

---

## 📋 Problem Statement

**Implement Quick Sort algorithm using recursion to sort an array in ascending order.**

### 🎯 **Input**
- An unsorted array of integers: `[6, 5, 4, 3, 2, 1, 0]`

### 🎯 **Output**
- Sorted array in ascending order: `[0, 1, 2, 3, 4, 5, 6]`

### 🔍 **Key Requirements**
- Use recursive approach
- Implement partition function
- Sort in-place (no extra space)
- Handle edge cases

---

## 🧠 Understanding Quick Sort

### 🎯 **Core Concept**

Quick Sort is a **divide-and-conquer** sorting algorithm that works by:

1. **Choosing a pivot** element from the array
2. **Partitioning** the array around the pivot
3. **Recursively sorting** the sub-arrays
4. **Combining** the results

### 🔄 **Recursive Strategy**

```
QuickSort(arr, low, high):
    if low < high:
        pivot_index = Partition(arr, low, high)
        QuickSort(arr, low, pivot_index - 1)    // Left sub-array
        QuickSort(arr, pivot_index + 1, high)   // Right sub-array
```

### 🎯 **Partition Function**

The partition function rearranges the array so that:
- All elements **smaller than pivot** are on the left
- All elements **greater than pivot** are on the right
- **Pivot** is in its final sorted position

---

## 💻 Implementation

### 🔧 **Complete Solution**

```java
public class p15 {
    
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[low];  // Choose first element as pivot
        int i = low;           // Left pointer
        int j = high;          // Right pointer

        while (i < j) {
            // Find element greater than pivot from left
            while (i <= high && arr[i] <= pivot) {
                i++;
            }
            // Find element smaller than pivot from right
            while (j >= low && arr[j] > pivot) {
                j--;
            }
            // Swap if pointers haven't crossed
            if (i < j) {
                ArrayUtils.swap(arr, i, j);
            }
        }
        // Place pivot in correct position
        ArrayUtils.swap(arr, low, j);
        return j;  // Return pivot index
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pindex = partition(arr, low, high);
            quickSort(arr, low, pindex - 1);    // Sort left sub-array
            quickSort(arr, pindex + 1, high);   // Sort right sub-array
        }
    }

    public static void main(String[] args) {
        int a[] = { 6, 5, 4, 3, 2, 1, 0 };
        System.out.println("Original Array: " + java.util.Arrays.toString(a));
        
        quickSort(a, 0, a.length - 1);
        
        System.out.println("Sorted Array: ");
        for(int x: a) {
            System.out.println(x);
        }
    }
}
```

### 🔧 **Helper Function (ArrayUtils)**

```java
public class ArrayUtils {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

## 🔍 Step-by-Step Execution

### 📊 **Example: Sorting [6, 5, 4, 3, 2, 1, 0]**

Let's trace through the execution:

#### **Initial State**
```
Array: [6, 5, 4, 3, 2, 1, 0]
       low=0, high=6
```

#### **First Partition (pivot = 6)**
```
Step 1: Choose pivot = arr[0] = 6
Step 2: i=0, j=6

Step 3: Move i right until arr[i] > 6
        i=0: arr[0]=6 ≤ 6, i++ → i=1
        i=1: arr[1]=5 ≤ 6, i++ → i=2
        i=2: arr[2]=4 ≤ 6, i++ → i=3
        i=3: arr[3]=3 ≤ 6, i++ → i=4
        i=4: arr[4]=2 ≤ 6, i++ → i=5
        i=5: arr[5]=1 ≤ 6, i++ → i=6
        i=6: arr[6]=0 ≤ 6, i++ → i=7 (i > high, stop)

Step 4: Move j left until arr[j] ≤ 6
        j=6: arr[6]=0 ≤ 6, stop

Step 5: i=7, j=6, i > j, so swap pivot with j
        Swap arr[0] and arr[6]
        Array: [0, 5, 4, 3, 2, 1, 6]
        Return j=6
```

#### **Recursive Calls**
```
quickSort([0, 5, 4, 3, 2, 1, 6], 0, 5)  // Left sub-array
quickSort([0, 5, 4, 3, 2, 1, 6], 7, 6)  // Right sub-array (invalid, ignored)
```

#### **Second Partition (pivot = 0)**
```
Array: [0, 5, 4, 3, 2, 1, 6]
       low=0, high=5, pivot=0

i moves: 0→1 (arr[1]=5 > 0, stop)
j moves: 5→4→3→2→1→0 (arr[0]=0 ≤ 0, stop)

i=1, j=0, i > j, swap pivot with j
Array: [0, 5, 4, 3, 2, 1, 6] (no change)
Return j=0
```

#### **Continue Recursion**
```
quickSort([0, 5, 4, 3, 2, 1, 6], 0, -1)  // Invalid, ignored
quickSort([0, 5, 4, 3, 2, 1, 6], 1, 5)  // Sort [5, 4, 3, 2, 1]
```

#### **Final Result**
After all recursive calls complete:
```
Sorted Array: [0, 1, 2, 3, 4, 5, 6]
```

---

## 🧮 Recursion Tree Analysis

### 🌳 **Recursive Call Structure**

```
quickSort([6,5,4,3,2,1,0], 0, 6)
├── partition → pivot=6, pindex=6
├── quickSort([0,5,4,3,2,1], 0, 5)
│   ├── partition → pivot=0, pindex=0
│   ├── quickSort([], 0, -1) → base case
│   └── quickSort([5,4,3,2,1], 1, 5)
│       ├── partition → pivot=5, pindex=5
│       ├── quickSort([1,2,3,4], 1, 4)
│       │   ├── partition → pivot=1, pindex=1
│       │   ├── quickSort([], 1, 0) → base case
│       │   └── quickSort([2,3,4], 2, 4)
│       │       ├── partition → pivot=2, pindex=2
│       │       ├── quickSort([], 2, 1) → base case
│       │       └── quickSort([3,4], 3, 4)
│       │           ├── partition → pivot=3, pindex=3
│       │           ├── quickSort([], 3, 2) → base case
│       │           └── quickSort([4], 4, 4) → base case
│       └── quickSort([], 6, 5) → base case
└── quickSort([], 7, 6) → base case
```

### 📊 **Base Cases**
- `low >= high`: Array has 0 or 1 element (already sorted)

### 🔄 **Recursive Cases**
- `low < high`: Array has 2 or more elements (needs sorting)

---

## ⏱️ Time Complexity Analysis

### 🎯 **Best Case: O(n log n)**
**Scenario**: Pivot always divides array into equal halves
```
Example: [4, 2, 6, 1, 3, 5, 7]
- Perfect pivot choices: 4, 2, 6, 1, 3, 5, 7
- Each level: n elements processed
- Levels: log₂(n)
- Total: n × log₂(n) = O(n log n)
```

### 🎯 **Average Case: O(n log n)**
**Scenario**: Pivot divides array reasonably well
```
Most real-world cases fall here
- Pivot typically divides array in 1:3 or 2:3 ratio
- Still results in O(n log n) performance
```

### 🎯 **Worst Case: O(n²)**
**Scenario**: Pivot always chooses smallest/largest element
```
Example: [1, 2, 3, 4, 5, 6, 7] (already sorted)
- Pivot choices: 1, 2, 3, 4, 5, 6, 7
- Each partition creates: [empty] + [n-1 elements]
- Levels: n
- Total: n × n = O(n²)
```

### 📊 **Space Complexity: O(log n)**
**Recursive call stack depth**:
- Best/Average: O(log n) - balanced recursion tree
- Worst: O(n) - skewed recursion tree

---

## 🔧 Optimization Strategies

### 🎯 **1. Randomized Pivot Selection**
```java
// Choose random pivot instead of first element
int randomIndex = low + (int)(Math.random() * (high - low + 1));
ArrayUtils.swap(arr, low, randomIndex);
int pivot = arr[low];
```

### 🎯 **2. Median-of-Three Pivot**
```java
// Choose median of first, middle, last elements
int mid = (low + high) / 2;
if (arr[mid] < arr[low]) ArrayUtils.swap(arr, low, mid);
if (arr[high] < arr[low]) ArrayUtils.swap(arr, low, high);
if (arr[high] < arr[mid]) ArrayUtils.swap(arr, mid, high);
ArrayUtils.swap(arr, low, mid);
int pivot = arr[low];
```

### 🎯 **3. Tail Call Optimization**
```java
// Optimize for worst-case space complexity
public static void quickSortOptimized(int arr[], int low, int high) {
    while (low < high) {
        int pindex = partition(arr, low, high);
        if (pindex - low < high - pindex) {
            quickSortOptimized(arr, low, pindex - 1);
            low = pindex + 1;  // Tail call
        } else {
            quickSortOptimized(arr, pindex + 1, high);
            high = pindex - 1;  // Tail call
        }
    }
}
```

---

## 🧪 Testing & Verification

### ✅ **Test Cases**

```java
// Test Case 1: Already sorted
int[] arr1 = {1, 2, 3, 4, 5};
quickSort(arr1, 0, arr1.length - 1);
// Expected: [1, 2, 3, 4, 5]

// Test Case 2: Reverse sorted
int[] arr2 = {5, 4, 3, 2, 1};
quickSort(arr2, 0, arr2.length - 1);
// Expected: [1, 2, 3, 4, 5]

// Test Case 3: Duplicate elements
int[] arr3 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
quickSort(arr3, 0, arr3.length - 1);
// Expected: [1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9]

// Test Case 4: Single element
int[] arr4 = {42};
quickSort(arr4, 0, arr4.length - 1);
// Expected: [42]

// Test Case 5: Empty array
int[] arr5 = {};
quickSort(arr5, 0, arr5.length - 1);
// Expected: []
```

### 🔍 **Edge Cases**
- Empty array
- Single element array
- Already sorted array
- Reverse sorted array
- Array with duplicates
- Array with negative numbers

---

## 🎯 Key Learning Points

### 🧠 **Recursive Thinking**
1. **Divide**: Partition array around pivot
2. **Conquer**: Recursively sort sub-arrays
3. **Combine**: Results are automatically combined

### 🔄 **Partition Strategy**
- **Two-pointer technique**: Efficient in-place partitioning
- **Pivot placement**: Ensures pivot is in final position
- **Boundary conditions**: Handle edge cases carefully

### ⚡ **Performance Characteristics**
- **In-place sorting**: No extra space needed
- **Cache-friendly**: Good locality of reference
- **Unstable sort**: Relative order of equal elements may change

### 🎯 **When to Use Quick Sort**
- **✅ Best for**: General-purpose sorting, large datasets
- **✅ Advantages**: Fast average case, in-place, cache-friendly
- **❌ Disadvantages**: Unstable, poor worst-case performance
- **🎯 Applications**: Built-in sort functions, real-world applications

---

## 🔗 Related Problems

### 📚 **Similar Recursive Sorting**
- **Merge Sort**: Divide-and-conquer, stable sort
- **Heap Sort**: In-place, guaranteed O(n log n)
- **Tree Sort**: Binary search tree approach

### 🎯 **Partition-Based Problems**
- **Quick Select**: Find k-th smallest element
- **Dutch National Flag**: Three-way partitioning
- **K-th Largest Element**: Using partition

---

## 🚀 Practice Problems

### 🎯 **Beginner Level**
1. **Implement Quick Sort with different pivot strategies**
2. **Count comparisons in Quick Sort**
3. **Find median using partition**

### 🎯 **Intermediate Level**
1. **Quick Select algorithm**
2. **Three-way Quick Sort (for duplicates)**
3. **Hybrid sorting (Quick Sort + Insertion Sort)**

### 🎯 **Advanced Level**
1. **Parallel Quick Sort**
2. **External Quick Sort**
3. **Quick Sort with custom comparators**

---

## 📊 Summary

| Aspect | Details |
|--------|---------|
| **Algorithm Type** | Divide-and-Conquer, Recursive |
| **Time Complexity** | O(n log n) average, O(n²) worst |
| **Space Complexity** | O(log n) average, O(n) worst |
| **Stability** | Unstable |
| **In-Place** | Yes |
| **Recursive Calls** | 2 per partition |
| **Base Case** | Array size ≤ 1 |

### 🎯 **Key Takeaways**
1. **Master partition function** - core of Quick Sort
2. **Understand pivot selection** - affects performance
3. **Handle edge cases** - empty arrays, duplicates
4. **Analyze complexity** - best, average, worst cases
5. **Optimize when needed** - randomized pivot, tail calls

---

<div align="center">

### 🌟 **Quick Sort Mastery Complete!** 🌟

**Next**: Explore other sorting algorithms or move to advanced recursion problems!

</div>

---

**Problem Type**: Sorting Algorithm  
**Difficulty**: ⭐⭐⭐ Medium  
**Key Concepts**: Divide-and-Conquer, Partition, Recursion  
**Time Complexity**: O(n log n) average  
**Space Complexity**: O(log n) average 