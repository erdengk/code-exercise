package dailyExercise.skillsContest;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author dk
 */
public class Main2 {

    public static int matrixScore( int[][] mar ) {
        if ( mar.length == 0 || mar[0].length == 0 ) {
            return 0;
        }
        int result = mar.length;
        for ( int i = 1; i < mar[0].length; i++ ) {
            int number = 0;
            for ( int j = 0; j < mar.length; j++ ) {
                if ( mar[j][i] == mar[j][0] ) {
                    number++;
                }
            }
            result = (result << 1) + Math.max( number, mar.length - number );
        }
        return result;
    }


    public static List<Integer> list = new ArrayList<>();


    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        for ( int i = 0; i < n; i++ ) {
            int m = sc.nextInt();
            int[][] a = new int[m][m];
            for ( int j = 0; j < m; j++ ) {
                for ( int k = 0; k < m; k++ ) {
                    a[j][k] = sc.nextInt();
                }
            }
            list.add( matrixScore( a ) );
        }
        for ( Integer i : list
        ) {
            System.out.println( i );
        }
    }

}


