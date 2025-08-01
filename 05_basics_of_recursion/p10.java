/*
 * check about palindrome number using recursion
*/
public class p10 {
    public static boolean checkPalindrome(char c[],int i,int j)
    {
        if (c.length == 0) {
            return false;
        }
        if (i >= j)
        {
            return true;
        }
        if (c[i] != c[j]) {
            return false;
        }
        i++;
        j--;
       return checkPalindrome(c, i, j);
    }
    public static void main(String[] args) {
        String s = "naman";
        char c[] = s.toCharArray();
        System.out.println(checkPalindrome(c, 0, c.length-1));
    }
}
