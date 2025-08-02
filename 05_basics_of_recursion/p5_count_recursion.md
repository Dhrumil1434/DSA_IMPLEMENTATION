# Problem 5: Count 1 to N Using Accumulator Pattern

## Problem Statement
Count from 1 to N using recursion with an accumulator pattern. This problem demonstrates how to use an accumulator parameter to maintain state across recursive calls and print the final count.

## Example
**Input:** N = 3  
**Output:** 3

## Solution Approach
This problem uses the accumulator pattern:
- **Accumulator Parameter**: `sum` parameter keeps track of the count
- **Increment Strategy**: Add 1 to accumulator in each recursive call
- **Base Condition**: Stop when current number becomes less than 1
- **Final Output**: Print the accumulated sum at the base case

## Code Implementation
```java
public class p5 {
    static void func(int i, int sum) {
        // Base condition: stop when current number is less than 1
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        
        // Recursive call with decremented number and incremented sum
        func(i - 1, sum + 1);
    }
    
    public static void main(String[] args) {
        int n = 3;
        func(n, 0);  // Start with sum = 0
    }
}
```

## Detailed Recursion Tree

```
                    func(3, 0)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 3 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    func(2, 1)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 2 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    func(1, 2)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 1 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    func(0, 3)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 0 < 1? → True
                    │             │
                    Print: 3
                    Return
```

## Call Stack Visualization

| Call Stack Level | Function Call | i | sum | Action | Output |
|------------------|---------------|---|-----|--------|---------|
| 1 | func(3, 0) | 3 | 0 | Call func(2, 1) | - |
| 2 | func(2, 1) | 2 | 1 | Call func(1, 2) | - |
| 3 | func(1, 2) | 1 | 2 | Call func(0, 3) | - |
| 4 | func(0, 3) | 0 | 3 | Base case, print 3 | 3 |

## Step-by-Step Execution Trace

```
Initial Call: func(3, 0)

Call 1: func(3, 0)
├── Check: i < 1? (3 < 1) → False
├── Recursive Call: func(2, 1)  // i-1=2, sum+1=1

Call 2: func(2, 1)
├── Check: i < 1? (2 < 1) → False
├── Recursive Call: func(1, 2)  // i-1=1, sum+1=2

Call 3: func(1, 2)
├── Check: i < 1? (1 < 1) → False
├── Recursive Call: func(0, 3)  // i-1=0, sum+1=3

Call 4: func(0, 3)
├── Check: i < 1? (0 < 1) → True
├── Print: 3
└── Return

Final Output: 3
```

## Key Concepts Explained

### 1. Accumulator Pattern
- **Purpose**: Maintains state across recursive calls
- **Implementation**: Additional parameter that accumulates the result
- **Advantage**: Avoids global variables and makes function pure

### 2. Tail Recursion
- **Definition**: Recursive call is the last operation
- **Pattern**: Process → Recursive Call (no operations after)
- **Optimization**: Can be optimized by compiler

### 3. Parameter Passing
- **Strategy**: Pass modified values as parameters
- **Immutability**: Original values remain unchanged
- **Thread Safety**: Each call has its own parameter values

## Time and Space Complexity

### Time Complexity: O(n)
- **Explanation**: Function is called exactly n+1 times (n to 0)
- **Analysis**: Each call performs constant time operations (check, increment, recursive call)

### Space Complexity: O(n)
- **Explanation**: Maximum depth of recursion stack = n+1
- **Stack Frames**: Each recursive call creates a new stack frame
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────┐
│ func(0, 3)      │ ← Base case, prints 3
├─────────────────┤
│ func(1, 2)      │ ← sum = 2
├─────────────────┤
│ func(2, 1)      │ ← sum = 1
├─────────────────┤
│ func(3, 0)      │ ← sum = 0
└─────────────────┘
```

## Alternative Implementations

### Approach 1: Return-based (Recommended)
```java
public static int func(int i) {
    if (i < 1) return 0;
    return 1 + func(i - 1);
}
```

### Approach 2: Global Variable (Not Recommended)
```java
static int count = 0;
public static void func(int i) {
    if (i < 1) {
        System.out.println(count);
        return;
    }
    count++;
    func(i - 1);
}
```

### Approach 3: Iterative Approach
```java
public static int func(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum++;
    }
    return sum;
}
```

## Comparison: Different Approaches

| Approach | Accumulator | Return-based | Global Variable | Iterative |
|----------|-------------|--------------|-----------------|-----------|
| **Space Complexity** | O(n) | O(n) | O(n) | O(1) |
| **Time Complexity** | O(n) | O(n) | O(n) | O(n) |
| **Thread Safety** | Yes | Yes | No | Yes |
| **Readability** | Medium | High | Low | High |
| **Memory Efficiency** | Low | Low | Low | High |

## Mathematical Analysis

### Understanding the Accumulator
- **Initial State**: sum = 0
- **Recursive Step**: sum = sum + 1 for each call
- **Final Result**: sum = n (where n is the input number)

### Mathematical Proof
For input n:
- Call 1: func(n, 0) → func(n-1, 1)
- Call 2: func(n-1, 1) → func(n-2, 2)
- Call 3: func(n-2, 2) → func(n-3, 3)
- ...
- Call n: func(1, n-1) → func(0, n)
- Call n+1: func(0, n) → Print n

## Common Mistakes to Avoid

1. **Wrong Accumulator Logic**: Not incrementing sum correctly
2. **Incorrect Base Condition**: Using wrong stopping criteria
3. **Parameter Order**: Confusing the order of parameters
4. **Missing Return**: Forgetting to return at base case

## Applications

1. **Counting Problems**: Any problem requiring counting
2. **Learning Accumulator Pattern**: Understanding state management
3. **Pure Functions**: Creating functions without side effects
4. **Template Pattern**: Base for more complex accumulator problems

## Practice Problems

1. Count even numbers from 2 to 2N using accumulator
2. Count numbers divisible by 3 from 3 to 3N
3. Count prime numbers from 1 to N
4. Count digits in a number using accumulator
5. Count occurrences of a character in a string

## Extended Example: Count with Custom Step

```java
public static void func(int i, int sum, int step) {
    if (i < 1) {
        System.out.println(sum);
        return;
    }
    func(i - step, sum + 1, step);
}

// Usage: func(10, 0, 2) // Count even numbers: 2, 4, 6, 8, 10
```

## Key Takeaways

- **Accumulator pattern** maintains state without global variables
- **Tail recursion** can be optimized by compilers
- **Parameter passing** makes functions pure and thread-safe
- **Understanding the flow** helps in debugging accumulator functions
- **Return-based approach** is often cleaner than accumulator pattern 