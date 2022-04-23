package dailyExercise.LeetCodeHashMap;

import java.util.HashMap;

/**
 * @ClassName: FourSumCount
 * @Description:
 * @author: dk
 * @date: 2021/12/26 10:22 上午
 */

public class FourSumCount {

    /**
     * [454. 四数相加 II](https://leetcode-cn.com/problems/4sum-ii/)
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount( int[] nums1, int[] nums2, int[] nums3, int[] nums4 ) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums1.length; i++ ) {
            for ( int j = 0; j < nums2.length; j++ ) {
                map.put( 0 - (nums1[i] + nums2[j]), map.getOrDefault( 0 - (nums1[i] + nums2[j]), 0 ) + 1 );
            }
        }
        int count = 0;
        for ( int i = 0; i < nums3.length; i++ ) {
            for ( int j = 0; j < nums4.length; j++ ) {
                int temp = nums3[i] + nums4[j];
                if ( map.containsKey( temp ) ) {
                    count = count + map.get( temp );
                }
            }
        }
        return count;
    }

}
