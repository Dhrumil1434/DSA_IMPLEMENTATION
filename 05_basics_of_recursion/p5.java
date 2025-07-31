/*
 * following is the simple code to count one to N using recursion
*/
public class p5 {
  static void func(int i,int sum)
  {
      if (i < 1) {
          System.out.println(sum);
          return;
      }
      func(i - 1, sum + 1);
  }
  public static void main(String[] args) {
      int n = 3;
      func(n, 0);
  }
}
/*
output:
3
2
1
0
walkthrough:
func(3,0)
func(2,1)
func(1,2)
func(0,3)
3
2
1
0
 */