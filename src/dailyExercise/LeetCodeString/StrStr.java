package dailyExercise.LeetCodeString;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @ClassName: StrStr
 * @Description:
 * @author: dk
 * @date: 2021/12/30 5:05 下午  2022-08-25 16:12:30
 */

public class StrStr {

    /**
     * https://leetcode-cn.com/problems/implement-strstr/
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                // 不对应时看前一位的位置
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                // 继续往后匹配 i 和 j 同时往后移动
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                // 不相等时，回退到前一位
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                // 相等时，前后缀长度+1
                j++;
            next[i] = j;
        }
    }
}
