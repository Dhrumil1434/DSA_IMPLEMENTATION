# Problem 13: Print All Subsequences of a String

## Problem Statement

Print all subsequences of a given string. A subsequence is a string that can be formed by deleting some or no characters without changing the order of the remaining characters.

## Example

**Input:** "abc"  
**Output:** "", "a", "b", "c", "ab", "ac", "bc", "abc"

## Solution Approach

We use recursion with a choice-based approach:

- At each index, we have 2 choices:
  1. **Include** the current character
  2. **Exclude** the current character

## Code Implementation

```java
public static void printSubSequence(int index, String s, String output) {
    // Base case: when we've processed all characters
    if (index == s.length()) {
        System.out.println(output);
        return;
    }

    // Choice 1: Include current character
    printSubSequence(index + 1, s, output + s.charAt(index));

    // Choice 2: Exclude current character
    printSubSequence(index + 1, s, output);
}
```

## Detailed Recursion Tree for "abc"

```
                                    printSubSequence(0, "abc", "")
                                           |
                    ┌─────────────────────┴─────────────────────┐
                    │                                           │
            Include 'a'                                  Exclude 'a'
                    │                                           │
        printSubSequence(1, "abc", "a")              printSubSequence(1, "abc", "")
                    │                                           │
        ┌───────────┴───────────┐                   ┌───────────┴───────────┐
        │                       │                   │                       │
    Include 'b'             Exclude 'b'         Include 'b'             Exclude 'b'
        │                       │                   │                       │
printSubSequence(2, "abc", "ab")    printSubSequence(2, "abc", "a")    printSubSequence(2, "abc", "b")    printSubSequence(2, "abc", "")
        │                       │                   │                       │
    ┌───┴───┐               ┌───┴───┐           ┌───┴───┐               ┌───┴───┐
    │       │               │       │           │       │               │       │
Include 'c' Exclude 'c' Include 'c' Exclude 'c' Include 'c' Exclude 'c' Include 'c' Exclude 'c'
    │       │               │       │           │       │               │       │
printSubSequence(3, "abc", "abc")    printSubSequence(3, "abc", "ab")    printSubSequence(3, "abc", "ac")    printSubSequence(3, "abc", "a")    printSubSequence(3, "abc", "bc")    printSubSequence(3, "abc", "b")    printSubSequence(3, "abc", "c")    printSubSequence(3, "abc", "")
    │       │               │       │           │       │               │       │
    │       │               │       │           │       │               │       │
  PRINT   PRINT           PRINT   PRINT       PRINT   PRINT           PRINT   PRINT
 "abc"    "ab"            "ac"    "a"         "bc"    "b"             "c"     ""
```

## Step-by-Step Execution Trace

| Call Stack | index | s     | output | Action      | Result            |
| ---------- | ----- | ----- | ------ | ----------- | ----------------- |
| 1          | 0     | "abc" | ""     | Include 'a' | → Call with "a"   |
| 2          | 1     | "abc" | "a"    | Include 'b' | → Call with "ab"  |
| 3          | 2     | "abc" | "ab"   | Include 'c' | → Call with "abc" |
| 4          | 3     | "abc" | "abc"  | Base case   | **PRINT "abc"**   |
| 3          | 2     | "abc" | "ab"   | Exclude 'c' | → Call with "ab"  |
| 4          | 3     | "abc" | "ab"   | Base case   | **PRINT "ab"**    |
| 2          | 1     | "abc" | "a"    | Exclude 'b' | → Call with "a"   |
| 3          | 2     | "abc" | "a"    | Include 'c' | → Call with "ac"  |
| 4          | 3     | "abc" | "ac"   | Base case   | **PRINT "ac"**    |
| 3          | 2     | "abc" | "a"    | Exclude 'c' | → Call with "a"   |
| 4          | 3     | "abc" | "a"    | Base case   | **PRINT "a"**     |
| 1          | 0     | "abc" | ""     | Exclude 'a' | → Call with ""    |
| 2          | 1     | "abc" | ""     | Include 'b' | → Call with "b"   |
| 3          | 2     | "abc" | "b"    | Include 'c' | → Call with "bc"  |
| 4          | 3     | "abc" | "bc"   | Base case   | **PRINT "bc"**    |
| 3          | 2     | "abc" | "b"    | Exclude 'c' | → Call with "b"   |
| 4          | 3     | "abc" | "b"    | Base case   | **PRINT "b"**     |
| 2          | 1     | "abc" | ""     | Exclude 'b' | → Call with ""    |
| 3          | 2     | "abc" | ""     | Include 'c' | → Call with "c"   |
| 4          | 3     | "abc" | "c"    | Base case   | **PRINT "c"**     |
| 3          | 2     | "abc" | ""     | Exclude 'c' | → Call with ""    |
| 4          | 3     | "abc" | ""     | Base case   | **PRINT ""**      |

## Output Order

The output will be printed in this order:

1. "abc" (include all)
2. "ab" (include a,b, exclude c)
3. "ac" (include a,c, exclude b)
4. "a" (include a only)
5. "bc" (include b,c, exclude a)
6. "b" (include b only)
7. "c" (include c only)
8. "" (exclude all)

## Time and Space Complexity

### Time Complexity: O(2^n)

- For a string of length n, we have 2^n possible subsequences
- Each recursive call takes O(1) time
- Total recursive calls = 2^n

### Space Complexity: O(n)

- Maximum depth of recursion stack = n (length of string)
- Each recursive call uses constant space for parameters

## Mathematical Proof

For a string of length n:

- Total subsequences = 2^n
- This is because for each character, we have 2 choices (include/exclude)
- Total combinations = 2 × 2 × 2 × ... × 2 (n times) = 2^n

## Key Insights

1. **Choice-based recursion**: At each step, we make a binary choice
2. **Base case**: When index reaches string length
3. **Order preservation**: Characters are always processed in order
4. **Complete enumeration**: All possible combinations are generated
5. **Backtracking nature**: The recursion naturally explores all paths

## Applications

- String pattern matching
- DNA sequence analysis
- Text processing algorithms
- Combinatorial problems
- Dynamic programming problems (as a subproblem)
