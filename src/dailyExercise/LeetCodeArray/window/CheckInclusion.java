package dailyExercise.LeetCodeArray.window;

import java.util.Arrays;

/**
 * @ClassName: CheckInclusion
 * @Description:
 * @author: dk
 * @date: 2021/12/19 2:42 下午
 */

public class CheckInclusion {

    /**
     * [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion( String s1, String s2 ) {
        boolean b = false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        int l = 0;
        int r = 0;
        for ( int i = 0; i < s1.length(); i++ ) {
            a1[s1.charAt( i ) - 'a']++;
        }
        while ( r < s2.length() ) {
            int index = s2.charAt( r ) - 'a';
            a2[index]++;
            if ( r - l + 1 == s1.length() ) {
                if ( check( a1, a2 ) ) {
                    return true;
                } else {
                    a2[s2.charAt( l ) - 'a']--;
                    l++;
                }
            }
            r++;

        }
        return b;
    }


    private boolean check( int[] a1, int[] a2 ) {
        Boolean f = true;
        for ( int i = 0; i < a1.length; i++ ) {
            if ( a1[i] != a2[i] ) {
                return false;
            }
        }
        return f;
    }

    public static void main(String[] args) {
        String  s = "123";
        String  s1 = "1234";

        System.out.println(s.indexOf(s1));
        System.out.println(s1.indexOf(s));
    }

}
