package dailyExercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Partition
 * @Description:
 * @author: dk
 * @date: 2022/1/2 9:40 上午
 */

public class Partition {




    /**
     * https://leetcode-cn.com/problems/palindrome-partitioning/
     * @param s
     * @return
     */
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        show(s,0);
        return res;
    }
    private void show( String s ,int start) {
        if ( start>=s.length() ){
            res.add( new LinkedList<>(path) );
            return;
        }
        for(int i=start;i<s.length();i++){
            String temp = s.substring( start, i + 1 );
            if ( back( s.toCharArray(), start, i ) ) {
                path.add( temp );
            } else {
                continue;
            }
            show( s,i+1);
            path.removeLast();
        }
    }

    private boolean back( char[] arr,int start,int end  ) {
        for ( int i = start ,j=0 ;i < end ;i++,j++ ){
            if(arr[i]!=arr[end-j])return false;
        }
        return true;
    }

}
