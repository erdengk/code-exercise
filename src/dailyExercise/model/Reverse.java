package dailyExercise.model;

/**
 * @ClassName: Reverse
 * @Description:
 * @author: dk
 * @date: 2021/12/27 1:10 下午
 */

public class Reverse {

    public static void reverse( char[] arr, int start, int end ) {

        for ( int i = start, j = end; i < j; i++, j-- ) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }
}
