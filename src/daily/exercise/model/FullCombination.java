package daily.exercise.model;

import java.util.HashSet;

/**
 * @ClassName: FullCombination
 * @Description: 全组合 (包含一个空字符串)
 * @author: dk
 * @date: 2021/11/27 11:53 上午
 */

public class FullCombination {

    public static HashSet<String> set = new HashSet<>();


    private static void print( char[] chs, int i, String s ) {
        if ( i == chs.length ) {
            if ( !set.contains( s ) ) {
                System.out.println( s );
                return;
            }
        }
        print( chs, i + 1, s );
        print( chs, i + 1, s + chs[i] );
    }


    public static void main( String[] args ) {
        String s = "123";
        print( s.toCharArray(), 0, "" );
    }

}

