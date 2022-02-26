package daily.exercise.LeetCodeDynamicProgram;

/**
 * @ClassName: Bag
 * @Description:
 * @author: dk
 * @date: 2022/2/26 6:40 下午
 */

public class Bag {
    //物品有3件
    static int N = 3;
    //背包容量为5
    static int W = 5;
    static int weight[] = { 1, 2, 3 };
    static int value[] = { 6, 9, 13 };


    public static void getValue() {
    //sum[i][j]意思是：背包容量为j时，在前i件物品中取小于等于i件物品，此时取得的物品的价值最大
        int sum[][] = new int[N + 1][W + 1];

        for ( int i = 1; i <= N; i++ ) {
            for ( int j = 1; j <= W; j++ ) {
                if ( weight[i-1] > j ) {
                    //太重了，拿不了
                    // 不拿： sum[i-1][j]
                    sum[i][j] = sum[i - 1][j];
                } else {
                    //拿：sum[i-1][j-weight[i-1]]+value[i-1]

                    //sum[i-1][j-weight[i-1]]可以理解为此时还没拿第i件的最大价值，要留weight[i]空间
                    sum[i][j] = Math.max( sum[i - 1][j], sum[i - 1][j - weight[i-1]] + value[i-1] );
                }
            }
        }
        for ( int i = 0; i < N + 1; i++ ) {
            for ( int j = 0; j < W + 1; j++ ) {
                System.out.print( " " + sum[i][j] );
            }
            System.out.println();
        }
        //System.out.println( sum[2][4] );
    }


    public static void main( String[] args ) {
        getValue();
    }

}
