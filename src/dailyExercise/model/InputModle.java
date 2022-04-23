package dailyExercise.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

/**
 * @ClassName: InputModle
 * @Description: acm 笔试输入模版
 * @author: dk
 * @date: 2022/1/7 7:15 下午
 */

public class InputModle {


    public static void inputRow() {
        //链接：https://ac.nowcoder.com/acm/contest/27121/B
        //来源：牛客网
        //
        //输入第一行包括一个数据组数t(1 <= t <= 100)
        //接下来每行包括两个正整数a,b(1 <= a, b <= 1000)
        //输出描述:
        //输出a+b的结果
        //示例1
        //输入
        //复制
        //2
        //1 5
        //10 20
        Scanner in = new Scanner( System.in );
        int num = in.nextInt();
        while ( in.hasNext() ) {
            for ( int i = 0; i < num; i++ ) {
                System.out.println( in.nextInt() + in.nextInt() );
            }

        }
    }
    public static void inputEnd(){
        //链接：https://ac.nowcoder.com/acm/contest/27121/C
        //来源：牛客网
        //
        //输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
        //输出描述:
        //输出a+b的结果
        //示例1
        //输入
        //复制
        //1 5
        //10 20
        //0 0
        Scanner in = new Scanner( System.in );
        while ( in.hasNext() ) {
            int a = in.nextInt() ;
            int b = in.nextInt();
            if ( a != 0 ) {
                System.out.println(a+b);
            }
        }
    }
    public static void inputOneRow(){
        //链接：https://ac.nowcoder.com/acm/contest/27121/D
        //来源：牛客网
        //
        //输入数据包括多组。
        //每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
        //接下来n个正整数,即需要求和的每个正整数。
        //输出描述:
        //每组数据输出求和的结果
        //示例1
        //输入
        //复制
        //4 1 2 3 4
        //5 1 2 3 4 5
        //0
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String str=sc.nextLine();
            if("0".equals(str)) return;
            String[] strArr=str.split(" ");
            int sum=0;
            for(int i=1;i<strArr.length;i++){
                sum+=Integer.parseInt(strArr[i]);
            }
            System.out.println(sum);
        }
    }
    public static void inputNRow() throws IOException {
        //链接：https://ac.nowcoder.com/acm/contest/27121/E
        //来源：牛客网
        //
        //输入描述:
        //输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
        //接下来t行, 每行一组数据。
        //每行的第一个整数为整数的个数n(1 <= n <= 100)。
        //接下来n个正整数, 即需要求和的每个正整数。
        //输出描述:
        //每组数据输出求和的结果
        //示例1
        //输入
        //复制
        //2
        //4 1 2 3 4
        //5 1 2 3 4 5
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] elements = line.split(" ");
            if(elements.length <= 1) continue;
            int sum = 0;
            for (int i = 1; i < elements.length; i++) {
                int num = Integer.parseInt(elements[i]);
                sum += num;
            }
            System.out.println(sum);
        }

    }

    public static void inputString(){
        //链接：https://ac.nowcoder.com/acm/contest/5657/H
        //来源：牛客网
        //
        //输入描述:
        //输入有两行，第一行n
        //
        //第二行是n个字符串，字符串之间用空格隔开
        //输出描述:
        //输出一行排序后的字符串，空格隔开，无结尾空格
        //示例1
        //输入
        //复制
        //5
        //c d a bb e
        //输出
        //复制
        //a bb c d e
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int length = sc.nextInt();
            sc.nextLine();
            String[] temp = sc.nextLine().split(" ");
            Arrays.sort(temp);
            for(int i = 0 ; i < length;i++){
                System.out.print(temp[i]+" ");
            }
        }
    }
    public static void inputStrings(){
        //链接：https://ac.nowcoder.com/acm/contest/5657/I
        //来源：牛客网
        //
        //输入描述:
        //多个测试用例，每个测试用例一行。
        //
        //每行通过空格隔开，有n个字符，n＜100
        //输出描述:
        //对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
        //示例1
        //输入
        //复制
        //a c bb
        //f dddd
        //nowcoder
        //输出
        //复制
        //a bb c
        //dddd f
        //nowcoder
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            //sc.nextLine();
            Arrays.sort(temp);
            for(String temps:temp){
                System.out.print(temps+" ");
            }
            System.out.println();
        }
    }
    public static void intputStr(){
        //链接：https://ac.nowcoder.com/acm/contest/5657/J
        //来源：牛客网
        //
        //输入描述:
        //多个测试用例，每个测试用例一行。
        //每行通过,隔开，有n个字符，n＜100
        //输出描述:
        //对于每组用例输出一行排序后的字符串，用','隔开，无结尾空格
        //示例1
        //输入
        //复制
        //a,c,bb
        //f,dddd
        //nowcoder
        //输出
        //复制
        //a,bb,c
        //dddd,f
        //nowcoder

        //Scanner in=new Scanner(System.in);
        //        while(in.hasNext()){
        //            String[] s=in.nextLine().split(",");
        //            Arrays.sort(s);
        //            System.out.println(String.join(",",s));
        //        }

        Scanner in =
                new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out =
                new PrintWriter(new OutputStreamWriter(System.out));

        while(in.hasNextLine()){
            String[] strs = in.nextLine().split(",");
            Arrays.sort(strs);
            for(int i = 0 ;i<strs.length-1;i++){//无结尾空格
                out.print(strs[i]);
                out.print(",");
            }
            out.println(strs[strs.length-1]);
        }

        out.flush();
    }
    public static void main( String[] args ) {
        //inputRow();
        //inputEnd();
        //inputOneRow();
        //inputNRow()

    }
}
