package daily.exercise.LeetCodeArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FindAnagrams
 * @Description:
 * @author: dk
 * @date: 2021/12/16 10:02 上午
 */

public class FindAnagrams {

    /**
     * [438. 找到字符串中所有字母异位词 （mid）](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)
     *
     * @param s
     * @param p
     * @return 参考 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/gong-shui-san-xie-shuang-zhi-zhen-shi-xi-t5hc/
     */
    public List<Integer> findAnagrams( String s, String p ) {
        List<Integer> res = new ArrayList<>();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        int l = 0;
        for ( int i = 0; i < p.length(); i++ ) {
            c2[p.charAt( i ) - 'a']++;
        }
        for ( int r = 0; r < s.length(); r++ ) {
            c1[s.charAt( r ) - 'a']++;
            // 如果 l到r 之间的距离超过了 p 的长度，就将最前面的字符频率-1
            if ( (r + 1 - l) > p.length() ) {
                c1[s.charAt( l++ ) - 'a']--;
            }
            if ( check( c1, c2 ) ) {
                res.add( l );
            }
        }
        return res;
    }


    private Boolean check( int[] c1, int[] c2 ) {
        for ( int i = 0; i < c1.length; i++ ) {
            if ( c1[i] != c2[i] ) {
                return false;
            }
        }
        return true;
    }

}
/*
cbaebac
abc

c1 [ c 1]
c2 [ a 1 b 1 c 1]
r=0

c1 [ c 1 b 1  ]
c2 [ a 1 b 1 c 1]
r=1

c1 [ c 1 b 1 a 1]
c2 [ a 1 b 1 c 1]
r=2
r+1-l = 3 = p.length
进入check return true
left=0
res.add(left=0)


cbaebac
abc

c1 [ c 1 b 1 a 1 e 1]
c2 [ a 1 b 1 c 1]
r=3
r+1-l = 4 > p.length
将s的left 位置的字符频率-1
此时left = 0
c1 [ c 0 b 1 a 1 e 1]
l++ l=1


c1 [ c 0 b 2 a 1 e 1 ]
c2 [ a 1 b 1 c 1]
r=4
r+1-l = 4+1-1 > p.length
将s的left 位置的字符频率-1
此时left = 1
c1 [ c 0 b 1 a 1 e 1]
l++ l=2



cbaebac
abc

c1 [ c 0 b 1 a 2 e 1 ]
c2 [ a 1 b 1 c 1]
r=5
r+1-l = 5+1-2 > p.length
将s的left 位置的字符频率-1
此时left = 2
c1 [ c 0 b 1 a 1 e 1 ]
l++ l=3

c1 [ c 1 b 1 a 1 e 1 ]
c2 [ a 1 b 1 c 1]
r=6
r+1-l = 6+1-3 > p.length
将s的left 位置的字符频率-1
此时left = 3
c1 [ c 1 b 1 a 1 e 0 ]
l++ l=4

check return true
res.add(4)

 */