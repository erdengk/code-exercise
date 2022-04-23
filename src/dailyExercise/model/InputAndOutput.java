package dailyExercise.model;

/**
 * @ClassName: InputAndOutput
 * @Description:
 * @author: dk
 * @date: 2022/1/7 8:03 下午
 */
import java.io.*;
public class InputAndOutput {

    public static void main( String[] args ) throws IOException {

        StreamTokenizer in = new StreamTokenizer( new BufferedReader( new InputStreamReader( System.in ) ) );
        PrintWriter out = new PrintWriter( new OutputStreamWriter( System.out ) );

        //StreamTokenizer.TT_EOF这个是个参数，就是EOF
        while ( in.nextToken() != StreamTokenizer.TT_EOF ) {
            int n = (int) in.nval;
            int max = 0;
            for ( int i = 0; i < n; i++ ) {
                in.nextToken();//指向下一个
                if(in.nval>max){
                    max= (int)in.nval;
                }
            }
            out.println( max );
            out.flush();//刷新，不然max会留在缓冲区
        }
    }
}
