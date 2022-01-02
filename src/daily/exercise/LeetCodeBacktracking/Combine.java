package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
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
    //结果集合
    List<List<Integer>> res = new ArrayList<>();
    //路径集合
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine( int n, int k ) {
        // 从n个数中选取 k 个数， 从 1 开始
        show( n, k, 1 );
        return res;
    }


    private void show( int n, int k, int start ) {
        // 收集到了k 个数，res 记录
        if ( path.size() == k ) {
            printIndent( count );
            System.out.println( "进入收集，第" + count + "层 ,收集到结果=" + path.toString() );
            res.add( new ArrayList<>( path ) );
            return;
        }
        // 从 start 开始，再选 x 个数，x 取决于之前选取了几个数
        for ( int i = start; i <= n; i++ ) {
            printIndent( count++ );
            System.out.println( "i=" + i + "第" + count + "层 ,回溯前=" + path.toString() );
            // 新的数加入到集合中
            path.add( i );

            // 从下一个数开始选择，直到 当前 path 收集到了k个数
            show( n, k, i + 1 );

            //将上一个加入的数剔除，从下一个数继续执行选择。
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

