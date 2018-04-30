public class MatrixChainMultiplication {

    private static int dimensions[];
    private static int m[][];
    private static int s[][];

    private static int min, row, column;

    private static final int NUMBER_OF_MATRICES = 5;

    public static void main(String[] args) {

        dimensions = new int[]{5, 4, 6, 2, 7};
        m = new int[NUMBER_OF_MATRICES][NUMBER_OF_MATRICES];
        s = new int[NUMBER_OF_MATRICES][NUMBER_OF_MATRICES];

        init();

        for (int diff = 1; diff < NUMBER_OF_MATRICES - 1; diff++) {

            System.out.println("Difference = " + diff);

            for (row = 1; row < NUMBER_OF_MATRICES - diff; row++) {

                column = row + diff;
                min = Integer.MAX_VALUE;

                for (int k = row; k <= column - 1; k++) {
                    System.out.println("Row = " + row);
                    System.out.println("Column = " + column);
                    System.out.println("K = " + k);

                    Printing.printPair(row, k);
                    Printing.printPair(k + 1, column);

                    int q = m[row][k] + m[k + 1][column] + dimensions[row - 1] * dimensions[k] * dimensions[column];
                    if (q < min) {
                        min = q;
                        s[row][column] = k;
                    }
                }
                m[row][column] = min;
            }

            System.out.println();
        }

        Printing.print2DArray(m);
        Printing.print2DArray(s);

        System.out.println(m[1][NUMBER_OF_MATRICES - 1]);

    }

    private static void init() {

        for (int i = 0; i < NUMBER_OF_MATRICES; i++) {
            for (int j = 0; j < NUMBER_OF_MATRICES; j++) {

                if (i == 0 || j == 0 || i == j) {
                    m[i][j] = 0;
                    s[i][j] = 0;
                }

            }
        }
    }

}
