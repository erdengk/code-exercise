package dailyExercise.LeetCodeListNode;

/**
 * @ClassName: ReverseList
 * @Description:
 * @author: dk
 * @date: 2021/12/23 1:54 下午
 */

public class ReverseList {

    /**
     * [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
     *
     * @param head
     * @return
     */
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

/*
1-2-3-4-5


pre-1(head-cur)-2-3


temp=cur.next
pre->1(head-cur)->2(temp)->3

cur.next = pre;
pre<-1(head-cur)   2(temp)->3

pre = cur;
pre<-1(head-cur)   2(temp)->3

null<-1(head-cur-pre) 2(temp)->3

cur = temp
null<-1(head-pre) 2(cur)->3

temp=cur.next
null<-1(head-pre) 2(cur)->3(temp)

cur.next = pre
null<-1(head-pre)<-2(cur)  3(temp)

pre = cur
null<-1(head)<-2(pre-cur)  3(temp)

cur =temp
null<-1(head)<-2(pre)  3(cur)->null

temp=cur.next
null<-1(head-cur)<-2(pre)  3(cur)->null(temp)

cur.next = pre
null<-1(head)<-2(pre)<-3(cur)   null(temp)

pre = cur
null<-1(head)<-2()<-3(pre-cur)   null(temp)

cur = temp
null<-1(head)<-2()<-3(pre)   null(cur)

cur ==null 跳出循环

null<-1(head)<-2()<-3(pre)


return pre

 */