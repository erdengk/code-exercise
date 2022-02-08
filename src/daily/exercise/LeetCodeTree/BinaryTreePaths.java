package daily.exercise.LeetCodeTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: BinaryTreePaths
 * @Description:
 * @author: dk
 * @date: 2022/2/8 6:42 下午
 */

public class BinaryTreePaths {
    public List<String> list = new ArrayList<>();
    public LinkedList<TreeNode> link = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root.left==null && root.right==null){
            list.add(new String(String.valueOf(root.val)));
            return list;
        }
        link.add(root);
        show(root);
        return list;
    }
    public void show(TreeNode root){
        if(root.left==null && root.right==null){
            List<TreeNode> r = new ArrayList<>(link);
            String res = getRes(r);
            list.add(res);
            return;
        }
        if(root.left!=null){
            link.add(root.left);
            show(root.left);
            link.removeLast();
        }
        if(root.right!=null){
            link.add(root.right);
            show(root.right);
            link.removeLast();
        }
    }
    public String getRes(List<TreeNode> resList){
        String s ="";
        for(TreeNode r: resList){
            s = s +"->"+ r.val ;
        }
        return s.substring(2,s.length());
    }
}
