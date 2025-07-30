/*
 * following is the code to print the string by n times 
*/
public class p2 {
    public static void demo(int i,int j)
    {
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
