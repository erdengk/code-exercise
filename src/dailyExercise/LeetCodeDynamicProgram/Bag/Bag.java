package dailyExercise.LeetCodeDynamicProgram.Bag;

import java.util.Arrays;

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
                if ( weight[i - 1] > j ) {
                    //太重了，拿不了
                    // 不拿： sum[i-1][j]
                    sum[i][j] = sum[i - 1][j];
                } else {
                    //拿：sum[i-1][j-weight[i-1]]+value[i-1]

                    //sum[i-1][j-weight[i-1]]可以理解为此时还没拿第i件的最大价值，要留weight[i]空间
                    sum[i][j] = Math.max( sum[i - 1][j], sum[i - 1][j - weight[i - 1]] + value[i - 1] );
                }
            }
        }
        for ( int i = 0; i < N + 1; i++ ) {
            for ( int j = 0; j < W + 1; j++ ) {
                System.out.print( " " + sum[i][j] );
            }
            System.out.println();
        }
        System.out.println( sum[N][W] );
    }


    public static int getMaxValue( int[] w, int[] v, int bag ) {
        return process( w, v, 0, 0, bag );
    }


    /**
     * 01 背包暴力递归代码
     *
     * 0--index-1 上做了的货物选择，使得当前已经达到的重量是  alreadyW
     *
     * @param w
     * @param v
     * @param index
     * @param alreadyW
     * @param bag
     * @return
     */
    public static int process( int[] w, int[] v, int index, int alreadyW, int bag ) {
        // 认为此时没有方案
        if ( alreadyW > bag ) {
            return -1;
        }
        // 重量没抄
        if ( index == w.length ) {
            return 0;
        }
        // 没有选当前物品
        int p1 = process( w, v, index + 1, alreadyW, bag );
        // 选择了当前位置的物品
        int p2Next = process( w, v, index + 1, alreadyW + w[index], bag );
        int p2 = -1;
        // 如果选择了当前未知的物品，且最后有合理的方案，则p2Next不会是-1，
        if ( p2Next != -1 ) {
            p2 = v[index] + p2Next;
        }
        return Math.max( p1, p2 );
    }


    /**
     * 只剩下了rest的空间
     * index..... 的货物自由选择，但是剩下的空间rest 不要小于 0
     * 返回 能够获得的最大价值
     *
     * @param w
     * @param v
     * @param index
     * @param rest
     * @return
     */
    public static int process2( int[] w, int[] v, int index, int rest ) {
        // 认为此时没有方案
        if ( rest <= 0 ) {
            return 0;
        }
        // 重量没抄 且此时存在 rest>=0
        if ( index == w.length ) {
            return 0;
        }
        // 没有选当前物品
        int p1 = process2( w, v, index + 1, rest );
        // 选择了当前位置的物品
        int p2 = Integer.MIN_VALUE;
        // 如果选择了当前位置的物品，且最后有合理的方案
        if ( rest >= w[index] ) {
            p2 = v[index] + process2( w, v, index + 1, rest - w[index] );
        }
        return Math.max( p1, p2 );
    }


    public static int dpWay( int[] w, int[] v, int bag ) {
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];
        // dp[N][...] = 0
        for ( int index = N - 1; index >= 0; index-- ) {
            // rest < 0
            for ( int rest = 0; rest <= bag; rest++ ) {

                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if ( rest - w[index] >= 0 ) {
                    p2 = v[index] + dp[index + 1][rest - w[index]];
                }
                dp[index][rest] = Math.max( p1, p2 );

//                int p1 = process2( w, v, index + 1, rest );
//                int p2 = Integer.MIN_VALUE;
//                if ( rest >= w[index] ) {
//                    p2 = v[index] + process2( w, v, index + 1, rest - w[index] );
//                }
//                return Math.max( p1, p2 );

            }
        }
        for ( int i = 0; i < dp.length; i++ ) {
            for ( int j = 0; j < dp[0].length; j++ ) {
                System.out.printf( "%3d", dp[i][j] );
            }
            System.out.println();
        }
        return dp[0][bag];
    }


    public static void dynamicByBag( int[] weight, int[] value, int index, int rest ) {
        int[][] dp = new int[N + 1][W + 1];

        for ( int i = 1; i < N + 1; i++ ) {
            for ( int j = 1; j < W + 1; j++ ) {
                if ( j < weight[i - 1] ) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max( dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1] );
                }
            }
        }
        System.out.println( "动态规划求解：" );
        for ( int i = 0; i < dp.length; i++ ) {
            for ( int j = 0; j < dp[0].length; j++ ) {
                System.out.printf( "%3d", dp[i][j] );
            }
            System.out.println();
        }
        System.out.println( dp[N][W] );
    }


    public static void testweightbagproblem( int[] weight, int[] value, int bagsize ) {
        int wlen = weight.length, value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wlen + 1][bagsize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for ( int i = 0; i <= wlen; i++ ) {
            dp[i][0] = value0;
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for ( int i = 1; i <= wlen; i++ ) {
            for ( int j = 1; j <= bagsize; j++ ) {
                if ( j < weight[i - 1] ) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max( dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1] );
                }
            }
        }
        //打印dp数组
        for ( int i = 0; i <= wlen; i++ ) {
            for ( int j = 0; j <= bagsize; j++ ) {
                System.out.print( dp[i][j] + " " );
            }
            System.out.print( "\n" );
        }
    }
    public static void getValueWrongWay() {
        int sum[] = new int[W+1];

        for ( int i = 0; i <N; i++ ) {
            for ( int j = weight[i]; j <= W ; j++ ) {
                sum[j] = Math.max( sum[j], sum[j - weight[i]] + value[i] );
                System.out.println("此时i="+ i + "  j=" + j + "  整个数组情况为：" + Arrays.toString( sum ) );
            }
        }
        System.out.println(sum[W]);
    }

    public static void getValue1() {
        int sum[] = new int[W+1];

        for ( int i = 0; i <N; i++ ) {
            for ( int j = W; j >= weight[i]; j-- ) {
                sum[j] = Math.max( sum[j], sum[j - weight[i]] + value[i] );
                System.out.println("此时i="+ i + "  j=" + j + "  整个数组情况为：" + Arrays.toString( sum ) );
            }
        }
		System.out.println(sum[W]);
    }


    public static void main( String[] args ) {
//        getValue();
//        System.out.println( getMaxValue( weight, value, W ) );
//        System.out.println( process2( weight, value, 0, W ) );

//        dynamicByBag( weight, value, 0, W );

//        System.out.println("暴力递归");
//        System.out.println( process2( weight, value, 0, W ) );
//        System.out.println( "暴力递归改为动态规划" );
//        System.out.println( dpWay( weight, value, 5 ) );

        int[] weight = { 1, 5, 5, 11 };
        int[] value = { 6, 9, 13, 15 };
        int bagsize = 12;
        testweightbagproblem( weight, value, bagsize );

//        System.out.println("一纬数组优化");
//        getValue1();
//        System.out.println("一纬数组优化错误示范");
//        getValueWrongWay();
    }

}
