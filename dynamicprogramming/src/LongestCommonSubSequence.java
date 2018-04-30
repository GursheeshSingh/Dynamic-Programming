public class LongestCommonSubSequence {

    private static int[][] lcs;
    private static Direction[][] directions;

    public static final int EMPTY_STRING = 0;
    public static final int START_INDEX = 0;

    enum Direction {
        LEFT, TOP, DIAGONAL, NONE
    }

    public static void main(String[] args) {


        System.out.println(LCS("ACBDEA","ABCDA"));
//        LCS("ACBDEA","ABCDA");

    }


//    Using Reccursion
    /*
    public static int LCS(String a,String b){

        int lenA = a.length();
        int lenB = b.length();

        if (lenA == EMPTY_STRING || lenB == EMPTY_STRING){
            return 0;
        }

        char lastCharacterStringA = a.charAt(lenA - 1);
        char lastCharacterStringB = b.charAt(lenB - 1);

        if (lastCharacterStringA == lastCharacterStringB){
            return ( 1 + LCS(a.substring(START_INDEX, lenA - 1), b.substring(START_INDEX, lenB - 1)) );
        }

        return (Math.max( LCS(a.substring(START_INDEX, lenA), b.substring(START_INDEX, lenB - 1)), LCS(a.substring(START_INDEX, lenA - 1), b.substring(START_INDEX, lenB)) ) );

    }
    */

    //BOTTOM-UP
    public static int LCS(String a,String b){

        int lenA = a.length();
        int lenB = b.length();

        if (lenA == EMPTY_STRING || lenB == EMPTY_STRING){
            return 0;
        }

        lcs = new int[lenA + 1][lenB + 1];
        directions = new Direction[lenA + 1][lenB + 1];

        for (int i = 0; i <= lenA; i++) {
            lcs[i][0] = 0;
            directions[i][0] = Direction.NONE;
        }

        for (int i = 0; i <= lenB; i++) {
            lcs[0][i] = 0;
            directions[0][i] = Direction.NONE;
        }

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {

                char characterStringA = a.charAt(i - 1);
                char characterStringB = b.charAt(j - 1);

                if (characterStringA == characterStringB){
                    lcs[i][j] = ( 1 + lcs[i - 1][j - 1] );
                    directions[i][j] = Direction.DIAGONAL;
                } else {
                    lcs[i][j] = Math.max( lcs[i][j - 1], lcs[i - 1][j] );
                    if (lcs[i][j] == lcs[i][j - 1]){
                        directions[i][j] = Direction.LEFT;
                    } else if ( lcs[i][j] == lcs[i - 1][j] ){
                        directions[i][j] = Direction.TOP;
                    }
                }
            }
        }

        Direction x = directions[lenA][lenB];
        String answer = "";
        int row = lenA;
        int column = lenB;
        while (x != Direction.NONE) {
            if (directions[row][column] == Direction.DIAGONAL) {
                answer = a.charAt(row - 1) + answer;
                row--;
                column--;
            } else if (directions[row][column] == Direction.LEFT) {
                column--;
            } else if (directions[row][column] == Direction.TOP) {
                row--;
            }
            x = directions[row][column];
        }
        System.out.println(answer);


        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                System.out.print(" " + lcs[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                System.out.print(" " + directions[i][j].toString());
            }
            System.out.println();
        }

        return lcs[a.length()][b.length()];

    }



}
