package dailyExercise.LeetCodeArray;

/**
 * @ClassName: SortedSquares
 * @Description:
 * @author: dk
 * @date: 2021/12/15 12:41 下午
 */

public class SortedSquares {

    /**
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares( int[] nums ) {
        int[] res = new int[nums.length];
        int n = nums.length - 1;
        int l = 0;
        int r = nums.length - 1;
        for ( int i = 0; i < nums.length; i++ ) {
            nums[i] = nums[i] * nums[i];
        }
        while ( l < r ) {
            if ( nums[l] <= nums[r] ) {
                res[n--] = nums[r];
                r--;
            } else if ( nums[l] > nums[r] ) {
                res[n--] = nums[l];
                l++;
            }
        }
        return res;
    }

    /*
-4	-1	0	3	10

--------------------------

16	1	0	9	100



l=0,r=4

arr[l]<arr[r]	16<100

res[0,0,0,0,100]

n=4 n--

r-- r=3



l=0,r=3

arr[l]>arr[r]	16>9

n=3  n--

res[0,0,0,16,100]

l++ l=1



l=1,r=3

arr[l]<arr[r]	1<9

n=2 n--

res[0,0,9,16,100]

r-- r=2



l=1,r=2

arr[l]>arr[r]	1>2

n=1 n--

res[0,1,9,16,100]

l++ l=2



但此时还有最后一个元素未处理，所以while的循环终止条件应该为l<=r



l=1,r=2

arr[l]=arr[r]	0=0

n=0 n--

res[0,1,9,16,100]

r-- r=1



l>r 退出循环
     */
}
