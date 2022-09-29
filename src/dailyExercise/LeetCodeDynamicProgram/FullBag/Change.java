package dailyExercise.LeetCodeDynamicProgram.FullBag;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: Change
 * @Description:
 * @author: dk
 * @date: 2022/3/10 3:41 下午
 */

public class Change {

    public int change(int amount, int[] coins) {
        int []dp = new int[amount+1];
        dp[0]=1;
        // 遍历 钱币
        for(int i=0;i<coins.length;i++){
            // 遍历 金额
            for(int j=coins[i];j<=amount;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    public static int change1( int amount, int[] coins ) {
        System.out.println("先遍历物品（面值），然后遍历背包（需要凑的数字）");
        int res = 0;
        int n = coins.length;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for ( int i = 0; i < n; i++ ) {
            for ( int j = coins[i]; j <= amount; j++ ) {
                dp[j] += dp[j - coins[i]];

                System.out.println("-----");
                for(int index=0;index< dp.length;index++){
                    if(index==j){
                        System.out.print("*"+dp[index]+"*");
                    }
                    else{
                        System.out.print("  "+dp[index]+"  ");
                    }
                }
                System.out.println();
                System.out.println("i="+i+"  "+"j="+j+"  "+"面值 coins[i]="+coins[i]+" 要凑的target为 "+j);
                System.out.println("-----");
            }
        }
        return dp[amount];
    }

    public static int change2( int amount, int[] coins ) {
        System.out.println("先遍历背包（需要凑的数字），然后遍历物品（面值）");
        int res = 0;
        int n = coins.length;

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int j = 0; j <= amount; j++) { // 遍历背包容量
            for (int i = 0; i < n; i++) { // 遍历物品
                if (j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];


                System.out.println("-----");
                for(int index=0;index< dp.length;index++){
                    if(index==j){
                        System.out.print("*"+dp[index]+"*");
                    }
                    else{
                        System.out.print("  "+dp[index]+"  ");
                    }
                }
                System.out.println();
                System.out.println("i="+i+"  "+"j="+j+"  "+"面值 coins[i]="+coins[i]+" 要凑的target为 "+j);
                System.out.println("-----");

                }

            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int []coins = new int[]{1,2,5};
        int amount = 5;
        //change1(amount,coins)；
        // 组合数 回溯打印
        //System.out.println(changeBack(amount, coins));
        // 此时dp[j]里算出来的就是排列数
        //change2(amount,coins);
        // 排列数  回溯打印
        //System.out.println(changeBack2(amount, coins));
    }

    private static int  res = 0;
    public static int changeBack(int amount, int[] coins) {
        Arrays.sort(coins);
        LinkedList<Integer> list = new LinkedList<>();
        back(coins,amount,0,list,0);
        return res;
    }

    public static int changeBack2(int amount, int[] coins) {
        Arrays.sort(coins);
        LinkedList<Integer> list = new LinkedList<>();
        back(coins,amount,0,list,0);
        return res;
    }

    private static void back(int[] nums,int target,int n,LinkedList<Integer> list,int index){
        if(n>target)return;
        if(n==target){
            res++;
            System.out.println(list.toString());
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(n+nums[i]>target)return;
            n+=nums[i];
            list.add(nums[i]);
            back(nums,target,n,list,0);
            n-=nums[i];
            list.removeLast();
        }
    }

    private static void back1(int[] nums,int target,int n,LinkedList<Integer> list,int index){
        if(n>target)return;
        if(n==target){
            res++;
            System.out.println(list.toString());
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(n+nums[i]>target)return;
            n+=nums[i];
            list.add(nums[i]);
            back(nums,target,n,list,i);
            n-=nums[i];
            list.removeLast();
        }
    }
}
