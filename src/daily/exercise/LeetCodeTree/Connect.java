package daily.exercise.LeetCodeTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Connect
 * @Description:
 * @author: dk
 * @date: 2022/2/8 5:34 下午
 */

public class Connect {

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;


        public Node() {
        }


        public Node( int _val ) {
            val = _val;
        }


        public Node( int _val, Node _left, Node _right, Node _next ) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

    }


    /**
     * 117. 填充每个节点的下一个右侧节点指针 II
     * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
     *
     * @param root
     * @return
     */
    public Node connect( Node root ) {
        if ( root == null ) {
            return null;
        }
        root.next = null;
        Queue<Node> qu = new LinkedList<>();

        if ( root.left != null ) {
            qu.offer( root.left );
        }
        if ( root.right != null ) {
            qu.offer( root.right );
        }

        while ( !qu.isEmpty() ) {

            int size = qu.size();
            Node node = null;
            Node preNode = null;

            for ( int i = 0; i < size; i++ ) {

                if ( i == 0 ) {
                    preNode = qu.poll();
                    node = preNode;
                } else {
                    node = qu.poll();
                    preNode.next = node;
                    preNode = preNode.next;
                }

                if ( node.left != null ) {
                    qu.offer( node.left );
                }
                if ( node.right != null ) {
                    qu.offer( node.right );
                }

            }
            // 本层最后一个节点 next 指向 null
            preNode.next = null;
        }
        return root;
    }

}
