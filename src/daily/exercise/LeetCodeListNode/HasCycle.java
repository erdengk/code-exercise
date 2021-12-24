package daily.exercise.LeetCodeListNode;

/**
 * @ClassName: HasCycle
 * @Description:
 * @author: dk
 * @date: 2021/12/24 9:08 上午
 */

public class HasCycle {

    /**
     * [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while ( fast.next!=null && fast.next.next!=null){
            if(slow==fast)return true;
            slow=slow.next;
            fast=fast.next;
        }
        return false;
    }

}
