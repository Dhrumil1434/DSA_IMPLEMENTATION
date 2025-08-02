# Problem 6: Factorial Using Recursion

## Problem Statement
Calculate the factorial of a number using recursion. Factorial of n (denoted as n!) is the product of all positive integers less than or equal to n.

## Mathematical Definition
- n! = n × (n-1) × (n-2) × ... × 2 × 1
- 0! = 1 (by definition)
- 1! = 1

## Example
**Input:** n = 5  
**Output:** 120 (5! = 5 × 4 × 3 × 2 × 1 = 120)

## Solution Approach
This problem uses mathematical recursion:
- **Base Cases**: n = 0 or n = 1, return 1
- **Recursive Case**: n! = n × (n-1)!
- **Decomposition**: Break down into smaller subproblems

## Code Implementation
```java
public class p6 {
    public static int factorial(int n) {
        // Base cases: factorial of 0 and 1 is 1
        if (n == 1 || n == 0) {
            return 1;
        }
        
        // Recursive case: n! = n × (n-1)!
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        int ans = factorial(5);
        System.out.println(ans);
    }
}
```

## Detailed Recursion Tree

```
                    factorial(5)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 5 == 1 or 0? → False
                    │             │
                    └──────┬──────┘
                           │
                    Return: 5 × factorial(4)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 4 == 1 or 0? → False
                    │             │
                    └──────┬──────┘
                           │
                    Return: 4 × factorial(3)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 3 == 1 or 0? → False
                    │             │
                    └──────┬──────┘
                           │
                    Return: 3 × factorial(2)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 2 == 1 or 0? → False
                    │             │
                    └──────┬──────┘
                           │
                    Return: 2 × factorial(1)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 1 == 1 or 0? → True
                    │             │
                    Return: 1
                    │             │
                    └──────┬──────┘
                           │
                    Calculate: 2 × 1 = 2
                           │
                    Calculate: 3 × 2 = 6
                           │
                    Calculate: 4 × 6 = 24
                           │
                    Calculate: 5 × 24 = 120
```

## Call Stack Visualization

| Call Stack Level | Function Call | n | Action | Return Value |
|------------------|---------------|---|--------|--------------|
| 1 | factorial(5) | 5 | Return 5 × factorial(4) | 5 × 24 = 120 |
| 2 | factorial(4) | 4 | Return 4 × factorial(3) | 4 × 6 = 24 |
| 3 | factorial(3) | 3 | Return 3 × factorial(2) | 3 × 2 = 6 |
| 4 | factorial(2) | 2 | Return 2 × factorial(1) | 2 × 1 = 2 |
| 5 | factorial(1) | 1 | Base case, return 1 | 1 |

## Step-by-Step Execution Trace

```
Initial Call: factorial(5)

Call 1: factorial(5)
├── Check: n == 1 or 0? (5 == 1 or 0) → False
├── Recursive Call: factorial(4)
└── Return: 5 × factorial(4)

Call 2: factorial(4)
├── Check: n == 1 or 0? (4 == 1 or 0) → False
├── Recursive Call: factorial(3)
└── Return: 4 × factorial(3)

Call 3: factorial(3)
├── Check: n == 1 or 0? (3 == 1 or 0) → False
├── Recursive Call: factorial(2)
└── Return: 3 × factorial(2)

Call 4: factorial(2)
├── Check: n == 1 or 0? (2 == 1 or 0) → False
├── Recursive Call: factorial(1)
└── Return: 2 × factorial(1)

Call 5: factorial(1)
├── Check: n == 1 or 0? (1 == 1 or 0) → True
└── Return: 1

Backtracking:
├── factorial(2) returns: 2 × 1 = 2
├── factorial(3) returns: 3 × 2 = 6
├── factorial(4) returns: 4 × 6 = 24
└── factorial(5) returns: 5 × 24 = 120

Final Result: 120
```

## Mathematical Analysis

### Understanding Factorial
- **Definition**: n! = n × (n-1) × (n-2) × ... × 2 × 1
- **Base Cases**: 0! = 1, 1! = 1
- **Recursive Formula**: n! = n × (n-1)!

### Mathematical Proof
For n = 5:
- 5! = 5 × 4!
- 4! = 4 × 3!
- 3! = 3 × 2!
- 2! = 2 × 1!
- 1! = 1

Substituting back:
- 2! = 2 × 1 = 2
- 3! = 3 × 2 = 6
- 4! = 4 × 6 = 24
- 5! = 5 × 24 = 120

## Time and Space Complexity

### Time Complexity: O(n)
- **Explanation**: Function is called exactly n times (n to 1)
- **Analysis**: Each call performs constant time operations (check, multiplication, recursive call)

### Space Complexity: O(n)
- **Explanation**: Maximum depth of recursion stack = n
- **Stack Frames**: Each recursive call creates a new stack frame
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────┐
│ factorial(1)    │ ← Base case, returns 1
├─────────────────┤
│ factorial(2)    │ ← Returns 2 × 1 = 2
├─────────────────┤
│ factorial(3)    │ ← Returns 3 × 2 = 6
├─────────────────┤
│ factorial(4)    │ ← Returns 4 × 6 = 24
├─────────────────┤
│ factorial(5)    │ ← Returns 5 × 24 = 120
└─────────────────┘
```

## Alternative Implementations

### Approach 1: Iterative (Recommended for Large Numbers)
```java
public static int factorial(int n) {
    if (n < 0) return -1; // Error case
    if (n == 0 || n == 1) return 1;
    
    int result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

### Approach 2: Tail Recursion (Optimized)
```java
public static int factorial(int n, int accumulator) {
    if (n <= 1) return accumulator;
    return factorial(n - 1, n * accumulator);
}

// Usage: factorial(5, 1)
```

### Approach 3: Long for Larger Numbers
```java
public static long factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

## Comparison: Recursive vs Iterative

| Aspect | Recursive | Iterative |
|--------|-----------|-----------|
| **Space Complexity** | O(n) | O(1) |
| **Time Complexity** | O(n) | O(n) |
| **Readability** | High | High |
| **Stack Overflow Risk** | Yes (for large n) | No |
| **Memory Efficiency** | Low | High |

## Common Mistakes to Avoid

1. **Missing Base Cases**: Not handling n = 0 or n = 1
2. **Incorrect Recursive Formula**: Using wrong mathematical relationship
3. **Stack Overflow**: Using very large numbers without optimization
4. **Negative Numbers**: Not handling negative input

## Applications

1. **Combinatorics**: Calculating combinations and permutations
2. **Probability**: Statistical calculations
3. **Series Expansion**: Mathematical series
4. **Algorithm Analysis**: Time complexity calculations

## Practice Problems

1. Calculate factorial using tail recursion
2. Calculate double factorial (n!!)
3. Calculate falling factorial (n)_k
4. Calculate factorial with modulo arithmetic
5. Calculate factorial using memoization

## Extended Example: Factorial with Memoization

```java
import java.util.*;

public class FactorialMemoization {
    static Map<Integer, Long> memo = new HashMap<>();
    
    public static long factorial(int n) {
        if (n <= 1) return 1;
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        long result = n * factorial(n - 1);
        memo.put(n, result);
        return result;
    }
}
```

## Key Takeaways

- **Mathematical recursion** follows mathematical definitions
- **Base cases** are crucial for stopping recursion
- **Stack overflow** can occur for large numbers
- **Iterative approach** is more memory efficient
- **Understanding mathematical relationships** is key to recursive solutions 