# Problem 8: Reverse Array Using Recursion (Single Pointer)

## Problem Statement
Reverse an array using recursion with a single pointer approach. This is an optimized version of the two-pointer approach that reduces the number of parameters and simplifies the logic.

## Example
**Input:** arr[] = {5, 4, 3, 2, 1}  
**Output:** arr[] = {1, 2, 3, 4, 5}

## Solution Approach
This problem uses single-pointer recursion:
- **Single Pointer**: Only track the current index (i)
- **Mirror Index**: Calculate the corresponding index from the end
- **Swap Strategy**: Swap current element with its mirror element
- **Base Condition**: Stop when pointer reaches middle of array

## Code Implementation
```java
class p8 {
    public static int[] reverse(int arr[], int i) {
        // Base condition: stop when pointer reaches middle of array
        if (i >= arr.length / 2) {
            return arr;
        }
        
        // Swap current element with its mirror element
        ArrayUtils.swap(arr, i, arr.length - 1 - i);
        
        // Recursive call with incremented pointer
        return reverse(arr, i + 1);
    }
    
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        int ans[] = reverse(arr, 0);
        
        for (int x : ans) {
            System.out.println(x);
        }
    }
}
```

## Detailed Recursion Tree

```
                    reverse([5,4,3,2,1], 0)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 0 >= 5/2? → False
                    │             │
                    └──────┬──────┘
                           │
                    Swap: arr[0] ↔ arr[4]
                    [1,4,3,2,5]
                           │
                    └──────┬──────┘
                           │
                    reverse([1,4,3,2,5], 1)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 1 >= 5/2? → False
                    │             │
                    └──────┬──────┘
                           │
                    Swap: arr[1] ↔ arr[3]
                    [1,2,3,4,5]
                           │
                    └──────┬──────┘
                           │
                    reverse([1,2,3,4,5], 2)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 2 >= 5/2? → True
                    │             │
                    Return: [1,2,3,4,5]
```

## Step-by-Step Execution Trace

```
Initial Array: [5, 4, 3, 2, 1]
Array Length: 5, Middle: 5/2 = 2

Call 1: reverse([5,4,3,2,1], 0)
├── Check: i >= arr.length/2? (0 >= 2) → False
├── Mirror Index: arr.length - 1 - i = 5 - 1 - 0 = 4
├── Swap: arr[0] ↔ arr[4]
├── Array becomes: [1, 4, 3, 2, 5]
└── Recursive Call: reverse([1,4,3,2,5], 1)

Call 2: reverse([1,4,3,2,5], 1)
├── Check: i >= arr.length/2? (1 >= 2) → False
├── Mirror Index: arr.length - 1 - i = 5 - 1 - 1 = 3
├── Swap: arr[1] ↔ arr[3]
├── Array becomes: [1, 2, 3, 4, 5]
└── Recursive Call: reverse([1,2,3,4,5], 2)

Call 3: reverse([1,2,3,4,5], 2)
├── Check: i >= arr.length/2? (2 >= 2) → True
└── Return: [1, 2, 3, 4, 5]

Final Result: [1, 2, 3, 4, 5]
```

## Call Stack Visualization

| Call Stack Level | Function Call | i | Mirror Index | Array State | Action |
|------------------|---------------|---|--------------|-------------|---------|
| 1 | reverse(arr, 0) | 0 | 4 | [5,4,3,2,1] | Swap arr[0]↔arr[4] |
| 2 | reverse(arr, 1) | 1 | 3 | [1,4,3,2,5] | Swap arr[1]↔arr[3] |
| 3 | reverse(arr, 2) | 2 | 2 | [1,2,3,4,5] | Base case, return |

## Array State Progression

```
Initial:  [5, 4, 3, 2, 1]
          ↑           ↑
          i=0         mirror=4

After 1st swap:  [1, 4, 3, 2, 5]
                    ↑     ↑
                    i=1   mirror=3

After 2nd swap:  [1, 2, 3, 4, 5]
                       ↑
                       i=2 (middle reached)

Final:    [1, 2, 3, 4, 5]
```

## Key Concepts Explained

### 1. Single Pointer Optimization
- **Advantage**: Reduces parameter count from 2 to 1
- **Mirror Calculation**: `arr.length - 1 - i`
- **Efficiency**: Same time complexity, cleaner code

### 2. Middle Point Logic
- **Base Condition**: `if (i >= arr.length / 2)`
- **Why `/2`**: Only need to process first half
- **Handles Both**: Even and odd length arrays

### 3. Mirror Index Calculation
- **Formula**: `arr.length - 1 - i`
- **Purpose**: Find corresponding element from end
- **Example**: For i=0, mirror=4; for i=1, mirror=3

## Time and Space Complexity

### Time Complexity: O(n/2) = O(n)
- **Explanation**: Function is called n/2 times (for n elements)
- **Analysis**: Each call performs constant time operations (swap, mirror calculation)

### Space Complexity: O(n/2) = O(n)
- **Explanation**: Maximum depth of recursion stack = n/2
- **Stack Frames**: Each recursive call creates a new stack frame
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────────────┐
│ reverse(arr, 2)         │ ← Base case reached
├─────────────────────────┤
│ reverse(arr, 1)         │ ← Swapped arr[1]↔arr[3]
├─────────────────────────┤
│ reverse(arr, 0)         │ ← Swapped arr[0]↔arr[4]
└─────────────────────────┘
```

## Comparison: Single vs Two Pointer

| Aspect | Single Pointer | Two Pointer |
|--------|----------------|-------------|
| **Parameters** | 1 (index) | 2 (start, end) |
| **Base Condition** | `i >= n/2` | `i >= j` |
| **Mirror Calculation** | `n-1-i` | Direct j parameter |
| **Code Complexity** | Simpler | More explicit |
| **Readability** | High | High |

## Alternative Implementations

### Approach 1: Two Pointer (Previous Problem)
```java
public static int[] reverse(int arr[], int i, int j) {
    if (i >= j) return arr;
    ArrayUtils.swap(arr, i, j);
    return reverse(arr, i + 1, j - 1);
}
```

### Approach 2: Iterative Single Pointer
```java
public static void reverse(int arr[]) {
    for (int i = 0; i < arr.length / 2; i++) {
        ArrayUtils.swap(arr, i, arr.length - 1 - i);
    }
}
```

### Approach 3: Using Collections
```java
public static void reverse(Integer arr[]) {
    Collections.reverse(Arrays.asList(arr));
}
```

## Common Mistakes to Avoid

1. **Wrong Base Condition**: Using `>` instead of `>=` can cause extra swaps
2. **Incorrect Mirror Calculation**: Wrong formula for mirror index
3. **Array Bounds**: Not checking bounds before swapping
4. **Middle Point Logic**: Confusing even vs odd length arrays

## Applications

1. **Array Optimization**: Reducing parameter count in recursive functions
2. **Space Efficiency**: Same functionality with fewer parameters
3. **Code Simplification**: Cleaner recursive implementations
4. **Learning Optimization**: Understanding how to simplify recursive functions

## Practice Problems

1. Reverse array using two pointers (previous problem)
2. Reverse only first half of array
3. Reverse array in groups of k using single pointer
4. Reverse array and check if it's palindrome
5. Reverse array with custom step size

## Extended Example: Reverse with Custom Step

```java
public static int[] reverseWithStep(int arr[], int i, int step) {
    if (i >= arr.length / 2) return arr;
    
    int mirrorIndex = arr.length - 1 - i;
    ArrayUtils.swap(arr, i, mirrorIndex);
    
    return reverseWithStep(arr, i + step, step);
}

// Usage: reverseWithStep(arr, 0, 2) // Reverse with step 2
```

## Key Takeaways

- **Single pointer approach** reduces parameter count and simplifies code
- **Mirror index calculation** is key to single pointer technique
- **Middle point logic** handles both even and odd length arrays
- **Same time complexity** as two-pointer approach
- **Cleaner implementation** with fewer parameters 