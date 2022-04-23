package dailyExercise.LeetCodeGreedy;

/**
 * @ClassName: MaxSubArray
 * @Description:
 * @author: dk
 * @date: 2022/1/7 9:30 上午
 */

public class MaxSubArray {

    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int res = Integer.MIN_VALUE;
        int count = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            count=count+nums[i];
            if ( count>res ){
                res = count;
            }
            if(count<=0) {
                count=0;
            }
        }
        return res;
    }

    public int maxSubArrayTwo(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum < 0){
                sum = nums[i];
            }else{
                sum = sum+nums[i];
            }
            res = Math.max(res,sum);
        }
        return res;
    }

}
