public class SellingWines {

    private static int prices[];
    private static int cache[][];

    private static int n;

    public static void main(String[] args) {

        n = 5;

        prices = new int[]{1, 3, 5, 1, 4};

        cache = new int[n][n];

        init();

        System.out.println("Max Profit = " + profit(0, 4));

    }

    private static int profit( int beg, int end) {

        if (beg > end) {
            return 0;
        }

        if (cache[beg][end] != -1)
            return cache[beg][end];

        int year = n - ( end - beg );

//        System.out.println("Year = " + year);
//        System.out.println("N = " + n);
//        System.out.println("End = " + end);
//        System.out.println("Beg = " + beg);

        return cache[beg][end] = (Math.max(profit(beg + 1, end) + year * prices[beg],
                profit(beg, end - 1) + year * prices[end]));

    }

    private static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }
    }

}
