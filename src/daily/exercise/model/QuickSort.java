package daily.exercise.model;

/**
 * @ClassName: QuickSort
 * @Description: 快排
 * @author: dk
 * @date: 2021/11/27 4:48 下午
 */

public class QuickSort {

    public static void quickSort( int[] arr ) {
        if ( arr == null || arr.length < 2 ) {
            return;
        }
        quickSort( arr, 0, arr.length - 1 );
    }


    public static void quickSort( int[] arr, int L, int R ) {
        if ( L < R ) {
            //先随机取出一个数放到最后
            //swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition( arr, L, R );
            quickSort( arr, L, p[0] - 1 );
            quickSort( arr, p[1] + 1, R );
        }
    }


    public static int[] partition( int[] arr, int l, int r ) {
        int less = l - 1;
        int more = r;
        while ( l < more ) {
            if ( arr[l] < arr[r] ) {
                swap( arr, ++less, l++ );
            } else if ( arr[l] > arr[r] ) {
                swap( arr, --more, l );
            } else {
                l++;
            }
        }
        swap( arr, more, r );
        return new int[]{ less + 1, more };
    }


    public static void swap( int[] arr, int i, int j ) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main( String[] args ) {
//        int[] arr = { 3, 4, 5, 6, 1, 2, 3, 4, 5, 4, 3 };
//        int num = 4;
//        printArray( arr );
//        quickSort( arr );
//        printArray( arr );
        StringBuffer sb = new StringBuffer();
        char a = 'a';
        sb.append( a );
    }


    private static void printArray( int[] arr ) {
        for ( Integer i :
                arr ) {
            System.out.print( i + " " );
        }
        System.out.println();
    }

}

