package daily.exercise.LeetCodeGraph;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Modle
 * @Description:
 * @author: dk
 * @date: 2022/1/19 2:41 下午
 */

public class Modle {

    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget( int[][] graph ) {
        // 维护递归过程中经过的路径
        LinkedList<Integer> path = new LinkedList<>();
        traverseAllGraph( graph, 0, path );
        return res;
    }

    /* 图的遍历框架 */
    void traverseAllGraph( int[][] graph, int s, LinkedList<Integer> path ) {
        // 添加节点 s 到路径
        path.addLast( s );
        int n = graph.length;
        if ( s == n - 1 ) {
            // 到达终点
            res.add( new LinkedList<>( path ) );
            path.removeLast();
            return;
        }
        // 递归每个相邻节点
        for ( int v : graph[s] ) {
            traverseAllGraph( graph, v, path );
        }
        // 从路径移出节点 s
        path.removeLast();
    }

}
