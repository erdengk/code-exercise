package dailyExercise.LeetCodeDynamicProgram.FullBag;

import java.util.Arrays;

/**
 * @ClassName: CombinationSum4
 * @Description: [377. 组合总和 Ⅳ](https://leetcode.cn/problems/combination-sum-iv/)
 * @author: dk
 * @date: 2022/9/29 11:10
 */

public class CombinationSum4 {

    /** From lc Angus-Liu
     * 简单递归
     */
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }
        return res;
    }

    /**
     * 记忆化搜索
     */
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    /**
     * 动态规划
     */
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    memo[i + num] += memo[i];
                }
            }
        }
        return memo[target];
    }


    public int combinationSum4_3(int[] nums, int target) {


        int []dp= new int[target+1];
        dp[0]=1;
        for(int j=0;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j-nums[i]>=0){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }

        return dp[target];
    }

}
