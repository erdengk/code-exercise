package daily.exercise.LeetCodeTree;

/**
 * @ClassName: BuildTree
 * @Description:
 * @author: dk
 * @date: 2022/2/11 4:14 下午
 */

public class BuildTree {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeByPreAndIno( int[] preorder, int[] inorder ) {
        if ( preorder.length == 0 && inorder.length == 0 ) {
            return null;
        }

        return build( preorder, 0, preorder.length, inorder, 0, inorder.length );
    }
    public TreeNode build( int[] preorder, int pStart, int pEnd,
            int[] inorder, int iStart, int iEnd ) {
        if ( pEnd - pStart < 1 ) {
            return null;
        }

        int rootValue = preorder[pStart];
        TreeNode node = new TreeNode( rootValue );

        if ( pEnd - pStart == 1 ) {
            return node;
        }

        int index;
        for ( index = 0; index < inorder.length; index++ ) {
            if ( inorder[index] == rootValue ) {
                break;
            }
        }
        int preorderLeftStart = pStart + 1;
        int preorderLeftEnd = pStart + 1 + index - iStart;

        int preorderRightStart = pStart + 1 + index - iStart;
        int preorderRightEnd = pEnd;

        int inorderLeftStart = iStart;
        int inorderLeftEnd = index;

        int inorderRightStart = index + 1;
        int inorderRightEnd = iEnd;

        node.left = build( preorder, preorderLeftStart, preorderLeftEnd,
                inorder, inorderLeftStart, inorderLeftEnd );
        node.right = build( preorder, preorderRightStart, preorderRightEnd,
                inorder, inorderRightStart, inorderRightEnd );

        return node;
    }




}
