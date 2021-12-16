package daily.exercise.skillsContest;


import java.util.Scanner;

/**
 * @author dk
 */
public class Main1 {

    public static int result = 0;


    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] res = new int[n][m];
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < m; j++ ) {
                res[i][j] = sc.nextInt();
            }
        }
        show( res );
        System.out.println( result );
    }


    public static void show( int[][] grid ) {
        for ( int i = 0; i < grid.length; i++ ) {
            for ( int j = 0; j < grid[0].length; j++ ) {
                if ( grid[i][j] == 1 ) {
                    sum( grid, i, j );
                    result++;
                }
            }
        }
    }


    public static void sum( int[][] grid, int i, int j ) {
        if ( i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] != 1 ) {
            return;
        }
        grid[i][j] = 0;
        sum( grid, i + 1, j );
        sum( grid, i - 1, j );
        sum( grid, i, j + 1 );
        sum( grid, i, j - 1 );
    }

}
