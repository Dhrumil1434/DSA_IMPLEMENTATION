# Problem 10: Check Palindrome (Recursive, Two Pointers)

## Problem Statement
Check if a given string is a palindrome using recursion with two pointers (start and end indices).

## Example
**Input:** "naman"  
**Output:** true

## Solution Approach
This problem uses recursion with two pointers:
- **Two Pointers**: Start (i) at the beginning, end (j) at the end
- **Base Cases**:
  - If string is empty, return false
  - If i >= j, return true (pointers have met/crossed)
  - If characters at i and j are not equal, return false
- **Recursive Call**: Move i forward, j backward

## Code Implementation
```java
public class p10 {
    public static boolean checkPalindrome(char c[], int i, int j) {
        if (c.length == 0) {
            return false;
        }
        if (i >= j) {
            return true;
        }
        if (c[i] != c[j]) {
            return false;
        }
        return checkPalindrome(c, i + 1, j - 1);
    }
    public static void main(String[] args) {
        String s = "naman";
        char c[] = s.toCharArray();
        System.out.println(checkPalindrome(c, 0, c.length - 1));
    }
}
```

## Recursion Tree / Diagram

```
checkPalindrome("naman", 0, 4)
|
|-- c[0] == c[4] ('n' == 'n') → recurse (1,3)
    |
    |-- c[1] == c[3] ('a' == 'a') → recurse (2,2)
        |
        |-- i >= j (2 >= 2) → return true
```

## Step-by-Step Dry Run

```
Input: "naman"
Array: ['n','a','m','a','n']

Call: checkPalindrome(c,0,4)
- c[0]=n, c[4]=n → equal → recurse (1,3)
Call: checkPalindrome(c,1,3)
- c[1]=a, c[3]=a → equal → recurse (2,2)
Call: checkPalindrome(c,2,2)
- i >= j (2 >= 2) → return true
Backtrack: all calls return true
```

## Time and Space Complexity
- **Time Complexity:** O(n)
- **Space Complexity:** O(n) (recursion stack)

## Key Concepts
- Two-pointer recursion
- Base case for empty string and pointer crossing
- Early exit on mismatch

## Applications
- Recursive string validation
- Palindrome checking in recursive algorithms

## Practice Problems
1. Check palindrome for numbers using recursion
2. Check palindrome for case-insensitive strings
3. Check palindrome for linked lists (recursive)

## Key Takeaways
- Recursive two-pointer approach is elegant and clear
- Recursion stack grows with string length
- Base cases are crucial for correctness