package dailyExercise.LeetCodeTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @ClassName: TreeModle
 * @Description:
 * @author: dk
 * @date: 2022/2/8 4:58 下午
 */

public class TreeModle {

    public List<Integer> treeDFS( TreeNode root ) {
        List<Integer> res = new ArrayList<>();
        if ( root == null ) {
            return res;
        }
        Queue<TreeNode> qu = new LinkedList<>();

        res.add( root.val );
        if ( root.left != null ) {
            qu.offer( root.left );
        }
        if ( root.right != null ) {
            qu.offer( root.right );
        }

        while ( !qu.isEmpty() ) {
            int size = qu.size();
            for ( int i = 0; i < size; i++ ) {
                TreeNode node = qu.poll();

                //do something

                if ( node.left != null ) {
                    qu.offer( node.left );
                }
                if ( node.right != null ) {
                    qu.offer( node.right );
                }
            }
        }
        return res;
    }



}
