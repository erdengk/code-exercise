package dailyExercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {

    /**
     * https://leetcode-cn.com/problems/combination-sum-iii/
     *
     * @param k
     * @param n
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    int end = 9;


    public List<List<Integer>> combinationSum3( int k, int n ) {
        show( k, n, 1 );
        return res;
    }


    private void show( int k, int n, int start ) {
        //System.out.println(n+"--"+sum +"  "+ k+"--"+ path.size());
        if ( path.size() == k && sum == n ) {
            printIndent( count );
            //System.out.println( "进入收集，第" + count + "层 ,收集到结果=" + path.toString() );
            res.add( new ArrayList<>( path ) );
            return;
        } else if ( sum > n ) {
            return;
        }

        for ( int i = start; i <= end; i++ ) {
            if ( path.contains( i ) ) {
                continue;
            }

            path.add( i );
            sum = sum + i;

            printIndent( count++ );
            //System.out.println( "i=" + i + "第" + count + "层 ,回溯前=" + path.toString() + "sum="+sum);
            show( k, n, i + 1 );
            path.removeLast();
            sum = sum - i;

            printIndent( --count );
            //System.out.println( "i=" + i + "第" + count + "层 ,回溯后=" + path.toString() );
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
i=1第1层 ,回溯前=[1]sum=1
    i=2第2层 ,回溯前=[1, 2]sum=3
        i=3第3层 ,回溯前=[1, 2, 3]sum=6
            i=4第4层 ,回溯前=[1, 2, 3, 4]sum=10
            i=4第3层 ,回溯后=[1, 2, 3]
            i=5第4层 ,回溯前=[1, 2, 3, 5]sum=11
            i=5第3层 ,回溯后=[1, 2, 3]
            i=6第4层 ,回溯前=[1, 2, 3, 6]sum=12
            i=6第3层 ,回溯后=[1, 2, 3]
            i=7第4层 ,回溯前=[1, 2, 3, 7]sum=13
            i=7第3层 ,回溯后=[1, 2, 3]
            i=8第4层 ,回溯前=[1, 2, 3, 8]sum=14
            i=8第3层 ,回溯后=[1, 2, 3]
            i=9第4层 ,回溯前=[1, 2, 3, 9]sum=15
            i=9第3层 ,回溯后=[1, 2, 3]
        i=3第2层 ,回溯后=[1, 2]
        i=4第3层 ,回溯前=[1, 2, 4]sum=7
            i=5第4层 ,回溯前=[1, 2, 4, 5]sum=12
            i=5第3层 ,回溯后=[1, 2, 4]
            i=6第4层 ,回溯前=[1, 2, 4, 6]sum=13
            i=6第3层 ,回溯后=[1, 2, 4]
            i=7第4层 ,回溯前=[1, 2, 4, 7]sum=14
            i=7第3层 ,回溯后=[1, 2, 4]
            i=8第4层 ,回溯前=[1, 2, 4, 8]sum=15
            i=8第3层 ,回溯后=[1, 2, 4]
            i=9第4层 ,回溯前=[1, 2, 4, 9]sum=16
            i=9第3层 ,回溯后=[1, 2, 4]
        i=4第2层 ,回溯后=[1, 2]
        i=5第3层 ,回溯前=[1, 2, 5]sum=8
            i=6第4层 ,回溯前=[1, 2, 5, 6]sum=14
            i=6第3层 ,回溯后=[1, 2, 5]
            i=7第4层 ,回溯前=[1, 2, 5, 7]sum=15
            i=7第3层 ,回溯后=[1, 2, 5]
            i=8第4层 ,回溯前=[1, 2, 5, 8]sum=16
            i=8第3层 ,回溯后=[1, 2, 5]
            i=9第4层 ,回溯前=[1, 2, 5, 9]sum=17
            i=9第3层 ,回溯后=[1, 2, 5]
        i=5第2层 ,回溯后=[1, 2]
        i=6第3层 ,回溯前=[1, 2, 6]sum=9
            进入收集，第3层 ,收集到结果=[1, 2, 6]
        i=6第2层 ,回溯后=[1, 2]
        i=7第3层 ,回溯前=[1, 2, 7]sum=10
        i=7第2层 ,回溯后=[1, 2]
        i=8第3层 ,回溯前=[1, 2, 8]sum=11
        i=8第2层 ,回溯后=[1, 2]
        i=9第3层 ,回溯前=[1, 2, 9]sum=12
        i=9第2层 ,回溯后=[1, 2]
    i=2第1层 ,回溯后=[1]
    i=3第2层 ,回溯前=[1, 3]sum=4
        i=4第3层 ,回溯前=[1, 3, 4]sum=8
            i=5第4层 ,回溯前=[1, 3, 4, 5]sum=13
            i=5第3层 ,回溯后=[1, 3, 4]
            i=6第4层 ,回溯前=[1, 3, 4, 6]sum=14
            i=6第3层 ,回溯后=[1, 3, 4]
            i=7第4层 ,回溯前=[1, 3, 4, 7]sum=15
            i=7第3层 ,回溯后=[1, 3, 4]
            i=8第4层 ,回溯前=[1, 3, 4, 8]sum=16
            i=8第3层 ,回溯后=[1, 3, 4]
            i=9第4层 ,回溯前=[1, 3, 4, 9]sum=17
            i=9第3层 ,回溯后=[1, 3, 4]
        i=4第2层 ,回溯后=[1, 3]
        i=5第3层 ,回溯前=[1, 3, 5]sum=9
            进入收集，第3层 ,收集到结果=[1, 3, 5]
        i=5第2层 ,回溯后=[1, 3]
        i=6第3层 ,回溯前=[1, 3, 6]sum=10
        i=6第2层 ,回溯后=[1, 3]
        i=7第3层 ,回溯前=[1, 3, 7]sum=11
        i=7第2层 ,回溯后=[1, 3]
        i=8第3层 ,回溯前=[1, 3, 8]sum=12
        i=8第2层 ,回溯后=[1, 3]
        i=9第3层 ,回溯前=[1, 3, 9]sum=13
        i=9第2层 ,回溯后=[1, 3]
    i=3第1层 ,回溯后=[1]
    i=4第2层 ,回溯前=[1, 4]sum=5
        i=5第3层 ,回溯前=[1, 4, 5]sum=10
        i=5第2层 ,回溯后=[1, 4]
        i=6第3层 ,回溯前=[1, 4, 6]sum=11
        i=6第2层 ,回溯后=[1, 4]
        i=7第3层 ,回溯前=[1, 4, 7]sum=12
        i=7第2层 ,回溯后=[1, 4]
        i=8第3层 ,回溯前=[1, 4, 8]sum=13
        i=8第2层 ,回溯后=[1, 4]
        i=9第3层 ,回溯前=[1, 4, 9]sum=14
        i=9第2层 ,回溯后=[1, 4]
    i=4第1层 ,回溯后=[1]
    i=5第2层 ,回溯前=[1, 5]sum=6
        i=6第3层 ,回溯前=[1, 5, 6]sum=12
        i=6第2层 ,回溯后=[1, 5]
        i=7第3层 ,回溯前=[1, 5, 7]sum=13
        i=7第2层 ,回溯后=[1, 5]
        i=8第3层 ,回溯前=[1, 5, 8]sum=14
        i=8第2层 ,回溯后=[1, 5]
        i=9第3层 ,回溯前=[1, 5, 9]sum=15
        i=9第2层 ,回溯后=[1, 5]
    i=5第1层 ,回溯后=[1]
    i=6第2层 ,回溯前=[1, 6]sum=7
        i=7第3层 ,回溯前=[1, 6, 7]sum=14
        i=7第2层 ,回溯后=[1, 6]
        i=8第3层 ,回溯前=[1, 6, 8]sum=15
        i=8第2层 ,回溯后=[1, 6]
... 162 more lines
 */