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
        boolean []used = new boolean[nums.length];
        getPermute( nums, used,0 );
        return res;
    }


    private void getPermute( int[] nums, boolean[] used, int start ) {

    }

    //TODO 随想录代码优化

}
