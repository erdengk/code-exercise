package daily.exercise.LeetCodeTree;

/**
 * @ClassName: IsBalanced
 * @Description:
 * @author: dk
 * @date: 2022/2/9 5:45 下午
 */

public class IsBalanced {

    class Info {

        public boolean isBalanced;
        public int height;

        public Info( boolean b, int h ) {
            isBalanced = b;
            height = h;
        }

    }


    public Info process( TreeNode node ) {
        if ( node == null ) {
            return new Info( true, 0 );
        }
        Info left = process( node.left );
        Info right = process( node.right );

        int height = Math.max( left.height, right.height ) + 1;

        boolean isBalanced = true;

        if ( !left.isBalanced || !right.isBalanced
                || Math.abs( left.height - right.height ) > 1
        ) {
            isBalanced = false;
        }

        return new Info( isBalanced, height );
    }


    /**
     * 110. 平衡二叉树
     * https://leetcode-cn.com/problems/balanced-binary-tree/
     * @param root
     * @return
     */
    public boolean isBalanced( TreeNode root ) {
        return process( root ).isBalanced;
    }

}
