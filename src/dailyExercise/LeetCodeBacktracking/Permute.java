package dailyExercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Permute
 * @Description:
 * @author: dk
 * @date: 2021/12/30 5:17 下午
 */

public class Permute {

    /**
     * @param nums
     * @return
     */
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> permute( int[] nums ) {
        //dfs( nums );
        dfsTwo( nums, 0 );
        return res;
    }


    private void dfs( int[] nums ) {
        if ( path.size() == nums.length ) {
            res.add( new LinkedList<>( path ) );
            return;
        }
        for ( int i = 0; i < nums.length; i++ ) {
            if ( path.contains( nums[i] ) ) {
                continue;
            }
            path.add( nums[i] );
            dfs( nums );
            path.removeLast();
        }
    }


    private void dfsTwo( int[] nums, int start ) {
        if ( start == nums.length ) {
            List<Integer> list = new ArrayList<>();
            for ( int i = 0; i < nums.length; i++ ) {
                list.add( nums[i] );
            }
            res.add( new LinkedList<>( list ) );
            return;
        }
        for ( int i = start; i < nums.length; i++ ) {
            swap( nums, i, start );
            dfsTwo( nums, start + 1 );
            swap( nums, i, start );
        }
    }


    public static void swap( int[] arr, int i, int j ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //TODO 为随想录添加新的解法
    //https://www.programmercarl.com/0046.%E5%85%A8%E6%8E%92%E5%88%97.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC






}
