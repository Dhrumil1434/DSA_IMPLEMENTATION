class p4 {
    public static void demo(int i,int N)
    {
        if (i < 1) {
            return;
        }
        demo(i - 1, N);
        System.out.println(i);
    }
    public static void main(String[] args) {
        demo(10, 10);
    }
}