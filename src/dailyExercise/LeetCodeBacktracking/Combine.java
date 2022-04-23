package dailyExercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Combine
 * @Description:
 * @author: dk
 * @date: 2021/12/31 1:18 下午
 */

public class Combine {

    /**
     * https://leetcode-cn.com/problems/combinations/
     *
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    //路径集合
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> findSubsequences( int[] nums ) {

        getSubsequences( nums, 0 );
        return res;
    }


    private void getSubsequences( int[] nums, int start ) {
        HashMap<Integer,Integer> map = new HashMap<>(200);
        List<List<Integer>> list = new ArrayList<>();

       list.add( Arrays.asList( 1,2,3 ) );

        if ( path.size() > 1 ) {
            res.add( new ArrayList<>( path ) );
            // 注意这里不要加return，要取树上的节点
        }
        int[] used = new int[201];
        for ( int i = start; i < nums.length; i++ ) {

            if ( !path.isEmpty() && nums[i] < path.getLast() ) {
                continue;
            }

            if ( used[nums[i] + 100] == 1 ) {
                continue;
            }

            used[nums[i] + 100] = 1;

            path.add( nums[i] );
            getSubsequences( nums, i + 1 );
            path.removeLast();
        }
    }


    // 全局变量，记录递归函数的递归层数
    int count = 0;


    // 输入 n，打印 n 个 tab 缩进
    void printIndent( int n ) {
        for ( int i = 0; i < n; i++ ) {
            System.out.printf( "    " );
        }
    }

}
/*
i=1第1层 ,回溯前=[1]
    i=2第2层 ,回溯前=[1, 2]
        进入收集，第2层 ,收集到结果=[1, 2]
    i=2第1层 ,回溯后=[1]
    i=3第2层 ,回溯前=[1, 3]
        进入收集，第2层 ,收集到结果=[1, 3]
    i=3第1层 ,回溯后=[1]
    i=4第2层 ,回溯前=[1, 4]
        进入收集，第2层 ,收集到结果=[1, 4]
    i=4第1层 ,回溯后=[1]
i=1第0层 ,回溯后=[]
i=2第1层 ,回溯前=[2]
    i=3第2层 ,回溯前=[2, 3]
        进入收集，第2层 ,收集到结果=[2, 3]
    i=3第1层 ,回溯后=[2]
    i=4第2层 ,回溯前=[2, 4]
        进入收集，第2层 ,收集到结果=[2, 4]
    i=4第1层 ,回溯后=[2]
i=2第0层 ,回溯后=[]
i=3第1层 ,回溯前=[3]
    i=4第2层 ,回溯前=[3, 4]
        进入收集，第2层 ,收集到结果=[3, 4]
    i=4第1层 ,回溯后=[3]
i=3第0层 ,回溯后=[]
i=4第1层 ,回溯前=[4]
i=4第0层 ,回溯后=[]

 */

