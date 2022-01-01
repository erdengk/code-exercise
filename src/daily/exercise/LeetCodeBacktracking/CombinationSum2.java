package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: CombinationSum2
 * @Description:
 * @author: dk
 * @date: 2021/12/31 3:27 下午
 */

public class CombinationSum2 {

    /**
     * https://leetcode-cn.com/problems/combination-sum-ii/
     *
     * @param candidates
     * @param target
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> combinationSum2( int[] candidates, int target ) {
        Arrays.sort( candidates );
        boolean[] used = new boolean[candidates.length];
        getCombination( candidates, used, target, 0 );
        return res;
    }


    int sum = 0;


    private void getCombination( int[] candidates, boolean[] used, int target, int start ) {
        if ( sum > target ) {
            return;
        }
        if ( sum == target ) {
            res.add( new ArrayList<>( path ) );
            return;
        }

        for ( int i = start; i < candidates.length; i++ ) {

            //只能剔除第一位重复 题目要求是每一位开头只求一次
            //if(path.size()==0 && i>0  && candidates[i]==candidates[i-1])continue;

            // 相当于把重复元素值的解给剔除了
            //if(path.size()>0 && path.getLast()==candidates[i])continue;

            //如果candidates[i] == candidates[i - 1] 并且 used[i - 1] == false
            // 【1，2，2，2，5】 target=5
            // 1，2，2，   为一个解
            // 1，2，  再次选2 时，candidates[i] == candidates[i - 1] ，且 used[i - 1] == false
            //  代表 2 已经被选过，且是当前集合中选取过了，所以不能选，所以continue

            //正确剔除重复解的办法
            if ( i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1] ) {
                continue;
            }

            used[i] = true;
            sum += candidates[i];
            path.add( candidates[i] );

            getCombination( candidates, used, target, i + 1 );

            used[i] = false;
            int temp = path.getLast();
            sum -= temp;
            path.removeLast();

        }
    }


//    List<List<Integer>> res = new ArrayList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//    int sum = 0;


    public List<List<Integer>> combinationSum2Two( int[] candidates, int target ) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort( candidates );
        backTracking( candidates, target, 0 );
        return res;
    }


    private void backTracking( int[] candidates, int target, int start ) {
        if ( sum == target ) {
            res.add( new ArrayList<>( path ) );
            return;
        }
        for ( int i = start; i < candidates.length && sum + candidates[i] <= target; i++ ) {
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if ( i > start && candidates[i] == candidates[i - 1] ) {
                continue;
            }

            sum += candidates[i];
            path.add( candidates[i] );
            // i+1 代表当前组内元素只选取一次
            backTracking( candidates, target, i + 1 );

            int temp = path.getLast();
            sum -= temp;
            path.removeLast();

        }
    }

}
