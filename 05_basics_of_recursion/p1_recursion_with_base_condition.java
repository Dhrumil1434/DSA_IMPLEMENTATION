// following is the code of the recursion using the base condition
class p1_recursion_with_base_condition
{
    static int count = 1;
    public static void demo()
    {
        if (count == 6) {
            return;
        }
        System.out.println(count);
        count++;
        demo();
    }
      public static void main(String[] args) {
          demo();
      }
}