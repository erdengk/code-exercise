package dailyExercise.LeetCodeDynamicProgram.Bag;

import java.util.LinkedList;

/**
 * @ClassName: FindTargetSumWays
 * @Description:
 * @author: dk
 * @date: 2022/3/2 1:08 下午
 */

public class FindTargetSumWays {

    /**
     * 494. 目标和
     * https://leetcode-cn.com/problems/target-sum/
     *
     * @param nums
     * @param target
     * @return
     */


    int res = 0;


    public int findTargetSumWaysByDFS( int[] nums, int target ) {
        int sum = 0;
        for ( Integer i : nums ) {
            sum += i;
        }
        if ( sum < target ) {
            return 0;
        }
        dfs( nums, target, 0, 0 );
        return res;
    }


    public void dfs( int[] nums, int target, int sum, int index ) {
        if ( index == nums.length ) {
            if ( sum == target ) {
                res++;
                return;
            }
        }
        if ( index != nums.length ) {
            dfs( nums, target, sum - nums[index], index + 1 );
            dfs( nums, target, sum + nums[index], index + 1 );
        }
    }


    public int findTargetSumWays( int[] nums, int target ) {

        int res = 0;
        int sum = 0;
        for ( int i : nums ) {
            sum += i;
        }

        if ( Math.abs( target ) > sum || (sum + target) % 2 != 0 ) {
            return 0;
        }

        int mid = (sum + target) / 2;
        int N = nums.length;
        int[][] dp = new int[N + 1][mid + 1];
        dp[0][0] = 1;

        for ( int i = 1; i <= N; i++ ) {
            for ( int j = 0; j <= mid; j++ ) {
                if ( j >= nums[i - 1] ) {
                    // 两种选择的结果之和
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    // 背包的空间不足，只能选择不装物品 i
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][mid];
    }


}
