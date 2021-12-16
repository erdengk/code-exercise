package daily.exercise.LeetCodeArray;


public class Search {

    /**
     * 704. 二分查找 https://leetcode-cn.com/problems/binary-search/
     *
     * @param nums
     * @param target
     * @return
     */
    public int search( int[] nums, int target ) {
        int l = 0;
        int r = nums.length - 1;
        //因为left == right是有意义的，所以使用 <=
        while ( l <= r ) {
            // 防止溢出
            int mid = l + (r - l) / 2;
            if ( nums[mid] == target ) {
                return mid;
            } else if ( nums[mid] < target ) {
                // 当前数字一定比targer小，所以下一次查询的范围是  【mid+1，r】
                l = mid + 1;
            } else if ( nums[mid] > target ) {
                //当前数字一定比targer大，所以下一次查询的范围是  【l，mid-1】
                r = mid - 1;
            }
        }
        return -1;
    }


    public int searchTwo( int[] nums, int target ) {
        int l = 0;
        // 定义target在左闭右开的区间里，即：[left, right)
        int r = nums.length;
        // 使用<  是因为left == right在区间[left, right)是没有意义的
        while ( l < r ) {
            // 防止溢出
            int mid = l + (r - l) / 2;
            if ( nums[mid] == target ) {
                return mid;
                //当 nums[mid] 被检测之后，下一步的搜索区间应该去掉 mid 分割成两个区间
                //即 [left, mid) 或 [mid + 1, right)
            } else if ( nums[mid] < target ) {
                //由于判断的区间范围是 【left，right）,此时 mid 位置的数是小于target的
                //下一步判断时就可以跳过 mid ，从mid +1 开始
                //判断范围为 [middle + 1, right)
                l = mid + 1;
            } else if ( nums[mid] > target ) {
                //由于判断的区间范围是 【left，right）,此时 mid 位置的数是大于target的
                //判断范围为【left, middle)
                // 若 r=mid-1 ，则本来 mid 与 l 产生的判断范围被忽略掉了
                r = mid;
            }
        }
        return -1;
    }
    /**
     *  -1  0   3   5   9   12
     *  ----------------------
     *  0   1   2   3   4   5
     *  target=3
     *  l=0，r=6
     *  第一次 mid = （0+6）/2 =3
     *   num[3] =5>3
     *  若 r =mid-1
     *  则 r=3-1=2
     *  第二次 mid = （0+2）/2=1
     *  num[1]=0 <3
     *  l=mid+1 =1+1=2 = r l==r while 循环退出，找不到target了
     *  但本例子中是有targer=3的
     *
     *  ------------------------
     *  选用r =mid
     *  则 r=3
     *  第二次 mid = （0+3）/2=1
     *  num[1]=0 <3
     *  l=mid+1 = 1+1 =2 < r
     *  第三次 mid = （2+3）/2=2
     *  num[2]=3  找到了target
     */

    //二分边界查找最优算法


    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange( int[] nums, int target ) {
        if ( nums.length == 0 || (nums.length == 1 && nums[0] != target) ) {
            return new int[]{ -1, -1 };
        }
        int left = searchLeft( nums, target );
        int right = searchRight( nums, target );
        return new int[]{ left, right };
    }


    private int searchRight( int[] nums, int target ) {
        int l = 0;
        int r = nums.length - 1;
        while ( l <= r ) {
            int mid = l + (r - l) / 2;
            if ( nums[mid] == target ) {
                l = mid + 1;
            } else if ( nums[mid] > target ) {
                r = mid - 1;
            } else if ( nums[mid] < target ) {
                l = mid + 1;
            }
        }
        return r >= 0 ? (nums[r] == target ? r : -1) : -1;
    }


    private int searchLeft( int[] nums, int target ) {
        int l = 0;
        int r = nums.length - 1;
        while ( l <= r ) {
            int mid = l + (r - l) / 2;
            if ( nums[mid] == target ) {
                r = mid - 1;
            } else if ( nums[mid] > target ) {
                r = mid - 1;
            } else if ( nums[mid] < target ) {
                l = mid + 1;
            }
        }
        return l <= nums.length - 1 ? (nums[l] == target ? l : -1) : -1;
    }


}
