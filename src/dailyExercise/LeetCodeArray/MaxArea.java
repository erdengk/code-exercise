package dailyExercise.LeetCodeArray;

/**
 * @ClassName: MaxArea
 * @Description:
 * @author: dk
 * @date: 2022/10/29 13:22
 */

public class MaxArea {

    /*
    [11. 盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/)

    每次排除掉左右两侧最小的，因为这个最小的决定了整体的下限

     */
    public int maxArea(int[] height) {
        int n = height.length-1;
        int left = 0;
        int right = n;
        int res = 0;
        while(left < right){
            res = Math.max(res, (right-left) * Math.min(height[left],height[right]) );
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
