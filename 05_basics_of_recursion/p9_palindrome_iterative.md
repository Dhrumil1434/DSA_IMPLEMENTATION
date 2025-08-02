# Problem 9: Check Palindrome (Iterative Approach)

## Problem Statement
Check if a given string is a palindrome using an iterative approach. A palindrome is a string that reads the same backward as forward.

## Example
**Input:** "12321"  
**Output:** true

## Solution Approach
This problem uses a two-pointer iterative approach:
- **Two Pointers**: Start (i) at the beginning, end (j) at the end
- **Compare**: Check if characters at i and j are equal
- **Move Pointers**: Increment i, decrement j
- **Base Condition**: If any mismatch, return false; if pointers cross, return true

## Code Implementation
```java
public class p9 {
    public static boolean checkPalindrome(char[] c) {
        if (c.length == 0) {
            return false;
        }
        int i = 0;
        int j = c.length - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "12321";
        char c[] = s.toCharArray();
        System.out.println(checkPalindrome(c));
    }
}
```

## Detailed Step-by-Step Dry Run

```
Input: "12321"
Array: ['1','2','3','2','1']

i=0, j=4: c[0]='1', c[4]='1' → equal → i++, j--
i=1, j=3: c[1]='2', c[3]='2' → equal → i++, j--
i=2, j=2: pointers meet/cross → done
Return: true
```

## Recursion Tree / Diagram

This approach is iterative, so the process is linear:

```
Start: i=0, j=length-1
|
|-- compare c[i] and c[j]
|   |-- if not equal: return false
|   |-- else: i++, j--
|-- repeat until i >= j
|
Return true
```

## Time and Space Complexity
- **Time Complexity:** O(n) (n = length of string)
- **Space Complexity:** O(1) (no extra space except variables)

## Key Concepts
- Two-pointer technique
- Iterative string processing
- Early exit on mismatch

## Applications
- String validation
- Palindrome checking in text processing
- Data cleaning (e.g., DNA, numbers)

## Practice Problems
1. Check if a number is a palindrome (convert to string/array)
2. Check palindrome for case-insensitive strings
3. Check palindrome for sentences (ignore spaces/punctuation)

## Key Takeaways
- Iterative two-pointer approach is efficient for palindrome checking
- Early exit improves performance for non-palindromes
- No recursion or extra space needed