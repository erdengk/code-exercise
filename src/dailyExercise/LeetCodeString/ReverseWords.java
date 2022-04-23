package dailyExercise.LeetCodeString;

import java.util.Stack;

/**
 * @ClassName: ReverseWords
 * @Description:
 * @author: dk
 * @date: 2021/12/28 2:37 下午
 */

public class ReverseWords {

    /**
     * @param s
     * @return
     */
    public String reverseWords( String s ) {
        //源字符数组
        char[] initialArr = s.toCharArray();
        //新字符数组
        char[] newArr = new char[initialArr.length + 1];
        int newArrPos = 0;
        //i来进行整体对源字符数组从后往前遍历
        int i = initialArr.length - 1;
        while ( i >= 0 ) {
            // 跳过空格，最后i停到最后一个单词的最后一个字母处
            while ( i >= 0 && initialArr[i] == ' ' ) {
                i--;
            }
            int right = i;
            // 找到单词的首字母
            while ( i >= 0 && initialArr[i] != ' ' ) {
                i--;
            }
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)
            // 取出的每组末尾都带有一个空格
            for ( int j = i + 1; j <= right; j++ ) {
                newArr[newArrPos++] = initialArr[j];
                if ( j == right ) {
                    // 补空格
                    newArr[newArrPos++] = ' ';
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；
        //若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if ( newArrPos == 0 ) {
            return "";
        } else {
            return new String( newArr, 0, newArrPos - 1 );
        }
    }


    public static void reverse( char[] arr, int start, int end ) {

        for ( int i = start, j = 0; i < (start + end) / 2; i++, j++ ) {
            char temp = arr[i];
            arr[i] = arr[end - 1 - j];
            arr[end - 1 - j] = temp;
        }

    }
    //TODO 双指针solution
}

