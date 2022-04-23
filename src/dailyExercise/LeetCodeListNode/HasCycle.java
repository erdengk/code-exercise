package dailyExercise.LeetCodeListNode;

/**
 * @ClassName: HasCycle
 * @Description:
 * @author: dk
 * @date: 2021/12/24 9:08 上午
 */

public class HasCycle {

    /**
     * [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
     *
     * @param head
     * @return
     */
    public boolean hasCycle( ListNode head ) {
        if ( head == null || head.next == null ) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if ( slow == fast ) {
                return true;
            }
        }
        return false;
    }


    public static boolean hasCycleTestByTwo( ListNode head ) {
        if ( head == null || head.next == null ) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        int slowNum = 0;
        int fastNum = 0;

        while ( fast.next != null && fast.next.next != null ) {
            System.out.println( "未相遇：slow.val=" + slow.val + "   fast.val=" + fast.val );

            slow = slow.next;
            slowNum++;
            fast = fast.next.next;
            fastNum += 2;
            if ( slow == fast ) {
                System.out.println( "slow.val=" + slow.val + "   fast.val=" + fast.val );
                System.out.println( slowNum + " " + fastNum );
                return true;
            }
        }
        return false;
    }


    public static boolean hasCycleTestByThree( ListNode head ) {
        if ( head == null || head.next == null ) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        int slowNum = 0;
        int fastNum = 0;
        while ( fast.next != null && fast.next.next != null && fast.next.next.next != null ) {

            System.out.println( "未相遇：slow.val=" + slow.val + "   fast.val=" + fast.val );

            slow = slow.next;
            slowNum++;

            fast = fast.next.next.next;
            fastNum += 3;

            if ( slow == fast ) {
                System.out.println( "slow.val=" + slow.val + "   fast.val=" + fast.val );
                System.out.println( slowNum + " " + fastNum );
                return true;
            }
        }
        return false;
    }


    public static void main( String[] args ) {
        ListNode node1 = new ListNode( 1 );
        ListNode node2 = new ListNode( 2 );
        ListNode node3 = new ListNode( 3 );
        ListNode node4 = new ListNode( 4 );
        ListNode node5 = new ListNode( 5 );
        ListNode node6 = new ListNode( 6 );
        ListNode node7 = new ListNode( 7 );
        ListNode node8 = new ListNode( 8 );
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node6;
        System.out.println( "此时环入口为 " + node6.val + "号节点" );
        System.out.println( hasCycleTestByTwo( node1 ) );
        System.out.println( "此时环入口为 " + node6.val + "号节点" );
        System.out.println( hasCycleTestByThree( node1 ) );
    }

    /**
     1.判断是否有环用快慢指针，只要相遇即为环，不用说，好理解。
     2.求环入口，就是一个数学问题转换为代码的问题。
     -------------------
     |                 ^
     v                 |
     0->1->2->3-> …… -> A ->....... -> B
     假设A为环入口，B为相遇点，设0到A距离为x,A到B距离为y,环的长度为c，快慢指针相遇是慢指针绕环n圈，快指针绕环m圈，
     由条件得快慢指针相遇时快指针走的长度是慢指针的2倍，则：
     2(x+nc+y)=x+mc+y；
     化简得x+y=(m-2n)c；
     x= （m-2n）c- y
     设相遇点到环入口距离为 z = c -y  y= c -z
     x  = （m-2n）c - (c-z)
     x  = (m-2n-1)c + z

     这意味着从起点0相遇点B的长度为环长度的正整数倍；
     换句话说，就是现在让两个指针速度都变成1(重点！！！)，第一个指针从起点0出发，第二个指针从相遇点B出发，
     则两个指针最后一定会在B点相遇；
     但这是两个指针第一次相遇吗？
     不，因为两个指针速度是相同的，所以往前退一退，就会发现两个指针其实是在环的入口第一次相遇后，就一直重合了；
     所以代码就转换成两个速度为1的指针，一个从起点出发，一个从B点出发，第一次相遇的节点即为入环点。
     伪代码如下：
     ListNode q = head;
     while (p != q) {
     p = p.next;
     q = q.next;
     }
     return q;`
     **/

    //TODO
    // 其他解题思路
    // https://leetcode-cn.com/problems/linked-list-cycle/solution/3chong-jie-jue-fang-shi-liang-chong-ji-bai-liao-10/
}
