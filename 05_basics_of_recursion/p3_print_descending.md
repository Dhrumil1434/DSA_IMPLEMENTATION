# Problem 3: Print N to 1 (Descending Order) Using Recursion

## Problem Statement

Print numbers from N down to 1 using recursion. This problem demonstrates tail recursion where the recursive call is the last operation, and we print before making the recursive call.

## Example

**Input:** N = 10  
**Output:** 10, 9, 8, 7, 6, 5, 4, 3, 2, 1

## Solution Approach

This problem uses a simple recursive approach:

- **Print First**: Print the current number before recursive call
- **Decrement**: Reduce the number by 1 in each recursive call
- **Base Condition**: Stop when number becomes less than 1

## Code Implementation

```java
class P3 {
    public static void printDescending(int n) {
        // Safety check and base condition
        if (n < 1) return;

        // Print current number
        System.out.println(n);

        // Recursive call with decremented value
        printDescending(n - 1);
    }

    public static void main(String[] args) {
        printDescending(10);
    }
}
```

## Detailed Recursion Tree

```
                    printDescending(10)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 10              Check: 10 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(9)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 9               Check: 9 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(8)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 8               Check: 8 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(7)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 7               Check: 7 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(6)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 6               Check: 6 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(5)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 5               Check: 5 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(4)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 4               Check: 4 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(3)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 3               Check: 3 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(2)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 2               Check: 2 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(1)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Print 1               Check: 1 < 1? → False
                    │                   │
                    └─────────┬─────────┘
                              │
                    printDescending(0)
                              │
                    ┌─────────┴─────────┐
                    │                   │
              Check: 0 < 1? → True
                    │                   │
                    Return (Base case)
```

## Call Stack Visualization

| Call Stack Level | Function Call       | n   | Action                            | Output |
| ---------------- | ------------------- | --- | --------------------------------- | ------ |
| 1                | printDescending(10) | 10  | Print 10, call printDescending(9) | 10     |
| 2                | printDescending(9)  | 9   | Print 9, call printDescending(8)  | 9      |
| 3                | printDescending(8)  | 8   | Print 8, call printDescending(7)  | 8      |
| 4                | printDescending(7)  | 7   | Print 7, call printDescending(6)  | 7      |
| 5                | printDescending(6)  | 6   | Print 6, call printDescending(5)  | 6      |
| 6                | printDescending(5)  | 5   | Print 5, call printDescending(4)  | 5      |
| 7                | printDescending(4)  | 4   | Print 4, call printDescending(3)  | 4      |
| 8                | printDescending(3)  | 3   | Print 3, call printDescending(2)  | 3      |
| 9                | printDescending(2)  | 2   | Print 2, call printDescending(1)  | 2      |
| 10               | printDescending(1)  | 1   | Print 1, call printDescending(0)  | 1      |
| 11               | printDescending(0)  | 0   | Base case reached, return         | -      |

## Step-by-Step Execution Trace

```
Initial Call: printDescending(10)

Call 1: printDescending(10)
├── Check: n < 1? (10 < 1) → False
├── Print: 10
└── Recursive Call: printDescending(9)

Call 2: printDescending(9)
├── Check: n < 1? (9 < 1) → False
├── Print: 9
└── Recursive Call: printDescending(8)

Call 3: printDescending(8)
├── Check: n < 1? (8 < 1) → False
├── Print: 8
└── Recursive Call: printDescending(7)

Call 4: printDescending(7)
├── Check: n < 1? (7 < 1) → False
├── Print: 7
└── Recursive Call: printDescending(6)

Call 5: printDescending(6)
├── Check: n < 1? (6 < 1) → False
├── Print: 6
└── Recursive Call: printDescending(5)

Call 6: printDescending(5)
├── Check: n < 1? (5 < 1) → False
├── Print: 5
└── Recursive Call: printDescending(4)

Call 7: printDescending(4)
├── Check: n < 1? (4 < 1) → False
├── Print: 4
└── Recursive Call: printDescending(3)

Call 8: printDescending(3)
├── Check: n < 1? (3 < 1) → False
├── Print: 3
└── Recursive Call: printDescending(2)

Call 9: printDescending(2)
├── Check: n < 1? (2 < 1) → False
├── Print: 2
└── Recursive Call: printDescending(1)

Call 10: printDescending(1)
├── Check: n < 1? (1 < 1) → False
├── Print: 1
└── Recursive Call: printDescending(0)

Call 11: printDescending(0)
├── Check: n < 1? (0 < 1) → True
└── Return (Base case reached)

Final Output: 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
```

## Key Concepts Explained

### 1. Tail Recursion

- **Definition**: Recursive call is the last operation
- **Pattern**: Process → Recursive Call (no operations after)
- **Optimization**: Can be optimized by compiler to avoid stack overflow

### 2. Pre-order Processing

- **Order**: Print before recursive call
- **Result**: Numbers printed in descending order
- **Timing**: Processing happens on the way down

### 3. Safety Check

- **Purpose**: Handles edge cases (negative numbers)
- **Implementation**: `if (n < 1) return;`
- **Benefit**: Makes function robust

## Time and Space Complexity

### Time Complexity: O(n)

- **Explanation**: Function is called exactly n+1 times (n to 0)
- **Analysis**: Each call performs constant time operations (print, check, decrement)

### Space Complexity: O(n)

- **Explanation**: Maximum depth of recursion stack = n+1
- **Stack Frames**: Each recursive call creates a new stack frame
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────────┐
│ printDescending(0)  │ ← Base case reached
├─────────────────────┤
│ printDescending(1)  │ ← Prints 1
├─────────────────────┤
│ printDescending(2)  │ ← Prints 2
├─────────────────────┤
│ printDescending(3)  │ ← Prints 3
├─────────────────────┤
│ printDescending(4)  │ ← Prints 4
├─────────────────────┤
│ printDescending(5)  │ ← Prints 5
├─────────────────────┤
│ printDescending(6)  │ ← Prints 6
├─────────────────────┤
│ printDescending(7)  │ ← Prints 7
├─────────────────────┤
│ printDescending(8)  │ ← Prints 8
├─────────────────────┤
│ printDescending(9)  │ ← Prints 9
├─────────────────────┤
│ printDescending(10) │ ← Prints 10
└─────────────────────┘
```

## Alternative Implementations

### Approach 1: Using While Loop (Iterative)

```java
public static void printDescending(int n) {
    while (n >= 1) {
        System.out.println(n);
        n--;
    }
}
```

### Approach 2: For Loop (Iterative)

```java
public static void printDescending(int n) {
    for (int i = n; i >= 1; i--) {
        System.out.println(i);
    }
}
```

### Approach 3: Return-based Recursion

```java
public static int printDescending(int n) {
    if (n < 1) return 0;
    System.out.println(n);
    return printDescending(n - 1);
}
```

## Comparison: Recursive vs Iterative

| Aspect                    | Recursive               | Iterative         |
| ------------------------- | ----------------------- | ----------------- |
| **Space Complexity**      | O(n)                    | O(1)              |
| **Time Complexity**       | O(n)                    | O(n)              |
| **Readability**           | High                    | High              |
| **Stack Usage**           | Yes                     | No                |
| **Compiler Optimization** | Tail recursion possible | Already optimized |

## Common Mistakes to Avoid

1. **Incorrect Base Condition**: Using `<=` instead of `<` can cause extra calls
2. **Missing Safety Check**: Not handling negative numbers
3. **Wrong Print Order**: Printing after recursive call changes output order
4. **Stack Overflow**: Using very large values without tail recursion optimization

## Applications

1. **Reverse Counting**: Countdown timers, reverse iteration
2. **Learning Tail Recursion**: Understanding optimization opportunities
3. **Pre-order Processing**: Operations before recursive calls
4. **Template Pattern**: Base for more complex descending algorithms

## Practice Problems

1. Print even numbers from N to 2 in descending order
2. Print numbers from N to 1 with custom step (e.g., N, N-2, N-4, ...)
3. Print numbers from N to 1 and then 1 to N (reverse and forward)
4. Implement a countdown timer using recursion
5. Print numbers from N to 1 with custom formatting

## Key Takeaways

- **Tail recursion** can be optimized by compilers to avoid stack overflow
- **Pre-order processing** prints numbers in descending order
- **Safety checks** make functions robust against edge cases
- **Base condition** should be carefully designed to avoid extra calls
- **Understanding execution order** is crucial for recursive algorithms
