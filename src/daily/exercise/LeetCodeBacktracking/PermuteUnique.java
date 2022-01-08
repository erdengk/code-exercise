package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: PermuteUnique
 * @Description:
 * @author: dk
 * @date: 2022/1/3 1:35 下午
 */

public class PermuteUnique {

    /**
     * https://leetcode-cn.com/problems/permutations-ii/
     *
     * @param nums
     * @return
     */
    //结果集合
    List<List<Integer>> res = new ArrayList<>();
    //路径集合
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> permuteUnique( int[] nums ) {
        boolean[] used = new boolean[nums.length];
        getPermute( nums, used, 0 );
        return res;
    }


    private void getPermute( int[] nums, boolean[] used, int start ) {
        if ( path.size() == nums.length ) {
            res.add( new ArrayList<>( path ) );
            return;
        }
        for ( int i = 0; i < nums.length; i++ ) {

            if ( i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false ) {
                continue;
            }
            if ( used[i] == false ) {
                used[i] = true;
                path.add( nums[i] );
                getPermute( nums, used, i + 1 );
                path.removeLast();
                used[i] = false;

            }


        }
    }

    //TODO 随想录代码优化

}
