package daily.exercise.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FullArrangement
 * @Description: 全排列
 * @author: dk
 * @date: 2021/11/27 11:49 上午
 */

public class FullArrangement {

    public static List<String> list = new ArrayList<>();


    private static void process( char[] ch, int start ) {
        if ( start == ch.length ) {
            System.out.println( String.valueOf( ch ) );
            list.add( String.valueOf( ch ) );
        }
        for ( int j = start; j < ch.length; j++ ) {
            swap( ch, start, j );
            process( ch, start + 1 );
            swap( ch, start, j );
        }
    }


    public static void swap( char[] chs, int i, int j ) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


    public static void main( String[] args ) {
        String ch = "123";
        process( ch.toCharArray(), 0 );
    }

}
