package dailyExercise.LeetCodeString;

/**
 * @ClassName: ReverseStr
 * @Description:
 * @author: dk
 * @date: 2021/12/28 1:20 下午
 */

public class ReverseStr {

    /**
     * [541. 反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii/)
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr( String s, int k ) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for ( int i = 0; i < arr.length; i = i + 2 * k ) {
            if ( n >= (i + 2 * k) ) {
                reverse( arr, i, i + k );
            } else if ( n - i < k ) {
                reverse( arr, i, n );
            } else if ( n - i >= k && n - i < 2 * k ) {
                reverse( arr, i, i + k );
            }
        }
        return String.valueOf( arr );
    }


    public static void reverse( char[] arr, int start, int end ) {

        for ( int i = start, j = 0; i < (start + end) / 2; i++, j++ ) {
            char temp = arr[i];
            arr[i] = arr[end - 1 - j];
            arr[end - 1 - j] = temp;
        }

    }

}
