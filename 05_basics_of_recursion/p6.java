/*  factorial of a number using recursion
factorial of 5 = 5 * 4 * 3 * 2 * 1
factorial of 0 = 1
factorial of 1 = 1
*/

public class p6 {
    public static int factorial(int n)
    {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        int ans = factorial(5);
        System.out.println(ans);
    }
}
/*
factorial(5)
5 * factorial(4)
5 * 4 * factorial(3)
5 * 4 * 3 * factorial(2)
5 * 4 * 3 * 2 * factorial(1)
5 * 4 * 3 * 2 * 1
5 * 4 * 3 * 2
5 * 4 * 6
5 * 24
120
 */
