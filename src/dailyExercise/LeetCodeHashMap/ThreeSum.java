package dailyExercise.LeetCodeHashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ThreeSum
 * @Description:
 * @author: dk
 * @date: 2021/12/26 8:48 上午
 */

public class ThreeSum {

    public List<List<Integer>> res = new ArrayList<>();


    /**
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum( int[] nums ) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort( nums );
        System.out.println();
        for ( int i = 0; i < nums.length; i++ ) {
            if ( nums[i] > 0 ) {
                return res;
            }
            // 错误去重方法，将会漏掉-1,-1,2 这种情况
            /*
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            */
            // 正确去重方法
            if ( i > 0 && nums[i] == nums[i - 1] ) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while ( right > left ) {
                int sum = nums[i] + nums[left] + nums[right];
                // 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，
                // 从而漏掉了 0,0,0 这种三元组
                /*
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                */
                if ( sum > 0 ) {
                    right--;
                } else if ( sum < 0 ) {
                    left++;
                } else if ( sum == 0 ) {
                    res.add( Arrays.asList( nums[i], nums[left], nums[right] ) );
                    // 去重逻辑应该放在找到一个三元组之后
                    while ( right > left && nums[right] == nums[right - 1] ) {
                        right--;
                    }
                    while ( right > left && nums[left] == nums[left + 1] ) {
                        left++;
                    }
                    right--;
                    left++;
                }
            }

        }
        return res;
    }

}
