package daily.exercise.skillsContest;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @author: dk
 * @date: 2021/11/27 11:50 上午
 */

public class Main3 {

    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println( isScramble( s1, s2 ) );
    }


    public static boolean isScramble( String s1, String s2 ) {
        if ( s1.length() != s2.length() ) {
            return false;
        }
        if ( s1.equals( s2 ) ) {
            return true;
        }

        int[] a = new int[26];
        for ( int i = 0; i < s1.length(); i++ ) {
            a[s1.charAt( i ) - 'a']++;
            a[s2.charAt( i ) - 'a']--;
        }

        for ( int i = 0; i < 26; i++ ) {
            if ( a[i] != 0 ) {
                return false;
            }
        }

        for ( int i = 1; i < s1.length(); i++ ) {
            if ( isScramble( s1.substring( 0, i ), s2.substring( 0, i ) )
                    && isScramble( s1.substring( i ), s2.substring( i ) ) ) {
                return true;
            }
            if ( isScramble( s1.substring( i ), s2.substring( 0, s2.length() - i ) )
                    &&
                    isScramble( s1.substring( 0, i ), s2.substring( s2.length() - i ) )
            ) {
                return true;
            }
        }
        return false;
    }

}
