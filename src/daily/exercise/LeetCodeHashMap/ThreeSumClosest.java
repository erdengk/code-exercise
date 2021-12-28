package daily.exercise.LeetCodeHashMap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName: ThreeSumClosest
 * @Description:
 * @author: dk
 * @date: 2021/12/27 10:28 上午
 */

public class ThreeSumClosest {

    /**
     * [16. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest( int[] nums, int target ) {
        Arrays.sort( nums );
        int ans = nums[0] + nums[1] + nums[2];
        for ( int i = 0; i < nums.length; i++ ) {
            if ( i > 0 && nums[i] == nums[i - 1] ) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while ( l < r ) {
                int temp = nums[i] + nums[l] + nums[r];
                if ( Math.abs( temp - target ) < Math.abs( ans - target ) ) {
                    ans = temp;
                }
                if ( temp > target ) {
                    r--;
                } else if ( temp < target ) {
                    l++;
                } else if ( temp == target ) {
                    // System.out.println("i: " + i + " l: " + l + "r : "+ r );
                    return temp;
                }
            }
        }

        return ans;
    }


    public int threeSumClosestTwo( int[] nums, int target ) {

        Arrays.sort( nums );

        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++ ) {
            if ( i > 0 && nums[i] == nums[i - 1] ) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;
            while ( l < r ) {
                int temp = nums[i] + nums[l] + nums[r];
                map.put( temp - target, temp );
                if ( temp > target ) {
                    r--;
                } else if ( temp < target ) {
                    l++;
                } else if ( temp == target ) {
                    // System.out.println("i: " + i + " l: " + l + "r : "+ r );
                    return temp;
                }
            }
        }

        int index = Integer.MAX_VALUE;
        for ( Integer i : map.keySet()
        ) {
            int a = Math.abs( i );
            int b = Math.abs( index );
            if ( b > a ) {
                index = i;
            }
            // System.out.println("key: " + i + " value: " + map.get(i));
        }
        System.out.println( "key: " + index );
        return map.get( index );
    }


}
