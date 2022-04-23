package dailyExercise.LeetCodeArray.window;

/**
 * @ClassName: FindMaxAverage
 * @Description:
 * @author: dk
 * @date: 2021/12/16 7:14 下午
 */

public class FindMaxAverage {

    /**
     * 643. 子数组最大平均数 I https://leetcode-cn.com/problems/maximum-average-subarray-i/
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int res=Integer.MIN_VALUE;
        int l=0;
        int r=0;
        int sum=0;
        while (r<nums.length){
            sum = sum+nums[r];
            if((r-l+1)==k){
                res = Math.max( sum,res );
                sum=sum-nums[l];
                l++;
            }
            r++;
        }
        return (double)res/k;
    }

}
