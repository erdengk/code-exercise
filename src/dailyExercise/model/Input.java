package dailyExercise.model;

/**
 * @ClassName: Input
 * @Description: 输入挂
 * @author: dk
 * @date: 2022/1/7 7:43 下午
 */


/*
lrj书中原话：最常用的Scanner类通常比scanf系列慢5~10倍，应尽量避免；下面的代码包装了速度较快的
BufferedReader和StringTokenizer（比split函数略快），推荐选手在比赛中使用。
 */
import java.io.*;
import java.util.*;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) {
        reader=new BufferedReader(new InputStreamReader(System.in));
        tokenizer=new StringTokenizer("");
    }
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer=new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}


/**
 * 然后接下来应用的时候，先要Reader.init(System.in);
 * 关于整数部分读入，直接用Reader.nextInt()方法，而浮点数读入用Reader.nextDouble()方法
 * 字符串读入，用Reader.next()方法
 */
public class Input {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] elements = line.split(" ");
            int sum = 0;
            for (int i = 0; i < elements.length; i++) {
                int num = Integer.parseInt(elements[i]);
                sum += num;
            }
            System.out.println(sum);
        }



        //way Two

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] stoken = br.readLine().split(" ");
//        int n = Integer.parseInt(stoken[0]);
//        int m = Integer.parseInt(stoken[1]);
//        System.out.println(n+m);
//
//         String x = br.readLine();
//         System.out.println(x.indexOf( "t" ));
    }
}
