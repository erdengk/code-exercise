package daily.exercise.LeetCodeBacktracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: CanPartitionKSubsets
 * @Description:
 * @author: dk
 * @date: 2021/12/30 5:47 下午
 */

public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets( int[] nums, int k ) {
        // 排除一些基本情况
        if ( k > nums.length ) {
            return false;
        }
        int sum = 0;
        for ( int v : nums ) {
            sum += v;
        }
        if ( sum % k != 0 ) {
            return false;
        }

        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];
        // 理论上每个桶（集合）中数字的和
        int target = sum / k;
        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
        return backtrack( nums, 0, bucket, target );
    }


    // 递归穷举 nums 中的每个数字
    boolean backtrack(
            int[] nums, int index, int[] bucket, int target ) {
        if(index==nums.length){
            for ( int i = 0; i < bucket.length; i++ ) {

            }
            return true;
        }
        return false;
    }

        public static void main (String[]args ){
            List<Integer> list = new ArrayList<>();
            list.add( 4 );
            list.add( 3 );
            list.add( 5 );
            list.add( 1 );
            list.add( 6 );
            // 正序
            list.sort( Integer::compareTo );
            list.forEach( ( i ) -> System.out.println( i ) );
            // 倒叙
            list.sort( Comparator.reverseOrder() );
            list.forEach( ( i ) -> System.out.println( i ) );


//            List<User> list = new ArrayList<>();
//            list.add(new User(1,12,"java"));
//            list.add(new User(2,13, "python"));
//            list.add(new User(3,14, "js"));
//            list.add(new User(4,15, "scala"));
//            list.add(new User(5,16, "ruby"));
//            list.add(new User(6,17, "c"));
//
//            list.sort((o1, o2) -> o2.getAge() - o1.getAge());

        }
    }
