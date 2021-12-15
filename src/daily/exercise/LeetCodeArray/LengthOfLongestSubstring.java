package daily.exercise.LeetCodeArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LengthOfLongestSubstring
 * @Description:
 * @author: dk
 * @date: 2021/12/15 2:26 下午
 */

public class LengthOfLongestSubstring {

    /**
     *[3. 无重复字符的最长子串 （mid）](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if ( s.length()<=1 ){
            return s.length();
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res=0;
        while (right < s.length()) {
            // 增大窗口
            char c = s.charAt( right );
            if(map.containsKey( c )) {
                //此时出现了重复的字母，需要更新窗口开始位置
                left = Math.max( left, map.get(c) + 1 );
            }
            //更新 c 所代表字符最晚出现位置
            map.put( c,right );
            res = Math.max( res,right-left+1);
            right++;
        }
        return res;
    }




}
/*
pwwkew

p w
(  p 0
   w 1
)
res = Math.max( res,right-left+1);
(0,1-0+1) res=2

p w w
(  p 0
   w 1
)
w 重复了,开始重新定位left
left = Math.max( left, map.get( c ) + 1 );
(0,1+1) left=2

更新 c 所代表字符的新的位置
map.put( c,right );
p w w
(  p 0
   w 2
)
res = Math.max( res,right-left+1);
(2,2-2+1) res=2

p w w k
(  p 0
   w 2
   k 3
)
res = Math.max( res,right-left+1);
(2,3-2+1) res=2

p w w k e
(  p 0
   w 2
   k 3
   e 4
)
res = Math.max( res,right-left+1);
(2,4-2+1) res=3

p w w k e w
(  p 0
   w 2
   k 3
   e 4
)
w 重复了 重新定位其位置
left = Math.max( left, map.get( c ) + 1 );
(2,2+1) left=3
res = Math.max( res,right-left+1);
(2,5-3+1) res=3




 */
