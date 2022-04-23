package dailyExercise.LeetCodeTree;

/**
 * @ClassName: MinDiffInBST
 * @Description:
 * @author: dk
 * @date: 2022/2/12 4:20 下午
 */

public class MinDiffInBST {

    // 记录上一个遍历的结点
    TreeNode pre;
    public int res = Integer.MAX_VALUE;


    /**
     * 783. 二叉搜索树节点最小距离
     * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
     * @param root
     * @return
     */
    public int minDiffInBST( TreeNode root ) {
        show( root );
        return res;
    }


    public void show( TreeNode root ) {
        if ( root == null ) {
            return;
        }
        show( root.left );
        if ( pre != null ) {
            System.out.println( " root.val--" + root.val + " pre.val--" + pre.val );
            res = Math.min( res, root.val - pre.val );
        }
        pre = root;
        //右
        show( root.right );
    }


}
