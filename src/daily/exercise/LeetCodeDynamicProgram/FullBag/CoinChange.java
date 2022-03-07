package daily.exercise.LeetCodeDynamicProgram.FullBag;

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
    public int change(int[] coins, int amount) {
        return  0 ;
    }

    int res = 0 ;
    public int changeByBack(int amount, int[] coins) {
        get(coins,amount,0,0);
        return res;
    }
    public void get(int []coins,int amount,int target,int index){
        if(target==amount){
            res++;
            return;
        }
        if(target>amount)return;

        for(int i=index;i<coins.length;i++){

            target+=coins[i];
            get(coins,amount,target,i);
            target-=coins[i];

        }
    }
}
