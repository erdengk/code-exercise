package daily.exercise.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: CombinationModle
 * @Description: 组合问题模版
 * @author: dk
 * @date: 2021/11/27 11:57 上午
 */

public class CombinationModle {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> combine( int n, int k ) {
        combineHelper( n, k, 1 );
        return result;
    }


    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     *
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */
    private void combineHelper( int n, int k, int startIndex ) {
        //终止条件
        if ( path.size() == k ) {
            result.add( new ArrayList<>( path ) );
            return;
        }
        // n - (k - path.size()) + 1  剪枝操作
        for ( int i = startIndex; i <= n - (k - path.size()) + 1; i++ ) {
            path.add( i );
            combineHelper( n, k, i + 1 );
            path.removeLast();
        }
    }

}
