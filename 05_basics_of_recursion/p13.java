public class p13 
{
    public static void  printSubSequence(int index,String s,String output)
    {
        if (index == s.length()) {
            System.out.println(output);
            return;
        }
        printSubSequence(index + 1, s, output + s.charAt(index));
        printSubSequence(index + 1, s, output);
    }
     public static void main(String[] args) {
         String s = "abc";
         printSubSequence(0, s, "");
     }
}