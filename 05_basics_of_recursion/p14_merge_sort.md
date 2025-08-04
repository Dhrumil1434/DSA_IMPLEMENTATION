 # 🔄 Problem 14: Merge Sort Using Recursion

> **Master the Divide-and-Conquer paradigm through Merge Sort implementation**

---

## 📋 Problem Statement

**Implement Merge Sort algorithm using recursion to sort an array in ascending order.**

### 🎯 **Objective**
- Sort an array using the Merge Sort algorithm
- Understand the Divide-and-Conquer approach
- Master the concept of merging two sorted arrays
- Analyze time and space complexity

### 📝 **Input/Output**
- **Input**: An unsorted array of integers
- **Output**: The same array sorted in ascending order
- **Example**: `[5, 4, 3, 2, 1]` → `[1, 2, 3, 4, 5]`

---

## 🧠 Understanding Merge Sort

### 🎯 **Core Concept**
Merge Sort is a **Divide-and-Conquer** algorithm that:
1. **Divides** the array into two halves recursively
2. **Conquers** by sorting the two halves
3. **Combines** the sorted halves into a single sorted array

### 🔄 **Algorithm Steps**

```mermaid
graph TD
    A[Original Array: 5,4,3,2,1] --> B[Divide: 5,4 | 3,2,1]
    B --> C[Divide: 5 | 4]
    B --> D[Divide: 3,2 | 1]
    C --> E[Sort: 4,5]
    D --> F[Divide: 3 | 2]
    F --> G[Sort: 2,3]
    G --> H[Merge: 1,2,3]
    E --> I[Merge: 1,2,3,4,5]
    H --> I
```

### 📊 **Recursion Tree Visualization**

```
                    [5,4,3,2,1]
                   /            \
            [5,4]              [3,2,1]
           /     \            /        \
        [5]     [4]        [3,2]      [1]
         |       |        /     \      |
        [4,5]   [4,5]  [3]   [2]    [1]
         |       |      |     |      |
        [4,5]   [4,5]  [2,3] [2,3]  [1]
         |       |      |     |      |
        [4,5]   [4,5]  [1,2,3]    [1,2,3]
         |       |      |           |
        [1,2,3,4,5] ← Final Result
```

---

## 💻 Implementation

### 🔧 **Complete Solution**

```java
public class p14 {
    public static void mergeSort(int arr[], int low, int high) {
        // Base case: if array has 1 or fewer elements
        if (low >= high) return;

        // Find middle point
        int mid = (low + high) / 2;
        
        // Recursively sort left half
        mergeSort(arr, low, mid);
        
        // Recursively sort right half
        mergeSort(arr, mid + 1, high);
        
        // Merge the sorted halves
        merge(arr, low, mid, high);
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int i = low;        // Index for left subarray
        int j = mid + 1;    // Index for right subarray
        int k = 0;          // Index for temp array
        int temp[] = new int[high - low + 1];  // Temporary array

        // Compare and merge elements from both subarrays
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right subarray
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy back the merged elements to original array
        for (i = low, k = 0; i <= high; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int a[] = { 5, 4, 3, 2, 1 };
        System.out.println("Original Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        
        mergeSort(a, 0, a.length - 1);
        
        System.out.println("\nSorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
```

### 🔍 **Code Explanation**

#### **1. mergeSort Function**
```java
public static void mergeSort(int arr[], int low, int high) {
    if (low >= high) return;  // Base case
    
    int mid = (low + high) / 2;  // Find middle
    mergeSort(arr, low, mid);    // Sort left half
    mergeSort(arr, mid + 1, high); // Sort right half
    merge(arr, low, mid, high);  // Merge sorted halves
}
```

**Key Points:**
- **Base Case**: `low >= high` (array has 1 or 0 elements)
- **Divide**: Calculate middle point
- **Conquer**: Recursively sort both halves
- **Combine**: Merge the sorted halves

#### **2. merge Function**
```java
public static void merge(int arr[], int low, int mid, int high) {
    int i = low;        // Left subarray index
    int j = mid + 1;    // Right subarray index
    int k = 0;          // Temp array index
    int temp[] = new int[high - low + 1];
    
    // Merge while both subarrays have elements
    while (i <= mid && j <= high) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
        }
    }
    
    // Copy remaining elements
    while (i <= mid) temp[k++] = arr[i++];
    while (j <= high) temp[k++] = arr[j++];
    
    // Copy back to original array
    for (i = low, k = 0; i <= high; i++, k++) {
        arr[i] = temp[k];
    }
}
```

**Key Points:**
- **Three Pointers**: `i` (left), `j` (right), `k` (temp)
- **Comparison**: Choose smaller element from either subarray
- **Cleanup**: Copy remaining elements from either subarray
- **Restore**: Copy back to original array

---

## 📊 Complexity Analysis

### ⏰ **Time Complexity**

| Scenario | Complexity | Explanation |
|----------|------------|-------------|
| **Best Case** | O(n log n) | Already sorted or reverse sorted |
| **Average Case** | O(n log n) | Random data |
| **Worst Case** | O(n log n) | Any input |

**Why O(n log n)?**
- **Divide**: O(1) - just finding middle
- **Conquer**: 2T(n/2) - two recursive calls
- **Combine**: O(n) - merging two sorted arrays
- **Recurrence**: T(n) = 2T(n/2) + O(n)
- **Solution**: T(n) = O(n log n)

### 💾 **Space Complexity**

| Component | Space | Explanation |
|-----------|-------|-------------|
| **Recursion Stack** | O(log n) | Height of recursion tree |
| **Temporary Array** | O(n) | For merging |
| **Total** | O(n) | Dominated by temp array |

### 📈 **Space-Time Trade-off**

```mermaid
graph LR
    A[Merge Sort] --> B[Time: O(n log n)]
    A --> C[Space: O(n)]
    A --> D[Stable: Yes]
    A --> E[In-place: No]
```

---

## 🎯 Key Learning Points

### 🔑 **Divide-and-Conquer Pattern**

1. **Divide**: Break problem into smaller subproblems
2. **Conquer**: Solve subproblems recursively
3. **Combine**: Merge solutions of subproblems

### 🧠 **Recursion Insights**

1. **Base Case**: Single element is always sorted
2. **Recursive Case**: Sort halves and merge
3. **Termination**: Each recursive call reduces problem size

### 💡 **Optimization Opportunities**

1. **Small Arrays**: Use insertion sort for small subarrays
2. **Already Sorted**: Check if array is already sorted
3. **Memory**: Use in-place merging (complex)

---

## 🚀 Advanced Concepts

### 🔄 **Stability**
- **Merge Sort is Stable**: Equal elements maintain relative order
- **Important**: Useful when sorting objects with multiple keys

### 📊 **Performance Characteristics**

| Feature | Merge Sort | Quick Sort | Heap Sort |
|---------|------------|------------|-----------|
| **Time** | O(n log n) | O(n log n) | O(n log n) |
| **Space** | O(n) | O(log n) | O(1) |
| **Stable** | ✅ Yes | ❌ No | ❌ No |
| **In-place** | ❌ No | ✅ Yes | ✅ Yes |

### 🎯 **When to Use Merge Sort**

**✅ Advantages:**
- Guaranteed O(n log n) performance
- Stable sorting algorithm
- Good for linked lists
- Predictable performance

**❌ Disadvantages:**
- Requires extra space O(n)
- Not in-place algorithm
- Overkill for small arrays

---

## 🧪 Testing & Verification

### 📝 **Test Cases**

```java
// Test Case 1: Normal array
int[] arr1 = {5, 4, 3, 2, 1};
// Expected: [1, 2, 3, 4, 5]

// Test Case 2: Already sorted
int[] arr2 = {1, 2, 3, 4, 5};
// Expected: [1, 2, 3, 4, 5]

// Test Case 3: Reverse sorted
int[] arr3 = {5, 4, 3, 2, 1};
// Expected: [1, 2, 3, 4, 5]

// Test Case 4: Duplicate elements
int[] arr4 = {3, 1, 4, 1, 5, 9, 2, 6};
// Expected: [1, 1, 2, 3, 4, 5, 6, 9]

// Test Case 5: Single element
int[] arr5 = {42};
// Expected: [42]

// Test Case 6: Empty array
int[] arr6 = {};
// Expected: []
```

### 🔍 **Step-by-Step Execution**

Let's trace through `[5, 4, 3, 2, 1]`:

```
Step 1: mergeSort([5,4,3,2,1], 0, 4)
├── mid = 2
├── mergeSort([5,4,3,2,1], 0, 2)  // Left half
│   ├── mid = 1
│   ├── mergeSort([5,4,3,2,1], 0, 1)  // [5,4]
│   │   ├── mid = 0
│   │   ├── mergeSort([5,4,3,2,1], 0, 0)  // [5]
│   │   ├── mergeSort([5,4,3,2,1], 1, 1)  // [4]
│   │   └── merge([5,4,3,2,1], 0, 0, 1)   // Merge [5] and [4] → [4,5]
│   ├── mergeSort([5,4,3,2,1], 2, 2)  // [3]
│   └── merge([5,4,3,2,1], 0, 1, 2)   // Merge [4,5] and [3] → [3,4,5]
├── mergeSort([5,4,3,2,1], 3, 4)  // Right half
│   ├── mid = 3
│   ├── mergeSort([5,4,3,2,1], 3, 3)  // [2]
│   ├── mergeSort([5,4,3,2,1], 4, 4)  // [1]
│   └── merge([5,4,3,2,1], 3, 3, 4)   // Merge [2] and [1] → [1,2]
└── merge([5,4,3,2,1], 0, 2, 4)       // Merge [3,4,5] and [1,2] → [1,2,3,4,5]
```

---

## 🎓 Practice Problems

### 📚 **Related Problems**

1. **Inversion Count**: Count inversions in array
2. **External Sort**: Sort large files
3. **Linked List Sort**: Sort linked list using merge sort
4. **K-way Merge**: Merge k sorted arrays

### 🎯 **Variations**

1. **Bottom-up Merge Sort**: Iterative approach
2. **In-place Merge Sort**: Space optimization
3. **Natural Merge Sort**: Exploit existing order
4. **Tim Sort**: Hybrid with insertion sort

---

## 💡 Tips & Tricks

### 🧠 **Memory Management**

1. **Reuse Arrays**: Use single temp array for all merges
2. **Alternate Arrays**: Switch between original and temp
3. **Linked Lists**: No extra space needed

### 🚀 **Performance Tips**

1. **Cutoff**: Use insertion sort for small subarrays
2. **Skip Merge**: Check if already sorted
3. **Optimize Merge**: Use sentinel values

### 🐛 **Common Mistakes**

1. **Index Errors**: Off-by-one errors in merge
2. **Memory Leaks**: Not reusing temp arrays
3. **Base Case**: Forgetting single element case

---

## 🎉 Summary

### ✅ **What We Learned**

- **Divide-and-Conquer**: Mastered the fundamental paradigm
- **Recursive Sorting**: Implemented stable sorting algorithm
- **Complexity Analysis**: Understood O(n log n) performance
- **Space Management**: Learned about auxiliary space requirements

### 🎯 **Key Takeaways**

1. **Merge Sort is Stable**: Maintains relative order of equal elements
2. **Predictable Performance**: Always O(n log n) regardless of input
3. **Space Trade-off**: Requires extra space for optimal performance
4. **Recursion Mastery**: Deep understanding of recursive algorithms

### 🚀 **Next Steps**

- Practice with different data types
- Implement variations (bottom-up, in-place)
- Compare with other sorting algorithms
- Apply to real-world problems

---

<div align="center">

### 🌟 **Mastered Merge Sort!** 🌟

_"The best way to predict the future is to implement it."_ - Alan Kay

</div>

---

**Difficulty Level**: ⭐⭐⭐ Medium  
**Key Topics**: Divide-and-Conquer, Recursion, Sorting Algorithms  
**Time Complexity**: O(n log n)  
**Space Complexity**: O(n)  
**Stability**: ✅ Stable