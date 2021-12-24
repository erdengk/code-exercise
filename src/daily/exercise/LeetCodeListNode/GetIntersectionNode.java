package daily.exercise.LeetCodeListNode;

/**
 * @ClassName: GetIntersectionNode
 * @Description:
 * @author: dk
 * @date: 2021/12/24 8:36 上午
 */

public class GetIntersectionNode {

    /**
     * [面试题 02.07. 链表相交](https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeTwo( ListNode headA, ListNode headB ) {
        ListNode la = headA;
        ListNode lb = headB;
        while ( la != lb ) {
            //到达链表末尾时，重新走另一条链表的路
            la = la == null ? headB : la.next;
            lb = lb == null ? headA : lb.next;
        }
        return la;
    }


    public ListNode getIntersectionNode( ListNode headA, ListNode headB ) {
        if ( headA == null || headB == null ) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int a = 0;
        int b = 0;
        while ( nodeA != null ) {
            nodeA = nodeA.next;
            a++;
        }
        while ( nodeB != null ) {
            nodeB = nodeB.next;
            b++;
        }
        if ( a == b ) {
            return null;
        } else if ( a > b ) {
            int time = a - b;
            while ( time > 0 ) {
                headA = headA.next;
                time--;
            }
        } else if ( a < b ) {
            int time = a - b;
            while ( time > 0 ) {
                headB = headB.next;
                time--;
            }
        }
        while ( headA != null && headB != null ) {
            if ( headA == headB ) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

}
