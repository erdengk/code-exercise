package daily.exercise.LeetCodeDynamicProgram.FullBag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName: CoinChange
 * @Description:
 * @author: dk
 * @date: 2022/2/28 4:04 下午
 */

public class CoinChange {

    /**
     * 322. 零钱兑换
     * https://leetcode-cn.com/problems/coin-change/
     * @param coins
     * @param amount
     * @return
     */
    int res =  Integer.MAX_VALUE  ;
    public int coinChange(int[] coins, int amount) {
        back(coins,amount,0);
        return res == Integer.MAX_VALUE ? -1 :res;
    }
    public void back(int []coins,int amount,int index){
        if(amount<0){
            return;
        }
        if(amount==0){
            if(index<res)res=index;
            return;
        }
        for(int i= 0 ;i<coins.length;i++){
            back(coins,amount-coins[i],index+1);
        }
    }




    int []memo ;
    public int coinChangeByArray(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return findWay(coins,amount);
    }
    public int findWay(int []coins,int amount){
        // base case
        if(amount<0)return -1;
        // 如果是凑0
        if(amount==0)return 0;
        // -1 是为了与下标对应
        if(memo[amount-1] != 0) {
            return memo[amount - 1];
        }


        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res = findWay(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
                min = res + 1;
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }


    public int coinChangeByDp(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        int []memo = new int[amount+1];
        for(int i =1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0 && memo[i-coins[j]]<min){
                    min = memo[i-coins[j]]+1;
                }
            }
            memo[i] = min;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
    //https://leetcode-cn.com/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/



    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int  n  = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();

        while ( n>0 ){
            list.add( sc.nextInt());
            n--;
        }
        int res = 0;
        int num = 0 ;
        System.out.println(list.size());

        while ( !list.isEmpty()) {
            int index = (int) Math.pow( 2, num );
            num++;
            int temp = 0;
            for ( int i = 0; i < index; i++ ) {
                temp = temp + list.get( i );
                list.removeFirst();
            }
            if(temp<res)res = temp;
        }
        System.out.println(res);
    }
}
