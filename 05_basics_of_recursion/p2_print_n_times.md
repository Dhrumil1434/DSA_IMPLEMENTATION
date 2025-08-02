# Problem 2: Print String N Times Using Recursion

## Problem Statement

Print a given string "Hello" exactly N times using recursion. This problem demonstrates parameter-based recursion where we pass the current iteration count and target count as parameters.

## Example

**Input:** N = 5  
**Output:**

```
Hello
Hello
Hello
Hello
Hello
```

## Solution Approach

This problem uses parameter-based recursion with two parameters:

- **Current Index (i)**: Tracks the current iteration
- **Target Count (j)**: The total number of times to print
- **Base Condition**: Stop when current index exceeds target count

## Code Implementation

```java
public class p2 {
    public static void demo(int i, int j) {
        // Base condition: stop when current index exceeds target
        if (i > j) {
            return;
        }

        // Print the string
        System.out.println("Hello");

        // Recursive call with incremented index
        demo(i + 1, j);
    }

    public static void main(String[] args) {
        demo(1, 5);  // Print "Hello" 5 times
    }
}
```

## Detailed Recursion Tree

```
                    demo(1, 5)
                           │
                    ┌──────┴──────┐
                    │             │
              Print "Hello"   Check: 1 > 5? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(2, 5)
                           │
                    ┌──────┴──────┐
                    │             │
              Print "Hello"   Check: 2 > 5? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(3, 5)
                           │
                    ┌──────┴──────┐
                    │             │
              Print "Hello"   Check: 3 > 5? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(4, 5)
                           │
                    ┌──────┴──────┐
                    │             │
              Print "Hello"   Check: 4 > 5? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(5, 5)
                           │
                    ┌──────┴──────┐
                    │             │
              Print "Hello"   Check: 5 > 5? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(6, 5)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 6 > 5? → True
                    │             │
                    Return (Base case)
```

## Call Stack Visualization

| Call Stack Level | Function Call | i   | j   | Action                         | Output |
| ---------------- | ------------- | --- | --- | ------------------------------ | ------ |
| 1                | demo(1, 5)    | 1   | 5   | Print "Hello", call demo(2, 5) | Hello  |
| 2                | demo(2, 5)    | 2   | 5   | Print "Hello", call demo(3, 5) | Hello  |
| 3                | demo(3, 5)    | 3   | 5   | Print "Hello", call demo(4, 5) | Hello  |
| 4                | demo(4, 5)    | 4   | 5   | Print "Hello", call demo(5, 5) | Hello  |
| 5                | demo(5, 5)    | 5   | 5   | Print "Hello", call demo(6, 5) | Hello  |
| 6                | demo(6, 5)    | 6   | 5   | Base case reached, return      | -      |

## Step-by-Step Execution Trace

```
Initial Call: demo(1, 5)

Call 1: demo(1, 5)
├── Check: i > j? (1 > 5) → False
├── Print: "Hello"
└── Recursive Call: demo(2, 5)

Call 2: demo(2, 5)
├── Check: i > j? (2 > 5) → False
├── Print: "Hello"
└── Recursive Call: demo(3, 5)

Call 3: demo(3, 5)
├── Check: i > j? (3 > 5) → False
├── Print: "Hello"
└── Recursive Call: demo(4, 5)

Call 4: demo(4, 5)
├── Check: i > j? (4 > 5) → False
├── Print: "Hello"
└── Recursive Call: demo(5, 5)

Call 5: demo(5, 5)
├── Check: i > j? (5 > 5) → False
├── Print: "Hello"
└── Recursive Call: demo(6, 5)

Call 6: demo(6, 5)
├── Check: i > j? (6 > 5) → True
└── Return (Base case reached)

Final Output:
Hello
Hello
Hello
Hello
Hello
```

## Key Concepts Explained

### 1. Parameter-based Recursion

- **Advantage**: More flexible and reusable than global variables
- **Parameters**: Current state (i) and target state (j)
- **Thread Safety**: Each call has its own parameter values

### 2. Base Condition Logic

- **Condition**: `if (i > j) return;`
- **Why `>` instead of `>=`**: Ensures we print exactly j times
- **Alternative**: Could use `if (i == j + 1) return;`

### 3. Tail Recursion

- **Definition**: Recursive call is the last operation
- **Optimization**: Can be optimized by compiler to avoid stack overflow
- **Pattern**: Process → Recursive Call (no operations after)

## Time and Space Complexity

### Time Complexity: O(n)

- **Explanation**: Function is called exactly n+1 times (1 to n+1)
- **Analysis**: Each call performs constant time operations (print, check, increment)

### Space Complexity: O(n)

- **Explanation**: Maximum depth of recursion stack = n+1
- **Stack Frames**: Each recursive call creates a new stack frame
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────┐
│ demo(6, 5)      │ ← Base case reached
├─────────────────┤
│ demo(5, 5)      │ ← Prints 5th "Hello"
├─────────────────┤
│ demo(4, 5)      │ ← Prints 4th "Hello"
├─────────────────┤
│ demo(3, 5)      │ ← Prints 3rd "Hello"
├─────────────────┤
│ demo(2, 5)      │ ← Prints 2nd "Hello"
├─────────────────┤
│ demo(1, 5)      │ ← Prints 1st "Hello"
└─────────────────┘
```

## Alternative Implementations

### Approach 1: Decrementing Counter

```java
public static void demo(int n) {
    if (n <= 0) return;
    System.out.println("Hello");
    demo(n - 1);
}
```

### Approach 2: Using String Parameter

```java
public static void demo(String str, int count) {
    if (count <= 0) return;
    System.out.println(str);
    demo(str, count - 1);
}
```

### Approach 3: Return-based with Counter

```java
public static int demo(int current, int target) {
    if (current > target) return current;
    System.out.println("Hello");
    return demo(current + 1, target);
}
```

## Comparison with Iterative Approach

### Recursive Approach

```java
public static void demo(int i, int j) {
    if (i > j) return;
    System.out.println("Hello");
    demo(i + 1, j);
}
```

### Iterative Approach

```java
public static void demo(int n) {
    for (int i = 1; i <= n; i++) {
        System.out.println("Hello");
    }
}
```

| Aspect               | Recursive | Iterative |
| -------------------- | --------- | --------- |
| **Space Complexity** | O(n)      | O(1)      |
| **Time Complexity**  | O(n)      | O(n)      |
| **Readability**      | High      | High      |
| **Stack Usage**      | Yes       | No        |
| **Flexibility**      | High      | Medium    |

## Common Mistakes to Avoid

1. **Incorrect Base Condition**: Using `>=` instead of `>` can cause off-by-one errors
2. **Parameter Order**: Confusing current index with target count
3. **Missing Increment**: Forgetting to increment the counter in recursive call
4. **Stack Overflow**: Using very large values without optimization

## Applications

1. **Simple Iteration**: Basic counting and repetition
2. **Learning Recursion**: Understanding parameter passing
3. **Template Pattern**: Base for more complex recursive functions
4. **Testing**: Simple test cases for recursion understanding

## Practice Problems

1. Print numbers from 1 to N using similar recursion
2. Print a custom string N times
3. Print numbers in reverse order (N to 1)
4. Print even numbers from 2 to 2N
5. Implement factorial using similar parameter-based recursion

## Key Takeaways

- **Parameter-based recursion** is more flexible than global variables
- **Base condition** should be carefully designed to avoid off-by-one errors
- **Tail recursion** can be optimized by compilers
- **Call stack** grows linearly with the number of recursive calls
- **Understanding parameter flow** is crucial for debugging recursive functions
