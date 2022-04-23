package dailyExercise.LeetCodeArray;

/**
 * @ClassName: RemoveElement
 * @Description:
 * @author: dk
 * @date: 2021/12/12 8:02 下午
 */

public class RemoveElement {

    /**
     * 27. 移除元素https://leetcode-cn.com/problems/remove-element/
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != val) {
                nums[s++] = nums[f];
            }
        }
        return s;
    }

    /**
     * 26. 删除有序数组中的重复项https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int s = 0;
        for (int f = 1; f < nums.length; f++) {
            if (nums[f] != nums[s]) {
                nums[++s] = nums[f];
            }
        }
        return s + 1;
    }

    int removeDuplicatesTwo(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 83. 删除排序链表中的重复元素https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = head;
        ListNode f = head.next;
        while (f != null) {
            if (s.val != f.val) {
                s.next = f;
                s = s.next;
                f = f.next;
            } else {
                f = f.next;
            }
        }
        // 断开与后面重复元素的连接
        s.next = null;
        return head;
    }

    /**
     * 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 去除 nums 中的所有 0
        // 返回去除 0 之后的数组长度
        int p = removeElementTemp(nums, 0);
        // 将 p 之后的所有元素赋值为 0
        for (; p < nums.length; p++) {
            nums[p] = 0;
        }
    }

    public int removeElementTemp(int[] nums, int val) {
        int s = 0;
        for (int f = 0; f < nums.length; f++) {
            if (nums[f] != val) {
                nums[s++] = nums[f];
            }
        }
        return s;
    }


    public void moveZeroesTwo(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void moveZeroesThree(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
//    作者：wang_ni_ma
//    链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
