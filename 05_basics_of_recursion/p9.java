/*
 * suppose following is the code for check about the palindrome of the given string 
*/
public class p9 {
    // first of all lets understand by using iterative manner how can we do it 
    public static boolean checkPalindrome(char[] c)
    {
        if (c.length == 0) {
            return false;
        }
        int i = 0;
        int j = c.length - 1;
        while (i < j)
        {
            if(c[i]!=c[j])
            {
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
