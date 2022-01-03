package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: SubsetsWithDup
 * @Description:
 * @author: dk
 * @date: 2022/1/2 10:50 上午
 */

public class SubsetsWithDup {

    /**
     * https://leetcode-cn.com/problems/subsets-ii/
     *
     * @param nums
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> subsetsWithDup( int[] nums ) {
        Arrays.sort( nums );
        show( nums, 0 );
        return res;
    }


    private void show( int[] nums, int start ) {
        res.add( new ArrayList<>( path ) );
        System.out.println( "进入收集，第" + count + "层 ,收集到结果=" + path.toString() );

        for ( int i = start; i < nums.length; i++ ) {
            if ( i > start && nums[i - 1] == nums[i] ) {
                continue;
            }

            path.add( nums[i] );
            printIndent( count++ );
            System.out.println( "i=" + i + "第" + count + "层 ,回溯前=" + path.toString() );
            show( nums, i + 1 );
            path.removeLast();
            printIndent( --count );
            System.out.println( "i=" + i + "第" + count + "层 ,回溯后=" + path.toString() );
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
进入收集，第0层 ,收集到结果=[]
start=0  i=0第1层 ,回溯前=[1]
进入收集，第1层 ,收集到结果=[1]
    start=1  i=1第2层 ,回溯前=[1, 2]
进入收集，第2层 ,收集到结果=[1, 2]
        start=2  i=2第3层 ,回溯前=[1, 2, 2]
进入收集，第3层 ,收集到结果=[1, 2, 2]
        start=2   i=2第2层 ,回溯后=[1, 2]
    start=1   i=1第1层 ,回溯后=[1]
start=0   i=0第0层 ,回溯后=[]
start=0  i=1第1层 ,回溯前=[2]
进入收集，第1层 ,收集到结果=[2]
    start=2  i=2第2层 ,回溯前=[2, 2]
进入收集，第2层 ,收集到结果=[2, 2]
    start=2   i=2第1层 ,回溯后=[2]
start=0   i=1第0层 ,回溯后=[]


----------------------------------不加去重
进入收集，第0层 ,收集到结果=[]
start=0  i=0第1层 ,回溯前=[1]
进入收集，第1层 ,收集到结果=[1]
    start=1  i=1第2层 ,回溯前=[1, 2]
进入收集，第2层 ,收集到结果=[1, 2]
        start=2  i=2第3层 ,回溯前=[1, 2, 2]
进入收集，第3层 ,收集到结果=[1, 2, 2]
        start=2   i=2第2层 ,回溯后=[1, 2]
    start=1   i=1第1层 ,回溯后=[1]
----start=1  i=2第2层 ,回溯前=[1, 2]------
进入收集，第2层 ,收集到结果=[1, 2]----------
    start=1   i=2第1层 ,回溯后=[1]
start=0   i=0第0层 ,回溯后=[]
start=0  i=1第1层 ,回溯前=[2]
进入收集，第1层 ,收集到结果=[2]
    start=2  i=2第2层 ,回溯前=[2, 2]
进入收集，第2层 ,收集到结果=[2, 2]
    start=2   i=2第1层 ,回溯后=[2]
start=0   i=1第0层 ,回溯后=[]
start=0  i=2第1层 ,回溯前=[2]----------
进入收集，第1层 ,收集到结果=[2]----------
start=0   i=2第0层 ,回溯后=[]


 */
