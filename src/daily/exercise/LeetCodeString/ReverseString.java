package daily.exercise.LeetCodeString;

/**
 * @ClassName: ReverseString
 * @Description:
 * @author: dk
 * @date: 2021/12/28 1:09 下午
 */

public class ReverseString {

    /**
     * [344. 反转字符串](https://leetcode-cn.com/problems/reverse-string/)
     *
     * @param s
     */
    public void reverseString( char[] s ) {
        int l = 0;
        int r = s.length - 1;
        while ( l < r ) {
            //构造 a ^ b 的结果，并放在 a 中
            s[l] ^= s[r];
            //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[r] ^= s[l];
            //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            s[l] ^= s[r];
            l++;
            r--;
        }
    }


    public void reverseStringTwo( char[] arr ) {
        int start = 1;
        int end = arr.length;

        for ( int i = start - 1, j = 0; i < (start + end) / 2; i++, j++ ) {
            char temp = arr[i];
            arr[i] = arr[end - 1 - j];
            arr[end - 1 - j] = temp;
        }

    }

}
