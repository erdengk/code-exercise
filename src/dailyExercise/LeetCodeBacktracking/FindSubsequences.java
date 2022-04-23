package dailyExercise.LeetCodeBacktracking;

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
     *
     * @param nums
     * @return
     */
    //结果集合
    List<List<Integer>> res = new ArrayList<>();
    //路径集合
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> findSubsequences( int[] nums ) {
        getSubsequences( nums, 0 );
        return res;
    }


    private void getSubsequences( int[] nums, int start ) {
        if ( path.size() > 1 ) {
            res.add( new ArrayList<>( path ) );
            return;
        }

        for ( int i = start; i < nums.length; i++ ) {

            if ( path.size() > 1 && path.getLast() < nums[i] ) {
                return;
            }
            if ( i > start && nums[i - 1] > nums[i] ) {
                return;
            }
            path.add( nums[i] );
            getSubsequences( nums, i + 1 );
            path.removeLast();
        }
    }
    /** 使用map
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
     // 注意这里不要加return，要取树上的节点
     }
     HashMap<Integer,Integer> map = new HashMap<>();
     for(int i=start ;i < nums.length ;i++){
     if(!path.isEmpty() && nums[i]< path.getLast()){
     continue;
     }
     if ( map.getOrDefault( nums[i],0 ) >=1 ){
     continue;
     }
     map.put(nums[i],map.getOrDefault( nums[i],0 )+1);
     path.add( nums[i] );
     getSubsequences( nums,i+1 );
     path.removeLast();

     }
     }
     */
    //TODO 为随想录添加新的解法
    //https://leetcode-cn.com/problems/increasing-subsequences/
    //https://www.programmercarl.com/0491.%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97.html#%E6%80%9D%E8%B7%AF

/*
i=0第1层 ,回溯前=[4]
    i=1第2层 ,回溯前=[4, 6]
进入收集，第2层 ,收集到结果=[4, 6]
        i=2第3层 ,回溯前=[4, 6, 7]
进入收集，第3层 ,收集到结果=[4, 6, 7]
            i=3第4层 ,回溯前=[4, 6, 7, 7]
进入收集，第4层 ,收集到结果=[4, 6, 7, 7]
            i=3第3层 ,回溯后=[4, 6, 7]
        i=2第2层 ,回溯后=[4, 6]
i=3第2层 ,重复的元素是：7
    i=1第1层 ,回溯后=[4]
    i=2第2层 ,回溯前=[4, 7]
进入收集，第2层 ,收集到结果=[4, 7]
        i=3第3层 ,回溯前=[4, 7, 7]
进入收集，第3层 ,收集到结果=[4, 7, 7]
        i=3第2层 ,回溯后=[4, 7]
    i=2第1层 ,回溯后=[4]
i=3第1层 ,重复的元素是：7
i=0第0层 ,回溯后=[]
i=1第1层 ,回溯前=[6]
    i=2第2层 ,回溯前=[6, 7]
进入收集，第2层 ,收集到结果=[6, 7]
        i=3第3层 ,回溯前=[6, 7, 7]
进入收集，第3层 ,收集到结果=[6, 7, 7]
        i=3第2层 ,回溯后=[6, 7]
    i=2第1层 ,回溯后=[6]
i=3第1层 ,重复的元素是：7
i=1第0层 ,回溯后=[]
i=2第1层 ,回溯前=[7]
    i=3第2层 ,回溯前=[7, 7]
进入收集，第2层 ,收集到结果=[7, 7]
    i=3第1层 ,回溯后=[7]
i=2第0层 ,回溯后=[]
i=3第0层 ,重复的元素是：7

 */


}
