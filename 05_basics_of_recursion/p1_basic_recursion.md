# Problem 1: Basic Recursion with Base Condition

## Problem Statement

Demonstrate the fundamental concept of recursion using a simple counter that prints numbers from 1 to 5 using a global variable and base condition.

## Example

**Input:** None (uses global counter)  
**Output:** 1, 2, 3, 4, 5

## Solution Approach

This problem introduces the core concepts of recursion:

- **Base Condition**: The stopping criteria for recursion
- **Recursive Call**: Function calling itself
- **Global Variable**: Shared state across recursive calls

## Code Implementation

```java
class p1_recursion_with_base_condition {
    static int count = 1;  // Global variable to track count

    public static void demo() {
        // Base condition: stop when count reaches 6
        if (count == 6) {
            return;
        }

        // Print current count
        System.out.println(count);

        // Increment count
        count++;

        // Recursive call
        demo();
    }

    public static void main(String[] args) {
        demo();
    }
}
```

## Detailed Recursion Tree

```
                    demo() [count = 1]
                           |
                    ┌──────┴──────┐
                    │             │
              Print 1        count++ (count = 2)
                    │             │
                    └──────┬──────┘
                           │
                    demo() [count = 2]
                           │
                    ┌──────┴──────┐
                    │             │
              Print 2        count++ (count = 3)
                    │             │
                    └──────┬──────┘
                           │
                    demo() [count = 3]
                           │
                    ┌──────┴──────┐
                    │             │
              Print 3        count++ (count = 4)
                    │             │
                    └──────┬──────┘
                           │
                    demo() [count = 4]
                           │
                    ┌──────┴──────┐
                    │             │
              Print 4        count++ (count = 5)
                    │             │
                    └──────┬──────┘
                           │
                    demo() [count = 5]
                           │
                    ┌──────┴──────┐
                    │             │
              Print 5        count++ (count = 6)
                    │             │
                    └──────┬──────┘
                           │
                    demo() [count = 6]
                           │
                    ┌──────┴──────┐
                    │             │
              Base Case      Return
              (count == 6)    (Stop)
```

## Call Stack Visualization

| Call Stack Level | Function Call | count Value | Action                              | Output |
| ---------------- | ------------- | ----------- | ----------------------------------- | ------ |
| 1                | demo()        | 1           | Print count, increment, call demo() | 1      |
| 2                | demo()        | 2           | Print count, increment, call demo() | 2      |
| 3                | demo()        | 3           | Print count, increment, call demo() | 3      |
| 4                | demo()        | 4           | Print count, increment, call demo() | 4      |
| 5                | demo()        | 5           | Print count, increment, call demo() | 5      |
| 6                | demo()        | 6           | Base case reached, return           | -      |

## Step-by-Step Execution Trace

```
Initial State: count = 1

Call 1: demo()
├── Check: count == 6? (1 == 6) → False
├── Print: 1
├── Increment: count = 2
└── Recursive Call: demo()

Call 2: demo()
├── Check: count == 6? (2 == 6) → False
├── Print: 2
├── Increment: count = 3
└── Recursive Call: demo()

Call 3: demo()
├── Check: count == 6? (3 == 6) → False
├── Print: 3
├── Increment: count = 4
└── Recursive Call: demo()

Call 4: demo()
├── Check: count == 6? (4 == 6) → False
├── Print: 4
├── Increment: count = 5
└── Recursive Call: demo()

Call 5: demo()
├── Check: count == 6? (5 == 6) → False
├── Print: 5
├── Increment: count = 6
└── Recursive Call: demo()

Call 6: demo()
├── Check: count == 6? (6 == 6) → True
└── Return (Base case reached)

Final Output: 1, 2, 3, 4, 5
```

## Key Concepts Explained

### 1. Base Condition

- **Purpose**: Prevents infinite recursion
- **Implementation**: `if (count == 6) return;`
- **Why Important**: Without base condition, recursion would continue forever

### 2. Global Variable

- **Purpose**: Maintains state across recursive calls
- **Advantage**: Simple to implement
- **Disadvantage**: Not thread-safe, can cause side effects

### 3. Recursive Call

- **Pattern**: Function calls itself with modified parameters
- **Order**: After processing current state
- **Stack**: Each call creates a new stack frame

## Time and Space Complexity

### Time Complexity: O(n)

- **Explanation**: Function is called exactly n times (where n = 5)
- **Analysis**: Each call performs constant time operations (print, increment, check)

### Space Complexity: O(n)

- **Explanation**: Maximum depth of recursion stack = n
- **Stack Frames**: Each recursive call creates a new stack frame
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────┐
│ demo() [count=6]│ ← Base case reached
├─────────────────┤
│ demo() [count=5]│ ← Prints 5
├─────────────────┤
│ demo() [count=4]│ ← Prints 4
├─────────────────┤
│ demo() [count=3]│ ← Prints 3
├─────────────────┤
│ demo() [count=2]│ ← Prints 2
├─────────────────┤
│ demo() [count=1]│ ← Prints 1
└─────────────────┘
```

## Common Mistakes to Avoid

1. **Missing Base Condition**: Leads to infinite recursion
2. **Incorrect Base Condition**: May stop too early or too late
3. **Global Variable Issues**: Can cause unexpected behavior in larger programs
4. **Stack Overflow**: Too many recursive calls without proper base condition

## Alternative Approaches

### Approach 1: Parameter-based (Recommended)

```java
public static void demo(int count) {
    if (count > 5) return;
    System.out.println(count);
    demo(count + 1);
}
```

### Approach 2: Return-based

```java
public static int demo(int count) {
    if (count > 5) return count;
    System.out.println(count);
    return demo(count + 1);
}
```

## Applications

1. **Simple Counting**: Basic iteration patterns
2. **Learning Recursion**: Fundamental concepts
3. **State Management**: Understanding global vs local variables
4. **Call Stack Understanding**: Visualizing recursion flow

## Practice Problems

1. Print numbers from 10 to 1 using recursion
2. Print even numbers from 2 to 20 using recursion
3. Print numbers from 1 to N using parameter-based recursion
4. Implement a recursive counter with local variables

## Key Takeaways

- **Base condition is crucial** for preventing infinite recursion
- **Global variables** can simplify recursion but have limitations
- **Call stack** grows with each recursive call
- **Parameter-based recursion** is generally preferred over global variables
- **Understanding the flow** helps in debugging recursive functions
