package daily.exercise.LeetCodeArray.window;

import java.util.Arrays;

/**
 * @ClassName: CheckInclusion
 * @Description:
 * @author: dk
 * @date: 2021/12/19 2:42 下午
 */

public class CheckInclusion {

    public boolean checkInclusion( String s1, String s2 ) {
        boolean b = false;
        int []a1= new int[26];
        int []a2= new int[26];
        int l=0;
        int r=0;
        for ( int i = 0; i < s1.length(); i++ ) {
            a1[s1.charAt( i )-'a']++;
        }
        while ( r<s2.length() ){
            int index = s1.charAt( r )-'a';
            if(a1[index]!=0){
                a2[index]++;
                r++;
            }else{
                l++;
                r++;
            }
            if(r-l+1==s1.length()){
                b = check(a1,a2);
            }
            if(b){
                return b;
            }else{
                l=r;
            }
        }

        return b;
    }


    private boolean check( int[] a1, int[] a2 ) {
        Boolean f = true;
        for ( int i = 0; i < a1.length; i++ ) {
            if(a1[i]!=a2[i])return false;
        }
        return f;
    }


}