# Problem 4: Print 1 to N (Ascending Order) Using Recursion

## Problem Statement
Print numbers from 1 to N in ascending order using recursion. This problem demonstrates post-order recursion where we print after making the recursive call, which results in ascending order output.

## Example
**Input:** N = 10  
**Output:** 1, 2, 3, 4, 5, 6, 7, 8, 9, 10

## Solution Approach
This problem uses post-order recursion:
- **Recursive Call First**: Make recursive call before printing
- **Print After**: Print the current number after returning from recursive call
- **Base Condition**: Stop when number becomes less than 1

## Code Implementation
```java
class p4 {
    public static void demo(int i, int N) {
        // Base condition: stop when current number is less than 1
        if (i < 1) {
            return;
        }
        
        // Recursive call first (with decremented value)
        demo(i - 1, N);
        
        // Print current number after recursive call
        System.out.println(i);
    }
    
    public static void main(String[] args) {
        demo(10, 10);
    }
}
```

## Detailed Recursion Tree

```
                    demo(10, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 10 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(9, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 9 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(8, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 8 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(7, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 7 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(6, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 6 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(5, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 5 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(4, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 4 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(3, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 3 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(2, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 2 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(1, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 1 < 1? → False
                    │             │
                    └──────┬──────┘
                           │
                    demo(0, 10)
                           │
                    ┌──────┴──────┐
                    │             │
              Check: 0 < 1? → True
                    │             │
                    Return (Base case)
                    │             │
                    └──────┬──────┘
                           │
                    Print 1 ← demo(1, 10) returns
                           │
                    Print 2 ← demo(2, 10) returns
                           │
                    Print 3 ← demo(3, 10) returns
                           │
                    Print 4 ← demo(4, 10) returns
                           │
                    Print 5 ← demo(5, 10) returns
                           │
                    Print 6 ← demo(6, 10) returns
                           │
                    Print 7 ← demo(7, 10) returns
                           │
                    Print 8 ← demo(8, 10) returns
                           │
                    Print 9 ← demo(9, 10) returns
                           │
                    Print 10 ← demo(10, 10) returns
```

## Call Stack Visualization

| Call Stack Level | Function Call | i | N | Action | Output |
|------------------|---------------|---|----|--------|---------|
| 1 | demo(10, 10) | 10 | 10 | Call demo(9, 10) | - |
| 2 | demo(9, 10) | 9 | 10 | Call demo(8, 10) | - |
| 3 | demo(8, 10) | 8 | 10 | Call demo(7, 10) | - |
| 4 | demo(7, 10) | 7 | 10 | Call demo(6, 10) | - |
| 5 | demo(6, 10) | 6 | 10 | Call demo(5, 10) | - |
| 6 | demo(5, 10) | 5 | 10 | Call demo(4, 10) | - |
| 7 | demo(4, 10) | 4 | 10 | Call demo(3, 10) | - |
| 8 | demo(3, 10) | 3 | 10 | Call demo(2, 10) | - |
| 9 | demo(2, 10) | 2 | 10 | Call demo(1, 10) | - |
| 10 | demo(1, 10) | 1 | 10 | Call demo(0, 10) | - |
| 11 | demo(0, 10) | 0 | 10 | Base case, return | - |
| 10 | demo(1, 10) | 1 | 10 | Print 1, return | 1 |
| 9 | demo(2, 10) | 2 | 10 | Print 2, return | 2 |
| 8 | demo(3, 10) | 3 | 10 | Print 3, return | 3 |
| 7 | demo(4, 10) | 4 | 10 | Print 4, return | 4 |
| 6 | demo(5, 10) | 5 | 10 | Print 5, return | 5 |
| 5 | demo(6, 10) | 6 | 10 | Print 6, return | 6 |
| 4 | demo(7, 10) | 7 | 10 | Print 7, return | 7 |
| 8 | demo(8, 10) | 8 | 10 | Print 8, return | 8 |
| 3 | demo(9, 10) | 9 | 10 | Print 9, return | 9 |
| 2 | demo(10, 10) | 10 | 10 | Print 10, return | 10 |

## Step-by-Step Execution Trace

```
Initial Call: demo(10, 10)

Phase 1: Recursive Calls (Going Down)
├── Call 1: demo(10, 10) → Check: 10 < 1? → False → Call demo(9, 10)
├── Call 2: demo(9, 10) → Check: 9 < 1? → False → Call demo(8, 10)
├── Call 3: demo(8, 10) → Check: 8 < 1? → False → Call demo(7, 10)
├── Call 4: demo(7, 10) → Check: 7 < 1? → False → Call demo(6, 10)
├── Call 5: demo(6, 10) → Check: 6 < 1? → False → Call demo(5, 10)
├── Call 6: demo(5, 10) → Check: 5 < 1? → False → Call demo(4, 10)
├── Call 7: demo(4, 10) → Check: 4 < 1? → False → Call demo(3, 10)
├── Call 8: demo(3, 10) → Check: 3 < 1? → False → Call demo(2, 10)
├── Call 9: demo(2, 10) → Check: 2 < 1? → False → Call demo(1, 10)
├── Call 10: demo(1, 10) → Check: 1 < 1? → False → Call demo(0, 10)
└── Call 11: demo(0, 10) → Check: 0 < 1? → True → Return

Phase 2: Printing (Coming Back Up)
├── Return to demo(1, 10) → Print: 1 → Return
├── Return to demo(2, 10) → Print: 2 → Return
├── Return to demo(3, 10) → Print: 3 → Return
├── Return to demo(4, 10) → Print: 4 → Return
├── Return to demo(5, 10) → Print: 5 → Return
├── Return to demo(6, 10) → Print: 6 → Return
├── Return to demo(7, 10) → Print: 7 → Return
├── Return to demo(8, 10) → Print: 8 → Return
├── Return to demo(9, 10) → Print: 9 → Return
└── Return to demo(10, 10) → Print: 10 → Return

Final Output: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
```

## Key Concepts Explained

### 1. Post-order Recursion
- **Definition**: Recursive call is made before processing
- **Pattern**: Recursive Call → Process (operations after return)
- **Result**: Numbers printed in ascending order

### 2. Stack-based Processing
- **Mechanism**: Uses call stack to reverse the order
- **Timing**: Processing happens on the way back up
- **Memory**: All calls are stored in stack before any printing

### 3. Two-Phase Execution
- **Phase 1**: All recursive calls are made (going down)
- **Phase 2**: All printing happens during returns (coming back up)

## Time and Space Complexity

### Time Complexity: O(n)
- **Explanation**: Function is called exactly n+1 times (n to 0)
- **Analysis**: Each call performs constant time operations (check, decrement, print)

### Space Complexity: O(n)
- **Explanation**: Maximum depth of recursion stack = n+1
- **Stack Frames**: All calls are stored before any returns
- **Memory**: O(n) space used in call stack

## Memory Layout

```
Call Stack (Top to Bottom):
┌─────────────────┐
│ demo(0, 10)     │ ← Base case reached
├─────────────────┤
│ demo(1, 10)     │ ← Will print 1
├─────────────────┤
│ demo(2, 10)     │ ← Will print 2
├─────────────────┤
│ demo(3, 10)     │ ← Will print 3
├─────────────────┤
│ demo(4, 10)     │ ← Will print 4
├─────────────────┤
│ demo(5, 10)     │ ← Will print 5
├─────────────────┤
│ demo(6, 10)     │ ← Will print 6
├─────────────────┤
│ demo(7, 10)     │ ← Will print 7
├─────────────────┤
│ demo(8, 10)     │ ← Will print 8
├─────────────────┤
│ demo(9, 10)     │ ← Will print 9
├─────────────────┤
│ demo(10, 10)    │ ← Will print 10
└─────────────────┘
```

## Alternative Implementations

### Approach 1: Pre-order Recursion (Descending)
```java
public static void demo(int i, int N) {
    if (i < 1) return;
    System.out.println(i);  // Print before recursive call
    demo(i - 1, N);
}
```

### Approach 2: Using While Loop (Iterative)
```java
public static void demo(int N) {
    int i = 1;
    while (i <= N) {
        System.out.println(i);
        i++;
    }
}
```

### Approach 3: For Loop (Iterative)
```java
public static void demo(int N) {
    for (int i = 1; i <= N; i++) {
        System.out.println(i);
    }
}
```

## Comparison: Post-order vs Pre-order

| Aspect | Post-order (Ascending) | Pre-order (Descending) |
|--------|------------------------|------------------------|
| **Print Order** | After recursive call | Before recursive call |
| **Output Order** | 1, 2, 3, ..., N | N, N-1, N-2, ..., 1 |
| **Stack Usage** | All calls stored | Minimal stack usage |
| **Memory Efficiency** | Less efficient | More efficient |
| **Readability** | Counter-intuitive | Intuitive |

## Common Mistakes to Avoid

1. **Wrong Print Order**: Printing before recursive call changes output order
2. **Incorrect Base Condition**: Using `<=` instead of `<` can cause extra calls
3. **Missing Safety Check**: Not handling negative numbers
4. **Confusing Parameters**: Mixing up current value with target value

## Applications

1. **Ascending Order**: Natural counting sequences
2. **Learning Post-order**: Understanding stack-based processing
3. **Reverse Processing**: When you need to process in reverse order
4. **Template Pattern**: Base for more complex post-order algorithms

## Practice Problems

1. Print even numbers from 2 to 2N using post-order recursion
2. Print numbers from 1 to N with custom step (e.g., 1, 3, 5, 7, ...)
3. Print numbers from 1 to N and then N to 1 (forward and backward)
4. Implement a recursive counter that counts up and then down
5. Print numbers from 1 to N with custom formatting

## Key Takeaways

- **Post-order recursion** prints numbers in ascending order
- **Stack-based processing** uses call stack to reverse order
- **Two-phase execution** separates recursive calls from processing
- **Memory usage** is higher due to storing all calls
- **Understanding execution flow** is crucial for post-order recursion 