package dailyExercise.LeetCodeArray;


public class Rotate {

    /**
     * 189. 轮转数组
     * https://leetcode.cn/problems/rotate-array/
     * 省略最简单的方案 拼接、创建新的空间
     *
     * @param nums
     * @param k
     */
    public void rotate( int[] nums, int k ) {
        int t = k % nums.length;
        if ( t == 0 ) {
            return;
        }

        revese( nums, 0, nums.length - 1 );
        revese( nums, 0, t - 1 );
        revese( nums, t, nums.length - 1 );
    }


    public void revese( int[] nums, int start, int end ) {
        while ( start < end ) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public void rotate1( int[] nums, int k ) {
        int n = nums.length;
        k = k % n;
        if ( k == 0 ) {
            return;
        }
        int count = 0;

        for ( int i = 0; count < n; i++ ) {
            // 当前位置
            int cur = i;
            // 当前位置的前一个数字（第一个就是其自己）
            int pre = nums[cur];
            do {
                // 下一个坐标
                int next = (cur + k) % n;
                // 交换
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                // 将下一个位置给cur
                cur = next;
                // 更换次数增加
                count++;
            } while ( i != cur );

        }
    }
//https://leetcode.cn/problems/rotate-array/solution/xuan-zhuan-shu-zu-yuan-di-huan-wei-xiang-xi-tu-jie/
}
