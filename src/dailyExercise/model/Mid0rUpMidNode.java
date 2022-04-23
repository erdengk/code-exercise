package dailyExercise.model;

/**
 * @ClassName: mid0rUpMidNode
 * @Description: 链表相关
 * @author: dk
 * @date: 2021/11/27 5:14 下午
 */

public class Mid0rUpMidNode {

    static class Node {

        int val;
        Node next;

    }


    //输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node mid0rUpMidNode( Node head ) {
        if ( head == null || head.next == null || head.next.next == null ) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static Node mid0rUpMidNode2( Node head ) {
        if ( head == null || head.next == null ) {
            return null;
        }
        Node n1 = head;
        Node n2 = head;
        while ( n2.next != null && n2.next.next != null ) { // find mid node
            n1 = n1.next; // n1 -》mid
            n2 = n2.next.next; // n2 -> end
        }
        return n1;
    }


    //输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node mid0rDownMidNode( Node head ) {
        if ( head == null || head.next == null ) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //输入链表头节点，奇数长度返回中点前一个，偶数长度返回.上中点前一个
    public static Node mid0rUpMidPreNode( Node head ) {
        if ( head == null || head.next == null || head.next.next == null ) {
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
