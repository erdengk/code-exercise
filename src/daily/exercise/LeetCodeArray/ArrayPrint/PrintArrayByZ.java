package daily.exercise.LeetCodeArray.ArrayPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PrintArrayByZ
 * @Description:
 * @author: dk
 * @date: 2021/12/16 9:09 下午
 */

public class PrintArrayByZ {

    /*
     给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵。例如

    1,8,6,7

    2,6,4,11

    3,5,9,10

    打印结果是1,8,2,3,6,6,7,4,5,9,11,10。要求额外空间复杂度是O(1)。

     */
    public static List<Integer> list = new ArrayList<>();


    private static void printByZ( int[][] arr ) {
        int m = arr.length - 1;
        int n = arr[0].length - 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        // 是否从下往上
        boolean f = true;
        while ( b <= n  ) {
            int printB = a == m ? b++ : b;
            int printA = a == m ? m : a++;
            int printC = d == n ? c++ : c;
            int printD = d == n ? d : d++;
            add( arr, printA, printB, printC, printD, f );
            f = !f;
        }
    }


    private static void add( int[][] arr, int printA, int printB, int printC, int printD, boolean f ) {
        //从下往上
        if ( f == true ) {
            for ( int i = printA; i >= printC; i-- ) {
                list.add( arr[i][printB++] );
            }
        } else {
            for ( int i = printC; i <= printA; i++ ) {
                list.add( arr[i][printD--] );
            }
        }
    }


    public static void main( String[] args ) {
        int[][] arr = new int[][]{
                { 1, 8, 6  }, { 2, 6, 4 }, { 3, 5, 9 }
        };
        printByZ( arr );
        for ( Integer i : list
        ) {
            System.out.printf( "%3d", i );
        }
    }


}
