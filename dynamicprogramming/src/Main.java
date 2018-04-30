public class Main {

    private static int memo[];


    public static void main(String[] args) {

        int n = 10
                ;
        init(n+1);

        System.out.println("Min Steps: " + getMinSteps(n));

    }

    private static int getMinSteps(int n){

        if(n == 1)
            return 0;
        if (memo[n] != -1){
            return memo[n];
        }

        int r;

        r = 1 + getMinSteps(n-1);

        if (n%2 == 0){
            r = Math.min(r, 1 + getMinSteps(n/2));
        }
        if (n%3 == 0){
            r = Math.min(r, 1 + getMinSteps(n/3));
        }

        memo[n] = r;

        return r;


    }

    private static void init(int n){

        memo = new int[n];

        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

    }


}
