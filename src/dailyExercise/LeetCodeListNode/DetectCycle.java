package dailyExercise.LeetCodeListNode;

/**
 * @ClassName: DetectCycle
 * @Description:
 * @author: dk
 * @date: 2021/12/24 9:14 上午
 */

public class DetectCycle {

    /**
     * [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
     *
     * @param head
     * @return
     */
    public ListNode detectCycle( ListNode head ) {
        if ( head == null || head.next == null ) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode node = null;

        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) {
                node = slow;
                break;
            }
        }
        if ( node != null ) {
            ListNode temp = head;
            while ( temp != node ) {
                temp = temp.next;
                node = node.next;
            }
            return temp;
        }
        return null;
    }

}
