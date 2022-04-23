package dailyExercise.LeetCodeArray.window;

import java.util.HashMap;

/**
 * @ClassName: MinWindow
 * @Description:
 * @author: dk
 * @date: 2021/12/20 2:31 下午
 */

public class MinWindow {

    /**
     * [76. 最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow( String s, String t ) {
        String res = "";
        if ( t.length() > s.length() ) {
            return res;
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for ( int i = 0; i < t.length(); i++ ) {
            char ch = t.charAt( i );
            need.put( ch, need.getOrDefault( ch, 0 ) + 1 );
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while ( right < s.length() ) {
            char c = s.charAt( right );
            right++;
            if ( need.containsKey( c ) ) {
                window.put( c, window.getOrDefault( c, 0 ) + 1 );
                if ( window.get( c ).equals( need.get( c ) ) ) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while ( valid == need.size() ) {
                // 在这里更新最小覆盖子串
                if ( right - left < len ) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt( left );
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if ( need.containsKey( d ) ) {
                    if ( window.get( d ).equals( need.get( d ) ) ) {
                        valid--;
                    }
                    window.put( d, window.get(d) - 1 );
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring( start, start+len );
    }

}
