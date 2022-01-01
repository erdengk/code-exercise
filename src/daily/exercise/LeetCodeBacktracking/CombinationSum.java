package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: CombinationSum
 * @Description:
 * @author: dk
 * @date: 2021/12/31 3:01 下午
 */

public class CombinationSum {

    /**
     * https://leetcode-cn.com/problems/combination-sum/
     *
     * @param candidates
     * @param target
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    // 全局变量，记录递归函数的递归层数
    int count = 0;


    // 输入 n，打印 n 个 tab 缩进
    void printIndent( int n ) {
        for ( int i = 0; i < n; i++ ) {
            System.out.printf( "    " );
        }
    }


    public List<List<Integer>> combinationSum( int[] candidates, int target ) {
        getCombination( candidates, target, 0 );
        return res;
    }


    private void getCombination( int[] candidates, int target, int start ) {
        if ( sum > target ) {
            return;
        }
        if ( sum == target ) {
            System.out.println( "进入收集，第" + count + "层 ,收集到结果=" + path.toString() );
            res.add( new ArrayList<>( path ) );
            return;
        }

        for ( int i = start; i < candidates.length; i++ ) {

            sum += candidates[i];
            path.add( candidates[i] );

            printIndent( count++ );
            System.out.println( "i=" + i + "第" + count + "层 ,回溯前=" + path.toString() + "sum=" + sum );

            getCombination( candidates, target, i );

            sum -= candidates[i];
            path.removeLast();
            printIndent( --count );
            System.out.println( "i=" + i + "第" + count + "层 ,回溯后=" + path.toString() );
        }
    }

}
/*
i=0第1层 ,回溯前=[2]sum=2
    i=0第2层 ,回溯前=[2, 2]sum=4
        i=0第3层 ,回溯前=[2, 2, 2]sum=6
            i=0第4层 ,回溯前=[2, 2, 2, 2]sum=8
进入收集，第4层 ,收集到结果=[2, 2, 2, 2]
            i=0第3层 ,回溯后=[2, 2, 2]
            i=1第4层 ,回溯前=[2, 2, 2, 3]sum=9
            i=1第3层 ,回溯后=[2, 2, 2]
            i=2第4层 ,回溯前=[2, 2, 2, 5]sum=11
            i=2第3层 ,回溯后=[2, 2, 2]
        i=0第2层 ,回溯后=[2, 2]
        i=1第3层 ,回溯前=[2, 2, 3]sum=7
            i=1第4层 ,回溯前=[2, 2, 3, 3]sum=10
            i=1第3层 ,回溯后=[2, 2, 3]
            i=2第4层 ,回溯前=[2, 2, 3, 5]sum=12
            i=2第3层 ,回溯后=[2, 2, 3]
        i=1第2层 ,回溯后=[2, 2]
        i=2第3层 ,回溯前=[2, 2, 5]sum=9
        i=2第2层 ,回溯后=[2, 2]
    i=0第1层 ,回溯后=[2]
    i=1第2层 ,回溯前=[2, 3]sum=5
        i=1第3层 ,回溯前=[2, 3, 3]sum=8
进入收集，第3层 ,收集到结果=[2, 3, 3]
        i=1第2层 ,回溯后=[2, 3]
        i=2第3层 ,回溯前=[2, 3, 5]sum=10
        i=2第2层 ,回溯后=[2, 3]
    i=1第1层 ,回溯后=[2]
    i=2第2层 ,回溯前=[2, 5]sum=7
        i=2第3层 ,回溯前=[2, 5, 5]sum=12
        i=2第2层 ,回溯后=[2, 5]
    i=2第1层 ,回溯后=[2]
i=0第0层 ,回溯后=[]
i=1第1层 ,回溯前=[3]sum=3
    i=1第2层 ,回溯前=[3, 3]sum=6
        i=1第3层 ,回溯前=[3, 3, 3]sum=9
        i=1第2层 ,回溯后=[3, 3]
        i=2第3层 ,回溯前=[3, 3, 5]sum=11
        i=2第2层 ,回溯后=[3, 3]
    i=1第1层 ,回溯后=[3]
    i=2第2层 ,回溯前=[3, 5]sum=8
进入收集，第2层 ,收集到结果=[3, 5]
    i=2第1层 ,回溯后=[3]
i=1第0层 ,回溯后=[]
i=2第1层 ,回溯前=[5]sum=5
    i=2第2层 ,回溯前=[5, 5]sum=10
    i=2第1层 ,回溯后=[5]
i=2第0层 ,回溯后=[]

 */