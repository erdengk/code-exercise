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
        // 可以用fast的下一个节点是否为空来判断整个链表节点个数是技术还是偶数
        if ( fast.next == null ) {
            // 需要将slow 指向下一个节点 再进行翻转
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
            // 若节点个数为偶数，则slow 在上中点
            // 需要返回以下中点为首的 翻转后的链表
            //返回 slow.next后半部分链表
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


    /**
     * 优秀的解法
     * https://labuladong.gitee.io/algo/2/17/19/
     * @param head
     * @return
     */
    boolean isPalindromeByLa(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverseList(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

}
