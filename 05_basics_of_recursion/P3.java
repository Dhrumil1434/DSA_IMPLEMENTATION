/*
 * Print N to 1 using recursion
 */
class P3 {
    public static void printDescending(int n) {
        if (n < 1) return; // safety check
        System.out.println(n);
        printDescending(n - 1);
    }

    public static void main(String[] args) {
        printDescending(10);
    }
}
