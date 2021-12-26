package daily.exercise.LeetCodeHashMap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: IsHappy
 * @Description:
 * @author: dk
 * @date: 2021/12/26 7:58 上午
 */

public class IsHappy {

    public boolean isHappy( int n ) {
        if ( n == 1 ) {
            return true;
        }
        if ( n < 10 && n != 7 ) {
            return false;
        } else {
            int temp = 0;
            while ( n != 0 ) {
                temp = temp + (n % 10) * (n % 10);
                n = n / 10;
            }
            //System.out.println( temp );
            return isHappy( temp );
        }
    }


    /**
     * good way
     *
     * @param n
     * @return
     */
    public boolean isHappyTwo( int n ) {
        Set<Integer> record = new HashSet<>();
        while ( n != 1 && !record.contains( n ) ) {
            record.add( n );
            n = getNextNumber( n );
        }
        return n == 1;
    }


    private int getNextNumber( int n ) {
        int res = 0;
        while ( n > 0 ) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }


    public static void main( String[] args ) {

        // System.out.println( isHappy( 19000 ) );
//        int n = 10;
//        for ( int i = 1; i < Math.sqrt( n ); i++ ) {
//            for ( int j = 1; j < Math.sqrt( n ); j++ ) {
//                for ( int k = 1; k < Math.sqrt( n ); k++ ) {
//                    if ( (i * i + j * j + k * k) == n ) {
//                        System.out.println( i + " " + j + " " + k );
//                    }
//                }
//            }
//        }
    }

}
