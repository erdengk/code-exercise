package daily.exercise.LeetCodeListNode;

/**
 * @ClassName: SwapPairs
 * @Description:
 * @author: dk
 * @date: 2021/12/22 3:03 下午
 */

public class SwapPairs {

    public ListNode swapPairs( ListNode head ) {

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode temp = pre;

        while ( temp.next != null && temp.next.next != null ) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

}
/*
1 2 3 4

(pre-temp)-1(head)-2-3-4

(pre-temp)-1(head-start)-2(end)-3-4

temp.next = end
(pre-temp)-2(end)--3-4
    1(head-start)-

start.next=end.next;
(pre-temp)-2(end)--3-4
    1(head-start)--3-4

end.next=start;
(pre-temp)-2(end)-1(head-start)--3-4

temp=start;
(pre-)-2(end)-1(head-pre)--3-4


 */

