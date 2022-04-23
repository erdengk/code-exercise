package dailyExercise.LeetCodeListNode;

/**
 * @ClassName: ReverseBetween
 * @Description:
 * @author: dk
 * @date: 2021/12/23 2:09 下午
 */

public class ReverseBetween {

    public ListNode reverseList( ListNode head ) {
        if ( head == null ) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while ( cur != null ) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public ListNode reverseBetween( ListNode head, int left, int right ) {
        if ( head == null || (left == right) ) {
            return head;
        }

        ListNode node = head;
        int size = 0;
        while ( node != null ) {
            size++;
            node = node.next;
        }

        if ( right == size ) {
            if ( left == 1 ) {
                return reverseList( head );
            }
            ListNode start = head;
            int num = 1;
            while ( num < left - 1 ) {
                start = start.next;
                num++;
            }
            start.next = reverseList( start.next );
        } else {
            int n = right - left + 1;
            ListNode start = head;
            ListNode end = head;
            int num = 1;
            while ( num < left - 1 ) {
                start = start.next;
                num++;
            }

            num = 1;
            while ( num < right + 1 ) {
                end = end.next;
                num++;
            }
            ListNode pre = null;
            ListNode cur = null;

            if ( left == 1 ) {
                cur = head;
            } else {
                cur = start.next;
            }

            while ( cur != null && n > 0 ) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
                n--;
            }

            if ( left == 1 ) {
                head.next = end;
                return pre;
            } else {
                //System.out.println(pre.val);
                ListNode temp = start.next;
                //System.out.println(temp.val);
                start.next = pre;
                temp.next = end;
                ;
            }
        }
        return head;
    }


}
