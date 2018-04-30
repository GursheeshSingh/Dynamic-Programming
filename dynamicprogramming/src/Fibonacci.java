public class Fibonacci {

    private static int[] fib;

    public static void main(String[] args) {

        int n = 6;

        fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = -1;
        }

        System.out.println(fibonacci(n));

    }

    //Simple Recurssion
//    private static int fibonacci(int n){
//        if (n <= 1)
//            return n;
//
//        return ( fibonacci(n - 1) + fibonacci(n - 2) );
//    }

    // Buttom-Up
//    private static int fibonacci(int n){
//
//        for (int i = 2; i <= n; i++) {
//            fib[i] = fib[i - 1] + fib[i - 2];
//        }
//
//        return fib[n];
//
//    }

    //Space Optimization
    private static int fibonacci(int n){

        int a, b, c;
        a = 0;
        b = 1;
        c = 1;

        if (n == 0)
            return a;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;


    }


}
