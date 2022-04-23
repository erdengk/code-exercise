package dailyExercise.LeetCodeTree;

/**
 * @ClassName: TreeNode
 * @Description:
 * @author: dk
 * @date: 2022/2/8 6:42 下午
 */

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;


    TreeNode() {
    }


    TreeNode( int val ) {
        this.val = val;
    }


    TreeNode( int val, TreeNode left, TreeNode right ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
