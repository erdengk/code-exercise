package dailyExercise.LeetCodeTree;

/**
 * @ClassName: ConstructMaximumBinaryTree
 * @Description:
 * @author: dk
 * @date: 2022/2/10 6:52 下午
 */

public class ConstructMaximumBinaryTree {

    public TreeNode getTree( int[] nums, int left, int right ) {
        if ( left >= right ) {
            return null;
        }
        //if(left<0 || right >nums.length )return null;

        int maxIndex = left;
        for ( int i = left + 1; i < right; i++ ) {
            if ( nums[maxIndex] < nums[i] ) {
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode( nums[maxIndex] );

        node.left = getTree( nums, left, maxIndex );
        node.right = getTree( nums, maxIndex + 1, right );

        return node;
    }


    public TreeNode constructMaximumBinaryTree( int[] nums ) {
        return getTree( nums, 0, nums.length );
    }

}
