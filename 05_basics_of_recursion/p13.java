/**
 * print all the subsequence of a string
 * subsequence is a string that can be formed by deleting some or no characters without changing the order of the remaining characters.
 *
 * for example:
 * input: abc
 * output: a, b, c, ab, ac, bc, abc
 *
 */
public class p13 
{
    public static void  printSubSequence(int index,String s,String output)
    {
        if (index == s.length()) {
            System.out.println(output);
            return;
        }
        printSubSequence(index + 1, s, output + s.charAt(index));
        printSubSequence(index + 1, s, output);
    }
     public static void main(String[] args) {
         String s = "abc";
         printSubSequence(0, s, "");
     }
}
/*
 * output:
 * a
 * b
 * c
 * ab
 * ac
 * bc
 * abc
 */

// time complexity: O(2^n)
// space complexity: O(n)

/*
 * lets understand the recursion tree for the above example:
 *
 *  printSubSequence(0, "abc", "")
 *  printSubSequence(1, "abc", "a")
 *  printSubSequence(2, "abc", "ab")
 *  printSubSequence(3, "abc", "abc")
 *  printSubSequence(3, "abc", "ab")
 *  printSubSequence(2, "abc", "a")
 *  printSubSequence(1, "abc", "")
 *  printSubSequence(0, "abc", "") 
 */