package dailyExercise.LeetCodeListNode;

import java.util.List;

/**
 * @ClassName: MyLinkedList
 * @Description:
 * @author: dk
 * @date: 2021/12/21 4:36 下午
 */

public class MyLinkedList {


    static class ListNode {

        int val;
        ListNode next;


        ListNode() {
        }


        ListNode( int val ) {
            this.val = val;
        }

    }


    int size;
    public ListNode list;


    public MyLinkedList() {
        size = 0;
        list = new ListNode();
    }


    public int get( int index ) {
        if ( list == null ) {
            return -1;
        }
        if ( index < 0 || index >= size ) {
            return -1;
        }
        ListNode currentNode = list;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for ( int i = 0; i <= index; i++ ) {
            currentNode = currentNode.next;
        }
        return currentNode.val;

    }


    public void addAtHead( int val ) {
        addAtIndex( 0, val );
    }


    public void addAtTail( int val ) {
        addAtIndex( size, val );
    }


    public void addAtIndex( int index, int val ) {
        if ( index > size ) {
            return;
        }
        if ( index < 0 ) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode pred = list;
        for ( int i = 0; i < index; i++ ) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode( val );
        toAdd.next = pred.next;
        pred.next = toAdd;
    }


    public void deleteAtIndex( int index ) {
        if ( index < 0 || index >= size ) {
            return;
        }
        size--;
        ListNode pred = list;
        for ( int i = 0; i < index; i++ ) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

}
