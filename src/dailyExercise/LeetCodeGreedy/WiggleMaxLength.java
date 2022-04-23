package dailyExercise.LeetCodeGreedy;

/**
 * @ClassName: WiggleMaxLength
 * @Description:
 * @author: dk
 * @date: 2022/1/7 9:09 上午
 */

public class WiggleMaxLength {

    /**
     * https://leetcode-cn.com/problems/wiggle-subsequence/
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength( int[] nums ) {
        int res = 0;
        int curDiff = 0; // 当前一对差值
        int preDiff = 0; // 前一对差值
        int result = 1;  // 记录峰值个数，序列默认序列最右边有一个峰值
        for ( int i = 0; i < nums.length - 1; i++ ) {
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            if ( (curDiff > 0 && preDiff <= 0) || (preDiff >= 0 && curDiff < 0) ) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

}
