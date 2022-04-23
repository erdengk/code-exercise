package dailyExercise.LeetCodeString;

/**
 * @ClassName: ReverseLeftWords
 * @Description:
 * @author: dk
 * @date: 2021/12/30 4:33 下午
 */

public class ReverseLeftWords {

    public String reverseLeftWords( String s, int n ) {
        char[] arr = s.toCharArray();
        reverse( arr, 0, n-1 );
        reverse( arr, n, arr.length-1 );
        reverse( arr, 0, arr.length-1 );
        return String.valueOf( arr );
    }

    public static void reverse( char[] arr, int start, int end ) {

        for ( int i = start, j = end; i < j; i++, j-- ) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

}
