package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: FindSubsequences
 * @Description:
 * @author: dk
 * @date: 2022/1/3 12:25 下午
 */

public class FindSubsequences {

    /**
     * https://leetcode-cn.com/problems/increasing-subsequences/
     * @param nums
     * @return
     */
    //结果集合
    List<List<Integer>> res = new ArrayList<>();
    //路径集合
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        getSubsequences(nums,0);
        return res;
    }


    private void getSubsequences( int[] nums, int start ) {
        if(path.size()>1 ){
            res.add( new ArrayList<>(path) );
            return;
        }

        for(int i=start ;i < nums.length ;i++){

            if(path.size()>1 && path.getLast()<nums[i]){
                return;
            }
            if(i>start && nums[i-1] > nums[i]){
                return;
            }
            path.add( nums[i] );

            getSubsequences( nums,i+1 );

            path.removeLast();
        }
    }
    //TODO 为随想录添加新的解法
    //https://leetcode-cn.com/problems/increasing-subsequences/
    //https://www.programmercarl.com/0491.%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF


}
