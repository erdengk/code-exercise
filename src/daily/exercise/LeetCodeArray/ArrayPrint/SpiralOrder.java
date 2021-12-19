package daily.exercise.LeetCodeArray.ArrayPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SpiralOrder
 * @Description:
 * @author: dk
 * @date: 2021/12/19 3:41 下午
 */

public class SpiralOrder {

    /**
     * [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)
     *
     * @param matrix
     * @return
     */
    public List<Integer> list = new ArrayList<>();


    public List<Integer> spiralOrder( int[][] matrix ) {
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int x = 0;
        int y = 0;
        while ( x <= m && y <= n ) {
            generate( matrix, x++, y++, m--, n-- );
        }
        return list;
    }


    private void generate( int[][] matrix, int x, int y, int m, int n ) {
        if ( x == m ) {
            for ( int i = y; i <= n; i++ ) {
                list.add( matrix[x][i] );
            }
        } else if ( y == n ) {
            for ( int i = x; i <= m; i++ ) {
                list.add( matrix[i][y] );
            }
        } else {
            // 行
            for ( int i = y; i <= n; i++ ) {
                list.add( matrix[x][i] );
            }
            //列
            for ( int i = x + 1; i <= m; i++ ) {
                list.add( matrix[i][n] );
            }
            // 行 《--
            for ( int i = n - 1; i >= y; i-- ) {
                list.add( matrix[m][i] );
            }
            // 列
            for ( int i = m - 1; i > x; i-- ) {
                list.add( matrix[i][y] );
            }

        }

    }

}
