package daily.exercise.LeetCodeListNode;

/**
 * @ClassName: IsPalindrome
 * @Description:
 * @author: dk
 * @date: 2021/12/24 11:48 上午
 */

public class IsPalindrome {

    /**
     * [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome( ListNode head ) {
        if ( head.next == null ) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reverseStart = slow;
        ListNode node = head;
        // 如果是奇数个节点，此时fast在最后一个节点
        // 需要将slow 指向下一个节点
        if ( fast.next == null ) {
            slow = slow.next;
            ListNode temp = reverseList( slow);
            while ( temp!=null ){
                if(temp.val!=node.val){
                    // System.out.println(temp.val +"-"+ node.val);
                    return false;
                }
                temp=temp.next;
                node=node.next;
            }
            reverseStart.next = reverseList( slow );
        } else {
            //返回 fast为首的后半部分链表
            ListNode temp = reverseList( slow.next );
            while ( temp!=null ){
                if(temp.val!=node.val){

                    return false;
                }
                temp=temp.next;
                node=node.next;
            }
            reverseStart.next = reverseList( slow );
        }

        return true;
    }


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

}
