/*
 * following is the code to print the string by n times using recursion
*/
public class p2 {
    public static void demo(int i, int j) {
        if (i > j) {
            return;
        }
        System.out.println("Hello");
        demo(i + 1, j);
    }

    public static void main(String[] args) {
        demo(1, 5);
    }
}
/*
 * time complexity is O(n)
 * space complexity is O(n)
*/
