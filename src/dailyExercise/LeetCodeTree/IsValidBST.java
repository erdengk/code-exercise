package dailyExercise.LeetCodeTree;

/**
 * @ClassName: IsValidBST
 * @Description:
 * @author: dk
 * @date: 2022/9/6 16:09
 */

public class IsValidBST {

    /**
     *[98. 验证二叉搜索树](https://leetcode.cn/problems/validate-binary-search-tree/)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return check(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }
    boolean check(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;

        return check(lower, root.val, root.left)
                &&
                check(root.val, upper, root.right);
    }
}
