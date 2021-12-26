package daily.exercise.LeetCodeListNode;

/**
 * @ClassName: RemoveElements
 * @Description:
 * @author: dk
 * @date: 2021/12/21 3:58 下午
 */

public class RemoveElements {

    /**
     * [203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/)
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements( ListNode head, int val ) {
        if ( head == null ) {
            return head;
        }
        ListNode node = new ListNode();
        node.next = head;
        ListNode pre = node;
        ListNode cur = head;
        while ( cur != null ) {
            if ( cur.val == val ) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return node.next;
    }

}

/**
 * ()中数字代表第几次出现，对应字母为当前指针指向这个节点
 *
 * (node-pre)-7(1-cur)-7(2)-8(1)-7(4)--9(1)
 *
 * (node-pre)-7(1-cur)-7(2)-8(1)-7(4)--9(1)
 *
 * cur.val==val
 *
 * (node-pre)--------7(2)-8(1)-7(4)--9(1)
 * 7(1-cur)
 * cur=cur.next;
 *
 * (node-pre)---7(2-cur)-8(1)-7(4)--9(1)
 *
 * cur.val==val
 *
 * (node-pre)----8(1)-7(4)--9(1)
 * 7(2-cur)
 * cur=cur.next;
 *
 * (node-pre)----8(1-cur)-7(4)--9(1)
 * cur.val!=val
 * pre = cur;
 * cur=cur.next;
 *
 * (node-pre)----8(1--pre)-7(4-cur)--9(1)
 * cur.val==val
 *
 * (node-pre)----8(1--pre)---------9(1)
 * 7(4-cur)
 * cur=cur.next;
 *
 * (node-pre)----8(1--pre)---------9(1-cur)
 * cur=cur.next;
 *
 * (node-pre)----8(1--pre)---------9(1-)-null(cur)
 * 退出循环
 *
 * node-8-9
 * return node.next;
 */