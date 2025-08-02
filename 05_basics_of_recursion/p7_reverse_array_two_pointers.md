# Problem 7: Reverse Array Using Recursion (Two Pointers)

## Problem Statement

Reverse an array using recursion with two pointers (start and end indices). This problem demonstrates how to manipulate arrays recursively by swapping elements from both ends.

## Example

**Input:** arr[] = {1, 2, 3, 4, 5}  
**Output:** arr[] = {5, 4, 3, 2, 1}

## Solution Approach

This problem uses two-pointer recursion:

- **Two Pointers**: Start index (i) and end index (j)
- **Swap Strategy**: Swap elements at start and end positions
- **Move Pointers**: Increment start, decrement end
- **Base Condition**: Stop when start >= end

## Code Implementation

```java
public class p7 {
    public static int[] reverse(int arr[], int i, int j) {
        // Base condition: stop when start index >= end index
        if (i >= j) {
            return arr;
        }

        // Swap elements at start and end positions
        ArrayUtils.swap(arr, i, j);

        // Recursive call with updated pointers
        return reverse(arr, i + 1, j - 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int i = 0;
        int j = arr.length - 1;
        int ans[] = reverse(arr, i, j);

        for (int k = 0; k < ans.length; k++) {
            System.out.println(ans[k]);
        }
    }
}
```

## ArrayUtils.swap Method

```java
public class ArrayUtils {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

## Detailed Recursion Tree

```
                    reverse([1,2,3,4,5], 0, 4)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 0 >= 4? → False
                    │             │
                    └──────┬──────┘
                           │
                    Swap: arr[0] ↔ arr[4]
                    [5,2,3,4,1]
                           │
                    └──────┬──────┘
                           │
                    reverse([5,2,3,4,1], 1, 3)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 1 >= 3? → False
                    │             │
                    └──────┬──────┘
                           │
                    Swap: arr[1] ↔ arr[3]
                    [5,4,3,2,1]
                           │
                    └──────┬──────┘
                           │
                    reverse([5,4,3,2,1], 2, 2)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 2 >= 2? → True
                    │             │
                    Return: [5,4,3,2,1]
```

## Step-by-Step Execution Trace

```
Initial Array: [1, 2, 3, 4, 5]
Start Index (i): 0, End Index (j): 4

Call 1: reverse([1,2,3,4,5], 0, 4)
├── Check: i >= j? (0 >= 4) → False
├── Swap: arr[0] ↔ arr[4]
├── Array becomes: [5, 2, 3, 4, 1]
└── Recursive Call: reverse([5,2,3,4,1], 1, 3)

Call 2: reverse([5,2,3,4,1], 1, 3)
├── Check: i >= j? (1 >= 3) → False
├── Swap: arr[1] ↔ arr[3]
├── Array becomes: [5, 4, 3, 2, 1]
└── Recursive Call: reverse([5,4,3,2,1], 2, 2)

Call 3: reverse([5,4,3,2,1], 2, 2)
├── Check: i >= j? (2 >= 2) → True
└── Return: [5, 4, 3, 2, 1]

Final Result: [5, 4, 3, 2, 1]
```

## Call Stack Visualization

| Call Stack Level | Function Call      | i   | j   | Array State | Action             |
| ---------------- | ------------------ | --- | --- | ----------- | ------------------ |
| 1                | reverse(arr, 0, 4) | 0   | 4   | [1,2,3,4,5] | Swap arr[0]↔arr[4] |
| 2                | reverse(arr, 1, 3) | 1   | 3   | [5,2,3,4,1] | Swap arr[1]↔arr[3] |
| 3                | reverse(arr, 2, 2) | 2   | 2   | [5,4,3,2,1] | Base case, return  |

## Array State Progression

```
Initial:  [1, 2, 3, 4, 5]
         ↑           ↑
         i=0         j=4

After 1st swap:  [5, 2, 3, 4, 1]
                    ↑     ↑
                    i=1   j=3

After 2nd swap:  [5, 4, 3, 2, 1]
                       ↑
                       i=2=j=2

Final:    [5, 4, 3, 2, 1]
```

## Key Concepts Explained

### 1. Two-Pointer Technique

- **Purpose**: Efficiently manipulate array from both ends
- **Strategy**: Move pointers towards center
- **Efficiency**: Reduces number of operations needed

### 2. In-Place Algorithm

- **Definition**: Modifies array without extra space
- **Advantage**: Space complexity O(1)
- **Implementation**: Direct element swapping

### 3. Base Condition Logic

- **Condition**: `if (i >= j) return arr;`
- **Why `>=`**: Handles both even and odd length arrays
- **Stopping Point**: When pointers meet or cross

## Time and Space Complexity

### Time Complexity: O(n/2) = O(n)

- **Explanation**: Function is called n/2 times (for n elements)
- **Analysis**: Each call performs constant time operations (swap, pointer update)

### Space Complexity: O(n/2) = O(n)

- **Explanation**: Maximum depth of recursion stack = n/2
- **Stack Frames**: Each recursive call creates a new stack frame
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────────────┐
│ reverse(arr, 2, 2)      │ ← Base case reached
├─────────────────────────┤
│ reverse(arr, 1, 3)      │ ← Swapped arr[1]↔arr[3]
├─────────────────────────┤
│ reverse(arr, 0, 4)      │ ← Swapped arr[0]↔arr[4]
└─────────────────────────┘
```

## Alternative Implementations

### Approach 1: Single Pointer (Next Problem)

```java
public static int[] reverse(int arr[], int i) {
    if (i >= arr.length / 2) return arr;
    ArrayUtils.swap(arr, i, arr.length - 1 - i);
    return reverse(arr, i + 1);
}
```

### Approach 2: Iterative Two Pointers

```java
public static void reverse(int arr[]) {
    int i = 0, j = arr.length - 1;
    while (i < j) {
        ArrayUtils.swap(arr, i, j);
        i++;
        j--;
    }
}
```

### Approach 3: Using Stack

```java
public static void reverse(int arr[]) {
    Stack<Integer> stack = new Stack<>();
    for (int num : arr) {
        stack.push(num);
    }
    for (int i = 0; i < arr.length; i++) {
        arr[i] = stack.pop();
    }
}
```

## Comparison: Different Approaches

| Approach             | Two-Pointer Recursive | Single-Pointer | Iterative | Stack  |
| -------------------- | --------------------- | -------------- | --------- | ------ |
| **Time Complexity**  | O(n)                  | O(n)           | O(n)      | O(n)   |
| **Space Complexity** | O(n)                  | O(n)           | O(1)      | O(n)   |
| **In-Place**         | Yes                   | Yes            | Yes       | No     |
| **Readability**      | High                  | High           | High      | Medium |

## Common Mistakes to Avoid

1. **Wrong Base Condition**: Using `>` instead of `>=` can miss middle element
2. **Incorrect Pointer Update**: Not incrementing/decrementing pointers correctly
3. **Array Bounds**: Not checking array bounds before swapping
4. **Return Value**: Forgetting to return the modified array

## Applications

1. **Array Manipulation**: Basic array operations
2. **String Reversal**: Can be applied to character arrays
3. **Palindrome Checking**: Part of palindrome algorithms
4. **Learning Recursion**: Understanding recursive array manipulation

## Practice Problems

1. Reverse array using single pointer recursion
2. Reverse only first half of array
3. Reverse array in groups of k
4. Reverse array without using extra space
5. Reverse array and find if it's palindrome

## Extended Example: Reverse with Custom Range

```java
public static int[] reverseRange(int arr[], int start, int end) {
    if (start >= end) return arr;

    ArrayUtils.swap(arr, start, end);
    return reverseRange(arr, start + 1, end - 1);
}

// Usage: reverseRange(arr, 1, 3) // Reverse subarray from index 1 to 3
```

## Key Takeaways

- **Two-pointer technique** efficiently manipulates arrays from both ends
- **In-place algorithms** modify arrays without extra space
- **Base condition** should handle both even and odd length arrays
- **Recursive approach** provides clear logic but uses stack space
- **Understanding pointer movement** is crucial for array manipulation
