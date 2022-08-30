package dailyExercise.LeetCodeGreedy;

import java.util.Arrays;

/**
 * @ClassName: EraseOverlapIntervals
 * @Description:
 * @author: dk
 * @date: 2022/2/17 9:06 下午
 */

public class EraseOverlapIntervals {

    /**
     * 435. 无重叠区间
     * https://leetcode-cn.com/problems/non-overlapping-intervals/
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            // 一个新的独立区间
            if (intervals[i][0] >= intervals[i - 1][1]) res++;
            else {
                //System.out.println("i="+ i +" intervals[i][1]="+intervals[i][1]);
                // 更新最右界限
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return intervals.length - res;
    }

}
