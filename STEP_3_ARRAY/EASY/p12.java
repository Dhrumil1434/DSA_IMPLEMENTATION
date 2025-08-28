package STEP_3_ARRAY.EASY;

public class p12 {
    public static int consicutiveOnes(int arr[])
    {
        int max_count = 0;// 1,
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count = 0;
            }
            else {
                count = count + 1;
                max_count = Math.max(max_count, count);
            }
        }
        return max_count;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, 1 ,1};
        System.out.println(consicutiveOnes(arr));
    }
}
