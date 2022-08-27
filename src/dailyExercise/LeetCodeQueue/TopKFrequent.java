package dailyExercise.LeetCodeQueue;

import java.util.*;

/**
 * @ClassName: TopKFrequent
 * @Description:
 * @author: dk
 * @date: 2022/8/27 17:07
 */

public class TopKFrequent {

    /**
     * [347. 前 K 个高频元素](https://leetcode.cn/problems/top-k-frequent-elements/)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值，构建于一个大顶堆（o1 - o2: 小顶堆， o2 - o1 : 大顶堆）
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new
                PriorityQueue<>(
                        (o1, o2) -> o2.getValue() - o1.getValue()
        );
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
    class Solution {
        class Info{
            int num;
            int times;
            public Info(int n,int t){
                num = n;
                times = t;
            }
        }
        public int[] topKFrequent(int[] nums, int k) {
            ArrayList<Info> list = new ArrayList<>();
            HashMap<Integer,Integer> map = new HashMap<>();
            for(Integer n:nums){
                if(!map.containsKey(n)){
                    map.put(n,1);
                }else{
                    map.put(n,map.get(n)+1);
                }
            }
            for (Integer i : map.keySet()) {
                // System.out.println("key: " + i + " value: " + map.get(i));
                list.add(new Info(i,map.get(i)));
            }
            list.sort(new Comparator<Info>() {
                @Override
                public int compare(Info o1, Info o2) {
                    return o2.times-o1.times;
                }
            });
            int []res = new int[k];
            for(int i=0;i<k;i++){
                res[i]=list.get(i).num;
            }
            return res;
        }
    }
}
