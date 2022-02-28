package daily.exercise.LeetCodeDynamicProgram.Bag;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: CanPartition
 * @Description:
 * @author: dk
 * @date: 2022/2/28 4:10 下午
 */

public class CanPartition {

    /**
     * https://leetcode-cn.com/problems/partition-equal-subset-sum/
     *
     * @param nums
     * @return
     */
    public boolean canPartition( int[] nums ) {
        return false;
    }


    public static boolean canPart( int[] nums ) {
        int sum = 0;
        for ( Integer i : nums ) {
            sum += i;
        }
        return dfs( nums, 0, 0, sum );
    }


    private static boolean dfs( int[] nums, int index, int sum, int target ) {
        //base case
        if ( nums.length == index ) {
            if ( sum == target ) {
                return true;
            } else {
                return false;
            }
        }

        //对于任意一个数，可与选或者不选
        return dfs( nums, index + 1, sum + nums[index], target )
                ||
                dfs( nums, index + 1, sum, target );
    }


    // 备忘录：也可用一个二维数组，一维表示元素和sum，一维表示当前索引index
    private Map<String, Boolean> map = new HashMap<>();


    private boolean dfsAndMap( int[] nums, int index, int sum, int target ) {
        if ( nums.length == index ) {
            if ( sum == target ) {
                return true;
            } else {
                return false;
            }
        }

        //描述一个子问题的两个变量是 sum 和 index，组成 key 字符串
        String key = sum + "&" + index;
        if ( map.containsKey( key ) ) {
            return map.get( key );
        }

        boolean ret = dfs( nums, index + 1, sum + nums[index], target ) ||
                dfs( nums, index + 1, sum, target );

        map.put( key, ret );

        return ret;
    }

//    作者：winlsr
//    链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/dfs-dfs-bei-wang-lu-01bei-bao-dong-tai-g-4j1t/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    public static boolean canPartion( int[] nums ) {
        int sum = 0;
        for ( Integer i : nums ) {
            sum += i;
        }
        if ( sum % 2 == 1 ) {
            return false;
        }
        int target = sum >> 1;
        int len = nums.length;
        boolean[][] dp = new boolean[target + 1][len + 1];
        for (int i = 0; i < len + 1; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i < target + 1; i++) {
            for (int j = 1; j < len + 1 ; j++) {
                // 如果不能装下前j个物品中的最后一个
                if (i < nums[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                    // 能装下，可以选择装或者不装
                } else if (i >= nums[j - 1]) {
                    dp[i][j] = dp[i][j - 1] || dp[i - nums[j - 1]][j - 1];
                }
            }
        }

        return dp[target][len];
    }


    public static void main( String[] args ) {
        int[] nums = new int[]{ 1, 2, 11, 5 };
        System.out.println( canPart( nums ) );
    }

}
