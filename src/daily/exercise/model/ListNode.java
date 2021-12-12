package daily.exercise.model;

import java.util.Scanner;

/**
 * @ClassName: ListNode
 * @Description: 链表相关
 * @author: dk
 * @date: 2021/12/3 11:59 上午
 */


class Node {

    int val;
    Node next = null;

    public Node(int val) {
        this.val = val;
    }
}


public class ListNode {
    public static Node head = null;
    public static Node node = null;

    public void addNode(int d) {
        Node n = new Node(d);
        if (head == null) {
            head = n;
            return;
        }
        node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
            ListNode m = new ListNode();
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                m.addNode(temp);
            }
            node = rever(head);
            for (int j = 0; j < n; j++) {
                System.out.print(node.val + " ");
                node = node.next;
            }
        }
    }

    public static Node rever(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}


