package dailyExercise.LeetCodeArray.ArrayPrint;

/**
 * @ClassName: GenerateMatrix
 * @Description:
 * @author: dk
 * @date: 2021/12/19 3:27 下午
 */

public class GenerateMatrix {

    /**
     * [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii/)
     *
     * @param n
     * @return
     */
    public static int number = 1;


    public static int[][] generateMatrix( int n ) {
        int[][] res = new int[n][n];
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = n - 1;
        while ( startX <= endX ) {
            generate( res, startX++, startY++, endX--, endY-- );
        }
        return res;
    }


    public static void main( String[] args ) {
        int n = 5;
        int[][] arr = generateMatrix( n );
        for ( int i = 0; i < arr.length; i++ ) {
            for ( int j = 0; j < arr[0].length; j++ ) {
                System.out.printf( "%5d", arr[i][j] );
            }
            System.out.println();
        }
    }


    private static void generate( int[][] res, int x1, int y1, int x2, int y2 ) {
        //行
        for ( int i = y1; i <= y2; i++ ) {
            res[x1][i] = number++;
        }
        //列
        for ( int i = x1 + 1; i <= x2; i++ ) {
            res[i][y2] = number++;
        }
        // 行 《----
        for ( int i = y2 - 1; i >= y1; i-- ) {
            res[x2][i] = number++;
        }
        // 列
        for ( int i = x2 - 1; i > x1; i-- ) {
            res[i][y1] = number++;
        }
    }

}
