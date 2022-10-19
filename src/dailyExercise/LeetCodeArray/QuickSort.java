package dailyExercise.LeetCodeArray;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName: QuickSort
 * @Description:
 * @author: dk
 * @date: 2022/10/19 16:53
 */

public class QuickSort {
    /**
     * https://leetcode.cn/problems/find-the-kth-largest-integer-in-the-array/
     * @param nums
     * @param k
     * @return
     */
    public String kthLargestNumber(String[] nums, int k) {
        int []arr = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]= Integer.parseInt(nums[i]);
        }

        randomizeQuicksort(arr, 0, arr.length - 1);
        return String.valueOf(arr[nums.length-k]);
    }

    private void randomizeQuicksort(int []nums, int left, int right){
        if(left<right){
            int pivot = randomizePartition(nums,left,right);
            randomizeQuicksort(nums,pivot+1,right);
            randomizeQuicksort(nums,left,pivot-1);
        }
    }

    private int randomizePartition(int []nums, int left, int right){
        // 随机化处理，面对有序序列可以增加其处理速度，不至于退化为 n^2
        int pos = new Random().nextInt(right-left)+left;
        swap(nums,pos,right);



        // 用当前区间最后一个值当pivot
        int pivot = nums[right];

        System.out.println("---------------------start");
        System.out.println("当前pivot="+pivot);
        System.out.println("当前数组是"+ Arrays.toString(nums));

        int l = left;
        int r = right-1;
        while(l<=r){
            while(l<=r && pivot<=nums[r])r--;
            while(l<=r && pivot>=nums[l])l++;
            if (l <= r) swap(nums, l, r);
        }
        System.out.println("当前交换前数组是"+Arrays.toString(nums));
        swap(nums, r + 1, right);
        System.out.println("当前交换后数组是"+Arrays.toString(nums));
        System.out.println("---------------------end");
        return r + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*



---------------------start
当前pivot=10
当前数组是[3, 6, 7, 13, 12, 2, 10]left=0  right=6
内部第0次循环[3, 6, 7, 2, 12, 13, 10]
内部第1次循环[3, 6, 7, 2, 12, 13, 10]

当前交换前数组是[3, 6, 7, 2, 12, 13, 10]
当前交换后数组是[3, 6, 7, 2, 10, 13, 12]
---------------------end

---------------------start
当前pivot=13
当前数组是[3, 6, 7, 2, 10, 12, 13]left=5  right=6
内部第0次循环[3, 6, 7, 2, 10, 12, 13]

当前交换前数组是[3, 6, 7, 2, 10, 12, 13]
当前交换后数组是[3, 6, 7, 2, 10, 12, 13]
---------------------end

---------------------start
当前pivot=3
当前数组是[2, 6, 7, 3, 10, 12, 13]left=0  right=3
内部第0次循环[2, 6, 7, 3, 10, 12, 13]

当前交换前数组是[2, 6, 7, 3, 10, 12, 13]
当前交换后数组是[2, 3, 7, 6, 10, 12, 13]
---------------------end

---------------------start
当前pivot=7
当前数组是[2, 3, 6, 7, 10, 12, 13]left=2  right=3
内部第0次循环[2, 3, 6, 7, 10, 12, 13]

当前交换前数组是[2, 3, 6, 7, 10, 12, 13]
当前交换后数组是[2, 3, 6, 7, 10, 12, 13]
---------------------end


 */
