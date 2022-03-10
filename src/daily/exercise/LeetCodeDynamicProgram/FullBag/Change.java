package daily.exercise.LeetCodeDynamicProgram.FullBag;

/**
 * @ClassName: Change
 * @Description:
 * @author: dk
 * @date: 2022/3/10 3:41 下午
 */

public class Change {

    public int change( int amount, int[] coins ) {
        int res = 0;
        int n = coins.length;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for ( int i = 1; i <= n; i++ ) {
            for ( int j = coins[i - 1]; j <= amount; j++ ) {
                dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }

}
