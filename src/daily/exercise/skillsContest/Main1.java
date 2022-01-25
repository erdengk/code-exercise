package daily.exercise.skillsContest;


import java.util.Scanner;

/**
 * @author dk
 */
public class Main1 {

    public static int result = 0;


    public static boolean like( String str, String expr ) {
        //str = str.toLowerCase(); // ignoring locale for now
        str = str.replace( ".", "\\." ); // "\\" is escaped to "\" (thanks, Alan M)
        // ... escape any other potentially problematic characters here
        str = str.replace( "?", "." );
        str = str.replace( "_", "." );
        str = str.replace( "%", ".*" );
        //expr = expr.toLowerCase();

        System.out.println( "str: " + str );
        System.out.println( "expr: " + expr );

        System.out.println( str.compareTo( expr ) );

        return str.matches( expr );
    }


    static String up( String s, int j ) {
        char[] arr = s.toCharArray();
        if ( arr[j] == '9' ) {
            arr[j] = '0';
        } else {
            arr[j] += 1;
        }
        return new String( arr );
    }
    static  String down( String s, int j ) {
        char[] arr = s.toCharArray();
        if ( arr[j] == '0' ) {
            arr[j] = '9';
        } else {
            arr[j] -= 1;
        }
        return new String( arr );
    }

    // 方向数组，分别代表上、下、左、右
    static int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
    static void dfs(int[][] grid, int i, int j,boolean[][] visited){
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (visited[i][j]) {
            // 已遍历过 (i, j)
            return;
        }
        visited[i][j] = true;
        System.out.println(grid[i][j]);
        for (int[] d : dirs) {
            int next_i = i + d[0];
            int next_j = j + d[1];
            dfs(grid, next_i, next_j,visited);
        }
    }
    public static void main( String[] args ) {
        int [][]grid=new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        boolean [][] visited = new boolean[3][3];
        dfs(grid,0,0,visited);

//        Scanner sc = new Scanner( System.in );
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[][] res = new int[n][m];
//        for ( int i = 0; i < n; i++ ) {
//            for ( int j = 0; j < m; j++ ) {
//                res[i][j] = sc.nextInt();
//            }
//        }
//        show( res );
//        System.out.println( result );
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
