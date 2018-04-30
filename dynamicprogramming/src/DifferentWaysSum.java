public class DifferentWaysSum {

    public static void main(String[] args) {

        int n = 5;

//        DP = number of ways to write a number
        int[] DP = new int[n];

        DP[0] = DP[1] = DP[2] = 1;
        DP[3] = 2;

        for (int i = 4; i < n; i++) {
            DP[i] = DP[i - 1] + DP[i - 3] + DP[i - 4];
        }

        System.out.println("DP = " + DP[n - 1]);


    }

}
