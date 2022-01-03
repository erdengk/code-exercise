package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: RestoreIpAddresses
 * @Description:
 * @author: dk
 * @date: 2022/1/2 10:12 上午
 */

public class RestoreIpAddresses {

    /**
     * https://leetcode-cn.com/problems/restore-ip-addresses/
     *
     * @param s
     * @return
     */
    List<String> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();


    public List<String> restoreIpAddresses( String s ) {
        show( s, 0 );
        return res;
    }


    String point = ".";


    private void show( String s, int start ) {
        if ( start >= s.length() && path.size() == 4 ) {
            String temp = "";
            for ( int i = 0; i < path.size(); i++ ) {
                temp = temp + path.get( i );
                if ( i != path.size() - 1 ) {
                    temp = temp + point;
                }
            }
            res.add( temp );
            return;
        }
        for ( int i = start; i < s.length(); i++ ) {
            String temp = s.substring( start, i + 1 );
            if ( legal( temp ) ) {
                path.add( temp );
            } else {
                continue;
            }
            show( s, i + 1 );
            path.removeLast();
        }
    }


    int illLegalNum = 255;


    private boolean legal( String temp ) {
        if ( temp.length() == 1 ) {
            return true;
        }
        //前导0
        if ( temp.length() > 1 && temp.charAt( 0 ) - '0' == 0 ) {
            return false;
        }
        if ( temp.length() >= 4 ) {
            return false;
        }
        int num = Integer.valueOf( temp );
        if ( num > illLegalNum ) {
            return false;
        }
        return true;
    }

}
