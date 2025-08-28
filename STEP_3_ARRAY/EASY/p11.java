package STEP_3_ARRAY.EASY;

class BruteForce {
    public static int findMissingElement(int arr[], int N) {
        if (arr.length < 1) {
            return -1;
        }
        int temp[] = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            temp[arr[i]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }
        return -1;

    }
}

class OptimalSolution1 {
    public static int findMissingElement(int arr[], int N) {
        N = N + 1;
        int total_sum = (N * (N + 1)) / 2;
        System.out.println(total_sum);
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return total_sum - sum;
    }
}

class OptimalSolution2 {
    public static int findMissingElement(int arr[],int N)
    {
        N = N + 1;
         if(arr.length<1)
         {
             return -1;
         }
         int xor1 = 0;
         int xor2 = 0;
         for (int i = 0; i <N-1;i++)
         {
             xor1 ^= i;
             xor2 ^= (i + 1);
         }
         return xor1 ^ xor2;
    }
}

public class p11 {
    public static void main(String[] args) {
        System.out.println("Brute Force Solution :");
        int arr1[] = { 1, 2, 4 };
        int N = arr1.length;
        System.out.println("Brute Force Approach :" + BruteForce.findMissingElement(arr1, N));
        System.out.println();
        System.out.println("Optimal 1 Approach :");
        System.out.println("ans :" + OptimalSolution1.findMissingElement(arr1, N));
        System.out.println();
        System.out.println("Optimal 2 Approach :");
        System.out.println("ans :"+OptimalSolution2.findMissingElement(arr1, N));

    }
    
}
