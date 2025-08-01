import java.util.*;

class p12 {
    static int[] dp;

    static int fibonacci(int N) {
        if (N <= 1) return N;

        if (dp[N] != -1) return dp[N];

        dp[N] = fibonacci(N - 1) + fibonacci(N - 2);
        return dp[N];
    }

    public static void main(String[] args) {
        int N = 50;
        dp = new int[N + 1];
        Arrays.fill(dp, -1);

        System.out.println("Fibonacci of " + N + " is: " + fibonacci(N));
    }
}
