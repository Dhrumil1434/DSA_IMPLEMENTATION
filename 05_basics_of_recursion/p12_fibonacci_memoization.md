# Problem 12: Fibonacci with Memoization (Dynamic Programming)

## Problem Statement

Calculate the Nth Fibonacci number using recursion with memoization (top-down dynamic programming). Memoization avoids redundant calculations by storing results of subproblems.

## Example

**Input:** N = 10  
**Output:** 55

## Solution Approach

This problem uses recursion with memoization:

- **Memoization Array**: Store results of subproblems in dp[]
- **Base Cases**: If N <= 1, return N
- **Recursive Case**: If dp[N] is not -1, return dp[N]; else compute and store
- **Avoids Redundant Work**: Each subproblem solved only once

## Code Implementation

```java
import java.util.*;

class p12 {
    static int[] dp;

    static int fibonacci(int N) {
        if (N <= 1) return N;
        if (dp[N] != -1) return dp[N];
        dp[N] = fibonacci(N - 1) + fibonacci(N - 2);
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 50;
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println("Fibonacci of " + N + " is: " + fibonacci(N));
    }
}
```

## Recursion Tree / Diagram

```
fibonacci(5)
|
|-- fibonacci(4)
|   |-- fibonacci(3)
|   |   |-- fibonacci(2)
|   |   |   |-- fibonacci(1) = 1
|   |   |   |-- fibonacci(0) = 0
|   |   |   = 1
|   |   |-- fibonacci(1) = 1
|   |   = 2
|   |-- fibonacci(2) = 1
|   = 3
|-- fibonacci(3)
|   |-- fibonacci(2) = 1
|   |-- fibonacci(1) = 1
|   = 2
= 5
```

## Step-by-Step Dry Run

```
N = 5
Call: fibonacci(5)
- dp[5] == -1 → compute
- fibonacci(4) + fibonacci(3)
  - fibonacci(4): dp[4] == -1 → compute
    - fibonacci(3) + fibonacci(2)
      ...
  - fibonacci(3): dp[3] == -1 → compute
    ...
Fill dp[] as you go, so repeated calls use stored values.
```

## Time and Space Complexity

- **Time Complexity:** O(N) (each subproblem solved once)
- **Space Complexity:** O(N) (recursion stack + dp array)

## Key Concepts

- Memoization (top-down DP)
- Avoiding redundant calculations
- Subproblem storage

## Applications

- Fibonacci sequence
- Dynamic programming introduction
- Any problem with overlapping subproblems

## Practice Problems

1. Climbing stairs (ways to reach Nth step)
2. Tiling problems (ways to tile a floor)
3. Coin change (minimum coins for amount)

## Key Takeaways

- Memoization drastically improves recursive performance
- Each subproblem is solved only once
- Dynamic programming is essential for efficiency in overlapping subproblems
