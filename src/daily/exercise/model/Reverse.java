package daily.exercise.model;

/**
 * @ClassName: Reverse
 * @Description:
 * @author: dk
 * @date: 2021/12/27 1:10 下午
 */

public class Reverse {

    public static void reverse(int[] arr,int start,int end) {

        for(int i = start-1 ,j=0; i<(start+end)/2;i++,j++){
            int temp = arr[i];
            arr[i]=arr[end-1-j];
            arr[end-1-j]=temp;
        }

    }
}
