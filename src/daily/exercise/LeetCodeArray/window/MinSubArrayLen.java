package daily.exercise.LeetCodeArray.window;


/**
 * @ClassName: MinSubArrayLen
 * @Description:
 * @author: dk
 * @date: 2021/12/15 12:59 下午
 */

public class MinSubArrayLen {

    /**
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen( int target, int[] nums ) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0;
        for ( int right = 0; right < nums.length; right++ ) {
            sum = sum + nums[right];
            while ( sum >= target ) {
                res = Math.min( right - l + 1, res );
                sum = sum - nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
