package daily.exercise.LeetCodeGreedy;

import java.util.Arrays;

/**
 * @ClassName: FindContentChildren
 * @Description:
 * @author: dk
 * @date: 2022/1/7 8:49 上午
 */

public class FindContentChildren {

    /**
     * https://leetcode-cn.com/problems/assign-cookies/
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren( int[] g, int[] s ) {
        if ( s.length == 0 ) {
            return 0;
        }
        int res = 0;
        Arrays.sort( g );
        Arrays.sort( s );
        int start = -1;
        for ( int i = 0; i < g.length; i++ ) {
            for ( int j = start + 1; j < s.length; j++ ) {
                if ( g[i] <= s[j] ) {
                    res++;
                    start = j;
                    break;
                }
            }
        }
        return res;
    }
    public int findContentChildrenTwo( int[] g, int[] s ) {
        if ( s.length == 0 ) {
            return 0;
        }
        int res = 0;
        Arrays.sort( g );
        Arrays.sort( s );
        int index = 0;
        for ( int i = 0; i < s.length; i++ ) {
            if(index<g.length && s[i] >= g[index]){
                res++;
                index++;
            }
        }
        return res;
    }
}
