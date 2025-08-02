# Problem 11: Check Palindrome (Recursive, Single Pointer Optimized)

## Problem Statement
Check if a given string is a palindrome using recursion with a single pointer (optimized approach).

## Example
**Input:** "naman"  
**Output:** true

## Solution Approach
This problem uses recursion with a single pointer:
- **Single Pointer**: Start (i) at the beginning
- **Mirror Index**: Compare s.charAt(i) with s.charAt(s.length()-i-1)
- **Base Cases**:
  - If string is empty, return false
  - If i >= s.length()/2, return true (checked all pairs)
  - If characters at i and mirror index are not equal, return false
- **Recursive Call**: Move i forward

## Code Implementation
```java
public class p11 {
    public static boolean checkPalindrome(String s, int i) {
        if (s.length() == 0) {
            return false;
        }
        if (i >= s.length() / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
            return false;
        }
        return checkPalindrome(s, i + 1);
    }
    public static void main(String[] args) {
        String s = "naman";
        System.out.println(checkPalindrome(s, 0));
    }
}
```

## Recursion Tree / Diagram

```
checkPalindrome("naman", 0)
|
|-- s[0] == s[4] ('n' == 'n') → recurse (1)
    |
    |-- s[1] == s[3] ('a' == 'a') → recurse (2)
        |
        |-- i >= s.length()/2 (2 >= 2) → return true
```

## Step-by-Step Dry Run

```
Input: "naman"
String: "naman"

Call: checkPalindrome(s,0)
- s[0]=n, s[4]=n → equal → recurse (1)
Call: checkPalindrome(s,1)
- s[1]=a, s[3]=a → equal → recurse (2)
Call: checkPalindrome(s,2)
- i >= s.length()/2 (2 >= 2) → return true
Backtrack: all calls return true
```

## Time and Space Complexity
- **Time Complexity:** O(n)
- **Space Complexity:** O(n) (recursion stack)

## Key Concepts
- Single pointer recursion
- Mirror index calculation
- Early exit on mismatch

## Applications
- Optimized recursive palindrome checking
- Space-efficient string validation

## Practice Problems
1. Check palindrome for numbers using single pointer recursion
2. Check palindrome for case-insensitive strings
3. Check palindrome for linked lists (single pointer)

## Key Takeaways
- Single pointer recursion is clean and efficient
- Mirror index calculation is key
- Base cases ensure correctness and efficiency