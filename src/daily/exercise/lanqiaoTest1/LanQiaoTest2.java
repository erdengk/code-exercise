package daily.exercise.lanqiaoTest1;

/**
 * @ClassName: LanQiaoTest2
 * @Description:
 * @author: dk
 * @date: 2021/12/2 11:33 上午
 */

public class LanQiaoTest2 {

    public static void main(String[] args) {
        String s = "123456789";
        process(s.toCharArray(),0);
    }


    private static void process(char[] ch, int i) {
        if(i==ch.length){
            System.out.println(String.valueOf(ch));
        }
        for(int j=i;j<ch.length;j++){
            swap(ch,i,j);
            process(ch,i+1);
            swap(ch,i,j);
        }
    }
    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

}
