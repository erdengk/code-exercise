package daily.exercise.LeetCodeArray.ArrayPrint;

/**
 * @ClassName: Rotate
 * @Description:
 * @author: dk
 * @date: 2021/12/19 4:23 下午
 */

public class Rotate {

    /**
     * [48. 旋转图像](https://leetcode-cn.com/problems/rotate-image/)
     *
     * @param matrix
     */
    public static void rotate( int[][] matrix ) {
        int x = 0;
        int y = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;
        while ( x < endX ) {
            rotateArr( matrix, x++, y++, endX--, endY-- );
        }
    }


    private static void rotateArr( int[][] matrix, int x, int y, int endX, int endY ) {
        int temp = 0;
        for ( int i = 0; i < endY - y; i++ ) {
            //保存第一行的数
            temp = matrix[x][y + i];
            // 将第一列的数给第一行
            matrix[x][y + i] = matrix[endX - i][y];
            // 将最后一行的数 给第一列
            matrix[endX - i][y] = matrix[endX][endY - i];
            // 将最后一列的数  给最后一行
            matrix[endX][endY - i] = matrix[x + i][endY];
            // 将 第一行的数 给最后一列
            matrix[x + i][endY] = temp;
        }
    }


}
