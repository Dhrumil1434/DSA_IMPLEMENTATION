/*
 * following is the more cleaner version of the checking palindrome
*/
public class p11 {
    public static boolean checkPalindrome(String s,int i)
    {
        if (s.length() == 0) {
            return false;
        }
        if (i >= s.length() / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length()-i-1)) {
            return false;
        }
        i++;
        return checkPalindrome(s, i);
    }
    public static void main(String[] args) {
        String s = "";
        System.out.println(checkPalindrome(s, 0));
    }
}
