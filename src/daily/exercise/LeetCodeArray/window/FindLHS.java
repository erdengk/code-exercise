package daily.exercise.LeetCodeArray.window;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: FindLHS
 * @Description:
 * @author: dk
 * @date: 2021/12/16 7:44 下午
 */

public class FindLHS {

    /**
     * 594. 最长和谐子序列  https://leetcode-cn.com/problems/longest-harmonious-subsequence/
     *
     * @param nums
     * @return
     */
    public int findLHS( int[] nums ) {
        //看到序列，即与原来顺序无关，可考虑排序
        if ( nums.length <= 1 ) {
            return 0;
        }
        Arrays.sort( nums );
        int res = 0;
        int l = 0;
        int r = 1;
        while ( r < nums.length ) {
            //此时为滑动窗口的时机
            while ( nums[r] - nums[l] > 1 && l < r ) {
                l++;
            }
            if ( nums[r] - nums[l] == 1 ) {
                res = Math.max( res, r - l + 1 );
            }
            r++;
        }
        return res;
    }


    // O(n^2) 过不去
    class Info {

        int low;
        int hight;
        int val;


        public Info( int l, int h, int val ) {
            this.val = val;
            this.low = l;
            this.hight = h;
        }

    }


    public int findLHS1( int[] nums ) {
        int res = 0;
        Info[] infos = new Info[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++ ) {
            if ( map.containsKey( nums[i] ) ) {
                infos[i] = new Info( 0, 0, map.get( nums[i] ) );
            } else {
                int l = serach( nums, nums[i] - 1 );
                int h = serach( nums, nums[i] + 1 );
                infos[i] = new Info( l, h, Math.max( l, h ) );
            }
        }
        for ( Info inf : infos
        ) {
            res = Math.max( res, inf.val );
        }
        return res;
    }


    private int serach( int[] nums, int i ) {
        int res = 0;
        for ( int j = 0; j < nums.length; j++ ) {
            if ( i == nums[j] || nums[j] + 1 == i ) {
                res++;
            }
        }
        return res;
    }

}
