package daily.exercise.LeetCodeArray.window;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: ShortestSubarray
 * @Description:
 * @author: dk
 * @date: 2022/1/16 4:54 下午
 */

public class ShortestSubarray {

    class Solution {

        /**
         * [862. 和至少为 K 的最短子数组](https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/)
         * @param A
         * @param K
         * @return
         */
        public int shortestSubarray( int[] A, int K ) {
            long[] arr = new long[A.length + 1];
            for ( int i = 0; i < A.length; i++ ) {
                arr[i + 1] = arr[i] + A[i];
                if ( A[i] >= K ) {
                    return 1;
                }
            }//得到前缀和数组
            int res = Integer.MAX_VALUE;
            Deque<Integer> queue = new ArrayDeque<>();
            for ( int i = 0; i < arr.length; i++ ) {
                while ( !queue.isEmpty() && arr[i] <= arr[queue.getLast()] ) {
                    queue.removeLast();
                }
                while ( !queue.isEmpty() && arr[i] - arr[queue.peek()] >= K ) {
                    res = Math.min( res, i - queue.poll() );
                }
                queue.add( i );

            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

    }

// 作者：ppppjcute
// 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/solution/java-qian-zhui-he-yu-shuang-duan-by-ppppjqute/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

/*
[10,-2,4,5,6]
15

如果用滑动窗口，窗口最大会变成【10，-2，4，5，6】
此时 sum= 23 > 15
缩小窗口  sum-10 = 13 < 15
返回合适的窗口大小为 5  ，其实正确的结果应该为【4，5，6】 窗口大小是3

            while(!queue.isEmpty()&&arr[i]<=arr[queue.getLast()])   queue.removeLast();
            while(!queue.isEmpty()&&arr[i]-arr[queue.peek()]>=K)    res = Math.min(res,i-queue.poll());
            queue.add( i );

  arr[i]<=arr[queue.getLast()]
  如果当前的前缀和要小于之前的前缀和，那必然是在求解前缀和的过程中越加越小的，

  情况1是把位于末尾没用的x1扔掉，
  情况2是把指向前面的已经满足条件的x1的指针向后移动1位，这是就需要比较当前最小值与此时刚符合条件的值的大小了。



原数组
【10,-2,4,5,6】

前缀和数组为
【0,10,8,12,17,23】
添加元素

【0】
【0，1】



开始删除最后进来的元素
i= 2 队列为： [0, 1]
i= 2 arr[i]= 8 arr[queue.getLast()]=10 删除的是1位置的数，也就是10，

添加元素
【0，2】
【0，2，3】

开始更新结果
i= 4 arr[i]= 17 arr[queue.peek()]=0
i= 4 队列为 [0, 2, 3]
结果更新为： 4
i= 4 结果更新后的队列为 [2, 3]

添加元素
【2，3，4】

开始更新结果
i= 5 arr[i]= 23 arr[queue.peek()]=8
i= 5 队列为 [2, 3, 4]
结果更新为： 3

5-queue.poll() = 5 -2 = 3





 */


    /**
     * 滑动窗口不能通过，因为中间有负数，会影响窗口的缩短
     * [84,-37,32,40,95]
     * 167
     *
     * @param nums
     * @param k
     * @return
     */
    public int shortestSubarrayBadWay( int[] nums, int k ) {
        if ( nums.length == 1 ) {
            if ( nums[0] == k ) {
                return 1;
            } else {
                return -1;
            }
        }
        int l = 0;
        int r = 0;
        int count = 0;
        for ( int i = 0; i < nums.length; i++ ) {
            if ( nums[i] > 0 ) {
                l = i;
                r = i;
                break;
            }
        }

        int res = Integer.MAX_VALUE;
        while ( r < nums.length ) {
            count = count + nums[r];
            r++;
            while ( count >= k || l < r ) {
                //System.out.println(count+" r= "+ r + " l= " + l);
                res = Math.min( res, r - l );
                count = count - nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
