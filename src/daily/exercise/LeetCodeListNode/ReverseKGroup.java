package daily.exercise.LeetCodeListNode;

/**
 * @ClassName: ReverseKGroup
 * @Description:
 * @author: dk
 * @date: 2021/12/23 3:04 下午
 */

public class ReverseKGroup {

    /**
     * [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)
     *
     * @param head
     * @param k
     * @return
     */
    ListNode reverseKGroup( ListNode head, int k ) {
        if ( head == null ) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for ( int i = 0; i < k; i++ ) {
            // 不足 k 个，不需要反转，base case
            if ( b == null ) {
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse( a, b );
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup( b, k );
        return newHead;
    }


    ListNode reverse( ListNode a, ListNode b ) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while ( cur != b ) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }


}
