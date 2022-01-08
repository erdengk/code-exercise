package daily.exercise.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
    public static void main( String[] args ) {
        //inputRow();
        //inputEnd();
        //inputOneRow();
        //inputNRow()

    }
}
