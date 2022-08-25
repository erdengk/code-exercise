package dailyExercise.LeetCodeString;

/**
 * @ClassName: StrStr
 * @Description:
 * @author: dk
 * @date: 2021/12/30 5:05 下午  2022-08-25 16:12:30
 */

public class StrStr {

    /**
     * https://leetcode-cn.com/problems/implement-strstr/
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return getIndexOf(haystack,needle);
    }
    public int getIndexOf(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] str = s1.toCharArray();
        char[] match = s2.toCharArray();
        int x = 0;
        int y = 0;
        // O(M) m <= n
        int[] next = getNextArray(match);
        // O(N)
        while (x < str.length && y < match.length) {
            if (str[x] == match[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // y == 0 str往后一个位置
                x++;
            } else {
                //match无法继续匹配，回到当前字符前面字串的最大相等位置的下一个位置继续匹配
                y = next[y];
            }
        }
        // y 越界 返回 -1
        // x 越界。y 越界 最后一段匹配了
        // x 没越界，y越界了， str 中有一部分是匹配到了match。也就是在 x-y位置
        return y == match.length ? x - y : -1;
    }

    //求next数组过程
    public  int[] getNextArray(char[] match) {
        if (match.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[match.length];
        // 0 位置匹配不到，则直接无法继续
        next[0] = -1;
        // 1 位置匹配不到，则返回 0 位置继续下一轮的匹配
        next[1] = 0;
        int i = 2; // 目前在哪个位置上求next数组的值
        int cn = 0; // 当前是哪个位置的值再和i-1位置的字符比较
        while (i < next.length) {
            // 当前位置的前一个位置的字符 如果与他记录的 next数组中元素位置的字符相等
            // 那这个位置的next元素为cn加1
            if (match[i - 1] == match[cn]) { // 配成功的时候
                next[i] = cn+1;
                i++;
                cn++;
            } else if (cn > 0) {
                // 不断的找上个位置，若回退到字符串开头。0 ，则代表没有前后缀公共长度为0
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
